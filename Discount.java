//Name:	Nathan Faucher & Martin Czerwinski
//Date:	November 23rd 2016
//File:	Discount.java

public class Discount
{
	private Boolean flagLaptop;
	
	public static double bulk(int quantity, double price) 
	{
		double priceDisc=0;
		
		if (quantity > 20)
		{
			priceDisc = price*0.85;
		}
		else
		{
			priceDisc = price;
		}
		return priceDisc;
	}
	
	public static void promo(String[] itemName, double[] itemPrice, int[] itemQuantity)
	{
		
	}
}