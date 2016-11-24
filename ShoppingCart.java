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

public class ShoppingCart
{
	static Discount discount = new Discount();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException
	{
		String inFilename;
		
		System.out.println("Please enter the name of the input file: ");
		
		inFilename = sc.nextLine();
		File file = new File(inFilename);
		Scanner inputFile = new Scanner(file);
		
		int arraySize = getArraySize(inFilename);
		
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
			itemPrice[i] = discount.bulk(itemQuantity[i],itemPrice[i]);
			System.out.println(itemPrice[i]);
			checkZero(itemPrice[i],i);
		}
		
	}
	public static void checkZero(double price,int i)
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
}