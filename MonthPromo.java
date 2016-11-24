//Name:	Nathan Faucher & Martin Czerwinski
//Date:	November 23rd 2016
//File:	MonthPromo.java

import java.util.*;
import java.text.SimpleDateFormat;

public class MonthPromo
{
	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat monthFormat 	= new SimpleDateFormat("MM");
	
	public static void main(String[] args)
	{
		String promo = null;
		int month = 0;
		
		Date date = new Date();
		month = Integer.parseInt(monthFormat.format(date));
		
		System.out.println("The current month is " + month);
		
		while(true)	//infinite loop because while loops run while a statement is true
					//true is always true so this loop runs infinitely 
		{
			System.out.println("Please enter a promo code or press enter to exit:");
			promo = sc.nextLine();
			
			switch(promo.toUpperCase())	//switch for case insensitive codes
			{
				case "":
				{
					System.exit(0);
				}
				
				case "SPRG15":
				{
					if(month==3 || month==4 || month==5)
					{
						System.out.println("Spring 15% off");
						System.out.println();
					}
					
					else
					{
						System.out.println("Invalid Option");
						System.out.println();
					}
					break;
				}
				
				case "SMMR15":
				{
					if(month==6 || month==7 || month==8)
					{
						System.out.println("Summer 15% off");
						System.out.println();
					}
					
					else
					{
						System.out.println("Invalid Option");
						System.out.println();
					}
					break;
				}
				
				case "FALL15":
				{
					if(month==9 || month==10 || month==11)
					{
						System.out.println("Fall 15% off");
						System.out.println();
					}
					
					else
					{
						System.out.println("Invalid Option");
						System.out.println();
					}
					break;
				}
				
				case "WNTR15":
				{
					if(month==12 || month==1 || month==2)
					{
						System.out.println("Winter 15% off");
						System.out.println();
					}
					
					else
					{
						System.out.println("Invalid Option");
						System.out.println();
					}
					break;
				}
				
				default:
				{
					System.out.println("Invalid Option");
					System.out.println();
					break;
				}
			}
		}
	}
}