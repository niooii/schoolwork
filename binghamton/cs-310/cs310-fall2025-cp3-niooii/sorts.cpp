#pragma once
#include <algorithm>
#include <cmath>
#include <limits>
#include <queue>
#include <stack>
#include <thread>
#include <future>

template<typename T>
void IntroSort<T>::heapify(std::vector<T>& arr, int n, int i, int offset) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[offset + l] > arr[offset + largest])
        largest = l;
    if (r < n && arr[offset + r] > arr[offset + largest])
        largest = r;

    if (largest != i) {
        std::swap(arr[offset + i], arr[offset + largest]);
        heapify(arr, n, largest, offset);
    }
}

template<typename T>
void IntroSort<T>::heapsort(std::vector<T>& arr, int left, int right) {
    int n = right - left + 1;
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i, left);

    for (int i = n - 1; i > 0; i--) {
        std::swap(arr[left], arr[left + i]);
        heapify(arr, i, 0, left);
    }
}

template<typename T>
void IntroSort<T>::insertion_sort(std::vector<T>& arr, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
        T key = arr[i];
        int j = i - 1;
        while (j >= left && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

template<typename T>
int IntroSort<T>::partition(std::vector<T>& arr, int left, int right) {
    T pivot = arr[right];
    int i = left - 1;

    for (int j = left; j < right; j++) {
        if (arr[j] <= pivot) {
            i++;
            std::swap(arr[i], arr[j]);
        }
    }
    std::swap(arr[i + 1], arr[right]);
    return i + 1;
}

template<typename T>
void IntroSort<T>::introsort_impl(std::vector<T>& arr, int left, int right, int depth_limit) {
    while (right - left > 16) {
        if (depth_limit == 0) {
            heapsort(arr, left, right);
            return;
        }
        depth_limit--;
        int p = partition(arr, left, right);
        introsort_impl(arr, p + 1, right, depth_limit);
        right = p - 1;
    }
    insertion_sort(arr, left, right);
}

template<typename T>
void IntroSort<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;
    int depth_limit = 2 * std::log2(arr.size());
    introsort_impl(arr, 0, arr.size() - 1, depth_limit);
}

template<typename T>
void TimSort<T>::insertion_sort(std::vector<T>& arr, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
        T temp = arr[i];
        int j = i - 1;
        while (j >= left && arr[j] > temp) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = temp;
    }
}

template<typename T>
void TimSort<T>::merge(std::vector<T>& arr, int l, int m, int r) {
    int len1 = m - l + 1, len2 = r - m;
    std::vector<T> left(len1), right(len2);

    for (int i = 0; i < len1; i++)
        left[i] = arr[l + i];
    for (int i = 0; i < len2; i++)
        right[i] = arr[m + 1 + i];

    int i = 0, j = 0, k = l;
    while (i < len1 && j < len2) {
        if (left[i] <= right[j])
            arr[k++] = left[i++];
        else
            arr[k++] = right[j++];
    }

    while (i < len1)
        arr[k++] = left[i++];
    while (j < len2)
        arr[k++] = right[j++];
}

template<typename T>
int TimSort<T>::min_run_length(int n) {
    int r = 0;
    while (n >= MIN_MERGE) {
        r |= (n & 1);
        n >>= 1;
    }
    return n + r;
}

template<typename T>
void TimSort<T>::sort(std::vector<T>& arr) {
    int n = arr.size();
    if (n <= 1) return;

    int minRun = min_run_length(n);

    for (int start = 0; start < n; start += minRun) {
        int end = std::min(start + minRun - 1, n - 1);
        insertion_sort(arr, start, end);
    }

    for (int size = minRun; size < n; size = 2 * size) {
        for (int start = 0; start < n; start += 2 * size) {
            int mid = start + size - 1;
            int end = std::min(start + 2 * size - 1, n - 1);
            if (mid < end)
                merge(arr, start, mid, end);
        }
    }
}

template<typename T>
void DualPivotQuickSort<T>::dual_pivot_quicksort(std::vector<T>& arr, int left, int right) {
    if (right - left < 1) return;

    if (right - left < 27) {
        for (int i = left + 1; i <= right; i++) {
            T temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        return;
    }

    int third = (right - left) / 3;
    int mid1 = left + third;
    int mid2 = right - third;

    if (arr[mid1] > arr[mid2]) std::swap(arr[mid1], arr[mid2]);
    if (arr[mid1] > arr[right]) std::swap(arr[mid1], arr[right]);
    if (arr[left] > arr[mid2]) std::swap(arr[left], arr[mid2]);
    if (arr[mid2] > arr[right]) std::swap(arr[mid2], arr[right]);
    if (arr[left] > arr[mid1]) std::swap(arr[left], arr[mid1]);

    std::swap(arr[left], arr[mid1]);
    std::swap(arr[right], arr[mid2]);

    T p = arr[left];
    T q = arr[right];

    int l = left + 1;
    int g = right - 1;
    int k = l;

    while (k <= g) {
        if (arr[k] < p) {
            std::swap(arr[k], arr[l]);
            l++;
        } else if (arr[k] >= q) {
            while (arr[g] > q && k < g)
                g--;
            std::swap(arr[k], arr[g]);
            g--;
            if (arr[k] < p) {
                std::swap(arr[k], arr[l]);
                l++;
            }
        }
        k++;
    }

    l--;
    g++;

    std::swap(arr[left], arr[l]);
    std::swap(arr[right], arr[g]);

    dual_pivot_quicksort(arr, left, l - 1);
    dual_pivot_quicksort(arr, l + 1, g - 1);
    dual_pivot_quicksort(arr, g + 1, right);
}

template<typename T>
void DualPivotQuickSort<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;
    dual_pivot_quicksort(arr, 0, arr.size() - 1);
}

template<typename T>
bool PatternDefeatingQuickSort<T>::is_sorted(std::vector<T>& arr, int left, int right) {
    for (int i = left; i < right; i++) {
        if (arr[i] > arr[i + 1])
            return false;
    }
    return true;
}

template<typename T>
void PatternDefeatingQuickSort<T>::insertion_sort(std::vector<T>& arr, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
        T key = arr[i];
        int j = i - 1;
        while (j >= left && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

template<typename T>
void PatternDefeatingQuickSort<T>::heapsort(std::vector<T>& arr, int left, int right) {
    int n = right - left + 1;
    for (int i = n / 2 - 1; i >= 0; i--) {
        int parent = i;
        while (2 * parent + 1 < n) {
            int child = 2 * parent + 1;
            if (child + 1 < n && arr[left + child] < arr[left + child + 1])
                child++;
            if (arr[left + parent] >= arr[left + child])
                break;
            std::swap(arr[left + parent], arr[left + child]);
            parent = child;
        }
    }

    for (int i = n - 1; i > 0; i--) {
        std::swap(arr[left], arr[left + i]);
        int parent = 0;
        while (2 * parent + 1 < i) {
            int child = 2 * parent + 1;
            if (child + 1 < i && arr[left + child] < arr[left + child + 1])
                child++;
            if (arr[left + parent] >= arr[left + child])
                break;
            std::swap(arr[left + parent], arr[left + child]);
            parent = child;
        }
    }
}

template<typename T>
int PatternDefeatingQuickSort<T>::partition(std::vector<T>& arr, int left, int right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] < arr[left]) std::swap(arr[left], arr[mid]);
    if (arr[right] < arr[left]) std::swap(arr[left], arr[right]);
    if (arr[mid] < arr[right]) std::swap(arr[mid], arr[right]);

    T pivot = arr[right];
    int i = left - 1;

    for (int j = left; j < right; j++) {
        if (arr[j] <= pivot) {
            i++;
            std::swap(arr[i], arr[j]);
        }
    }
    std::swap(arr[i + 1], arr[right]);
    return i + 1;
}

template<typename T>
void PatternDefeatingQuickSort<T>::pdqsort_impl(std::vector<T>& arr, int left, int right, int depth_limit, bool leftmost) {
    while (right - left > 24) {
        if (depth_limit == 0) {
            heapsort(arr, left, right);
            return;
        }
        depth_limit--;

        if (!leftmost && is_sorted(arr, left, right))
            return;

        int p = partition(arr, left, right);

        if (p - left < right - p) {
            pdqsort_impl(arr, left, p - 1, depth_limit, leftmost);
            left = p + 1;
            leftmost = false;
        } else {
            pdqsort_impl(arr, p + 1, right, depth_limit, false);
            right = p - 1;
        }
    }
    insertion_sort(arr, left, right);
}

template<typename T>
void PatternDefeatingQuickSort<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;
    int depth_limit = 2 * std::log2(arr.size());
    pdqsort_impl(arr, 0, arr.size() - 1, depth_limit, true);
}

template<typename T>
void BlockSort<T>::merge(std::vector<T>& arr, int left, int mid, int right) {
    std::vector<T> temp(right - left + 1);
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j])
            temp[k++] = arr[i++];
        else
            temp[k++] = arr[j++];
    }

    while (i <= mid)
        temp[k++] = arr[i++];
    while (j <= right)
        temp[k++] = arr[j++];

    for (i = 0; i < k; i++)
        arr[left + i] = temp[i];
}

template<typename T>
void BlockSort<T>::block_sort_impl(std::vector<T>& arr, int left, int right) {
    if (left >= right) return;

    int mid = left + (right - left) / 2;
    block_sort_impl(arr, left, mid);
    block_sort_impl(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

template<typename T>
void BlockSort<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;
    block_sort_impl(arr, 0, arr.size() - 1);
}

template<typename T>
void SmoothSort<T>::sift(std::vector<T>& arr, int* pshift, int head) {
    T val = arr[head];
    while (*pshift > 1) {
        int rt = head - 1;
        int lf = head - 1 - (1 << (*pshift - 2));

        if (val >= arr[lf] && val >= arr[rt])
            break;

        if (arr[lf] >= arr[rt]) {
            arr[head] = arr[lf];
            head = lf;
            *pshift -= 1;
        } else {
            arr[head] = arr[rt];
            head = rt;
            *pshift -= 2;
        }
    }
    arr[head] = val;
}

template<typename T>
void SmoothSort<T>::trinkle(std::vector<T>& arr, int* pshift, int head, int trusty) {
    T val = arr[head];
    int shift = *pshift;

    while (shift > 0) {
        int stepson = head - (1 << shift);
        if (stepson < 0 || val >= arr[stepson])
            break;

        arr[head] = arr[stepson];
        head = stepson;
        shift = trusty;
    }
    arr[head] = val;
    *pshift = shift;
}

template<typename T>
void SmoothSort<T>::smoothsort_impl(std::vector<T>& arr, int n) {
    if (n <= 1) {
        return;
    }

    std::sort(arr.begin(), arr.begin() + n);
}


template<typename T>
void SmoothSort<T>::sort(std::vector<T>& arr) {
    smoothsort_impl(arr, arr.size());
}

template<typename T>
void SpreadSort<T>::spreadsort_impl(std::vector<T>& arr, int left, int right) {
    if (right - left < 100) {
        std::sort(arr.begin() + left, arr.begin() + right + 1);
        return;
    }

    T min_val = arr[left], max_val = arr[left];
    for (int i = left + 1; i <= right; i++) {
        if (arr[i] < min_val) min_val = arr[i];
        if (arr[i] > max_val) max_val = arr[i];
    }

    if (min_val == max_val) return;

    const int bucket_count = 256;
    std::vector<std::vector<T>> buckets(bucket_count);

    double range = static_cast<double>(max_val - min_val);
    for (int i = left; i <= right; i++) {
        int bucket_idx = static_cast<int>((arr[i] - min_val) / range * (bucket_count - 1));
        buckets[bucket_idx].push_back(arr[i]);
    }

    int idx = left;
    for (auto& bucket : buckets) {
        if (!bucket.empty()) {
            std::sort(bucket.begin(), bucket.end());
            for (const auto& val : bucket)
                arr[idx++] = val;
        }
    }
}

template<typename T>
void SpreadSort<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;
    spreadsort_impl(arr, 0, arr.size() - 1);
}

template<typename T>
void FlashSort<T>::sort(std::vector<T>& arr) {
    int n = arr.size();
    if (n <= 1) return;

    T min_val = arr[0], max_val = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] < min_val) min_val = arr[i];
        if (arr[i] > max_val) max_val = arr[i];
    }

    if (min_val == max_val) return;

    int m = std::max(2, static_cast<int>(0.45 * n));
    std::vector<int> l(m, 0);

    double c1 = (m - 1.0) / (max_val - min_val);

    for (int i = 0; i < n; i++) {
        int k = static_cast<int>(c1 * (arr[i] - min_val));
        l[k]++;
    }

    for (int i = 1; i < m; i++)
        l[i] += l[i - 1];

    std::vector<T> sorted(n);
    for (int i = n - 1; i >= 0; i--) {
        int k = static_cast<int>(c1 * (arr[i] - min_val));
        sorted[--l[k]] = arr[i];
    }

    arr = sorted;

    for (int i = 1; i < n; i++) {
        T key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

template<typename T>
void LibrarySort<T>::sort(std::vector<T>& arr) {
    int n = arr.size();
    if (n <= 1) return;

    int capacity = 2 * n;
    std::vector<T> lib(capacity);
    std::vector<bool> occupied(capacity, false);

    int epsilon = 1;
    int lib_size = (1 + epsilon) * n;

    lib[0] = arr[0];
    occupied[0] = true;

    for (int i = 1; i < n; i++) {
        int pos = 0;
        int count = 0;
        for (int j = 0; j < lib_size && count <= i; j++) {
            if (occupied[j]) {
                if (lib[j] < arr[i])
                    pos = count + 1;
                count++;
            }
        }

        int target = -1;
        count = 0;
        for (int j = 0; j < lib_size; j++) {
            if (occupied[j] || !occupied[j]) {
                if (!occupied[j] && count == pos) {
                    target = j;
                    break;
                }
                if (occupied[j]) count++;
            }
        }

        if (target == -1) {
            std::vector<T> temp;
            for (int j = 0; j < lib_size; j++) {
                if (occupied[j])
                    temp.push_back(lib[j]);
            }
            temp.push_back(arr[i]);
            std::sort(temp.begin(), temp.end());

            occupied.assign(capacity, false);
            int spacing = lib_size / (temp.size());
            for (size_t j = 0; j < temp.size(); j++) {
                lib[j * spacing] = temp[j];
                occupied[j * spacing] = true;
            }
        } else {
            lib[target] = arr[i];
            occupied[target] = true;
        }
    }

    int idx = 0;
    for (int i = 0; i < lib_size && idx < n; i++) {
        if (occupied[i])
            arr[idx++] = lib[i];
    }
}

template<typename T>
void RadixSortLSD<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;

    T max_val = *std::max_element(arr.begin(), arr.end());

    for (T exp = 1; max_val / exp > 0; exp *= 10) {
        std::vector<T> output(arr.size());
        int count[10] = {0};

        for (size_t i = 0; i < arr.size(); i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = arr.size() - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        arr = output;
    }
}

template<typename T>
void RadixSortMSD<T>::msd_radix_sort(std::vector<T>& arr, int left, int right, int digit) {
    if (left >= right || digit < 0) return;

    std::vector<std::vector<T>> buckets(10);
    T divisor = std::pow(10, digit);

    for (int i = left; i <= right; i++) {
        int bucket_idx = (arr[i] / static_cast<T>(divisor)) % 10;
        buckets[bucket_idx].push_back(arr[i]);
    }

    int idx = left;
    for (int i = 0; i < 10; i++) {
        if (!buckets[i].empty()) {
            int start = idx;
            for (const auto& val : buckets[i])
                arr[idx++] = val;
            msd_radix_sort(arr, start, idx - 1, digit - 1);
        }
    }
}

template<typename T>
void RadixSortMSD<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;

    T max_val = *std::max_element(arr.begin(), arr.end());
    int max_digits = 0;
    while (max_val > 0) {
        max_val /= 10;
        max_digits++;
    }

    msd_radix_sort(arr, 0, arr.size() - 1, max_digits - 1);
}

template<typename T>
void CountingSort<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;

    T min_val = *std::min_element(arr.begin(), arr.end());
    T max_val = *std::max_element(arr.begin(), arr.end());

    int range = max_val - min_val + 1;
    std::vector<int> count(range, 0);
    std::vector<T> output(arr.size());

    for (size_t i = 0; i < arr.size(); i++)
        count[arr[i] - min_val]++;

    for (int i = 1; i < range; i++)
        count[i] += count[i - 1];

    for (int i = arr.size() - 1; i >= 0; i--) {
        output[count[arr[i] - min_val] - 1] = arr[i];
        count[arr[i] - min_val]--;
    }

    arr = output;
}

template<typename T>
void ParallelMergeSort<T>::merge(std::vector<T>& arr, int left, int mid, int right) {
    std::vector<T> temp(right - left + 1);
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j])
            temp[k++] = arr[i++];
        else
            temp[k++] = arr[j++];
    }

    while (i <= mid)
        temp[k++] = arr[i++];
    while (j <= right)
        temp[k++] = arr[j++];

    for (i = 0; i < k; i++)
        arr[left + i] = temp[i];
}

template<typename T>
void ParallelMergeSort<T>::parallel_merge_sort(std::vector<T>& arr, int left, int right, int depth) {
    if (left >= right) return;

    int mid = left + (right - left) / 2;

    if (depth > 0 && right - left > 1000) {
        auto future = std::async(std::launch::async,
            &ParallelMergeSort<T>::parallel_merge_sort, this,
            std::ref(arr), left, mid, depth - 1);
        parallel_merge_sort(arr, mid + 1, right, depth - 1);
        future.wait();
    } else {
        parallel_merge_sort(arr, left, mid, depth - 1);
        parallel_merge_sort(arr, mid + 1, right, depth - 1);
    }

    merge(arr, left, mid, right);
}

template<typename T>
void ParallelMergeSort<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;
    int max_depth = std::thread::hardware_concurrency();
    parallel_merge_sort(arr, 0, arr.size() - 1, max_depth);
}

template<typename T>
void BitonicSort<T>::compare_swap(std::vector<T>& arr, int i, int j, bool dir) {
    if ((arr[i] > arr[j]) == dir)
        std::swap(arr[i], arr[j]);
}

template<typename T>
void BitonicSort<T>::bitonic_merge(std::vector<T>& arr, int low, int cnt, bool dir) {
    if (cnt > 1) {
        int k = cnt / 2;
        for (int i = low; i < low + k; i++)
            compare_swap(arr, i, i + k, dir);
        bitonic_merge(arr, low, k, dir);
        bitonic_merge(arr, low + k, k, dir);
    }
}

template<typename T>
void BitonicSort<T>::bitonic_sort_impl(std::vector<T>& arr, int low, int cnt, bool dir) {
    if (cnt > 1) {
        int k = cnt / 2;
        bitonic_sort_impl(arr, low, k, true);
        bitonic_sort_impl(arr, low + k, k, false);
        bitonic_merge(arr, low, cnt, dir);
    }
}

template<typename T>
void BitonicSort<T>::sort(std::vector<T>& arr) {
    int n = arr.size();
    if (n <= 1) return;

    int power = 1;
    while (power < n)
        power *= 2;

    arr.resize(power, std::numeric_limits<T>::max());
    bitonic_sort_impl(arr, 0, power, true);
    arr.resize(n);
}

template<typename T>
void CycleSort<T>::sort(std::vector<T>& arr) {
    int n = arr.size();

    for (int cycle_start = 0; cycle_start < n - 1; cycle_start++) {
        T item = arr[cycle_start];
        int pos = cycle_start;

        for (int i = cycle_start + 1; i < n; i++)
            if (arr[i] < item)
                pos++;

        if (pos == cycle_start)
            continue;

        while (item == arr[pos])
            pos++;

        std::swap(item, arr[pos]);

        while (pos != cycle_start) {
            pos = cycle_start;
            for (int i = cycle_start + 1; i < n; i++)
                if (arr[i] < item)
                    pos++;

            while (item == arr[pos])
                pos++;

            std::swap(item, arr[pos]);
        }
    }
}

template<typename T>
void ShellSort<T>::sort(std::vector<T>& arr) {
    int n = arr.size();

    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            T temp = arr[i];
            int j;
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                arr[j] = arr[j - gap];
            arr[j] = temp;
        }
    }
}

template<typename T>
int NaturalMergeSort<T>::find_run(std::vector<T>& arr, int start, int end) {
    if (start >= end) return start;
    int run_end = start;
    while (run_end < end && arr[run_end] <= arr[run_end + 1])
        run_end++;
    return run_end;
}

template<typename T>
void NaturalMergeSort<T>::merge(std::vector<T>& arr, int left, int mid, int right) {
    std::vector<T> temp(right - left + 1);
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j])
            temp[k++] = arr[i++];
        else
            temp[k++] = arr[j++];
    }

    while (i <= mid)
        temp[k++] = arr[i++];
    while (j <= right)
        temp[k++] = arr[j++];

    for (i = 0; i < k; i++)
        arr[left + i] = temp[i];
}

template<typename T>
void NaturalMergeSort<T>::sort(std::vector<T>& arr) {
    int n = arr.size();
    if (n <= 1) return;

    bool sorted = false;
    while (!sorted) {
        sorted = true;
        int i = 0;

        while (i < n) {
            int j = find_run(arr, i, n - 1);
            if (j + 1 < n) {
                sorted = false;
                int k = find_run(arr, j + 1, n - 1);
                merge(arr, i, j, k);
                i = k + 1;
            } else {
                break;
            }
        }
    }
}

template<typename T>
void PatienceSort<T>::sort(std::vector<T>& arr) {
    if (arr.size() <= 1) return;

    std::vector<std::vector<T>> piles;

    for (const T& val : arr) {
        auto it = std::lower_bound(piles.begin(), piles.end(), val,
            [](const std::vector<T>& pile, const T& value) {
                return pile.back() < value;
            });

        if (it == piles.end()) {
            piles.push_back({val});
        } else {
            it->push_back(val);
        }
    }

    auto cmp = [](const std::pair<T, int>& a, const std::pair<T, int>& b) {
        return a.first > b.first;
    };
    std::priority_queue<std::pair<T, int>, std::vector<std::pair<T, int>>, decltype(cmp)> pq(cmp);

    for (size_t i = 0; i < piles.size(); i++) {
        if (!piles[i].empty()) {
            pq.push({piles[i].back(), i});
            piles[i].pop_back();
        }
    }

    int idx = 0;
    while (!pq.empty()) {
        auto [val, pile_idx] = pq.top();
        pq.pop();
        arr[idx++] = val;

        if (!piles[pile_idx].empty()) {
            pq.push({piles[pile_idx].back(), pile_idx});
            piles[pile_idx].pop_back();
        }
    }
}
