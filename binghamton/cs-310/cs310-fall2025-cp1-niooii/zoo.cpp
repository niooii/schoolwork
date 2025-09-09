#include "Animal.h"
#include "AnimalsInZoo.h"

int main() {
   // Test first constructor (species, year)
   Animal *animal1 = new Animal("African Elephant", 1758);
   Animal animal2("Giant Panda", 1869);
   
   cout << "Animals created with species and discovery year:" << endl;
   animal1->display();
   animal2.display();
   
   // Test second constructor (species, weight, dangerous)
   Animal animal3("Bengal Tiger", 220.5f, true);
   Animal animal4("Red Panda", 4.5f, false);
   
   cout << "\nAnimals created with species, weight, and danger status:" << endl;
   animal3.display();
   animal4.display();
   
   // Test default constructor
   AnimalsInZoo zoo1;
   cout << "Default zoo created" << endl;
   zoo1.show();
   
   // Test parameterized constructor
   AnimalsInZoo zoo2(5);
   cout << "\nZoo with capacity 5 created" << endl;
   
   // Test store method
   cout << "\nStoring animals in zoo:" << endl;
   bool stored1 = zoo2.store(*animal1);
   bool stored2 = zoo2.store(animal2);
   bool stored3 = zoo2.store(animal3);
   bool stored4 = zoo2.store(animal4);
   
   cout << "Store results: " << stored1 << " " << stored2 << " " << stored3 << " " << stored4 << endl;
   
   cout << "\nZoo contents:" << endl;
   zoo2.show();
   
   // Test find method
   cout << "\nFinding animals:" << endl;
   Animal found1 = zoo2.find("Giant Panda");
   Animal found2 = zoo2.find("Nonexistent Animal");
   cout << "Found Giant Panda:" << endl;
   found1.display();
   
   // Test remove method
   cout << "\nRemoving Bengal Tiger:" << endl;
   bool removed = zoo2.remove("Bengal Tiger");
   cout << "Remove result: " << removed << endl;
   
   cout << "\nZoo contents after removal:" << endl;
   zoo2.show();
   
   // Test readSizes method
   cout << "\nReading zoo sizes:" << endl;
   unsigned int count, capacity;
   zoo2.readSizes(count, capacity);
   cout << "Count: " << count << ", Capacity: " << capacity << endl;
   
   delete animal1;
}
