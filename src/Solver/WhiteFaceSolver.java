package Solver;

import java.util.ArrayList;

import Lib.Corner;
import Lib.Cube;
import Lib.FaceUtils;


public class WhiteFaceSolver {
	
	boolean firstTime = true;
	ArrayList<FaceUtils> centerFaces = new ArrayList<FaceUtils>();
	Cube cube;
	
	public void test() {
		int[] i = {0,1,5,3};
		int[] coords = {2,1,1,0,0,1,1,2};
		int[] corners = {2,2,0,0,2,0,0,2,0,0,2,2,0,2,2,0};
		FaceUtils blueFace = new FaceUtils(2,i,cube.getCube(), coords, corners);
		int[] i2 = {0,4,5,2};
		int[] coords2 = {1,2,1,0,1,2,1,2};
		int[] corners2 = {0,2,0,0,2,0,2,2,0,2,2,2,0,2,2,2};
		
		//0,2,   0,0,2,0,  2,2   0,2, , 2,2
		FaceUtils redFace = new FaceUtils(1,i2,cube.getCube(), coords2, corners2);
		int[] i3 = {0,3,5,1};
		int[] coords3 = {0,1,1,0,2,1,1,2};
		int[] corner3 = {0,0,0,0,2,0,2,0,2,2,2,2,0,2,0,2};
		FaceUtils greenFace = new FaceUtils(4,i3,cube.getCube(), coords3, corner3);
		int[] i4 = {0,2,5,4};
		int[] coords4 = {1,0,1,0,1,0,1,2};
		int[] corners4 = {2,0,0,0,2,0,0,0,2,0,2,2,0,2,0,0};
		FaceUtils orangeFace = new FaceUtils(3,i4,cube.getCube(), coords4, corners4);
		if(firstTime) {
			centerFaces.add(blueFace);
			centerFaces.add(redFace);
			centerFaces.add(greenFace);
			centerFaces.add(orangeFace);
			firstTime = false;
		}
		
		Corner activeCorner = blueFace.getCorner(0);
		System.out.println(activeCorner.getColors()[0]);
	}
	
	public void setCube(Cube cube) {
		this.cube = cube;
	}
}
