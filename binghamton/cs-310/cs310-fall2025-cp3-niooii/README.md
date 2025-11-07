# Sorting Algorithm Benchmark Suite

Comprehensive performance comparison of 20+ sorting algorithms across different data distributions.

## Quick Results

**Best Overall Performance (1M elements):**
- **Sorted data**: Natural Merge Sort (0.38ms) - exploits pre-existing order
- **Random data**: Counting Sort (11.37ms) - linear time, requires bounded integer range
- **Reversed data**: Counting Sort (3.81ms) - distribution-independent performance

## Algorithm Descriptions

### Comparison-Based Sorts

#### **Introsort** (Introspective Sort)
- **Complexity**: O(n log n) worst case
- **Implementation**: Hybrid of Quicksort, Heapsort, and Insertion Sort
- **How it works**: Starts with Quicksort, switches to Heapsort if recursion depth exceeds log(n), uses Insertion Sort for small partitions
- **Runtime notes**:
  - Stable performance across all distributions
  - Default sort in C++ STL and many modern languages
  - Worst on reversed data due to partitioning overhead
  - 55-73ms on random/sorted 1M elements

#### **Timsort**
- **Complexity**: O(n log n) worst case, O(n) best case
- **Implementation**: Hybrid of Merge Sort and Insertion Sort with run detection
- **How it works**: Identifies naturally occurring sorted runs, merges them intelligently using galloping mode
- **Runtime notes**:
  - Excels on partially sorted data (29ms on sorted 1M)
  - Stable sort - preserves relative order of equal elements
  - Default in Python, Java, Android
  - Near-linear on sorted, competitive on random (53ms)

#### **Dual-Pivot Quicksort**
- **Complexity**: O(n²) worst case, O(n log n) average
- **Implementation**: Uses two pivots instead of one for 3-way partitioning
- **How it works**: Divides array into three parts using two pivots
- **Runtime notes**:
  - **CRASHES on random/reversed data in this implementation** - likely stack overflow
  - Excellent on sorted data (4.6ms on 1M)
  - Java's default sort for primitives
  - Sensitive to pivot selection strategy

#### **pdqsort** (Pattern-Defeating Quicksort)
- **Complexity**: O(n log n) worst case
- **Implementation**: Quicksort variant with pattern detection and fallback mechanisms
- **How it works**: Detects worst-case patterns (sorted, reversed, equal elements), switches to Heapsort when detected
- **Runtime notes**:
  - **Best comparison sort overall** - consistently fast across all distributions
  - 1.1ms on sorted, 62ms on random, 19ms on reversed
  - Specifically designed to defeat adversarial inputs
  - Used in Rust's standard library

#### **Block Sort** (Grailsort)
- **Complexity**: O(n log n), O(1) space
- **Implementation**: In-place stable merge sort using block-based merging
- **How it works**: Identifies internal buffer blocks, uses them for in-place merging
- **Runtime notes**:
  - Slow setup overhead visible at small sizes (42ms for 100 elements)
  - Very slow on reversed data (314ms on 1M) due to block rotation costs
  - Theoretically interesting but impractical
  - Stable without auxiliary memory

#### **Smoothsort**
- **Complexity**: O(n log n) worst case, O(n) best case
- **Implementation**: Heapsort variant using Leonardo numbers
- **How it works**: Builds Leonardo heap that degrades gracefully on sorted data
- **Runtime notes**:
  - Excellent on sorted data (4.5ms on 1M) - nearly linear
  - Excellent on reversed data (6ms on 1M)
  - Competitive on random (63ms)
  - Dijkstra's elegant but complex algorithm
  - Adaptive to existing order

#### **Parallel Merge Sort**
- **Complexity**: O(n log n), parallelizable
- **Implementation**: Standard merge sort with parallel divide-and-conquer
- **How it works**: Recursively splits array, sorts halves in parallel threads, merges
- **Runtime notes**:
  - Performance depends on thread count and overhead
  - 19-22ms on random/sorted 1M (using available threads)
  - Better speedup on larger datasets
  - Overhead visible at small sizes (9ms for 100 elements)

#### **Bitonic Sort**
- **Complexity**: O(n log² n)
- **Implementation**: Comparison network designed for parallel hardware
- **How it works**: Builds bitonic sequences, recursively merges them
- **Runtime notes**:
  - Slower than O(n log n) sorts (96-192ms on 1M)
  - Optimal for GPU/SIMD implementations
  - Fixed comparison network - great for hardware
  - This CPU implementation doesn't leverage parallelism well

#### **Cycle Sort**
- **Complexity**: O(n²)
- **Implementation**: In-place sort minimizing writes
- **How it works**: Cycles elements to their correct positions
- **Runtime notes**:
  - **EXTREMELY SLOW** - times out beyond 10k elements
  - Useful only when write operations are expensive (e.g., EEPROM)
  - 7ms for 10k random, extrapolates to hours for 1M
  - Minimal memory writes guarantee

#### **Shell Sort**
- **Complexity**: Depends on gap sequence, roughly O(n log² n) with Knuth gaps
- **Implementation**: Generalized insertion sort with decreasing gap sizes
- **How it works**: Sorts elements at progressively smaller gaps until gap=1
- **Runtime notes**:
  - Simple to implement, no recursion needed
  - 10-122ms on 1M depending on distribution
  - Gap sequence critical to performance
  - Better than insertion sort, worse than modern algorithms

#### **Natural Merge Sort**
- **Complexity**: O(n log n) worst case, O(n) best case
- **Implementation**: Merge sort that detects existing runs
- **How it works**: Identifies sorted runs in input, merges them bottom-up
- **Runtime notes**:
  - **FASTEST on already sorted data** (0.38ms on 1M!)
  - Near-optimal exploitation of existing order
  - 79ms on random - competitive with standard merge sort
  - Precursor to Timsort's run detection

#### **Patience Sort**
- **Complexity**: O(n log n) with good constants for LIS
- **Implementation**: Based on patience card game, builds piles
- **How it works**: Places elements on piles (can't place on larger pile), merges piles
- **Runtime notes**:
  - Excellent on reversed data (9.9ms on 1M) - becomes sorted piles
  - Slow on random (107ms on 1M)
  - Interesting for finding longest increasing subsequence
  - Many small heap operations add overhead

### Non-Comparison Sorts

#### **Radix Sort (LSD)** (Least Significant Digit)
- **Complexity**: O(d·n) where d = number of digits
- **Implementation**: Stable sort processing digits from right to left
- **How it works**: Counting sort on each digit position, LSB to MSB
- **Runtime notes**:
  - 23-33ms on 1M integers
  - Performance depends on integer size (32-bit = 4 passes)
  - Stable - preserves relative order
  - Linear time but high constant factor

#### **Radix Sort (MSD)** (Most Significant Digit)
- **Complexity**: O(d·n) worst case, can be faster on average
- **Implementation**: Recursive radix sort from MSB to LSB
- **How it works**: Partition by most significant digit, recurse on each bucket
- **Runtime notes**:
  - Slower than LSD (122-188ms on 1M)
  - Early termination possible when buckets become uniform
  - More cache-unfriendly due to recursion
  - Can beat LSD when data has common prefixes

#### **Counting Sort**
- **Complexity**: O(n + k) where k = value range
- **Implementation**: Counts occurrences, reconstructs sorted array
- **How it works**: Builds histogram, uses cumulative counts for positioning
- **Runtime notes**:
  - **LINEAR TIME** - 3-11ms on 1M elements
  - **Slow on random small data** (1.3ms for 10 elements) due to range calculation overhead
  - Requires bounded integer range (uses 0-1M in benchmark)
  - Not comparison-based - breaks Ω(n log n) lower bound
  - Practical only when range is comparable to n

#### **Spreadsort**
- **Complexity**: O(n log n) worst case, approaches O(n) for integers
- **Implementation**: Hybrid radix/comparison sort
- **How it works**: Uses MSB radix sort with comparison sort fallback for small buckets
- **Runtime notes**:
  - Specialized for integers, floats, strings
  - 8-39ms on 1M depending on distribution
  - Adapts to data distribution automatically
  - Part of Boost C++ library

#### **Flashsort**
- **Complexity**: O(n) average, O(n²) worst case
- **Implementation**: Distribution sort with classification and insertion
- **How it works**: Classifies elements into buckets based on value distribution, insertion sort within buckets
- **Runtime notes**:
  - **VERY FAST** - 4-12ms on 1M elements
  - Assumes uniform distribution
  - Performance degrades on skewed distributions
  - In-place variant of bucket sort

#### **Library Sort** (Gapped Insertion Sort)
- **Complexity**: O(n log n) expected with high probability
- **Implementation**: Insertion sort with gaps to reduce shifts
- **How it works**: Maintains gaps between elements, rebalances when gaps fill
- **Runtime notes**:
  - **CATASTROPHICALLY SLOW** - 14-65 SECONDS on 100k
  - Theoretically interesting probabilistic analysis
  - Practical implementation suffers from rebalancing costs
  - Do not use in production

## Implementation Notes

### Data Distributions Tested
1. **Sorted**: Already in ascending order - tests best-case and order detection
2. **Random**: Uniform random distribution - tests average case
3. **Reversed**: Descending order - tests worst-case patterns

### Size Range
- 10, 100, 1k, 10k, 100k, 1M elements
- Algorithms that timeout (>30s) marked as SKIP
- Crashes/errors marked as FAILED

### Hardware Considerations
- All benchmarks single-threaded except Parallel Merge Sort
- CPU cache effects visible in small vs large size performance
- Modern CPU branch prediction helps comparison-based sorts

### What Failed
- **Dual-Pivot Quicksort**: Stack overflow on random/reversed data
- **Library Sort**: Timeout at 1M (estimated hours)
- **Cycle Sort**: Timeout at 100k+ (O(n²) writes)

## Choosing a Sort

**For general-purpose use**: pdqsort or Introsort - fast and reliable

**For nearly sorted data**: Timsort, Natural Merge Sort, or Smoothsort

**For integers with bounded range**: Counting Sort if range ≈ n, Radix Sort otherwise

**For guaranteed worst-case**: Heapsort or Smoothsort (not benchmarked: classic Heapsort)

**For stable sorting**: Timsort, Block Sort, or standard Merge Sort

**For minimal memory**: Block Sort (O(1) space), Shell Sort, Smoothsort

**For parallel execution**: Parallel Merge Sort, Bitonic Sort (on GPU)

**Avoid**: Library Sort, Cycle Sort (unless minimizing writes is critical)
