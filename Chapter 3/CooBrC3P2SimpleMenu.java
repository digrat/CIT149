/* Program Name: CooBrC3P2SimpleMenu
 * Author : Brigham Cook
 * Date Written : 06/10/2018
 * Class : CIT 149 Java I
 * Chapter 3 Program 2
 * Description: This program will prompt the user for a type of shape, then calculate the
 * area of that shape based on further user input. */

import java.util.Scanner;  // Used for keyboard input

public class CooBrC3P2SimpleMenu
{
    public static void main( String [ ] args )
    {
      // Initialize variables
      int optionSelected = 0;  // The selected menu item
      double shapeArea = 0.0;  // The calculated area of the selected shape
      String shapeName = "";  // The name of the selected shape
      String shapeParameters = "";  // The parameters that go in to calculating the area
      boolean errorEncountered = false;  // Set to true if an error was found in the menu selection
      Scanner keyboard = new Scanner(System.in);  // Initialize "keyboard" as input scanner
      
      // Display menu and get user input
      System.out.println("Calculate the area for which type of shape?");
      System.out.println("1. Area of a rectangle");
      System.out.println("2. Area of a circle");
      System.out.println("3. Area of a triangle");
      System.out.println();
      System.out.print("Enter the number of the selection (1, 2, or 3): ");
      optionSelected = keyboard.nextInt();  // Get input for menu selection
      System.out.println();

      // If the user selected rectangle
      if (optionSelected == 1)
      {
        shapeName = "rectangle";
        double rectangleWidth = 0.0;  // The width of the rectangle
        double rectangleHeight = 0.0;  // The height of the rectangle
        
        // Prompt the user for input
        System.out.print("Enter the rectangle width: ");
        rectangleWidth = keyboard.nextDouble();
        System.out.print("Enter the rectangle height: ");
        rectangleHeight = keyboard.nextDouble();
        
        // Calulate the area of a rectangle = width * height
        shapeArea = rectangleWidth * rectangleHeight;
        // Define the paramaters used
        shapeParameters = "width of " + rectangleWidth + " and height of " + rectangleHeight;
      }
      // If the user selected circle
      else if (optionSelected == 2)
      {
        shapeName = "circle";
        double circleRadius = 0.0;  // The radius of the circle

        // Prompt the user for input
        System.out.print("Enter the circle radius: ");
        circleRadius = keyboard.nextDouble();

        // Area of a circle = Math.PI * radius^2
        shapeArea = Math.PI * circleRadius * circleRadius;
        // Define the paramaters used
        shapeParameters = "radius of " + circleRadius;
      }
      // If the user selected circle
      else if (optionSelected == 3)  // Triangle
      {
        shapeName = "triangle";
        double triangleBase = 0.0;  // The base of the triangle
        double triangleHeight = 0.0;  // The height of the triangle

        // Prompt the user for input
        System.out.print("Enter the triangle base: ");
        triangleBase = keyboard.nextDouble();
        System.out.print("Enter the triangle height: ");
        triangleHeight = keyboard.nextDouble();
        
        // Calculate the area of a triangle = 1/2 base * height
        shapeArea = (triangleBase * triangleHeight) / 2;
        // Define the paramaters used
        shapeParameters = "base of " + triangleBase + " and height of " + triangleHeight;
      }
      // If the user entered an unexpected response 
      else 
      {
        System.out.println("Error: Entry did not match expected value.");
        errorEncountered = true;  // An error was encountered
      }
      
      // If an error was not encountered, display the results. 
      if (!errorEncountered)
      {
        // Output section
        System.out.println();
        // Use the shapeParameters to display the entered criteria for the selected shape
        System.out.print("The area of a " + shapeName + " with " + shapeParameters + " is ");
        System.out.printf("%1.4f",shapeArea);
        System.out.println();
      }
      
   }
}