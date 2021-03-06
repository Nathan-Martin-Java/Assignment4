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
			case "":	//case for if enter was pressed without any characters
			{
				flagSwitchActivated = true;	//activates a flag so that the second switch is not activated
				break;
			}
				
			case "F3qytr":
			{
				if (flagCheckLaptop == false)				//checks if the code has been entered already
				{
					System.out.println("Laptop Code!");
					System.out.println("15% off laptops");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					flagCheckLaptop = true;
					break;
				}
				
				else
				{
					System.out.println("You Have Already Entered The Laptop Code!");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					break;
				}
			}
			
			case "Jxn4ns":
			{
				if (flagCheckComp == false)					//checks if the code has been entered already
				{
					System.out.println("Computer Peripherals Code!");
					System.out.println("25% off mice & keyboards");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					flagCheckComp = true;
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Computer Peripherals Code!");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					break;
				}
			}
			
			case "udXyj6":
			{
				if (flagCheckNetwork == false)				//checks if the code has been entered already
				{
					System.out.println("Networking Code!");
					System.out.println("20% off switches & routers");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					flagCheckNetwork = true;
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Networking Code!");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					break;
				}
			}
			
			case "Gc47wX":
			{
				if (flagCheckCable == false)				//checks if the code has been entered already
				{
					System.out.println("Ethernet Cable Code!");
					System.out.println("Half Off Ethernet Cables!");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					flagCheckCable = true;
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Ethernet Cable Code!");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					break;
				}
			}
			
			case "kc42Qj":
			{
				if (flagCheckOffice == false)				//checks if the code has been entered already
				{
					System.out.println("Home Office Starter Pack!");
					System.out.println("10% off Desktops, 30% off mice, keyboards & monitors!");
					System.out.println();
					flagCheckOffice = true;
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Home Office Starter Pack Code!");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					break;
				}
			}
			
			case "DQB6HS":
			{
				if (flagCheckHomeNet == false)				//checks if the code has been entered already
				{
					System.out.println("Home Networking Starter Pack!");
					System.out.println("15% off Wireless Access Points & Ethernet Cables!");
					System.out.println();
					flagCheckHomeNet = true;
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					break;
				}
				else
				{
					System.out.println("You Have Already Entered The Home Networking Starter Pack Code!");
					System.out.println();
					flagSwitchActivated = true;				//activates a flag so that the second switch is not activated
					break;
				}
			}
			default:
			{
				break;
			}
		}
		
		if(flagSwitchActivated==false)	//if the first switch was not activated
		{
			switch(code.toUpperCase())	//switch for case insensitive codes
			{
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
						if(flagCheckSeason == false)				//checks if the code has been entered already
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
						if(flagCheckSeason == false)				//checks if the code has been entered already
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
						if(flagCheckSeason == false)				//checks if the code has been entered already
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
						if(flagCheckSeason == false)				//checks if the code has been entered already
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
					if (flagCheckFamily == false)	//checks if the code has been entered already
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

		double[] totalPrice = new double[price.length];
		
		for(int i = 0; i < totalPrice.length; i++)
		{
			totalPrice[i] = price[i] * quantity[i]; 
		}
		
		if(flagCheckLaptop == true)
		{
			index = ary.getIndex(names, "Laptop");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.85) * quantity[index];
			}
			else
			{
				System.out.println("There are no Laptops in your order.");
			}
			
		}
		
		if(flagCheckComp == true)
		{
			index = ary.getIndex(names, "Mouse");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.75) * quantity[index];
			}
			else
			{
				System.out.println("There are no Mice in your order.");
			}
			index = ary.getIndex(names, "Keyboard");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.75) * quantity[index];
			}
			else
			{
				System.out.println("There are no Keyboards in your order.");
			}
		}
		
		if(flagCheckNetwork == true)
		{
			index = ary.getIndex(names, "Switch");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.80) * quantity[index];
			}
			else
			{
				System.out.println("There are no Switches in your order.");
			}
			index = ary.getIndex(names, "Router");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.80) * quantity[index];
			}
			else
			{
				System.out.println("There are no Routers in your order.");
			}
		}
		
		if(flagCheckCable == true)
		{
			index = ary.getIndex(names, "Ethernet Cable");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.50) * quantity[index];
			}
			else
			{
				System.out.println("There are no Ethernet Cables in your order.");
			}
		}

		if(flagCheckOffice == true)
		{
			index = ary.getIndex(names, "Desktop Comp");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.90) * quantity[index];
			}
			else
			{
				System.out.println("There are no Desktop Computers in your order.");
			}
			index = ary.getIndex(names, "Monitor");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.70) * quantity[index];
			}
			else
			{
				System.out.println("There are no Monitors in your order.");
			}
			index = ary.getIndex(names, "Mouse");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.70) * quantity[index];
			}
			else
			{
				System.out.println("There are no Mice in your order.");
			}
			index = ary.getIndex(names, "Keyboard");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.70) * quantity[index];
			}
			else
			{
				System.out.println("There are no Keyboards in your order.");
			}
		}
		if(flagCheckHomeNet == true)
		{
			index = ary.getIndex(names, "Ethernet Cable");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.70) * quantity[index];
			}
			else
			{
				System.out.println("There are no Ethernet Cables in your order.");
			}
			index = ary.getIndex(names, "Wireless Router");
			if (index != -1)
			{
				totalPrice[index] = (price[index] * 0.70) * quantity[index];
			}
			else
			{
				System.out.println("There are no Wireless Routers in your order.");
			}
		}
		
		if(flagCheckSeason == true)
		{
			for(int i = 0; i < totalPrice.length; i++)
			{
				totalPrice[i] = (price[i]*0.85) * quantity[i]; 
			}
		}
		
		if(flagCheckFamily == true)
		{
			for(int i = 0; i < totalPrice.length; i++)
			{
				totalPrice[i] = (price[i]*0.95) * quantity[i]; 
			}
		}
		
		return totalPrice;
	}
}
