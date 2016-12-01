//Name:	Nathan Faucher & Martin Czerwinski
//Date:	November 29th 2016
//File:	ArrayUtil.java



/******** Import Libraries ********/

import java.util.*;

public class ArrayUtil
{
	public static int getIndex(String[] array, String search) 	//method that finds the index of a string in a string array
																//and checks for duplicates within the array
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
				System.out.printf("\nFATAL: Two Instances of %s Were Found Within The Array", search);
				System.out.printf("\nFATAL: Check Your Infile For Duplicate Names");
				System.out.printf("\nFATAL: Program Will Now Halt");
				System.exit(-1);									//exit the program because it does not know how to differentiate
																	//between the first and second instances of the found word and
																	//the program does not know which instance to apply the discount to
																	//Note: This statement should never get activated due to new method below
			}
		}
		return index;	//return the index of the found string or return -1 if the string wasn't found
	}
	
	public static void checkDuplicate(String[] array)	//method that checks for duplicates in a single array
	{
		for(int i = 0; i < array.length; i++)			//loop that selects each item
		{
			for(int f = 0; f < array.length; f++)		//loop that compares selected item to each item (and itself)
			{
				if(array[i].equals(array[f]) && i != f)	//if the elements at the i index and f index are the same and the indexs are
														//different then there must be a duplicate
				{
					System.out.printf("\nFATAL: Two Instances of \"%s\" Were Found Within The Array at line %d & line %d", array[i], (i+1), (f+1));
					System.out.printf("\nFATAL: Check Your Infile For Duplicate Names");
					System.out.printf("\nFATAL: Program Will Now Halt");
					System.exit(-1);
				}
			}
		}
	}
}