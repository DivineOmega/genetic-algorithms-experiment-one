package genetics;

import java.util.Random;

import util.GenomeUtils;
import util.StringUtils;

public class Genome
{
	public String binaryGenome = new String("");
	public int fitness = -999;
	
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
		
	public void determineFitness(String idealSpecimen)
	{				
		String specimen = getSpecimen();
		
		fitness = 0;
		
		int levensteinDistance = StringUtils.levensteinDistance(specimen, idealSpecimen);
		fitness += idealSpecimen.length() - levensteinDistance;
		
		fitness += StringUtils.directComparison(specimen, idealSpecimen);
	}
	
	public void display() 
	{
		System.out.println("- Fitness: "+fitness);
		
		System.out.println(getSpecimen());
		
		System.out.println();
	}
}
