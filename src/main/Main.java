package main;

import genetics.Population;

import java.util.Scanner;

public class Main
{
	public static String idealSpecimen = "";
	
	public static void main(String[] args)
	{
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
		
		System.out.println("Ideal specimen defined.");
		
		System.out.println("Generating new population...");
		
		Population population = new Population();
		
		population.createNew(40);
	}
	
}
