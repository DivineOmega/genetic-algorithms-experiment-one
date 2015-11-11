package genetics;

import java.util.Random;

import util.GenomeUtils;
import util.StringUtils;

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
	
	public String getSpecimen()
	{
		String specimen = "";
		
		String stringGenome = new String();
		
		stringGenome = GenomeUtils.decodeBinaryGenomeToString(binaryGenome);
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				specimen = specimen + stringGenome.charAt((i*5)+j);
			}
			specimen = specimen + '\n';
		}
		
		return specimen;
	}
		
	public int getFitness(String idealSpecimen)
	{
		int fitness = 0;
				
		int levensteinDistance = StringUtils.levensteinDistance(getSpecimen(), idealSpecimen);
		
		fitness = idealSpecimen.length() - levensteinDistance;
		
		return fitness;
	}
}
