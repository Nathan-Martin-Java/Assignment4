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

import java.io.*;
import java.util.*;

public class ShoppingCart
{
	static Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
	static Discount discount = new Discount();
=======
>>>>>>> origin/master
	
	public static void main(String[] args) throws IOException
	{
		
		
		
		String inFilename;
		System.out.println("Please enter the name of the input file: ");
		inFilename = sc.nextLine();
		File file = new File(inFilename);
		Scanner inputFile = new Scanner(file);
		
		int arraySize = getArraySize(inFilename);
		
		String[] itemName = new String[arraySize];
		double[] price = new double[arraySize];
		int[] quantity = new int[arraySize];
		
		for (int i=0; i<arraySize; i++)
		{
			String line=inputFile.nextLine();
			String[] nextfield=line.split(",",-1);
			
			itemName[i] = nextfield[0];
			price[i] = Double.parseDouble(nextfield[1]); 
			quantity[i] = Integer.parseInt(nextfield[2]);
		}
		
		int i = 0;
		
		while(i < arraySize)
		{
			System.out.println(itemName[i]);
			System.out.println(price[i]);
			System.out.println(quantity[i]);
			System.out.println();
			i++;
		}
		i=0;
		for (i=0; i<arraySize; i++)
		{
			price[i] = discount.bulk(quantity[i],price[i]);
			System.out.println(price[i]);
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