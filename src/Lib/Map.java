package Lib;

import java.util.Arrays;

public class Map {
	public static int[] testMap = {
			0,1,2,2,1,2,2,1,2,0,1,2
	};
	public static int[] rightClockwiseMap = {0,0,2,4,2,0,0,1,2,4,1,0,0,2,2,4,0,0,2,0,2,0,0,2,2,1,2,0,1,2,2,2,2,0,2,2,5,0,2,2,0,2,5,1,2,2,1,2,5,2,2,2,2,2,4,0,0,5,2,2,4,1,0,5,1,2,4,2,0,5,0,2};
	public static int[] rightCounterClockwiseMap = {4,2,0,0,0,2,4,1,0,0,1,2,4,0,0,0,2,2,0,0,2,2,0,2,0,1,2,2,1,2,0,2,2,2,2,2,2,0,2,5,0,2,2,1,2,5,1,2,2,2,2,5,2,2,5,2,2,4,0,0,5,1,2,4,1,0,5,0,2,4,2,0};
	
	public static int[] upClockwiseMap = {1,0,0,2,0,0,1,0,1,2,0,1,1,0,2,2,0,2,2,0,0,3,0,0,2,0,1,3,0,1,2,0,2,3,0,2,3,0,0,4,0,0,3,0,1,4,0,1,3,0,2,4,0,2,4,0,0,1,0,0,4,0,1,1,0,1,4,0,2,1,0,2};
	public static int[] upCounterClockwiseMap = {2,0,0,1,0,0,2,0,1,1,0,1,2,0,2,1,0,2,3,0,0,2,0,0,3,0,1,2,0,1,3,0,2,2,0,2,4,0,0,3,0,0,4,0,1,3,0,1,4,0,2,3,0,2,1,0,0,4,0,0,1,0,1,4,0,1,1,0,2,4,0,2};
	
	public static int[] frontClockwiseMap = {0,2,0,1,0,0,0,2,1,1,1,0,0,2,2,1,2,0,1,0,0,5,0,2,1,1,0,5,0,1,1,2,0,5,0,0,5,0,2,3,2,2,5,0,1,3,1,2,5,0,0,3,0,2,3,2,2,0,2,0,3,1,2,0,2,1,3,0,2,0,2,2};
	public static int[] frontCounterClockwiseMap = {1,0,0,0,2,0,1,1,0,0,2,1,1,2,0,0,2,2,5,0,2,1,0,0,5,0,1,1,1,0,5,0,0,1,2,0,3,2,2,5,0,2,3,1,2,5,0,1,3,0,2,5,0,0,0,2,0,3,2,2,0,2,1,3,1,2,0,2,2,3,0,2};
	
	public static int[] leftClockwiseMap = {0,0,0,2,0,0,0,1,0,2,1,0,0,2,0,2,2,0,2,0,0,5,0,0,2,1,0,5,1,0,2,2,0,5,2,0,5,0,0,4,2,2,5,1,0,4,1,2,5,2,0,4,0,2,4,2,2,0,0,0,4,1,2,0,1,0,4,0,2,0,2,0};
	public static int[] leftCounterClockwiseMap = {2,0,0,0,0,0,2,1,0,0,1,0,2,2,0,0,2,0,5,0,0,2,0,0,5,1,0,2,1,0,5,2,0,2,2,0,4,2,2,5,0,0,4,1,2,5,1,0,4,0,2,5,2,0,0,0,0,4,2,2,0,1,0,4,1,2,0,2,0,4,0,2};
	
	public static int[] backClockwiseMap = {1,0,2,0,0,0,1,1,2,0,0,1,1,2,2,0,0,2,5,2,2,1,0,2,5,2,1,1,1,2,5,2,0,1,2,2,3,2,0,5,2,2,3,1,0,5,2,1,3,0,0,5,2,0,0,0,0,3,2,0,0,0,1,3,1,0,0,0,2,3,0,0};
	public static int[] backCounterClockwiseMap = {0,0,0,1,0,2,0,0,1,1,1,2,0,0,2,1,2,2,1,0,2,5,2,2,1,1,2,5,2,1,1,2,2,5,2,0,5,2,2,3,2,0,5,2,1,3,1,0,5,2,0,3,0,0,3,2,0,0,0,0,3,1,0,0,0,1,3,0,0,0,0,2};
	
	public static int[] downClockwiseMap = {1,2,0,4,2,0,1,2,1,4,2,1,1,2,2,4,2,2,4,2,0,3,2,0,4,2,1,3,2,1,4,2,2,3,2,2,3,2,0,2,2,0,3,2,1,2,2,1,3,2,2,2,2,2,2,2,0,1,2,0,2,2,1,1,2,1,2,2,2,1,2,2,
			};
	public static int[] downCounterClockwiseMap = {4,2,0,1,2,0,4,2,1,1,2,1,4,2,2,1,2,2,3,2,0,4,2,0,3,2,1,4,2,1,3,2,2,4,2,2,2,2,0,3,2,0,2,2,1,3,2,1,2,2,2,3,2,2,1,2,0,2,2,0,1,2,1,2,2,1,1,2,2,2,2,2,};
	
	public static int[] middleSliceClockwiseMap = {0,0,1,4,2,1,0,1,1,4,1,1,0,2,1,4,2,1,4,2,1,5,0,1,4,1,1,5,1,1,4,0,1,5,2,1,5,0,1,2,0,1,5,1,1,2,1,1,5,2,1,2,2,1,2,0,1,0,0,1,2,1,1,0,1,1,2,2,1,0,2,1,4,0,1,4,0,1,5,2,1};
	public static int[] middleSliceCounterClockwiseMap = {4,2,1,0,0,1,4,1,1,0,1,1,4,2,1,0,2,1,5,0,1,4,2,1,5,1,1,4,1,1,5,2,1,4,0,1,2,0,1,5,0,1,2,1,1,5,1,1,2,2,1,5,2,1,0,0,1,2,0,1,0,1,1,2,1,1,0,2,1,2,2,1};
	
	public static int[] sideSliceClockwiseMap = {0,1,0,1,0,1,0,1,1,1,1,1,0,1,2,1,2,1,1,0,1,5,1,2,1,1,1,5,1,1,1,2,1,5,1,0,5,1,2,3,2,1,5,1,1,3,1,1,5,1,0,3,0,1,3,2,1,0,1,0,3,1,1,0,1,1,3,0,1,0,1,2,};
	public static int[] sideSliceCounterClockwiseMap = {1,0,1,0,1,0,1,1,1,0,1,1,1,2,1,0,1,2,5,1,2,1,0,1,5,1,1,1,1,1,5,1,0,1,2,1,3,2,1,5,1,2,3,1,1,5,1,1,3,0,1,5,1,0,0,1,0,3,2,1,0,1,1,3,1,1,0,1,2,3,0,1,};
	
	public static int[] equatorSliceClockwiseMap = {
			1,1,0,2,1,0,
			1,1,1,2,1,1,
			1,1,2,2,1,2,
			
			2,1,0,3,1,0,
			2,1,1,3,1,1,
			2,1,2,3,1,2,
			
			3,1,0,4,1,0,
			3,1,1,4,1,1,
			3,1,2,4,1,2,
			
			4,1,0,1,1,0,
			4,1,1,1,1,1,
			4,1,2,1,1,2,
	};
	
	public static int[] equatorSliceCounterClockwiseMap = {
			2,1,0,1,1,0,
			2,1,1,1,1,1,
			2,1,2,1,1,2,
			
			3,1,0,2,1,0,
			3,1,1,2,1,1,
			3,1,2,2,1,2,
			
			4,1,0,3,1,0,
			4,1,1,3,1,1,
			4,1,2,3,1,2,
			
			1,1,0,4,1,0,
			1,1,1,4,1,1,
			1,1,2,4,1,2,
	};
	
	public static int[][][] applyMap(int[][][] colorData, int[] map){
		int[] backup = new int[map.length/3];
		for(int i = 0; i < backup.length; i ++) {
			int j = i * 3;
			backup[i] = colorData[map[j]][map[j + 1]][map[j + 2]];
		}
		for(int i = 3; i < map.length; i += 6) {
			colorData[map[i]][map[i + 1]][map[i + 2]] = backup[i/3 - 1];
		}
		return colorData;
	} 
} 
