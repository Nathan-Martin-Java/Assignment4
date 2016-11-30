//Name:	Nathan Faucher & Martin Czerwinski
//Date:	November 23rd 2016
//File:	Discount.java

/******** Import Libraries ********/

import java.util.*;
import java.text.SimpleDateFormat;

public class Discount
{
	
	/******** Import Classes ********/
	
	static ArrayUtil ary = new ArrayUtil();
	
	
	
	/******** Declare Flags ********/
	
	
	private static Boolean flagCheckLaptop = false;
	private static Boolean flagCheckComp = false;
	private static Boolean flagCheckNetwork = false;
	private static Boolean flagCheckCable = false;
	private static Boolean flagCheckOffice = false;
	private static Boolean flagCheckHomeNet = false;
	private static Boolean flagCheckSeason = false;
	private static Boolean flagCheckFamily = false;
	
	
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
				if (flagCheckLaptop == false)
				{
					System.out.println("Laptop Code!");
					System.out.println("15% off laptops");
					System.out.println();
					flagSwitchActivated = true;
					flagCheckLaptop = true;
					break;
				}
				
				else
				{
					System.out.println("You Have Already Entered The Laptop Code!");
					System.out.println();
					flagSwitchActivated = true;
					break;
				}
			}
			
			case "Jxn4ns":
			{
				if (flagCheckComp == false)
				{
					System.out.println("Computer Peripherals Code!");
					System.out.println("25% off mice & keyboards");
					System.out.println();
					flagSwitchActivated = true;
					flagCheckComp = true;
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Computer Peripherals Code!");
					System.out.println();
					flagSwitchActivated = true;
					break;
				}
			}
			
			case "udXyj6":
			{
				if (flagCheckNetwork == false)
				{
					System.out.println("Networking Code!");
					System.out.println("20% off switches & routers");
					System.out.println();
					flagSwitchActivated = true;
					flagCheckNetwork = true;
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Networking Code!");
					System.out.println();
					flagSwitchActivated = true;
					break;
				}
			}
			
			case "Gc47wX":
			{
				if (flagCheckCable == false)
				{
					System.out.println("Ethernet Cable Code!");
					System.out.println("Half Off Ethernet Cables!");
					System.out.println();
					flagSwitchActivated = true;
					flagCheckCable = true;
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Ethernet Cable Code!");
					System.out.println();
					flagSwitchActivated = true;
					break;
				}
			}
			
			case "kc42Qj":
			{
				if (flagCheckOffice == false)
				{
					System.out.println("Home Office Starter Pack!");
					System.out.println("10% off Desktops, 30% off mice, keyboards & monitors!");
					System.out.println();
					flagCheckOffice = true;
					flagSwitchActivated = true;
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Home Office Starter Pack Code!");
					System.out.println();
					flagSwitchActivated = true;
					break;
				}
			}
			
			case "DQB6HS":
			{
				if (flagCheckHomeNet == false)
				{
					System.out.println("Home Networking Starter Pack!");
					System.out.println("15% off Wireless Access Points & Ethernet Cables!");
					System.out.println();
					flagCheckHomeNet = true;
					flagSwitchActivated = true;
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Home Networking Starter Pack Code!");
					System.out.println();
					flagSwitchActivated = true;
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
						if(flagCheckSeason == false)
						{
							System.out.println("Spring 15% off");
							System.out.println();
							flagCheckSeason = true;
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
						if(flagCheckSeason == false)
						{
							System.out.println("Summer 15% off");
							System.out.println();
							flagCheckSeason =true;
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
				
				case "FALL15":
				{
					if(month==9 || month==10 || month==11)
					{
						if(flagCheckSeason == false)
						{
							System.out.println("Fall 15% off");
							System.out.println();
							flagCheckSeason = true;
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
				
				case "WINTER15":
				{
					if(month==12 || month==1 || month==2)
					{
						if(flagCheckSeason == false)
						{
							System.out.println("Winter 15% off");
							System.out.println();
							flagCheckSeason=true;
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
				
				case "FAMILY":
				{
					if (flagCheckFamily == false)
					{
						System.out.println("You Entered The Friends and Family Discount");
						System.out.println();
						flagCheckFamily = true;
						break;
					}
					
					else
					{
						System.out.println("You Have Already Entered The Friends and Family Code!");
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
		flagSwitchActivated = false;
	}

	
	public static double[] total(String[] names, double[] price, int[] quantity)
	{	
		int index = 0;
		int tempQuantity = 0;
		double tempPrice = 0;
		double[] totalPrice = new double[price.length];
		
		for(int i = 0; i < totalPrice.length; i++)
		{
			totalPrice[i] = price[i] * quantity[i]; 
		}
		
		if(flagCheckLaptop == true)
		{
			index = ary.getIndex(names, "Laptop");
			tempPrice = price[index];
			tempQuantity = quantity[index];
			
			totalPrice[index] = (price[index] * 0.85) * quantity[index];
		}
		
		/*if(flagCheckComp == true)
		{
			ary.getIndex(names, name)
		}
		
		if(flagCheckNetwork == true)
		{
			ary.getIndex(names, name)
		}
		
		if(flagCheckCable == true)
		{
			ary.getIndex(names, name)
		}

		if(flagCheckOffice == true)
		{
			ary.getIndex(names, name)
		}
		
		if(flagCheckHomeNet == true)
		{
			ary.getIndex(names, name)
		}
		
		if(flagCheckSeason == true)
		{
			ary.getIndex(names, name)
		}
		
		if(flagCheckFamily == true)
		{
			ary.getIndex(names, name)
		}*/
		
		return totalPrice;
	}
}
