package util;

public abstract class StringUtils 
{
	public static int levensteinDistance(String a, String b) 
	{
        
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
	
	public static int directComparison(String a, String b) 
	{
		int matchingCharacters = 0;
		
		for (int i = 0; i < a.length(); i++) 
		{
			if (a.charAt(i)==b.charAt(i))
			{
				matchingCharacters++;
			}
		}
		
		return matchingCharacters;
	}
}
