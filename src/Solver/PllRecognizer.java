package Solver;

import java.util.ArrayList;

import Lib.Algorithm;
import Lib.Cube;

public class PllRecognizer {
	ArrayList<Algorithm> algs = new ArrayList<Algorithm>();
	
	public void addAlg(String moves) {
		algs.add(new Algorithm(moves));
	}
	
	public PllRecognizer() {
		addAlg("M2 D S2 D2 S2 D M2");
		addAlg("B2 U' M' U2 M U' B2");
		addAlg("B2 U M' U2 M U B2");
		addAlg("M2 U M2 U M' U2 M2 U2 M' U2");
		addAlg("R' F R' B2 R F' R' B2 R2");
		addAlg("R B' R F2 R' B R F2 R2");
		addAlg("D R' D2 F' D L D' F D2 R D' F' L' F");
		addAlg("L F R' F' L' F' D2 B' L' B D2 F' R F2");
		addAlg("U2 d2 F2 D R' U R' U' R D' F2 L' U L U2 d2");
		addAlg("R' U' R B2 D L' U L U' L D' B2");
		addAlg("U d' R2 u' R U' R U R' u R2 B U' B' U' d");
		addAlg("B' U F' U2 B U' B' U2 F B U'");
		addAlg("B U' F U2 B' U B U2 F' B' U");
		addAlg("R U' L d2 L' U L R' U' R U2 r' F l' d2 U'");
		addAlg("F2 R' F' U' F' U F R F' U2 F U2 F'");
		addAlg("B2 R B U B U' B' R' B U2 B' U2 B");
		addAlg("R2 D' F2 D R2 B2 D L2 D' B2 U");
		addAlg("R' U R' d' R' F' R2 U' R' U R' F R F d U");
		addAlg("F2 U F U' F' U L F R' F R F L' F'");
	}
	
	public void excecutePLL(Cube cube) {
		for(Algorithm alg: algs) {
			System.out.println("HH");
			if(this.testAlg(alg, cube)) {
				System.out.println("yEs");
				return;
			}
		}
	}
	
	public boolean testAlg(Algorithm alg, Cube cube) {
		
		int[][][] solvedCube = new Cube().getCube();
		
		for(int i2 = 0; i2 < 4; i2 ++) {
			
			int correctColors = 0;
			
			cube.excecuteAlg(alg, false);
			for(int i3 = 0; i3 < 4; i3 ++) {
				int[][][] cubeState = null;
				
				cubeState = cube.getCube();
				for(int i = 0; i < 6; i ++) {
					for(int j = 0; j < 3; j ++) {
						for(int k = 0; k < 3; k ++) {
							if(cubeState[i][j][k] == solvedCube[i][j][k]) {
								correctColors ++;
							}
						}
					}
				}
				if(correctColors == 54) {
					for(int i = 0; i < i2; i ++) {
						cube.excecuteMove(Cube.TOP_FACE_C, true);
						cube.excecuteMove(Cube.TOP_FACE_CC, false);
					}
					cube.addMovesToList(alg);
					for(int i = 0; i < i3; i ++) {
						cube.excecuteMove(Cube.TOP_FACE_CC, true);
						cube.excecuteMove(Cube.TOP_FACE_C, false);
					}
					return true; 
				}
				cube.excecuteMove(Cube.TOP_FACE_CC, false);
				correctColors = 0;
			}
			
			alg.reverseAlgorithm();
			cube.excecuteAlg(alg, false);
			alg.reverseAlgorithm();
			
			cube.excecuteMove(Cube.TOP_FACE_C, false);
		}
		return false;
	}
	
	public void cloneToArray(int[][][] array1, int[][][] array2) {
		for(int i = 0; i < 6; i ++) {
			for(int j = 0; j < 3; j ++) {
				for(int k = 0; k < 3; k ++){			
					array2[i][j][k] = array1[i][j][k];
				}
			}
		}
	}
	
	public int[][][] clone(int[][][] array){
		int[][][] retVal = new int[6][3][3];
		for(int i = 0; i < 6; i ++) {
			for(int j = 0; j < 3; j ++) {
				for(int k = 0; k < 3; k ++){			
					retVal[i][j][k] = array[i][j][k];
				}
			}
		}
		return retVal;
	}
}
