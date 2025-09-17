#pragma once

#include <iostream>
#include <stdlib.h>
using namespace std;

class Animal {
    // this is not great practice but since the container and the
    // element are so tightly tied togehter
    // might as well, i hate writing getters and setters lol
  friend class AnimalsInZoo;

public:
  Animal() = default;
  // trivial copy consructor performs a shallow copy
  Animal(const Animal &other) = default;
  Animal(string speciesName, unsigned int discoveryYear);
  Animal(string speciesName, float weight, bool dangerous);

  void display();
  string get_name();

private:
  string species{};
  unsigned int year_discovered{};
  float weight{};
  bool dangerous{};
};
