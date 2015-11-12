package util;

import genetics.Genome;

import java.util.Random;

public abstract class GenomeUtils
{
	public static String encodeStringToBinaryGenome(String str)
	{
		String binaryString = "";
		
		for (int i = 0; i < str.length(); i++)
		{
			int charInt = (int) str.charAt(i);
						
			String binaryStringPart = Integer.toBinaryString(charInt);
			
			while(binaryStringPart.length()<8)
			{
				binaryStringPart = "0".concat(binaryStringPart);
			}
						
			binaryString = binaryString.concat(binaryStringPart);
		}
		
		return binaryString;
	}
	
	public static String decodeBinaryGenomeToString(String binaryGenome)
	{
		String str = "";
		
		for (int i = 0; i < binaryGenome.length(); i+=8)
		{
			
			char binaryStringPartChars[] = new char[8];
			
			for (int j = 0; j < binaryStringPartChars.length; j++)
			{
				binaryStringPartChars[j] = binaryGenome.charAt(i+j);
			}
			
			String binaryStringPart = new String(binaryStringPartChars);
						
			int charInt = Integer.parseInt(binaryStringPart, 2);
			
			char strChar = (char) charInt;
			
			str = str + strChar;
		}
		
		return str;
	}
	
	public static Genome crossover(Genome mum, Genome dad)
	{
		Random random = new Random();
		
		Genome child = new Genome();
		
		child.binaryGenome = mum.binaryGenome;
		
		if (random.nextFloat()<=0.7)
		{
			int crossOverPoint = random.nextInt(child.binaryGenome.length());
			
			child.binaryGenome = child.binaryGenome.substring(0, crossOverPoint);
			
			child.binaryGenome = child.binaryGenome.concat(dad.binaryGenome.substring(crossOverPoint));
		}
		
		for (int i = 0; i < child.binaryGenome.length(); i++) 
		{
			if (random.nextFloat()<=0.001)
			{
				StringBuilder binaryGenomeStringBuilder = new StringBuilder(child.binaryGenome);
				
				if (child.binaryGenome.charAt(i)=='1')
				{
					binaryGenomeStringBuilder.setCharAt(i, '0');
				}
				else
				{
					binaryGenomeStringBuilder.setCharAt(i, '1');
				}
				
				child.binaryGenome = binaryGenomeStringBuilder.toString();
			}
		}
		
		return child;
	}
}
