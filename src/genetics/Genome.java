package genetics;

import java.util.Random;

import util.GenomeUtils;

public class Genome
{
	public String binaryGenome = new String("");
	
	public void randomizeGenome()
	{
		Random random = new Random();
		
		binaryGenome = "";
		
		for (int i = 0; i < 25; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				int randInt = random.nextInt(2);
				String binaryStringDigit = Integer.toString(randInt);
				
				binaryGenome = binaryGenome.concat(binaryStringDigit);
			}
		}
		
	}
	
	public void displaySpecimen()
	{
		String stringGenome = new String();
		
		stringGenome = GenomeUtils.decodeBinaryGenomeToString(binaryGenome);
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				System.out.print(stringGenome.charAt((i*5)+j));
			}
			System.out.println();
		}
	}

}
