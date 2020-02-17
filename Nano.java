
//  THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR
//  OR CODE WRITTEN BY OTHER STUDENTS - Laura Neff


import java.util.Arrays;

public class Nano
{
   public static char[] digit
            = {'#', '!', '%', '@', '(', ')', '[', ']', '$'};

   /* ==========================================================
      Return the 2's complement binary representation for the
      Nano number given in String s
      ========================================================== */


   public static int Power(int k)
   {
      int r = 1;   // Stores: 00000000000000000000000000000001  in variable r

      for (int i = 0; i < k; i++ )
      {
         r = r * 9;  // The Java compiler will convert 9 into the
         // binary number 0000000000000000000000000001001
         // This statement will multiply bin number r
         // with 00000000000000000000000000001001
      }

      return r;    // Returns a BINARY number in 2's compl
      // that represents the VALUE 9^k
   }



   public static int parseNano(String s)
   {
      /* ------------------------------------------------------------------
         This loop checks if the input contains an illegal (non-Nano) digit
         ------------------------------------------------------------------ */
      for (int i = 0 ; i < s.length(); i++)
      {
         int j = 0;
         while ( j < digit.length )
         {
            if ( s.charAt(i) == digit[j] || s.charAt(i) == '-' )
            {
               break;
            }

            j++;
         }

         if (j >= digit.length)
         {
            System.out.println("Illegal nano digit found in input: "
					+ s.charAt(i) );
            System.out.println("A Nano digit must be one of these: "
				+ Arrays.toString (digit) );
            System.exit(1);
         }
      }



      // Write the parseNano() code here

      int[] humandigit = new int[20]; // Used to store individual digits in String s
      int  value;
      int  sign = 1;
      int  pos;
      int  len = s.length();

      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == '-'){
            sign = -1;
            len--;
            continue;
         }

         for (int num=0; num < digit.length; num++){
            if(digit[num]==s.charAt(i)){
               if(sign==-1){
                  humandigit[i-1] = num;
               } else {
                  humandigit[i] = num;
               }
               break;
            }
         }

      }

         /* ------------------------------------------
         Compute the absolute value of the number
         ------------------------------------------ */
      value = 0;

      for (int k = 0; k < len; k++)
      {
         /* ---------------------------------------------------------------
            Value of the digits:

               digit[0] ...  digit[k]    ...     digit[len-2] digit[len-1]
                           10^((len-1)-k)            10^1          10^0
            ---------------------------------------------------------------- */
         pos = (len - 1) - k;

         value = value + humandigit[k]*Power(pos);  // High school knowledge....
      }


      /* ========================================================
         Negate 2's complement representation if first character
	 of input was '-'
	 ========================================================= */
      value = sign*value;  // Compute the signed value (= flip bits and add 1 !!)

      // Return a BINARY 2's compl code

      return(value);
   }



   /* ==========================================================
      Return the String of Nano digit that represent the value
      of the 2's complement binary number given in
      the input parameter 'value'
      ========================================================== */
   public static String toString(int value)
   {
      // Write the toString() code here

      boolean valueWasNeg;
      int remainder[] = new int[200];
      char nanodigit[] = new char[200];  // Max 100 digits in number
      String result;
      int   nDigits;

      if (value < 0)
      {
         valueWasNeg = true;
         value = -value;        // Negate to make input positive

      }

      else
      {
         valueWasNeg = false;
      }


      /* -------------------------------------------------------
         Get all digit by collecting remainders divided by 9
         ------------------------------------------------------- */
      nDigits = 0;              // Count # digits in number

      if(value == 0){
         remainder[0] = 0;
         nDigits++;
      }

      while (value > 0)
      {
         remainder[nDigits] = value % 9;
         nDigits++;

         value = value / 9;
      }

      for (int i = 0; i < nDigits; i++)
      {
         nanodigit[i] = digit[remainder[i]];

      }
      /* ---------------------------------------------------------
         Make a string (start with last remainder)
         --------------------------------------------------------- */
      result = "";                              // Initialize output string

      for (int i = nDigits-1; i >= 0; i--)
         result = result + nanodigit[i];            // Add next digit


      /* ---------------------------------------------------------
         Prepend '-' if input was negative
         --------------------------------------------------------- */
      if (valueWasNeg == true)
      {
         result = "-" + result;   // Try: "******" + result for banks
      }

      return(result);
   }


   

   }



