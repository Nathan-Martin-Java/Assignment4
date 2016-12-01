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
		
		inFilename = getInFile();				//prompt and get the infile then open it
		arraySize = getArraySize(inFilename);	//get the number of lines from the file
		
		String outFilename = getOutFile();		//prompt and get the outfile then open it
		
		
		
		/******** Create Arrays ********/
		
		String[] itemName = new String[arraySize];		//create a new array that is the size of arraySize for names
		double[] itemPrice = new double[arraySize];		//create a new array that is the size of arraySize for price
		double[] itemTotal = new double[arraySize];		//create a new array that is the size of arraySize for item totals before discounts
		double[] itemBulk = new double[arraySize];		//create a new array that is the size of arraySize for bulk discount
		double[] itemDiscount = new double[arraySize];	//create a new array that is the size of arraySize for item totals after all discounts
		int[] itemQuantity = new int[arraySize];		//create a new array that is the size of arraySize for quantity
		double[] itemSavings = new double[arraySize];	//create a new array that is the size of arraySize for savings per item total
		
		/******** Create Variables for Calculations ********/
		
		double highSavings = 0;
		double lowSavings = 100000;
		int lowIndex = 0;
		int highIndex = 0;
		
		/******** Populate Arrays ********/
		
		for (int i=0; i<arraySize; i++)			// NOTE: I'm concerned that we have to change this to a while loop based on the assignment rubric specifications
		{
			String line=inputFile.nextLine();
			String[] nextfield=line.split(",",-1);
			
			itemName[i] = nextfield[0];
			itemPrice[i] = Double.parseDouble(nextfield[1]); 
			itemQuantity[i] = Integer.parseInt(nextfield[2]);
		}	
		
		
		int i=0;
		for (i=0; i<arraySize; i++)
		{
			checkZer0(itemPrice[i],i);									//Checks for a zero value in the price field
			
			itemName[i] = upperCaser(itemName[i]);						//Transliterates the input file String column to Title Case
			
			itemBulk[i] = discount.bulk(itemQuantity[i],itemPrice[i]);	//Calculate the bulk discount price of an item
			
			itemTotal[i] = getTotal(itemPrice[i], itemQuantity[i]);
		}
		
		while(!code.equals(""))		//Gets the promo codes from the user
		{
			System.out.println("Please enter a promo code or press enter to exit:");
			code = sc.nextLine();
			
			discount.promo(code);
		}
		
		itemDiscount = discount.total(itemName, itemBulk, itemQuantity);	//Applies the promo codes to the appropriate items
		
		printTitles();					//Display Order Table - Colomun Names
		
		for (i=0; i<arraySize; i++)		//Display Order Table - Fields
		{
			printReceipt(itemName[i],itemQuantity[i],itemTotal[i],itemDiscount[i]);	
		}
		
		for (i=0; i<arraySize; i++)
		{
			itemSavings[i] = itemTotal[i] - itemDiscount[i];
	
			if (itemSavings[i] > highSavings)
			{
				highSavings = itemSavings[i];
				highIndex = i;
			}
			if (itemSavings[i] < lowSavings)
			{
				lowSavings = itemSavings[i];
				lowIndex = i;
			}
		}
		
		printCalcs(itemName[highIndex],itemName[lowIndex],highSavings,lowSavings);
		
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
	
	public static double getTotal(double itemPrice, int itemQuantity)
	{
		double itemTotal = itemPrice*itemQuantity;
		
		return itemTotal;
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
        System.out.println("\nITEM NAME\tITEM QUANTITY\tORIGINAL ITEM TOTALS\tDISCOUNTED ITEM TOTALS\n");
        outfile.writeLineToFile("\nITEM NAME\tITEM QUANTITY\tORIGINAL ITEM TOTALS\tDISCOUNTED ITEM TOTALS\n");
    }
	
	public static void printReceipt(String itemName, int itemQuantity, double itemTotal, double itemDiscount)
    {
        System.out.printf("\n%-10s\t%d\t\t$%8.2f\t\t$%8.2f\n", itemName, itemQuantity, itemTotal, itemDiscount);
        outfile.writeLineToFile("\n%-10s\t%d\t\t$%8.2f\t\t$%8.2f\n",itemName, itemQuantity, itemTotal,itemDiscount);
    }
	
	/******** Methods to Print the Receipt Table ********/
	
	public static void printCalcs(String highString, String lowString, double highSavings, double lowSavings)
	{
		System.out.println(highString);
		System.out.println(lowString);
		System.out.println(highSavings);
		System.out.println(lowSavings);
	}
	
}