package util;

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
						
			int strCharValue = Integer.parseInt(binaryStringPart, 2);
						
			char strChar = (char) strCharValue;
			
			str = str + strChar;
		}
		
		return str;
	}
}
