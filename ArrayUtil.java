//Name:	Nathan Faucher & Martin Czerwinski
//Date:	November 23rd 2016
//File:	ArrayUtil.java



/******** Import Libraries ********/

import java.util.*;

public class ArrayUtil
{
	public static int getIndex(String[] array, String search) 	//pass quantity and current price
	{
		int index = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(search.equals(array[i]))
			{
				index = i;
			}
		}
		
		return index;
	}
}