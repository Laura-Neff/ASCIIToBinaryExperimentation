// Test program for cs255 pj3
// DO NOT make any changes to this program
//
// For pj3, you must write another program in file "Nano.java"
// that contains the static methods:
//
//         public static int parseNano(String s)
//         public static String toString(int a)
//
// Compile the program (after you have written "Nano.java")
// with:
//         javac pj3.java
//
// and run it with the command:
//         java pj3
//

import java.util.Scanner;


public class pj3
{
   public static char[] digit
            = {'#', '!', '%', '@', '(', ')', '[', ']', '$'};

   public static void main (String[] args)
   {
      Scanner in = new Scanner(System.in);

      String s;
      int x, y, z;

      System.out.println("For your convenience, here are the Nano digits:\n");

      System.out.print("Nano digit:     ");
      for ( int i = 0; i < digit.length; i++ )
          System.out.print( digit[i] + "  " );
      System.out.println();

      System.out.print("Value of digit: ");
      for ( int i = 0; i < digit.length; i++ )
          System.out.print( i + "  " );
      System.out.println("\n");

      System.out.print ("Enter first Nano number x = ");
      s = in.next();
      x = Nano.parseNano(s);  // Convert septadecimal number to binary

      System.out.println("\nDebug: your parseNano() function returned this 2s complement code:");
      System.out.print("                    ");
      PrintBits(x);
      System.out.println("\nDebug: decimal value represented by code = "
                          + x + "\n");

      System.out.print ("Enter second Nano number y = ");
      s = in.next();
      y = Nano.parseNano(s);  // Convert septadecimal number to binary
      System.out.println("\nDebug: your parseNano() function returned this 2s complement code:");
      System.out.print("                    ");
      PrintBits(y);
      System.out.println("\nDebug: decimal value represented by code = "
                          + y + "\n");

      z = x + y;
      System.out.print("The sum in binary = ");
      PrintBits(z);
      System.out.println("\nDecimal value represented by binary number = "
                          + z + "\n");

      System.out.println ("The representation in Nano number system = " +
				Nano.toString(z) + "\n" );
      System.out.println ("(This representation was returned by your toString( ))");
      System.out.println ("(Check if this string indeed represents the correct value !)");
   }



   public static void PrintBits(int x)
    {
      int i;

      for (i = 31; i >= 0; i--)
         if ( (x & (1 << i)) != 0 )
            System.out.print("1");
         else
            System.out.print("0");
    }

}

