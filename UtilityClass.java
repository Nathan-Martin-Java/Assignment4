/*	Name: Martin Czerwinski
	Date: Sept. 21, 2016
	File: UtilityClass.java

	Utility that handles operations with Output File
*/

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.swing.JOptionPane;

public class UtilityClass
{
	private String filename;
	private PrintWriter rptfile;
	
	public UtilityClass(String filename)
	{
		this.filename = filename;
	}
	public void openFile()
	{
		try
		{
			FileWriter fw = new FileWriter(filename,true);
			rptfile = new PrintWriter(fw);
		}
		catch (IOException ioE)
		{
			System.out.println("OutFilename incorrect - check path");
			System.exit(0);
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
	}
	public void writeLineToFile(String str, Object... args)
	{
		rptfile.printf(str, args);
		rptfile.flush();
	}
	public void closeFile()
	{
		rptfile.close();
	}
	public String myDate()
	{
		SimpleDateFormat martinDateFormat = new SimpleDateFormat("MMMM-dd-yyyy");
		Date date = new Date();
		System.out.println();
		return new String("Date is " + martinDateFormat.format(date) + "\n");
	}
	public String myName()
	{
		return new String ("This program is written by Trent Cuddeback and Martin Czerwinski\n");
	}
	public String goodbye()
	{
		return new String ("\nGoodbye!\n");
	}
}