/****************************************************************************
*	Name:																	*
*		Nathan Faucher														*
*		Martin Czerwinski													*
*	Date:																	*
*		November 23th 2016													*
*	File:																	*
*		ShoppingCart.java													*
*																			*
*	Functionality:															*
*																			*
*	Inputs:			Type:		Description:								*
*																			*
*	Outputs:		Type:		Description:								*
*																			*
*	Constants:		Type:		Value:		Description:					*
*																			*
*	Formulas:																*
*																			*
****************************************************************************/



/******** Import Libraries ********/

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ShoppingCart
{
	
	/******** Import Classes ********/
	
	static Discount discount = new Discount();
	static ArrayUtil ary = new ArrayUtil();
	
	
	
	/******** Create a New Scanner ********/
	
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) throws IOException
	{
		String inFilename = null;
		String code = "init";		//cannot be initialized to null because .equals() throws an exception
		
		System.out.println("Please enter the name of the input file: ");
		
		inFilename = sc.nextLine();
		File file = new File(inFilename);
		Scanner inputFile = new Scanner(file);
		
		int arraySize = getArraySize(inFilename);
		
		/******** Create a New Instance of the Utility Class ********/
		
		System.out.print("Please enter the path and file to which you wish to save the output: ");
		String Out = sc.nextLine();
		UtilityClass outfile = new UtilityClass(Out);  	
		outfile.openFile();
		
		String[] itemName = new String[arraySize];
		double[] itemPrice = new double[arraySize];
		int[] itemQuantity = new int[arraySize];
		
		for (int i=0; i<arraySize; i++)
		{
			String line=inputFile.nextLine();
			String[] nextfield=line.split(",",-1);
			
			itemName[i] = nextfield[0];
			itemPrice[i] = Double.parseDouble(nextfield[1]); 
			itemQuantity[i] = Integer.parseInt(nextfield[2]);
		}
		
		int i = 0;
		
		while(i < arraySize)
		{
			System.out.println(itemName[i]);
			System.out.println(itemPrice[i]);
			System.out.println(itemQuantity[i]);
			System.out.println();
		 	i++;
		}
		
		i=0;
		
		for (i=0; i<arraySize; i++)
		{
			checkZer0(itemPrice[i],i);
			
			itemName[i] = upperCaser(itemName[i]);
			System.out.println(itemName[i]);
			
			itemPrice[i] = discount.bulk(itemQuantity[i],itemPrice[i]);
			System.out.println(itemPrice[i]);
			
			System.out.println();
		}
		
		while(!code.equals("")) 
		{
			System.out.println("Please enter a promo code or press enter to exit:");
			code = sc.nextLine();
			
			discount.promo(code);
		}
		
		System.out.println("The Price of Laptops Before Discounts is " + (itemPrice[0]*itemQuantity[0]));
		itemPrice = discount.total(itemName, itemPrice, itemQuantity);
		System.out.println("The Price of Laptops After Discounts is " + itemPrice[0]);
		
		outfile.closeFile();
	}
	
	/******** Method to Transliterate to Uppercase ********/
	
	public static String upperCaser(String itemName)
	{
		String temp1 = itemName.toUpperCase().substring(0,1);
		itemName = temp1 + itemName.substring(1);
		
		int whitespace = itemName.indexOf(" ");
		if (whitespace != -1)
		{
			String temp2 = itemName.toUpperCase().substring(whitespace+1,whitespace+2);
			itemName = itemName.substring(0,whitespace+1) + temp2 + itemName.substring(whitespace+2);
		}
		return itemName;
	}

	/******** Check the price field for the value zero ********/
	
	public static void checkZer0(double price,int i)
	{
		if (price == 0)
		{
			System.out.printf("\nError: the price in line %d is zero.",i+1);
			System.exit(0);
		}
	}
	
	/******** Determines the number of lines in the input file ********/
	
	public static int getArraySize(String inFilename) throws IOException
	{
		int i = 0;
		File file = new File(inFilename);
		Scanner inputFile = new Scanner(file);
		
		String line=inputFile.nextLine();
		
		while(line!=null)
		{
			i++;
			try
			{
				line=inputFile.nextLine();
			}
			
			catch (Exception e)
			{
				break;
			}
			
		}
		return i;
	}
	
	/******** Method to Print the Receipt Table ********/
	
	public static void printBmi(String[] itemName, int[] itemQuantity, double[] itemPrice,int i, UtilityClass outfile)
    {
        System.out.printf("\n\t%-10s\t%d\t%.2f\t\t%.2f\t\t%.2f\n", itemName[i], itemQuantity[i], itemPrice[i]);
        outfile.writeLineToFile("\n\t%d\t%.2f\t\t%.2f\t\t%.2f\n",age[i], height[i], weight[i], bmi[i]);
    }
	
}