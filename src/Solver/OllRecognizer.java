package Solver;

import java.util.ArrayList;

import Lib.Algorithm;
import Lib.Cube;

public class OllRecognizer {
	ArrayList<Algorithm> algs = new ArrayList<Algorithm>();
	
	public void addAlg(String moves) {
		algs.add(new Algorithm(moves));
	}
	
	public OllRecognizer() {
		addAlg("L U L' U L U2 L'");
		addAlg("R' U' R U' R' U2 R");
		addAlg("R U2 R' U' R U R' U' R U' R'");
		addAlg("R U2 R2 U' R2 U' R2 U2 R");
		addAlg("R2 D R' U2 R D' R' U2 R'");
		addAlg("l' U' L U R U' R' M' F");
		addAlg("R' F R B' R' F' R B");
		addAlg("R U2 R2 F R F' U2 R' F R F'");
		addAlg("F R U R' U' F' f R U R' U' f'");
		addAlg("f R U R' U' f' U' F R U R' U' F'");
		addAlg("f R U R' U' f' U F R U R' U' F'");
		addAlg("R U R' U R' F R F' U2 R' F R F'");
		addAlg("M U R U R' U' M2 U R U' r'");
		addAlg("F R U R' U U' d R' U2 R' F R F'");
		addAlg("r' R U R U R' U' r R2 F R F'");
		addAlg("R' U' R' F R F' U R");
		addAlg("R U R2 U' R' F R U R U' F'");
		addAlg("R U2 R2 U' R U' R' U2 F R F'");
		addAlg("R U R' U R d' R U' R' F'");
		addAlg("f R U R' U' R U R' U' f'");
		addAlg("F R U R' U' R F' r U R' U' r'");
		addAlg("F R U R' U' R U R' U' F'");
		addAlg("R' U' R' F R F' R' F R F' U R");
		addAlg("r U R' U R U' R' U R U2 r'");
		addAlg("l' U' L U' L' U L U' L' U2 l");
		addAlg("R' F R' F' R2 U2 U d' R' F R F'");
		addAlg("R' F R2 B' R2 F' R2 B R'");
		addAlg("f R U R' U' f'");
		addAlg("f' L' U' L U f");
		addAlg("R U B' U' R' U R B R'");
		addAlg("R' U' F U R U' R' F' R");
		addAlg("F R U R' U' F'");
		addAlg("R U R' U' R' F R F'");
		addAlg("R U R' U R U' R' U' R' F R F'");
		addAlg("L' U' L U' L' U L U L F' L' F");
		addAlg("R2 U R' B' R U' R2 U R B R'");
		addAlg("M U R U R' U' R' F R F' M'");
		addAlg("R U' R' U2 R U2 d R U' R' U' F'");
		addAlg("R' U2 R U R' U R U D' F R U R' U' F'");
		addAlg("F R U' R' U' R U R' F'");
		addAlg("R U2 R2 F R F' R U2 R'");
		addAlg("R U R' U R' F R F' R U2 R'");
		addAlg("R U R' U' R' F R2 U R' U' F'");
		addAlg("r U' r' U' r U r' U d' R' U R");
		addAlg("R' F R U R' F' R U d' R U' R'");
		addAlg("r U r' R U R' U' r U' r'");
		addAlg("l' U' l L' U' L U l' U l");
		addAlg("R' F R U R' U' F' U R");
		addAlg("L F' L' U' L U F U' L'");
		addAlg("R U2 R' U2 R' F R F'");
		addAlg("r U R' U R U2 r'");
		addAlg("F R U R' U' F' U F R U R' U' F'");
		addAlg("F' L' U' L U F U d' F R U R' U' F'");
		addAlg("r U2 R' U' R U' r'");
		addAlg("l' U2 L U L' U l");
		addAlg("M' U M U2 M' U M");
		addAlg("R U R' U' M' U R U' r'");
		addAlg("r U R' U R U' R' U R U2 r'");
	}
	
	public int findCase(int[][][] cube, Algorithm alg) {
		boolean Break = false;
		boolean firstTry = false;
		int i1 = 0;
		Cube activeCube = new Cube();
		for(Algorithm test: algs) {
			if(Break) {
				break;
			}
			int[][][] backupCubeData = new int[6][3][3];
			int[][][] activeCubeData = new int[6][3][3];
			for(int i = 0; i < 6; i ++) {
				for(int j = 0; j < 3; j ++) {
					for(int k = 0; k < 3; k ++) {
						backupCubeData[i][j][k] = cube[i][j][k];
						activeCubeData[i][j][k] = cube[i][j][k];
					}
				}
			}
			for(i1 = 0; i1 < 4; i1 ++) {
				int[][] solvedFace = {{1,1,1},{1,1,1},{1,1,1}};
				activeCube.setCube(activeCubeData);
				activeCube.excecuteAlg(test);
				int k1 = 0;
				for(int i4 = 0; i4 < 3; i4 ++) {
					for(int j = 0; j < 3; j ++) {
						if(activeCube.getCube()[0][i4][j] == solvedFace[i4][j]) {
							k1 ++;
						}
					}
				}
				if(k1 == 9) {
					alg.addMoves(test.getMovesAsString());
					if(i1 == 0) {
						firstTry = true;
					}
					Break = true;
					break;
				}
				for(int i = 0; i < 6; i ++) {
					for(int j = 0; j < 3; j ++) {
						for(int k = 0; k < 3; k ++) {
							activeCubeData[i][j][k] = backupCubeData[i][j][k];
						}
					}
				}
					activeCube.excecuteMove(Cube.TOP_FACE_C);
					int[][][] h = activeCube.getCube();
					for(int i = 0; i < 6; i ++) {
						for(int j = 0; j < 3; j ++) {
							for(int k = 0; k < 3; k ++) {
								backupCubeData[i][j][k] = h[i][j][k];
								activeCubeData[i][j][k] = h[i][j][k];
							}
						}
					}
			}
		}
		int retval = i1;
		
		System.out.println("\n " + retval);
		return retval;
	}
}
