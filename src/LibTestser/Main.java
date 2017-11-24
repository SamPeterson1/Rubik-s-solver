package LibTestser;

import Lib.Algorithm;
import Lib.AlgorithmMap;
import Lib.Cube;
import Lib.FaceUtils;
import Lib.Map;
import Lib.Move;

public class Main {
	public static void main(String[] args) {
		Cube cube = new Cube();
		
		String moves = "F2 D2 B' D U2 L B L F' U R D2 U2 B' F' R' U F2 U' B2 L B' U2 R U'";
		Algorithm alg = new Algorithm(moves);
		
		alg.rotatePerspectiveLeft();
		String[] moves1 = alg.getMovesAsString();
		
		for(int i = 0; i < moves1.length; i ++) {
			System.out.println(moves1[i]);
		}
		//alg.reverseAlgorithm();
		String[] h = {" "};
		int[] faces = {1,2,3,4};
		
		FaceUtils util  = new FaceUtils(0, faces, cube.getCube());
		
		//cube.setCube(Map.applyMap(cube.getCube(), Map.equatorSliceClockwiseMap));
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
    