#include "Animal.h"
#include "AnimalsInZoo.h"

#include <iostream>

int main() {
    Animal a{"Aardvark", 100, false};
    Animal b{"Bear", 1000, true};
    Animal c{"Crocodile", 600, true};
    Animal d{"Deer", 80, false};

    AnimalsInZoo small_zoo;
    small_zoo.store(a);
    small_zoo.store(b);

    unsigned int size, capacity;
    small_zoo.readSizes(size, capacity);
    cout << "After adding 2 animals, our zoo has " << size << " animals, and can hold " << capacity << " animals total." << endl;
    small_zoo.show();

    small_zoo.store(c);
    small_zoo.store(d);

    small_zoo.readSizes(size, capacity);
    cout << "After adding 2 more animals, our zoo now has " << size << " animals, and can hold " << capacity << " animals total." << endl;
    small_zoo.show();

    if (Animal bear = small_zoo.find("Bear"); bear.get_name() != "") {
        cout << "Our zoo contains a bear." << endl;
    } else {
        cout << "Our zoo does not contain a bear." << endl;
    }

    if (small_zoo.remove("Crocodile")) {
        cout << "Our zoo no longer contains a crocodile." << endl;
    } else {
        cout << "Couldn't find a crocodile to remove." << endl;
    }
    small_zoo.show();

    small_zoo.store(a);
    small_zoo.store(b);
    small_zoo.store(d);

    small_zoo.readSizes(size, capacity);
    cout << "After adding 3 more animals, our zoo now has " << size << " animals, and can hold " << capacity << " animals total." << endl;
    small_zoo.show();
}
