Coding Project 1 (CP1):
Dynamic Growable Array
CS310: Data Structures & Algorithms
Fall 2025

The goal of Coding Project 1 (CP1) is to build support for dynamic storage of Animals on the heap, in memory allocated by new,  not physically within the object itself. In particular, your CP1 AnimalsInZoo class should contain data members that include a pointer to an Animal(for storing the dynamically allocated array of Animals), and two unsigned ints, to represent the capacity and the number of Animals currently stored.

Please begin by adding data members to your Animal class, to store an animal’s weight (as a float), and a boolean that indicates whether the animal is dangerous. Create a value constructor that takes and stores 3 arguments, for the animal’s name (string), weight (float), and dangerousness (bool).

Your CP1 code should implement the following functions, with behavior indicated: 

bool AnimalsInZoo::store(Animal &another_animal);
Adds an animal to the zoo by placing it in the first available spot in the contained dynamically allocated array. If your zoo container fills up, it should expand and move into a larger space. So the store() function should never return false or report that it cannot store more animals. (The return type should remain bool, however.). This function should generate output to cout of the form:
Animal <animal_name> added to spot <N> of the contained array.
The angle brackets should be replaced with data… so for example an actual output message might be:
Animal Aardvark added to spot 4 of the contained array.
When your array grows out of necessity (i.e. when the user asks to store another animal and there is no more room), it should double in size.

bool AnimalsInZoo::remove(const string& animal_name);
Removes an Animal object whose name matches animal_name. Returns true if an Animal is found and removed, false if an animal by that name is not found. A failed remove also results in the following message on standard output (cout):
Animal <animal_name> not found.
<animal_name should be replaced with the name of the animal that was passed as a parameter. For example, 
Animal Zebra not found.
Remove an animal by copying the animal in the last position into the position of the animal being removed.

Animal AnimalsInZoo::find(const string& animal_name);
Returns a copy of the first animal whose name matches animal_name. If no such animal exists, this function should return a copy of an object created with the Animal default (empty) constructor.

void AnimalsInZoo::readSizes(unsigned int &count, unsigned int &capacity);
This function should fill in the parameters count and capacity to store the number of Animals currently stored in the object, and the number of array locations currently allocated for Animals, respectively. 

void AnimalsInZoo::show() const; 
Show all the animals in the object, one per line, with the following format for each line:
<i>: <animal_name>, <pounds> lbs [be careful!]
“be careful!” should be printed if the animal is dangerous.
Actual output, depending on data, might be:
0: kittycat, 8 lbs
1: Tiger, 100 lbs be careful!
2: alligator, 200 lbs be careful!
3: monkey, 22 lbs

AnimalsInZoo::AnimalsInZoo();
AnimalsInZoo::AnimalsInZoo(unsigned int initial_capacity);
The initial size of your array should be set to 1 when the default constructor is used to create an AnimalsInZoo object. But your AnimalsInZoo class should also support an initial value constructor that takes a single unsigned int parameter that specifies the initial size of the array. You should disallow 0 as a parameter to this initial value constructor and instead allocate an array of size 1 with an initial capacity of 1 if the user passes a 0.

unsigned int AnimalsInZoo::makeSpace(unsigned int how_many=0);
This function allows the user of your class to make additional space, even if the array is not full. If the user passes a positive number as an int parameter, then the array should expand to include that many more spaces for Animals. If the user passes 0 or omits the parameter to this function, then the array should double in size. This function should return the number of spaces added to the capacity. If it doubles from 8 to 16 spaces, then the function should return 8. If the function adds 9 spaces, the function should return 9..

Accepting the Assignment

To implement the assignment, accept the GitHub classroom assignment by clicking the link provided in Brightspace. Copy over your files from CP0 and add them to your repo (git add followed by git commit and git push). The repository provided in the GitHub classroom is empty this time (no starter code or sample executable, etc.). If we give you anything to test your CP1 code, we will do so outside of the initially cloned assignment repository.
