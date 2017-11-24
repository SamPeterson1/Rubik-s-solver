package Lib;

public class AlgorithmMap {

	public static String[] rotatePerspectiveLeft = {
			"F","R",
			"F'","R'",
			"R","B",
			"R'","B'",
			"B","L",
			"B'","L'",
			"L","F",
			"L'","F'",
			
			"F2","R2",
			"R2","B2",
			"B2","L2",
			"L2","F2",
			
			"f","r",
			"f'","r'",
			"r","b",
			"r'","b'",
			"b","l",
			"b'","l'",
			"l","f",
			"l'","f'",
			
			"f2","r2",
			"r2","b2",
			"b2","l2",
			"l2","f2",
			
			"M","S",
			"M'","S'",
			"S","M",
			"S'","M'",
			
			"M2","S2",
			"S2","M2"
			
	};
	
	public static String[] rotatePerspectiveRight = {
			"R","F",
			"R'","F'",
			"B","R",
			"B'","R'",
			"L","B",
			"L'","B'",
			"F","L",
			"F'","L'",
			
			"R2","F2",
			"B2","R2",
			"L2","B2",
			"F2","L2",
			
			"r","f",
			"r'","f'",
			"b","r",
			"b'","r'",
			"l","b",
			"l'","b'",
			"f","l",
			"f'","l'",
			
			"r2","f2",
			"b2","r2",
			"l2","b2",
			"f2","l2",
			
			"S","M",
			"S'","M'",
			"M","S",
			"M'","S'",
			
			"S2","M2",
			"M2","S2"
			
	};
	
	public static String[] applyMap(String[] algorithm, String[] map) {
		for(int i = 0; i < algorithm.length; i ++) {
			
			for(int j = 0; j < map.length; j += 2) {
				System.out.println("HII");
				if(algorithm[i].equals(map[j])) {
					algorithm[i] = map[j + 1];
					
					break;
				}
			}
		}
		return algorithm;
	}
}
