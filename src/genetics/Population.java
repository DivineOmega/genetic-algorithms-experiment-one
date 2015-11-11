package genetics;

import java.util.ArrayList;

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
	
}
