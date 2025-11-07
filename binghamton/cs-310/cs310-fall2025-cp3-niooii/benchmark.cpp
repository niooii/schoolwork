#include <iostream>
#include <iomanip>
#include <chrono>
#include <random>
#include <vector>
#include <memory>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <fstream>
#include "sorts.h"

using namespace std;
using namespace std::chrono;

template<typename T>
class BenchmarkRunner {
private:
    vector<unique_ptr<SortAlgorithm<T>>> algorithms;
    mt19937 rng;

    vector<T> generate_random_data(int size) {
        vector<T> data(size);
        uniform_int_distribution<T> dist(0, 1000000);
        for (int i = 0; i < size; i++) {
            data[i] = dist(rng);
        }
        return data;
    }

    vector<T> generate_sorted_data(int size) {
        vector<T> data(size);
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
        return data;
    }

    vector<T> generate_reversed_data(int size) {
        vector<T> data(size);
        for (int i = 0; i < size; i++) {
            data[i] = size - i - 1;
        }
        return data;
    }

    bool verify_sorted(const vector<T>& arr) {
        for (size_t i = 1; i < arr.size(); i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    double benchmark_algorithm(SortAlgorithm<T>* algo, vector<T>& data, int size) {
        vector<T> test_data = data;

        auto start = high_resolution_clock::now();
        algo->sort(test_data);
        auto end = high_resolution_clock::now();

        if (!verify_sorted(test_data)) {
            cerr << "ERROR: " << algo->name() << " failed to sort correctly!" << endl;
            return -1.0;
        }

        duration<double, milli> elapsed = end - start;
        return elapsed.count();
    }

public:
    BenchmarkRunner() : rng(42) {
        algorithms.push_back(make_unique<IntroSort<T>>());
        algorithms.push_back(make_unique<TimSort<T>>());
        algorithms.push_back(make_unique<DualPivotQuickSort<T>>());
        algorithms.push_back(make_unique<PatternDefeatingQuickSort<T>>());
        algorithms.push_back(make_unique<BlockSort<T>>());
        algorithms.push_back(make_unique<SmoothSort<T>>());
        algorithms.push_back(make_unique<SpreadSort<T>>());
        algorithms.push_back(make_unique<FlashSort<T>>());
        algorithms.push_back(make_unique<LibrarySort<T>>());
        algorithms.push_back(make_unique<RadixSortLSD<T>>());
        algorithms.push_back(make_unique<RadixSortMSD<T>>());
        algorithms.push_back(make_unique<CountingSort<T>>());
        algorithms.push_back(make_unique<ParallelMergeSort<T>>());
        algorithms.push_back(make_unique<BitonicSort<T>>());
        algorithms.push_back(make_unique<CycleSort<T>>());
        algorithms.push_back(make_unique<ShellSort<T>>());
        algorithms.push_back(make_unique<NaturalMergeSort<T>>());
        algorithms.push_back(make_unique<PatienceSort<T>>());
    }

    void run_benchmarks() {
        vector<int> sizes = {10, 100, 1000, 10000, 100000, 1000000};
        const double max_time_ms = 5000.0;
        const unordered_map<string, int> manual_caps = {
            {"Cycle Sort", 10000}
        };

        ofstream csv_file("benchmark_results.csv");

        // CSV Header
        csv_file << "Algorithm,DataType,Size,Time_ms\n";

        cout << "\n";
        cout << "+---------------------------------------------------------------+\n";
        cout << "|              SORTING ALGORITHM BENCHMARK RESULTS              |\n";
        cout << "+---------------------------------------------------------------+\n";
        cout << "\n";
        cout << "Running benchmarks and writing results to benchmark_results.csv\n";
        cout << "Time measurements in milliseconds (ms)\n\n";

        vector<string> data_types = {"sorted", "random", "reversed"};

        for (const string& data_type : data_types) {
            cout << "Testing " << data_type << " data...\n";

            for (auto& algo : algorithms) {
                const string algo_name = algo->name();
                bool skip_due_to_time = false;

                for (int size : sizes) {
                    if (auto cap_it = manual_caps.find(algo_name); cap_it != manual_caps.end() && size > cap_it->second) {
                        csv_file << algo_name << "," << data_type << "," << size << ",SKIP\n";
                        continue;
                    }

                    if (skip_due_to_time) {
                        csv_file << algo_name << "," << data_type << "," << size << ",SKIP\n";
                        continue;
                    }

                    vector<T> data;
                    if (data_type == "sorted") {
                        data = generate_sorted_data(size);
                    } else if (data_type == "random") {
                        data = generate_random_data(size);
                    } else if (data_type == "reversed") {
                        data = generate_reversed_data(size);
                    }

                    cout << "  " << algo_name << " (n=" << size << ")... " << flush;
                    double time_ms = benchmark_algorithm(algo.get(), data, size);
                    cout << time_ms << " ms\n";

                    if (time_ms < 0) {
                        csv_file << algo_name << "," << data_type << "," << size << ",FAILED\n";
                        skip_due_to_time = true;
                        continue;
                    }

                    csv_file << algo_name << "," << data_type << "," << size << "," << fixed << setprecision(6) << time_ms << "\n";

                    if (time_ms > max_time_ms && size != sizes.back()) {
                        skip_due_to_time = true;
                    }
                }
            }
        }

        csv_file.close();

        cout << "\nCSV file 'benchmark_results.csv' created successfully.\n";
        cout << "The file contains benchmark results for sorted, random, and reversed data.\n";
        cout << "You can now plot these results using matplotlib in Python.\n\n";

        cout << "\n+---------------------------------------------------------------+\n";
        cout << "|                        BENCHMARK COMPLETE                     |\n";
        cout << "+---------------------------------------------------------------+\n";
        cout << "\nAlgorithm Categories:\n";
        cout << "  Standard Library:     Introsort, Timsort, Dual-Pivot Quicksort, pdqsort\n";
        cout << "  Specialized:          Block Sort, Smoothsort, Spreadsort, Flashsort, Library Sort\n";
        cout << "  Radix-based:          Radix Sort (LSD/MSD), Counting Sort\n";
        cout << "  Parallel:             Parallel Merge Sort, Bitonic Sort\n";
        cout << "  Special Purpose:      Cycle Sort, Shell Sort, Natural Merge, Patience\n";
        cout << "\n";
    }



};

int main() {
    BenchmarkRunner<int> runner;
    runner.run_benchmarks();
    return 0;
}
