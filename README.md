Question 1: LaunchSequence Class [10 Marks]
The first thing we need is a class to represent a launch sequence. In a file “LaunchSequence.java” write a class LaunchSequence that will store a sequence of procedures.

The class should contain:

one or more private fields to store the sequence. Each procedure should be stored as a number 1, 2, 3, 4, 5, 6, 7, 8, or
Think carefully about the datatype that is best suited for this information.
a public constructor that takes a single int[] argument and uses it to initialise the sequence,
a public method int getProcedure(int i) that returns the procedure at position i in the sequence,
a public method String toString() that returns the sequence of procedures separated by spaces. E.g. for the sequence 3 4 1 2 5 it should return the string “3 4 1 2 5”.
Here you can assume that all sequences will be of length 5 and only contain numbers between 1 and 9. You do not need to do any validation in this class.

Compile your code and run

$ java -jar cs1811Assignment2TesterStudent.jar
All tests for Question 1 should now pass.

Question 2: ProposedSequence Class [10 Marks]
During each round of the game, the user will suggest a sequence. This attempt will receive a score depending on the number of correct procedures. In a file “ProposedSequence.java”, write a class ProposedSequence to store a sequence and its score.

The class should contain:

a public constructor that takes two LaunchSequence arguments. The first is the suggestion and the second is the solution,
the solution will be used later in the assignment to calculate the score (see Question 4),
three public getter methods
getSequence() that returns the suggested LaunchSequence,
getNumCorrect() that returns the number of correctly positioned procedures (suitable for the sequence and in the right spot) as an int, and
getNumWrongPosition() that returns the number of procedures that are suitable for the sequence, but are not in the right position (also as an int).
for now, getNumCorrect, and getNumWrongPosition can just return 0 (see Question 4),
a public toString() method that returns a String representing the procedure sequence followed by the number of correct and badly placed procedures – for example “9 3 7 4 1 (Correct 0, Wrong position 0)”. For now, the number of correct and wrongly-positioned procedures can be displayed as 0 (see Question 4).
For this, and subsequent, questions, you will need to decide yourself which fields the class needs (and their respective visibility). You should also decide whether intermediate methods are required to better structure your code.

Compile your code and run

$ java -jar cs1811Assignment2TesterStudent.jar
All tests for Question 2 should now pass.

Question 3: SequencePlanner Class [15 Marks]
We are now ready to build the sequence planning class to manage a play of the game. The scoring will not work yet (see the next question), but the main parts of the game will be brought together.

In a file “SequencePlanner.java”, write a class SequencePlanner that keeps track of the previous attempts in the game, and contains the following methods:

a public constructor that takes a single LaunchSequence argument that is the game solution,
a public method checkProposedSequence(LaunchSequence sequence) that creates a new ProposedSequence from the suggested sequence (sequence) and the game solution and stores the ProposedSequence at the head of a linked list. It returns a boolean that is true if and only if the proposed sequence is the one the Mission Controller expected. This can just return false for now (see Question 4).
public getter methods getPreviousSuggestions and getSolution, returning the head of the list of previous suggestions and the solution respectively. getPreviousSuggestions should return null when the list is empty.
In your linked list node class, override the toString method to return a string representation of the list (starting from the current (this) node to the end of the list). Each attempt should be displayed on a new line in the same format as the toString method of the ProposedSequence class. For example, the string may be

> 9 3 7 4 1 (Correct 3, Wrong position 2)
> 4 7 1 3 9 (Correct 0, Wrong position 5)
> 9 4 7 1 3 (Correct 1, Wrong position 4)
Important: you must write your own linked list data structure to store the list of attempts. Do not use the Java API LinkedList or similar library classes.

Compile your code and run

$ java -jar cs1811Assignment2TesterStudent.jar
All tests for Question 3 should now pass.

Question 4: Scoring [10 Marks]
We now look at the trickier task of scoring a proposed sequence. We can break this task down into two parts: calculating the number of procedures in the right place, calculating the procedures that belong in the sequence but are in the wrong position.

Revisit the ProposedSequence class. Complete the implementation of the getNumCorrect and getNumWrongPosition methods. That is, the getNumCorrect method should return the number of required procedures that are in the right position, and getNumWrongPosition should return the number of required procedures that should be moved to a different position.

For example, if we compare the proposed sequence 9 3 4 7 1 to the solution 9 3 7 4 1, then there are three procedures in the correct place (9, 3, and 1), and two that should be moved (4 and 7).

Next, add a public method isCorrect() to the ProposedSequence class that returns a boolean that is true if the suggestion fully matches the solution.

Finally, complete the checkProposedSequence method of the SequencePlanner class. It should return true if the suggested sequence matches the solution.

Compile your code and run

$ java -jar cs1811Assignment2TesterStudent.jar
All tests for Question 4 should now pass.

Question 5: Generate a Random Solution [10 Marks]
The simulation will be unrealistic if the trainee has to enter the solution before they start. To fix this, add to the SequencePlanner class a second public constructor that takes no arguments. Instead it should generate a random solution.

To do this, create a new int[] array of length 5, and fill it with random procedures. You can use the Java Random class. You can read about the Random class here.

The Random class can be used to generate random integers up to a maximum value.

It is important that the sequence you generate here is valid (i.e., no repetition and consisting only of procedures from Stellar Space Center). Your solution need not be fast.

Compile your code and run

$ java -jar cs1811Assignment2TesterStudent.jar
All tests for Question 5 should now pass.

Question 6: Command Line Interface [10 Marks]
Finally, we can complete the simulation with a user interface. This will be a simple command line program.

In a file “SequencePlannerCLI.java” declare a class SequencePlannerCLI that contains (at least) a main method and a method runSimulation that takes a single argument of type SequencePlanner and follows the workflow of the simulation.

The main method should only create a new SequencePlanner object (with a random solution) and then call the runSimulation method with that new object as parameter. You should not do any other kind of initialisation in main (or it might interfere with the tester).

The runSimulation workflow should consist of a loop which repeats until the user suggests the correct sequence. The loop should perform the following actions.

First print a line “Previous attempts:” followed by the list of previous attempts in the simulation. It should print the list of previous attempts with the most recent attempt at the top. You will need to iterate over the list returned by getPreviousSuggestions() on the SequencePlanner object. If there are no previous attempts, the program should display “No previous attempts”.
Next, it should ask the user to “Enter new sequence:” and read 5 procedures (integers) from the keyboard, each separated by a space.
The user input should be validated after all five numbers have been entered. You will always receive 5 integers. If you are given a number that does not correspond to a procedure at Stellar Space Center, the program should output “Invalid sequence!” and go back to the previous step (i.e. ask for another sequence). It should still ask for all 5 procedures, even if the first one is invalid.
If the suggested sequence is correct, print “Sequence verified!” then print the list of procedure names corresponding to the chosen procedure codes (one name per line). It is recommended that you implement the printing of the procedure names in a separate method.
An example run is given in the Overview section of this specification.

Compile your code and run

$ java -jar cs1811Assignment2TesterStudent.jar
All tests for Question 6 should now pass.

Question 7: Tracking Attempts [10 Marks]
Modify your game to keep track of how many valid attempts the player needs to find the correct sequence (the final correct attempt should also be counted).

When the correct sequence is found, display the number of attempts needed before showing the final sequence:

Sequence verified!
Launch Pad Clear
Navigation Setup
Communication Test
Crew Boarding
System Check
You needed X attempts to find the sequence.
Question 8: Code Quality [25 Marks]
Marks for this question will depend on the quality of your code. See the marking criteria section for an example of good vs. bad programming style, and also the global feedback from the formative coursework.

Take time to improve your code at this stage (whether or not it passes all tests). Try to avoid repetitive code and long/complicated methods.

Important: make sure your submitted code compiles with the command

$ javac *.java
Code that does not compile cannot pass any tests, and will lose 75 marks!

Once you have submitted your solution on Moodle, download it again and test it.
