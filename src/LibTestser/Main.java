package LibTestser;

import Lib.Algorithm;
import Lib.Cube;

public class Main {
	public static void main(String[] args) {
		Cube cube = new Cube();
		
		String[] moves = {"U","U","R'","U'","R'","F","R","F'"};
		
		Algorithm alg = new Algorithm(moves, moves.length);
		
		int[] moves2 = alg.getMoves();
		
		cube.excecuteMove(moves2[0]);
		for(int i = 0; i < 6; i ++) { 
			System.out.println(" ");
			for(int j = 0; j < 3; j ++) {
				System.out.println(" ");
				for(int k = 0; k < 3; k ++) {
					System.out.print(cube.getCube()[i][j][k]);
				}
			}
		}
		System.out.println(cube.getCube());
	}
}
 