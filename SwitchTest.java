//Name:	Nathan Faucher & Martin Czerwinski
//Date:	November 23rd 2016
//File:	SwitchTest.java

import java.util.*;

public class SwitchTest
{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		String promo = null;
		Boolean flagSwitchActivated = false;	//boolean to signal if second switch should be skipped (in the case that the first one was entered)
		
		while(true)	//infinite loop because while loops run while a statement is true
					//true is always true so this loop runs infinitely 
		{
			System.out.println("Please enter a promo code or press enter to exit:");
			promo = sc.nextLine();
			
			switch(promo)				//switch for case sensitive codes
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
			
			
			if(flagSwitchActivated==false)
			{
				switch(promo.toUpperCase())	//switch for case insensitive codes
				{
					case "":
					{
						System.exit(0);
					}
					case "FULLCOMMIE":
					{
						System.out.println("Glory to the motherland!");
						System.out.println();
						break;
					}
					
					case "SPRG15":
					{
						System.out.println("Spring 15% off");
						System.out.println();
						break;
					}
					
					case "SMMR15":
					{
						System.out.println("Summer 15% off");
						System.out.println();
						break;
					}
					
					case "WNTR15":
					{
						System.out.println("Winter 15% off");
						System.out.println();
						break;
					}
					
					case "FALL15":
					{
						System.out.println("Fall 15% off");
						System.out.println();
						break;
					}
					
					case "FAMILY":
					{
						System.out.println("Friends and Family Discount");
						System.out.println();
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
			
			flagSwitchActivated = false;
			
		}
	}
}