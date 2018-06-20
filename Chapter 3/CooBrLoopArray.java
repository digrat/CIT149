/* Program Name: CooBrLoopArray
 * Author : Brigham Cook
 * Date Written : 06/16/2018
 * Class : CIT 149 Java I
 * Chapter 3 Program 3
 * Description: This program will allow a user to input grades, which will be stored in an array.
 *  The array will then be sorted, averaged, totalled, and these results will be formatted and
 *  displayed to the user. */

/* Some code examples used:
 * https://stackoverflow.com/questions/25277286/exception-handling-with-scanner-nextint-vs-scanner-nextline
 */

import java.util.Arrays;        // Array sorting
import java.util.Collections;   // Array reverse sorting
import java.util.Scanner;       // Keyboard input
import java.util.InputMismatchException; // Error catch

public class CooBrLoopArray
{
    public static void main( String [ ] args )
    {
      // Initialize variables
      int numberOfGrades = 0;  // The number of grades to enter
      boolean invalidEntry = true; // Check to see if the user input is in the correct format
      double gradeValue[];  // The grade(s) entered by the user
      double gradeValueSorted[];  // The grade(s) entered by the user, sorted ascending, for display
      int gradeLoop = 0;  // Loop counter
      double gradeAverage = 0.0;  // The average of all entered grades
      double gradeTotal = 0.0;  // The sum of all entered grades
      Scanner keyboard = new Scanner(System.in);  // Initialize "keyboard" as input scanner
      
      /* *** Display program name and get user input *** */     
      System.out.println("*** Grade Calculator ***\n");
      // Get number of grades from user
      System.out.print("How many grades will be entered: ");
      do
      {
        try  // Ensure that user input is valid
        {
          numberOfGrades = keyboard.nextInt();  // Get input for menu selection
          invalidEntry = false;  // User entered valid integer! Yay!
        }
        catch (InputMismatchException ex)  // If input is not valid, have the user try again.
        {
          System.out.print("Entry is not valid, try again. How many grades will be entered: ");
          invalidEntry = true;  // User did not enter valid integer
          keyboard.nextLine();  // Consume the invalid entry and reset Scanner input to enable reentry of data
        }
      }
      while (invalidEntry && numberOfGrades > 0);

      /* Instantiate and dimension the array once I know how big it's supposed to be. 
       * I figured this one out by trial and error. :) */
      gradeValue = new double[numberOfGrades];  // Zero indexed, but this gives the number of elements, not the size
      gradeLoop = 0; // I think it's safe to assume the array lower bound will always be zero, at least in this program.

      //System.out.println("numberOfGrades = " + numberOfGrades);

      /* *** Populate grade array with input from user *** */
      do  // Do loop to fully populate grades
      {
        System.out.print("Enter grade " + (gradeLoop + 1) + ": ");
        do  // Do loop to check for valid entry
        {
          try  // Ensure that user input is valid
          {            
            gradeValue[gradeLoop] = keyboard.nextDouble();  // Get input for menu selection
            invalidEntry = false;  // User entered valid double
            //System.out.println("gradeValue[" + gradeLoop + "] = " + gradeValue[gradeLoop]);
            //System.out.println("gradeLoop = " + gradeLoop);
          }
          catch (InputMismatchException ex)  // If input is not valid, have the user try again.
          {
            System.out.print("Entry is not valid, try again. Enter grade " + (gradeLoop + 1) + ": ");
            invalidEntry = true;  // User did not enter valid integer
            keyboard.nextLine();  // Consume the invalid entry and reset Scanner input to enable reentry of data
          }
        }
        while (invalidEntry);  // End do loop to check for invalid entry
        gradeLoop++;
      }
      while (gradeLoop < numberOfGrades); // Pop out when the array's full!
      
      /* *** Calculate and display results *** */
      gradeLoop = gradeValue.length - 1;  // Reset the loop counter for another round, but do it backwards to display in reverse order
      gradeValueSorted = gradeValue;  // Assign the gradeValue array to gradeValueSorted, to keep the original array, just in case
      Arrays.sort(gradeValueSorted);  // Sort the grades

      System.out.println("The grades entered, sorted in descending order, are:");
      do  // Do loop to average and display grades
      {
        gradeTotal += gradeValueSorted[gradeLoop];  //  Add current grade to total
        System.out.println(gradeValueSorted[gradeLoop]);  // Print current grade
        gradeLoop--;  // Subtract 1 from gradeLoop to sort in reverse order
      }
      while (gradeLoop >= 0); // Pop out when all of the grades have been displayed
      //System.out.printf("gradeTotal: %1.2f\n numberOfGrades: %1d\n",gradeTotal,numberOfGrades);  // Troubleshooting
      gradeAverage = gradeTotal / numberOfGrades;  // Average the grades
      System.out.print("The average grade is ");
      System.out.printf("%1.2f",gradeAverage);
      System.out.println();      
   }
}