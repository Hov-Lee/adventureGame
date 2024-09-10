package com.company;

/*
  Description: The class will hold methods that may be applicable to multiple classes

  @Author: Hovan Lee
  @Version: June 14, 2021
*/

// Import Java classes
import java.util.Scanner;
import java.util.ArrayList;

class Generic { // Start of Generic
  /*
      Description: The method gets a string from the user

      @Author: Hovan Lee
      @Version: June 14, 2021
  */
  public static String getString (byte bytType, String strMessage, String strCondition1, String strCondition2) 
  {
    // Stores the user's input
    String strInput;
    // Stores whether this is a valid input
    boolean bolValidInput;

    do {
      // Reset bolValidInput
      bolValidInput = true;

      // Print the prompt out to the user and record their response
      System.out.print(strMessage);
      strInput = new Scanner(System.in).nextLine().trim();

      // Check if the user entered anything
      if (strInput.length() == 0) {
          // Warn the user that their input is invalid and record the error
          System.out.println("Error: Please input something\n");
          bolValidInput = false;
      } // End of catching nothing being entered

      // Checks if this instance needs specific inputs
      if (bolValidInput && bytType == 1 && !strInput.equalsIgnoreCase(strCondition1) && !strInput.equalsIgnoreCase(strCondition2))
      {
          // Warn the user that their input is invalid and record the error
          System.out.println("Error: Invalid input\n");
          bolValidInput = false;
      } // End of catching an invalid input
    } while (!bolValidInput); // Ask until the user enters a valid input

    return strInput;
  } // End of getString


  /*
      Description: The method gets a byte from the user

      @Author: Hovan Lee
      @Version: June 14, 2021
  */
  public static byte getByte (byte bytType, String strMessage, byte bytMin, byte bytMax) {
      // Stores the user's input
      byte bytInput = 0;
      // Stores whether this is a valid input
      boolean bolValidInput;

      do 
      {
        // Reset bolValidInput
        bolValidInput = true;

        // Print the prompt out to the user and record their response
        System.out.print(strMessage);

        try
        {
            bytInput = new Scanner(System.in).nextByte();
        }
        catch (Exception e)
        {
            // Warn the user that their input is not a byte and record the error
            System.out.println("Error: Please enter a byte\n");
            bolValidInput = false;
        }
        
        // Checks if this instance needs to be in a range
        if (bolValidInput && bytType == 1)
        {
          // Check if the number is in the range
          if (bytInput < bytMin || bytInput > bytMax)
          {
              // Warn the user that their input is out of bounds and record the error
              System.out.println("Error: Input is out of the range\n");
              bolValidInput = false;
          } // End of catching an out of bounds number
        } // End of catching an invalid input
      } while (!bolValidInput); // Ask until the user enters a valid input

      return bytInput;
  } // End of getString


  /*
      Description: The method prints out an entire ArrayList

      @Author: Hovan Lee
      @Version: June 14, 2021
  */
  public static void printArrayList (ArrayList alArray)
  {
    // Print the elements of the array and a corresponding number
    for (int i = 0; i < alArray.size(); i++)
    {
        // Print out the corresponding number to the element and the element itself
        System.out.println("\n" + (i+1) + ".");
        System.out.print(alArray.get(i));
        
        // Give the element some space
        System.out.println();
    } // End of printing the elements of the array
  } // End of printArrayList
} // End of Generic