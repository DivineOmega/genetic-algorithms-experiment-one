package genetics;

import java.util.ArrayList;
import java.util.Iterator;

public class Population
{
	public ArrayList<Genome> genomes = new ArrayList<Genome>();
	
	public void createNew(int size)
	{
		genomes.clear();
		
		for (int i = 0; i < size; i++)
		{
			Genome newGenome = new Genome();
			
			newGenome.randomizeGenome();
			
			genomes.add(newGenome);
		}
	}

	public void evaluate(String idealSpecimen) 
	{
		int x = 0;
		
		for (Genome genome: genomes) 
		{
			int fitness = genome.getFitness(idealSpecimen);
			
			System.out.println("- Specimen "+x);
			System.out.println("  - Fitness: "+fitness);
			
			System.out.println(genome.getSpecimen());
			
			System.out.println();
		}
	}
	
}
