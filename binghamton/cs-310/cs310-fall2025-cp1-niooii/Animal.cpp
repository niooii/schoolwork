#include "Animal.h"

Animal::Animal(string speciesName, unsigned int discoveryYear)
    : species(speciesName), year_discovered(discoveryYear) {}

Animal::Animal(string name, float weight, bool dangerous)
    : species(name), weight(weight), dangerous(dangerous) {}

string Animal::get_name() {
    return species;
}

void Animal::display() {
  cout << species << " [" << year_discovered << "]" << endl;
}
