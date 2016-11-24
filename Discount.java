public class Discount
{
	
	
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
	
}