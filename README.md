# Phone_Book
HyperSkill Project #13

https://hyperskill.org/projects/63

Phone_Book/Phone Book/task/src/phonebook/
Source Code location

This project was a simple excercise to parse through two text files in order to simulate looking through a phonebook. The projected implemented the Strategy pattern in order to demonstrate different search and sort algorithms. The last method used shows the power of a Hashtable and Hashset which is faster than a sorted implementation of the Quicksort algorithm and a binary search.

The code should read through every name in the find.txt file and create a list of people to look for. The directory.txt file is a large repository of names and phone numbers of over a million different contacts.

The SearchProgram.java file is the main driver code for the program.

The first search used is the the least efficient method of a linear search in where it will look for every single name in the find.txt file and look through the entire directory.txt file until it finds or does not find a given name. The only advantage to this search algorithm is that the list does not need to be sorted.

The second search method uses the bubble sort and a jump sort algorithm in order to search. The code will exit the bubble sort if it takes more than 10 times the time it took the linear search and default to a linear search to finish. The bubble sort algorithm is extremely slow and inefficient. The jump search algorithm searches through blocks of a list. If the value is passed, the jump search becomes a linear search backwards from 1 to (block size of list). If the value is not in the block, the value does not exist.

The third search method uses the quicksort algorithm to sort the directory. The quicksort algorithm is very efficient in time and space complexity. A binary search simply looks through a list by halves and adjusts the left and right index based on how close it is to the value being searched for. 

The last search shows how much faster hashing is compared to a sort and search strategy for a given value in a list.
