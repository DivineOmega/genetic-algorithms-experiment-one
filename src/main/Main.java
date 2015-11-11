package main;

import util.GenomeUtils;

public class Main
{
	public static void main(String[] args)
	{		
		String stringGenome = "test";
		
		System.out.println("Starting string genome: "+stringGenome);
		
		String binaryGenome = GenomeUtils.encodeStringToBinaryGenome(stringGenome);
		
		System.out.println("Encoded to binary genome: "+binaryGenome);
		
		stringGenome = GenomeUtils.decodeBinaryGenomeToString(binaryGenome);
		
		System.out.println("Decoded back to string genome: "+stringGenome);
	}

}
