/* Program Name: CooBrWages
 * Author : Brigham Cook
 * Date Written : 06/03/2018
 * Class : CIT 149 Java I
 * Chapter 3 Program 1
 * Description: This program will calculate an hourly employee’s pay based on 
 * regular hourly rates and time-and-a-half overtime pay. */

import java.util.Scanner;  // Used for keyboard input

public class CooBrWages
{
    // Declare constants - Must be done inside class, outside of main
    public static final double regularRate = 12.5;  // Set regular hourly rate to $12.50
    public static final double overtimeMultiplier = 1.5;  // Set the multiplier for overtime pay
    public static final int regularWorkWeek = 40;  // Define the number of hours in a regular work week
    public static final double minHours = 0.1;  // Define the minimum number of hours possible
    public static final double maxHours = 128;  // Define the maximum number of hours possible   
    
    public static void main( String [ ] args )
    {
      // Initialize variables
      double hoursWorked = 0.0;  // Total number of hours worked; may be in tenths of an hour
      double regularHours = 0.0;  // Initialize variable for the hours worked at the regular rate
      double regularPay = 0.0;  // Initialize variable for regular pay dollars earned
      double overtimeHours = 0.0;  // Initialize variable for the hours worked at the overtime rate 
      double overtimePay = 0.0;  // Initialize variable for the overtime pay dollars earned
      Scanner keyboard = new Scanner(System.in);  // Initialize "keyboard" as input scanner
      
      // Get user input
      System.out.print("Enter the number of hours worked (round to the nearest .1 hrs):");
      hoursWorked = keyboard.nextDouble();  // Get keyboard input for itemPrice
      hoursWorked = Math.round(hoursWorked * 10d) / 10d;  // Round data entered to 1 decimal place
      
      /* Only calculate for valid hours: Employee must have worked at least .1 hours and no more than
       * 128 hours. If hours entered are outside that range, display an error and exit program. */
      if (hoursWorked >= minHours && hoursWorked <= maxHours)
      {
        // Calculate compensation
        if (hoursWorked > regularWorkWeek)
        {
          // If the number of hours worked includes overtime, calculate overtime
          regularHours = regularWorkWeek;
          overtimeHours = hoursWorked - regularHours;
          overtimePay = overtimeHours * regularRate * overtimeMultiplier;
        }
        else
        {
          // If the number of hours worked does not include overtime, leave the
          // overtime variables at their default.
          regularHours = hoursWorked;
        }
        regularPay = regularHours * regularRate;  // Calculate pay for regular hours
        
        // Output section
        System.out.println("**** COMPENSATION CALCULATION ****\n");
        
        System.out.println("\tHours\t  Rate\t   Pay");  // Print table header
        
        // Print tab delimited values for regular hours
        System.out.print("Regular\t");
        System.out.printf("%4.1f\t", regularHours);  // Hours worked
        System.out.printf("$%3.2f\t", regularRate);  // Regular rate
        System.out.printf("$%7.2f\n", regularPay);   // Regular pay
                           
        // Print tab delimited values for overtime hours
        System.out.print("Overtime\t");
        System.out.printf("%4.1f\t", overtimeHours); // Hours worked
        System.out.printf("$%3.2f\t", overtimeMultiplier * regularRate);  // Overtime rate
        System.out.printf("$%7.2f\n", overtimePay);  // Overtime pay
                           
        System.out.println("---------------------------------------");
        
        // Print tab delimited values for total pay
        System.out.print("Total\t\t\t");
        System.out.printf("$%7.2f\n", regularPay + overtimePay);  // Regular pay + overtime pay
      }
      else
      {
        // Hours are outside of acceptable values
        System.out.println("Number of hours entered is less than " + minHours + " or greater than " + maxHours + ".");
        System.out.println("Program terminated.");
      }
   }
}