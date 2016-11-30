//Name:	Nathan Faucher & Martin Czerwinski
//Date:	November 29th 2016
//File:	ArrayUtil.java



/******** Import Libraries ********/

import java.util.*;

public class ArrayUtil
{
	public static int getIndex(String[] array, String search) 	//pass quantity and current price
	{
		int index = -1;							//set index to -1 (for Error) if String was not found
		Boolean wasFound = false;
		
		for(int i = 0; i < array.length; i++)	//for loop that runs while i is less than the number of elements in the array
		{
			if(search.equals(array[i]) && wasFound == false)
												//if the imported string "search" equals the array's string at index i and
												//a string of that name has not been found yet
			{
				index = i;						//index is equal to i because that is where the string
				wasFound = true;					
			}
			
			else if(search.equals(array[i]) && wasFound == true)	//if search = array at i and search has already been found
			{														//print some error messages
				System.out.printf("\n\nFATAL: Two Instances of %s Were Found Within The Array", search);
				System.out.printf("\nFATAL: Check Your Infile For Duplicate Names");
				System.out.printf("\nFATAL: Program Will Now Halt");
				System.exit(-1);									//exit the program because it does not know how to differentiate
																	//between the first and second instances of the found word and
																	//the program does not know which instance to apply the discount to
			}
		}
		return index;	//return the index of the found string or return -1 if the string wasn't found
	}
	
	public static void checkDuplicate(String[] array)
	{
		for(int i = 0; i < array.length; i++)	//for loop that runs while i is less than the number of elements in the array
		{
			for(int f = 0; f < array.length; f++)
			{
				if(array[i].equals(array[f]) && i != f)
				{
					System.out.println("Duplicate found at different location. !!!ERROR!!!");
				}
			}
		}
	}
}