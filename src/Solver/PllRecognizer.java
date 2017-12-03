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
		addAlg("B2 U M U2 M' U B2");
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
		addAlg("R U' L d2 L' U L R' U' R U2 r' F l'");
		addAlg("F2 R' F' U' F' U F R F' U2 F U2 F'");
		addAlg("B2 R B U B U' B' R' B U2 B' U2 B");
		addAlg("R2 D' F2 D R2 B2 D L2 D' B2 U");
		addAlg("R' U R' d' R' F' R2 U' R' U R' F R F");
		addAlg("F2 U F U' F' U L F R' F R F L' F'");
	}
	
	public Cube findCase(Cube cube) {
		Cube retVal = new Cube();
		retVal.setCube(this.clone(cube.getCube()));
		int[][][] backupData1 = new int[6][3][3];
		int[][][] solvedState = this.clone(new Cube().getCube());
		int[][][] origionalCube = this.clone(cube.getCube());
		
		for(Algorithm alg: algs) {
			
			backupData1 = this.clone(retVal.getCube());
			
			System.out.println("HII");
			for(int i = 0; i < 4; i ++) {
				retVal.setCube(this.clone(backupData1));
				retVal.excecuteAlg(alg);
				int count = 0;
				for(int i2 = 0; i2 < 6; i2 ++) {
					for(int j = 0; j < 3; j ++) {
						for(int k = 0; k < 3; k ++) {
							if(retVal.getCube()[i][j][k] == solvedState[i][j][k]) {
								count ++;
							}
						}
					}
				}
				if(count == 54) {
					System.out.println("PRITNNN");
					this.printMatrix(solvedState);
					retVal.setCube(solvedState);
					return retVal;
				}

				
				retVal.setCube(this.clone(backupData1));
				retVal.excecuteMove(Cube.TOP_FACE_C);
				backupData1 = this.clone(retVal.getCube());
			}
			retVal.setCube(this.clone(origionalCube));
		}
		return null;
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
	
	private void printMatrix(int[][][] colorData) {
		for(int i = 0; i < 6; i ++) {
			System.out.println("");
			for(int j = 0; j < 3; j ++) {
				System.out.println("");
				for(int k = 0; k < 3; k ++) {
					System.out.print(colorData[i][j][k]);
				}
			}
		}
	}
}
