#pragma once

#include "Animal.h"
#include <optional>

typedef unsigned long long ull;

class AnimalsInZoo {
public:
  AnimalsInZoo() {
    constexpr ull default_size = 32;
    capacity = default_size;
    data = new Animal[default_size];
  };

  ~AnimalsInZoo() { delete data; }

  void show() const;

  void readSizes(unsigned int &count, unsigned int &capacity);

  bool store(Animal &other);

  bool remove(const std::string &name);

  Animal find(const string &name);

private:
  ull size{};
  ull capacity;
  Animal *data;
};
