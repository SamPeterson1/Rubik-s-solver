package Lib;

import java.util.Arrays;

public class Cube {
	private int[][][] colorData = new int[6][3][3];
	
	//TOP, RIGHT, FRONT, LEFT, BACK, BOTTOM
	
	public static int YELLOW = 1;
	public static int RED = 2;
	public static int BLUE = 3;
	public static int ORANGE = 4;
	public static int GREEN = 5;
	public static int WHITE = 6;
	
	//C = Clockwise
	
	public static int TOP_FACE_C = 1;
	public static int RIGHT_FACE_C = 2;
	public static int FRONT_FACE_C = 3;
	public static int LEFT_FACE_C = 4;
	public static int BACK_FACE_C = 5;
	public static int BOTTOM_FACE_C = 6;
	
	
	//CC = Counter-Clockwise
	
	public static int TOP_FACE_CC = 7;
	public static int RIGHT_FACE_CC = 8;
	public static int FRONT_FACE_CC = 9;
	public static int LEFT_FACE_CC = 10;
	public static int BACK_FACE_CC = 11;
	public static int BOTTOM_FACE_CC = 12;
	
	//U2, F2, etc...
	
	public static int TOP_FACE_TWICE = 13;
	public static int RIGHT_FACE_TWICE = 14;
	public static int FRONT_FACE_TWICE = 15;
	public static int LEFT_FACE_TWICE = 16;
	public static int BACK_FACE_TWICE = 17;
	public static int BOTTOM_FACE_TWICE = 18;
	
	public static int[] TOP_FACE_SURROUNDINGS = {1,4,3,2};
	public static int[] RIGHT_FACE_SURROUNDINGS = {1,5,3,0};
	public static int[] FRONT_FACE_SURROUNDINGS = {5,4,1,3};
	public static int[] LEFT_FACE_SURROUNDINGS = {2,1,4,6};
	public static int[] BACK_FACE_SURROUNDINGS = {0,4,5,2};
	public static int[] BOTTOM_FACE_SURROUNDINGS = {3,4,1,2};
	
	public Cube() {
		for(int i = 0; i < 6; i ++) {
			for(int j = 0; j < 3; j ++) {
				for(int k = 0; k < 3; k ++) {
					colorData[i][j][k] = i + 1;
				}
			}
		}
		colorData[0][0][0] = 3;
	}
	
	public void excecuteAlg(Algorithm alg) {
		
	}
	
	public void excecuteMove(int value) {
		int face = 0;
		System.out.println(value);
		int direction = 0;
		if(value < 7) {
			face = value - 1;
			direction = 0;
		} else if(value < 13) {
			face = value - 7;
			direction = 1;
		} else if(value < 19) {
			face = value - 13;
			direction = 2;
		}
		if(direction == 0) {
			int[][] i = this.rotateCW(this.colorData[face], 1);
			this.colorData[face] = Arrays.copyOf(i, i.length);
		} else {
			int[][] i = this.rotateCW(this.colorData[face], 3);
			this.colorData[face] = Arrays.copyOf(i, i.length);
		}
		
		if(face == 0) {
			if(direction == 0) {
				for(int i = 0; i < 3; i ++) {
					int[] colors = {this.colorData[1][0][i], this.colorData[2][0][i], this.colorData[3][0][i], this.colorData[4][0][i]};
					this.colorData[1][0][i] = colors[3];
					this.colorData[2][0][i] = colors[0];
					this.colorData[3][0][i] = colors[1];
					this.colorData[4][0][i] = colors[2];
				}
			} else {
				for(int i = 0; i < 3; i ++) {
					int[] colors = {this.colorData[1][0][i], this.colorData[2][0][i], this.colorData[3][0][i], this.colorData[4][0][i]};
					this.colorData[1][0][i] = colors[1];
					this.colorData[2][0][i] = colors[2];
					this.colorData[3][0][i] = colors[3];
					this.colorData[4][0][i] = colors[0];
				}
			}
		}
	}
	
	private int[][] rotateCW(int[][] mat, int iterations) {
		int[][] ret = null;
		for(int i = 0; i < iterations; i ++) {
			System.out.println("HIS");
		    final int M = mat.length;
		    final int N = mat[0].length;
		    ret = new int[N][M];
		    for (int r = 0; r < M; r++) {
		        for (int c = 0; c < N; c++) {
		            ret[c][M-1-r] = mat[r][c];
		        }
		    }
		    mat = ret;
		}
	    return ret;
	}
	
	public int[][][] getCube(){
		return this.colorData;
	}
}
