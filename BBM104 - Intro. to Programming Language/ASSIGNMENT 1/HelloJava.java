import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class HelloJava
{
	public static BigInteger factorial(int iNum)
	{
		BigInteger one = BigInteger.ONE;
		BigInteger others = BigInteger.valueOf(iNum);
		if (iNum==0)
        	return one;
        else;
        	return others.multiply(factorial(iNum-1));
	}
	
	public static double arcsinh(double dNum)
	{
		double totalArc = 0; // Value of total Arcsinh(dNum). 
		if (Math.abs(dNum)<1)
		{
			for(int n=0;n<=30;n++)
			{
				BigInteger factA = factorial(2*n); // (2n)!
				BigInteger factB = (factorial(n)).multiply(factorial(n)); // n!*n!
				double other1 = (double) Math.pow(-1, n); // n power of -1
				double other2 = (Math.pow(4, n))*(2*n+1); // (n power of 4)*(2n+1)
				double other3 = Math.pow(dNum, (2*n+1)); // (2n+1). power of dNum
				
				double result = factA.doubleValue()/factB.doubleValue()*other1/other2*other3; // Maclaurin Series for approximation of Arcsinh(dNum)
				totalArc += result;
			}
		}
		return totalArc;
	}
	
	public static double func1(double d_initialNum,double d_finalNum,int i_rectangleCount)
	{
		double fark = (d_finalNum-d_initialNum)/i_rectangleCount;
		double total = 0;
		for(double x = d_initialNum; x<d_finalNum; x+=fark)
		{
			double medNum = x+(fark/2);
			if (medNum < d_finalNum) // If I don't use this line, result may be wrong for rectangle count is more than 100.
				total += Math.abs(medNum*medNum-medNum+3);
		}
		return total*fark; // Because, area of rectangle is multiply the edges.
	}
	
	public static double func2(double d_initialNum,double d_finalNum,int i_rectangleCount)
	{	
		double fark = (d_finalNum-d_initialNum)/i_rectangleCount;
		double total = 0;
		for(double x = d_initialNum; x<d_finalNum; x+=fark)
		{
			double medNum = x+(fark/2);
			if (medNum < d_finalNum) // If I don't use this line, result may be wrong for rectangle count is more than 100.
				total += Math.pow((3*(Math.sin(medNum))-4), 2);
		}
		return total*fark; // Because, area of rectangle is multiply the edges.
	}
	
	public static double func3(double d_initialNum,double d_finalNum,int i_rectangleCount)
	{
		double fark = (d_finalNum-d_initialNum)/i_rectangleCount;
		double total = 0;
		for(double x = d_initialNum; x<d_finalNum; x+=fark)
		{
			double medNum = x+(fark/2);
			if (medNum < d_finalNum) // If I don't use this line, result may be wrong for rectangle count is more than 100.
			{
				double arcsinhResult = arcsinh(medNum);
				total += arcsinhResult;
			}
		}
		return total*fark; // Because, area of rectangle is multiply the edges.
	}
	
	public static ArrayList<String> armstrong(String a) // a is equal to number of digit. 
	{
		ArrayList<String> armstrongNumbers = new ArrayList<String>();
		for (int num=0; num<Math.pow(10, Integer.parseInt(a)); num++) // num is equal to numbers between 0 to a power of 10
		{
			String number = String.valueOf(num);
			String[] numParts = number.split(""); // Example, for 153 ==> numParts = [1,5,3]
			int total = 0;
			for (int i=0; i<numParts.length; i++)
				total += Math.pow(Double.parseDouble(numParts[i]), (double) numParts.length);
			if(total==num)
				armstrongNumbers.add(String.valueOf(total));
		}
		return armstrongNumbers;
	}

	public static void main(String[] args)
	{ 
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			Scanner scanner = new Scanner(new File(args[0]));
			while(scanner.hasNext()) // Read a file word by word, instead of line by line
				list.add(scanner.next()); // Ex: [IntegrateReimann, Func1, -5, 12, 40, IntegrateReimann, Func1, ...]
			scanner.close();
		}
		
		catch (FileNotFoundException ex1) {System.out.println(ex1.getMessage());}
		catch (ArrayIndexOutOfBoundsException ex2){System.out.println(ex2.getMessage());} // If you don't write anything to args[0].
		
		for (int i=0; i<list.size(); i++)
		{
			if (list.get(i).equals("IntegrateReimann"))
			{
				if (list.get(i+1).equals("Func1"))
				{
					System.out.println(list.get(i)+" "+list.get(i+1)+" "+list.get(i+2)+" "+list.get(i+3)+" "+list.get(i+4)+" Result: "+
				func1(Double.parseDouble(list.get(i+2)), Double.parseDouble(list.get(i+3)), Integer.parseInt(list.get(i+4))));
				}
				else if (list.get(i+1).equals("Func2"))
				{
					System.out.println(list.get(i)+" "+list.get(i+1)+" "+list.get(i+2)+" "+list.get(i+3)+" "+list.get(i+4)+" Result: "+
				func2(Double.parseDouble(list.get(i+2)), Double.parseDouble(list.get(i+3)), Integer.parseInt(list.get(i+4))));
				}
				else
				{
					System.out.println(list.get(i)+" "+list.get(i+1)+" "+list.get(i+2)+" "+list.get(i+3)+" "+list.get(i+4)+" Result: "+
				func3(Double.parseDouble(list.get(i+2)), Double.parseDouble(list.get(i+3)), Integer.parseInt(list.get(i+4))));
				}
			}
			else if (list.get(i).equals("Arcsinh"))
				System.out.println(list.get(i)+" "+list.get(i+1)+" Result: "+arcsinh(Double.parseDouble(list.get(i+1))));
			else if (list.get(i).equals("Armstrong"))
				System.out.println(list.get(i)+" "+list.get(i+1)+" Result: "+armstrong(list.get(i+1)));
		}
	}
}