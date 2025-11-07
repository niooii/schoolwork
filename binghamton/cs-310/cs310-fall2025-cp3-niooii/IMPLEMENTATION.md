# Benchmark Implementation Overview

## Architecture

### Type Erasure via Interface Pattern

The benchmark uses a classic polymorphic interface to store heterogeneous sorting algorithms in a single container.

**Interface definition** (`sort_interface.h`):
```cpp
template<typename T>
class SortAlgorithm {
    virtual void sort(std::vector<T>& arr) = 0;
    virtual std::string name() const = 0;
};
```

**Why this works**: All 20 sorting algorithm classes inherit from `SortAlgorithm<T>` and override `sort()` and `name()`. This allows storing `unique_ptr<SortAlgorithm<T>>` in a vector despite each algorithm having completely different implementations.

**Storage** (`benchmark.cpp:19`):
```cpp
vector<unique_ptr<SortAlgorithm<T>>> algorithms;
```

The `unique_ptr` handles ownership and automatic cleanup. Constructor populates this vector with 18 algorithm instances using `make_unique`.

## Data Generation

Three generator functions create test data:

1. **Sorted**: `[0, 1, 2, ..., n-1]` - tests best-case and adaptive behavior
2. **Random**: Uniform distribution `[0, 1000000]` using `mt19937` with fixed seed (42) for reproducibility
3. **Reversed**: `[n-1, n-2, ..., 1, 0]` - tests worst-case patterns

Seed is fixed at construction, ensuring identical random data across runs for fair comparison.

## Benchmark Methodology

### Single Algorithm Timing (`benchmark_algorithm`, line 56)

1. **Copy data** - ensures each algorithm sorts identical data, prevents cache warming effects
2. **Time sort operation** - `high_resolution_clock` measures wall time in milliseconds
3. **Verify correctness** - linear scan ensures output is sorted; returns -1.0 on failure
4. **Return elapsed time**

### Main Benchmark Loop (`run_benchmarks`, line 94)

Nested iteration structure:
- **Outer**: 3 data types (sorted, random, reversed)
- **Middle**: 18 algorithms
- **Inner**: 6 sizes (10, 100, 1K, 10K, 100K, 1M)

**Flow for each (data_type, algorithm, size) triple:**

1. Check if algorithm should be skipped (manual cap or prior timeout)
2. Generate test data
3. Run benchmark and time
4. Verify result correctness
5. Write to CSV: `Algorithm,DataType,Size,Time_ms`
6. Check if time exceeded threshold

## Adaptive Skipping

Two mechanisms prevent wasted time on slow algorithms:

### 1. Manual Caps (line 97-99)
```cpp
const unordered_map<string, int> manual_caps = {
    {"Cycle Sort", 10000}
};
```
Hardcoded size limits for known-slow algorithms. If `size > cap`, writes "SKIP" to CSV and continues to next size.

### 2. Dynamic Timeout (line 155-157)
```cpp
if (time_ms > max_time_ms && size != sizes.back()) {
    skip_due_to_time = true;
}
```
If any size exceeds 5 seconds (5000ms) and it's not the final size, all larger sizes are skipped. The `skip_due_to_time` flag propagates through remaining iterations.

**Why check `size != sizes.back()`**: Always run the largest size even if slow, for completeness. Prevents skipping 1M just because 100K was slow.

### 3. Failure Propagation (line 147-150)
If verification fails (algorithm didn't sort correctly), writes "FAILED" and sets skip flag. Prevents cascading failures when an algorithm crashes or produces garbage.

## CSV Output Format

```
Algorithm,DataType,Size,Time_ms
Introsort,sorted,10,0.000300
Introsort,sorted,100,0.003600
...
Dual-Pivot Quicksort,random,100,FAILED
Dual-Pivot Quicksort,random,1000,SKIP
...
```

- **Numeric time**: Successfully completed in milliseconds (6 decimal precision)
- **FAILED**: Algorithm produced incorrect output or crashed
- **SKIP**: Skipped due to manual cap or prior timeout

File written incrementally during benchmark, survives early termination.

## Execution

1. `main()` instantiates `BenchmarkRunner<int>` - templated on int type
2. Constructor allocates all 18 algorithms on heap via `unique_ptr`
3. `run_benchmarks()` executes full test matrix
4. Destructor automatically cleans up all algorithm instances

## Design Choices

**Why interface pattern**: Allows uniform treatment of algorithms with vastly different implementations (comparison sorts, radix sorts, parallel sorts). Alternative would be function pointers, but loses encapsulation of helper functions.

**Why `unique_ptr`**: Single ownership semantics - benchmark runner owns algorithms. No copying needed. Automatic cleanup prevents leaks.

**Why copy test data**: Prevents measurement contamination. Some algorithms (e.g., Timsort) perform better on pre-cached data. Copy ensures cold start.

**Why fixed RNG seed**: Reproducibility. Same "random" data across multiple runs. Critical for comparing results between different compilation flags or machines.

**Why verify after every run**: Catches implementation bugs early. Some algorithms (Dual-Pivot Quicksort) crash on certain inputs - verification prevents writing garbage times to CSV.

**Why skip on timeout**: O(n²) algorithms take hours on 1M elements. Timeout saves time while still collecting data at smaller sizes.

**Why separate data generators**: Clarity and testability. Each generator is trivial to verify. Alternative of parameterized single function adds complexity.

## Limitations

- **Single-threaded timing**: Only Parallel Merge Sort uses threads; others run single-threaded even if parallelizable
- **Wall time, not CPU time**: Includes OS scheduling noise
- **No warmup runs**: First run may include cache misses
- **Integer-only**: Templated on `int`, doesn't test string/float sorting
- **Fixed data distribution**: Random is uniform; doesn't test skewed distributions
- **No memory measurement**: Only tracks time, not space complexity
