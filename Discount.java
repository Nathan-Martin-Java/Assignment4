//Name:	Nathan Faucher & Martin Czerwinski
//Date:	November 23rd 2016
//File:	Discount.java



/******** Import Libraries ********/

import java.util.*;
import java.text.SimpleDateFormat;

public class Discount
{
	
	/******** Declare Flags ********/
	
	private static Boolean flagSeason = false;
	private static Boolean flagFamily = false;
	
	
	/******** Create Month Format ********/
	
	static SimpleDateFormat monthFormat 	= new SimpleDateFormat("MM");
	
	
	
	/******** Method For Bulk Discount ********/
	
	public static double bulk(int quantity, double price) 	//pass quantity and current price
	{
		double priceDisc=0;			//initialize the discount amount
		
		if (quantity >= 100)		//if quantity is 100+
		{
			priceDisc = price*0.80;	//apply a 20% discount
		}
		
		else if (quantity >= 50)	//if quantity is 50-99
		{
			priceDisc = price*0.85;	//apply a 15% discount
		}
		
		else if (quantity >= 25)	//if quantity is 25-49
		{
			priceDisc = price*0.90;	//apply a 10% discount
		}
		
		else if (quantity >= 10)	//if quantity is 10-24
		{
			priceDisc = price*0.95;	//apply a 5% discount
		}
		
		else						//if quantity is 0-9
		{
			priceDisc = price;		//do not apply a discount
		}
		return priceDisc;			//return the updated value of price
	}
	
	
	
	/******** Method For Bulk Discount ********/
	
	public static void promo(String code)					//pass the promo code
	{
		Boolean flagSwitchActivated = false;				//initialize Boolean to see if first switch was activated
		int month = 0;										//initialize month
		
		Date date = new Date();								//create a new instance of date
		month = Integer.parseInt(monthFormat.format(date));	//parse the new instance of date so it only has the month in number format
		
		
		
		switch(code)	//switch for case sensitive codes
		{
			case "F3qytr":
			{
				System.out.println("Laptop Code!");
				System.out.println("15% off laptops");
				System.out.println();
				flagSwitchActivated = true;
				break;
			}
			
			case "Jxn4ns":
			{
				System.out.println("Computer Peripherals Code!");
				System.out.println("25% off mice & keyboards");
				System.out.println();
				flagSwitchActivated = true;
				break;
			}
			
			case "udXyj6":
			{
				System.out.println("Networking Code!");
				System.out.println("20% off switches & routers");
				System.out.println();
				flagSwitchActivated = true;
				break;
			}
			
			case "Gc47wX":
			{
				System.out.println("Ethernet Cable Code!");
				System.out.println("Half Off Ethernet Cables!");
				System.out.println();
				flagSwitchActivated = true;
				break;
			}
			
			case "kc42Qj":
			{
				System.out.println("Home Office Starter Pack!");
				System.out.println("10% off Desktops, 30% off mice, keyboards & monitors!");
				System.out.println();
				flagSwitchActivated = true;
				break;
			}
			
			case "DQB6HS":
			{
				System.out.println("Home Networking Starter Pack!");
				System.out.println("15% off Wireless Access Points & Ethernet Cables!");
				System.out.println();
				flagSwitchActivated = true;
				break;
			}
		}
		
		if(flagSwitchActivated==false)	//if the first switch was not activated
		{
			switch(code.toUpperCase())	//switch for case insensitive codes
			{
				case "":
				{
					break;
				}
				case "FULLCOMMIE":
				{
					System.out.println("Glory to the motherland!");
					System.out.println();
					break;
				}
				
				case "SPRING15":
				{
					if(month==3 || month==4 || month==5)
					{
						if(flagSeason == false)
						{
							System.out.println("Spring 15% off");
							System.out.println();
							flagSeason = true;
							break;
						}
					
						else
						{
							System.out.println("You have already entered the season discount.");
							System.out.println();
							break;
						}
					}
					else
					{
						System.out.println("Invalid Option");
						System.out.println();
					}
					break;
				}
				
				case "SUMMER15":
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
				
				case "WINTER15":
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
				
				case "FAMILY":
				{
					if (flagFamily == false)
					{
						System.out.println("You Entered The Friends and Family Discount");
						System.out.println();
						flagFamily = true;
						break;
					}
					
					else
					{
						System.out.println("You Have Already Entered That Code!");
						System.out.println();
						break;
					}
					
				}
				
				default:
				{
					System.out.println("Invalid Option");
					System.out.println();
					break;
				}
			}
		}
		
		flagSwitchActivated = false;	//reset first switch activated Boolean to false
		
	}
	
	/*public static void total()
	{
		if(flagLaptop = true)
		{
			
		}
	}*/
}