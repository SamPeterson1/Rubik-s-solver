package Lib;

import java.util.Arrays;

public class Cube {
	private int[][][] colorData = new int[6][3][3];
	
	//TOP, RIGHT, FRONT, LEFT, BACK, BOTTOM
	
	public static final int YELLOW = 1;
	public static final int RED = 2;
	public static final int BLUE = 3;
	public static final int ORANGE = 4;
	public static final int GREEN = 5;
	public static final int WHITE = 6;
	
	//C = Clockwise
	
	public static final int TOP_FACE_C = 1;
	public static final int RIGHT_FACE_C = 2;
	public static final int FRONT_FACE_C = 3;
	public static final int LEFT_FACE_C = 4;
	public static final int BACK_FACE_C = 5;
	public static final int BOTTOM_FACE_C = 6;
	
	
	//CC = Counter-Clockwise
	
	public static final int TOP_FACE_CC = 7;
	public static final int RIGHT_FACE_CC = 8;
	public static final int FRONT_FACE_CC = 9;
	public static final int LEFT_FACE_CC = 10;
	public static final int BACK_FACE_CC = 11;
	public static final int BOTTOM_FACE_CC = 12;
	
	//U2, F2, etc...
	
	public static final int TOP_FACE_TWICE = 13;
	public static final int RIGHT_FACE_TWICE = 14;
	public static final int FRONT_FACE_TWICE = 15;
	public static final int LEFT_FACE_TWICE = 16;
	public static final int BACK_FACE_TWICE = 17;
	public static final int BOTTOM_FACE_TWICE = 18;
	
	//Slice Moves
	
	public static final int MIDDLE_SLICE_C = 19;
	public static final int EQUATOR_SLICE_C = 20;
	public static final int SIDE_SLIDE_C = 21;

	public static final int MIDDLE_SLICE_CC = 22;
	public static final int EQUATOR_SLICE_CC = 23;
	public static final int SIDE_SLICE_CC = 24;
	
	public static final int MIDDLE_SLICE_TWICE = 25;
	public static final int EQUATOR_SLICE_TWICE = 26;
	public static final int SIDE_SLICE_TWICE = 27;
	
	public static final int SMALL_TOP_FACE_C = 28;
	public static final int SMALL_RIGHT_FACE_C = 29;
	public static final int SMALL_FRONT_FACE_C = 30;
	public static final int SMALL_LEFT_FACE_C = 31;
	public static final int SMALL_BACK_FACE_C = 32;
	public static final int SMALL_BOTTOM_FACE_C = 33;
	
	
	//CC = Counter-Clockwise
	
	public static final int SMALL_TOP_FACE_CC = 34;
	public static final int SMALL_RIGHT_FACE_CC = 35;
	public static final int SMALL_FRONT_FACE_CC = 36;
	public static final int SMALL_LEFT_FACE_CC = 37;
	public static final int SMALL_BACK_FACE_CC = 38;
	public static final int SMALL_BOTTOM_FACE_CC = 39;
	
	//U2, F2, etc...
	
	public static final int SMALL_TOP_FACE_TWICE = 40;
	public static final int SMALL_RIGHT_FACE_TWICE = 41;
	public static final int SMALL_FRONT_FACE_TWICE = 42;
	public static final int SMALL_LEFT_FACE_TWICE = 43;
	public static final int SMALL_BACK_FACE_TWICE = 44;
	public static final int SMALL_BOTTOM_FACE_TWICE = 45;
	
	public Cube() {
		for(int i = 0; i < 6; i ++) {
			for(int j = 0; j < 3; j ++) {
				for(int k = 0; k < 3; k ++) {
					colorData[i][j][k] = i + 1;
				}
			}
		}
	}
	
	public void excecuteAlg(Algorithm alg) {
		
	}
	
	public void excecuteMove(int value) {
		int face = 0;
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
		int iterations = 1,k = 1;
		if(direction == 1) k += 2;
		if(direction == 2) iterations ++;
		for(int i = 0; i < iterations; i ++) {
			colorData[face] = this.rotateCW(colorData[face], k);
			if(face == 0) {
				if(direction == 0) {
					this.setCube(Map.applyMap(this.getCube(), Map.upClockwiseMap));
				} else {
					this.setCube(Map.applyMap(this.getCube(), Map.upCounterClockwiseMap));
				}
			} else if(face == 1) {
				if(direction == 0) {
					this.setCube(Map.applyMap(this.getCube(), Map.rightClockwiseMap));
				} else {
					this.setCube(Map.applyMap(this.getCube(), Map.rightCounterClockwiseMap));
				}
			} else if(face == 2) {
				if(direction == 0) {
					this.setCube(Map.applyMap(this.getCube(), Map.frontClockwiseMap));
				} else {
					this.setCube(Map.applyMap(this.getCube(), Map.frontCounterClockwiseMap));
				}
			} else if(face == 3) {
				if(direction == 0) {
					this.setCube(Map.applyMap(this.getCube(), Map.leftClockwiseMap));
				} else {
					this.setCube(Map.applyMap(this.getCube(), Map.leftCounterClockwiseMap));
				}
			} else if(face == 4) {
				if(direction == 0) {
					this.setCube(Map.applyMap(this.getCube(), Map.backClockwiseMap));
				} else {
					this.setCube(Map.applyMap(this.getCube(), Map.backCounterClockwiseMap));
				}
			} else if(face == 5) {
				if(direction == 1) {
					this.setCube(Map.applyMap(this.getCube(), Map.downClockwiseMap));
				} else {
					this.setCube(Map.applyMap(this.getCube(), Map.downCounterClockwiseMap));
				}
			} 
		}
	}
	
	
	private int[][] rotateCW(int[][] mat, int iterations) {
		int[][] ret = null;
		for(int i = 0; i < iterations; i ++) {
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
	    return Arrays.copyOf(ret, ret.length);
	}
	
	public int[][][] getCube(){
		return this.colorData;
	}
	public void setCube(int[][][] i) {
		this.colorData = i;
	}
}
