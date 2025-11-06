#pragma once
#include <vector>
#include <string>
#include <functional>

template<typename T>
class SortAlgorithm {
public:
    virtual ~SortAlgorithm() = default;
    virtual void sort(std::vector<T>& arr) = 0;
    virtual std::string name() const = 0;
};
