Altering and Recompiling a C++ Program
Now let’s change the C++ code. Open zoo.cpp and alter the code to create a third Animal object. Save the file, run ./zoo, and notice the new output doesn’t appear. That’s because you updated the source but not the executable. Run make again to rebuild, then run ./zoo to see the change.

Separating C++ Code into Multiple Source Files
Next, separate the Animal class (currently in zoo.cpp) into Animal.cpp and Animal.h. Keep main() in zoo.cpp.
Move:
- Class definition → Animal.h
- Function implementations → Animal.cpp

Add this line to the top of both Animal.cpp and zoo.cpp:
    #include "Animal.h"

Update the makefile to also compile Animal.cpp into Animal.o and link it with zoo.o to produce zoo.

Adding a AnimalsInZoo Class
Add a new class AnimalsInZoo to store 0 or 1 animals:
- Private: int numAnimals; and Animal animal;
- Constructors:
  1. One taking an Animal object and setting numAnimals to 1
  2. A default constructor setting numAnimals to 0
- display() should print numAnimals and then call Animal::display() if there is an animal

In main():
1. Create a AnimalsInZoo object
2. Add an animal to it
3. Call display()

Final File Structure
You should have:
1. Animal.h
2. Animal.cpp
3. AnimalsInZoo.h
4. AnimalsInZoo.cpp
5. zoo.cpp

Once the makefile builds everything successfully, the assignment is complete.


