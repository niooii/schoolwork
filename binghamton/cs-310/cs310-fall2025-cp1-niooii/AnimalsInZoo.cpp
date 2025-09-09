#include "AnimalsInZoo.h"
#include "Animal.h"
#include <format>

bool AnimalsInZoo::store(Animal &other) {
  if (size == capacity) {
    // resize storage
    capacity *= 2;
    Animal *ndata = new Animal[capacity];

    for (ull i = 0; i < size; i++) {
      ndata[i] = std::move(data[i]);
    }

    delete data;
    data = ndata;
  }

  data[size++] = other;

  std::cout << std::format("Animal {} added to spot {} of the contained array.",
                           other.species, size - 1);

  return true;
}

bool AnimalsInZoo::remove(const std::string &name) {
  for (ull i = 0; i < size; i++) {
    auto &a = data[i];
    if (a.species == name) {
      data[i] = std::move(data[--size]);
      return true;
    }
  }
  std::cout << std::format("Animal {} not found.", name);
  return false;
}

Animal AnimalsInZoo::find(const std::string &name) {
  for (ull i = 0; i < size; i++) {
    auto &a = data[i];
    if (a.species == name) {
      return a;
    }
  }

  return {};
}

void AnimalsInZoo::readSizes(unsigned int &count, unsigned int &capacity){ 
    count = size;
    capacity = this->capacity;
}

void AnimalsInZoo::show() const {
    for (ull i = 0; i < size; i++) {
        auto& a = data[i];
        std::cout << std::format("{}: {}, {} lbs {}", i, a.species, a.weight, a.dangerous ? "be careful!" : "");
    }
}
