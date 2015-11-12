package main;

import genetics.Genome;
import genetics.Population;

import java.util.ArrayList;
import java.util.Scanner;

import util.GenomeUtils;

public class Main
{
	public static String idealSpecimen = "";
	
	final static int populationSize = 100;
	
	public static void main(String[] args)
	{
		// Define ideal specimen
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Define a 5x5 ideal specimen.");
		
		for (int i = 0; i < 5; i++)
		{
			String specimenLine = "";
			
			while(specimenLine.length()!=5)
			{
				System.out.print("Line "+(i+1)+": ");
				specimenLine = keyboard.nextLine();
			}
			
			idealSpecimen = idealSpecimen.concat(specimenLine);
			idealSpecimen = idealSpecimen + '\n';
		}
		
		keyboard.close();
		
		System.out.println("Ideal specimen defined.");
		
		
		// Create initial population
				
		int generation = 1;
		
		System.out.println("Generating new population...");
		
		Population population = new Population();
		
		population.createRandom(generation, populationSize);
		
		while(generation<100000)
		{
			population.evaluateFitness(idealSpecimen);
			
			population.displayBest();
			
			generation++;
			
			Population newPopulation = new Population();
			newPopulation.generation = generation;
						
			while(newPopulation.genomes.size()<populationSize)
			{
				ArrayList<Genome> selectedParents = population.rouletteWheelSelection();
				Genome mum = selectedParents.get(0);
				Genome dad = selectedParents.get(1);
				
				Genome child = GenomeUtils.crossover(mum, dad);
				
				newPopulation.genomes.add(child);
			}
			
			population = newPopulation;
		}
	}
	
}
