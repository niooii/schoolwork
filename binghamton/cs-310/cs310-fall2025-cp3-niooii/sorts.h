#pragma once
#include "sort_interface.h"
#include <algorithm>
#include <cmath>
#include <thread>
#include <future>

template<typename T>
class IntroSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Introsort"; }
private:
    void introsort_impl(std::vector<T>& arr, int left, int right, int depth_limit);
    void heapsort(std::vector<T>& arr, int left, int right);
    void insertion_sort(std::vector<T>& arr, int left, int right);
    int partition(std::vector<T>& arr, int left, int right);
    void heapify(std::vector<T>& arr, int n, int i, int offset);
};

template<typename T>
class TimSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Timsort"; }
private:
    static const int MIN_MERGE = 32;
    void insertion_sort(std::vector<T>& arr, int left, int right);
    void merge(std::vector<T>& arr, int l, int m, int r);
    int min_run_length(int n);
};

template<typename T>
class DualPivotQuickSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Dual-Pivot Quicksort"; }
private:
    void dual_pivot_quicksort(std::vector<T>& arr, int left, int right);
};

template<typename T>
class PatternDefeatingQuickSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "pdqsort"; }
private:
    void pdqsort_impl(std::vector<T>& arr, int left, int right, int depth_limit, bool leftmost);
    void insertion_sort(std::vector<T>& arr, int left, int right);
    void heapsort(std::vector<T>& arr, int left, int right);
    int partition(std::vector<T>& arr, int left, int right);
    bool is_sorted(std::vector<T>& arr, int left, int right);
};

template<typename T>
class BlockSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Block Sort"; }
private:
    void block_sort_impl(std::vector<T>& arr, int left, int right);
    void merge(std::vector<T>& arr, int left, int mid, int right);
};

template<typename T>
class SmoothSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Smoothsort"; }
private:
    void smoothsort_impl(std::vector<T>& arr, int n);
    void sift(std::vector<T>& arr, int* pshift, int head);
    void trinkle(std::vector<T>& arr, int* pshift, int head, int trusty);
};

template<typename T>
class SpreadSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Spreadsort"; }
private:
    void spreadsort_impl(std::vector<T>& arr, int left, int right);
};

template<typename T>
class FlashSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Flashsort"; }
};

template<typename T>
class LibrarySort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Library Sort"; }
};

template<typename T>
class RadixSortLSD : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Radix Sort (LSD)"; }
};

template<typename T>
class RadixSortMSD : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Radix Sort (MSD)"; }
private:
    void msd_radix_sort(std::vector<T>& arr, int left, int right, int digit);
};

template<typename T>
class CountingSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Counting Sort"; }
};

template<typename T>
class ParallelMergeSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Parallel Merge Sort"; }
private:
    void parallel_merge_sort(std::vector<T>& arr, int left, int right, int depth);
    void merge(std::vector<T>& arr, int left, int mid, int right);
};

template<typename T>
class BitonicSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Bitonic Sort"; }
private:
    void bitonic_sort_impl(std::vector<T>& arr, int low, int cnt, bool dir);
    void bitonic_merge(std::vector<T>& arr, int low, int cnt, bool dir);
    void compare_swap(std::vector<T>& arr, int i, int j, bool dir);
};

template<typename T>
class CycleSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Cycle Sort"; }
};

template<typename T>
class ShellSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Shell Sort"; }
};

template<typename T>
class NaturalMergeSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Natural Merge Sort"; }
private:
    void merge(std::vector<T>& arr, int left, int mid, int right);
    int find_run(std::vector<T>& arr, int start, int end);
};

template<typename T>
class PatienceSort : public SortAlgorithm<T> {
    void sort(std::vector<T>& arr) override;
    std::string name() const override { return "Patience Sort"; }
};

#include "sorts.cpp"
