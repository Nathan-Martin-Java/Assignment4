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
	
	
	
	/******** Create New Scanners ********/
	
	static Scanner sc = new Scanner(System.in);
	static Scanner inputFile;
	static UtilityClass outfile;
	
	
	
	public static void main(String[] args) throws IOException
	{
		
		/******** Declare Variables ********/
		
		String inFilename = null;	//creates a string for to hold the infile name
		String code = "init";		//cannot be initialized to null because .equals() throws an exception
		
		int arraySize = 0;			//integer to hold the size of the arrays
		
		inFilename = getInFile();				//prompt and get the infile
		arraySize = getArraySize(inFilename);	//get the number of lines from the file
		
		String outFilename = getOutFile();
		
		
		
		
		
		
		String[] itemName = new String[arraySize];	//create a new array that is the size of arraySize for names
		double[] itemPrice = new double[arraySize];	//create a new array that is the size of arraySize for price
		double[] itemTotal = new double[arraySize];
		int[] itemQuantity = new int[arraySize];	//create a new array that is the size of arraySize for quantity
		
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
		itemTotal = discount.total(itemName, itemPrice, itemQuantity);
		System.out.println("The Price of Laptops After Discounts is " + itemPrice[0]);
		
		printTitles();
		for (i=0; i<arraySize; i++)
		{
			printReceipt(itemName[i],itemQuantity[i],itemPrice[i]);
		}
	}
	
	public static String getInFile() throws IOException
	{
		System.out.println("Please enter the name of the input file: ");
		
		String filename = sc.nextLine();
		File file = new File(filename);
		inputFile = new Scanner(file);
		
		return filename;
	}
	
	/******** Create a New Instance of the Utility Class ********/
	
	public static String getOutFile() throws IOException
	{
		System.out.print("Please enter the path and file to which you wish to save the output: ");
		String Out = sc.nextLine();
		outfile = new UtilityClass(Out);  	
		outfile.openFile();
		return Out;
	}
	
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

	public static void checkZer0(double price,int i)
	{
		if (price == 0)
		{
			System.out.printf("\nError: the price in line %d is zero.",i+1);
			System.exit(0);
		}
	}
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
	
	/******** Methods to Print the Receipt Table ********/
	
	public static void printTitles()
    {
        System.out.println("\nITEM NAME\tITEM QUANTITY\tITEM PRICE\n");
        outfile.writeLineToFile("\nITEM NAME\tITEM QUANTITY\tITEM PRICE\n");
    }
	
	public static void printReceipt(String itemName, int itemQuantity, double itemPrice)
    {
        System.out.printf("\n%-10s\t%d\t%.2f\n", itemName, itemQuantity, itemPrice);
        outfile.writeLineToFile("\n%-10s\t%d\t%.2f\n",itemName, itemQuantity, itemPrice);
    }
}