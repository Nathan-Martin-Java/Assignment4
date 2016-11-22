

public class ShoppingCart
{
	public static void main(String[] args)
	{
		
		
		
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