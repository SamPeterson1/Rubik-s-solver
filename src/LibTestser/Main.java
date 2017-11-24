package LibTestser;

import Lib.Algorithm;
import Lib.Cube;
import Lib.Map;

public class Main {
	public static void main(String[] args) {
		Cube cube = new Cube();
		
		String[] moves = {"U","D","L'","U2","L","D'","L'","U2","L'"};
		
		Algorithm alg = new Algorithm(moves, moves.length);
		
		int[] moves2 = alg.getMoves();
			for(int i = 0; i < moves2.length; i ++) {
			//	cube.excecuteMove(moves2[i]);
			}
		cube.setCube(Map.applyMap(cube.getCube(), Map.equatorSliceClockwiseMap));
		for(int i = 0; i < 6; i ++) { 
			System.out.println(" ");
			for(int j = 0; j < 3; j ++) {
				System.out.println(" ");
				for(int k = 0; k < 3; k ++) {
					System.out.print(cube.getCube()[i][j][k]);
				}
			}
		}
	}
}
    