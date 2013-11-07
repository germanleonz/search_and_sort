/*
 * Cay S. Horstmann & Gary Cornell, Core Java
 * Published By Sun Microsystems Press/Prentice-Hall
 * Copyright (C) 1997 Sun Microsystems Inc.
 * All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this 
 * software and its documentation for NON-COMMERCIAL purposes
 * and without fee is hereby granted provided that this 
 * copyright notice appears in all copies. 
 * 
 * THE AUTHORS AND PUBLISHER MAKE NO REPRESENTATIONS OR 
 * WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. THE AUTHORS
 * AND PUBLISHER SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED 
 * BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING 
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */
 
 /**
 * An easy interface to read numbers and strings from 
 * standard input
 * @version 1.10 10 Mar 1997
 * @author Cay Horstmann
 */

package algoritmosOrdenamiento;

public class Console
{  /**
    * print a prompt on the console but don't print a newline
    * @param prompt the prompt string to display
    */

   public static void printPrompt(String prompt)
   {  System.out.print(prompt + " ");
      System.out.flush();
   }
   
   /**
    * read a string from the console. The string is 
    * terminated by a newline
    * @return the input string (without the newline)
    */
    
   public static String readString()
   {  int ch;
      String r = "";
      boolean done = false;
      while (!done)
      {  try
         {  ch = System.in.read();
            if (ch < 0 || (char)ch == '\n')
               done = true;
            else if ((char)ch != '\r') // weird--it used to do \r\n translation
               r = r + (char) ch;
         }
         catch(java.io.IOException e)
         {  done = true;
         }
      }
      return r;
   }

   /**
    * read a string from the console. The string is 
    * terminated by a newline
    * @param prompt the prompt string to display
    * @return the input string (without the newline)
    */
    
   public static String readString(String prompt)
   {  printPrompt(prompt);
      return readString();
   }

   /**
    * read a word from the console. The word is 
    * any set of characters terminated by whitespace
    * @return the 'word' entered
    */
    
   public static String readWord()
   {  int ch;
      String r = "";
      boolean done = false;
      while (!done)
      {  try
         {  ch = System.in.read();
            if (ch < 0 
               || java.lang.Character.isWhitespace((char)ch))
               done = true;
            else
               r = r + (char) ch;
         }
         catch(java.io.IOException e)
         {  done = true;
         }
      }
      return r;
   }

   /**
    * read an integer from the console. The input is 
    * terminated by a newline
    * @param prompt the prompt string to display
    * @return the input value as an int
    * @exception NumberFormatException if bad input
    */
    
   public static int readInt(String prompt)
   {  while(true)
      {  printPrompt(prompt);
         try
         {  return Integer.valueOf
               (readString().trim()).intValue();
         } catch(NumberFormatException e)
         {  System.out.println
               ("Not an integer. Please try again!");
         }
      }
   }

   /**
    * read a floating point number from the console. 
    * The input is terminated by a newline
    * @param prompt the prompt string to display
    * @return the input value as a double
    * @exception NumberFormatException if bad input
    */
    
   public static double readDouble(String prompt)
   {  while(true)
      {  printPrompt(prompt);
         try
         {  return Double.valueOf
               (readString().trim()).doubleValue();
         } catch(NumberFormatException e)
         {  System.out.println
         ("Not a floating point number. Please try again!");
         }
      }
   }
}
