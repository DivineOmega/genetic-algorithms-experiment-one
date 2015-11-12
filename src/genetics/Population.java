package genetics;

import java.util.ArrayList;
import java.util.Collections;

public class Population
{
	public ArrayList<Genome> genomes = new ArrayList<Genome>();
	public int generation = 0;
	
	public void createRandom(int generation, int size)
	{
		this.generation = generation;
		
		genomes.clear();
		
		for (int i = 0; i < size; i++)
		{
			Genome newGenome = new Genome();
			
			newGenome.randomizeGenome();
			
			genomes.add(newGenome);
		}
	}
	
	public void display() 
	{
		System.out.println("- Population (Generation: "+generation+")");
		System.out.println("- Size: "+genomes.size()+" genomes");
		
		int x = 0;
		
		for (Genome genome: genomes) 
		{
			x++;
			
			System.out.println("  - Specimen "+x);
			System.out.println("    - Fitness: "+genome.fitness);
			
			System.out.println(genome.getSpecimen());
			
			System.out.println();
		}
	}
	
	public Genome getBest()
	{
		Genome bestGenome = genomes.get(0);
		
		for (Genome genome: genomes) 
		{
			if (genome.fitness>bestGenome.fitness)
			{
				bestGenome = genome;
			}
		}
		
		return bestGenome;
	}
	
	public void displayBest() 
	{
		Genome bestGenome = getBest();
		
		System.out.println("- Best Specimen (Generation: "+generation+")");
				
		System.out.println("    - Fitness: "+bestGenome.fitness);
		
		System.out.println(bestGenome.getSpecimen());
		
		System.out.println();
	}

	public void evaluateFitness(String idealSpecimen) 
	{
		for (Genome genome: genomes) 
		{
			genome.determineFitness(idealSpecimen);
		}
	}
	
	public ArrayList<Genome> rouletteWheelSelection()
	{
		ArrayList<Genome> selectedGenomes = new ArrayList<Genome>();
		
		ArrayList<Genome> routletteWheel = new ArrayList<Genome>();
		
		for (Genome genome : genomes) 
		{			
			for (int i = 0; i < genome.fitness; i++) 
			{
				routletteWheel.add(genome);
			}
		}
		
		Collections.shuffle(routletteWheel);
		
		selectedGenomes.add(routletteWheel.get(0));
		selectedGenomes.add(routletteWheel.get(1));
		
		return selectedGenomes;
	}
	
}
