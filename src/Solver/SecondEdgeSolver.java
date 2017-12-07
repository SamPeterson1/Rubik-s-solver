package Solver;

import java.util.ArrayList;

import Lib.Algorithm;
import Lib.Cube;
import Lib.Edge;
import Lib.FaceUtils;

public class SecondEdgeSolver {
	boolean firstTime = true;
	ArrayList<FaceUtils> centerFaces = new ArrayList<FaceUtils>();
	Cube cube;
	
	public void setCube(Cube cube) {
		this.cube = cube;
	}
	
	public void test() {
		int[] i = {0,1,5,3};
		int[] coords = {2,1,1,0,0,1,1,2};
		int[] corners = {2,2,0,0,2,0,0,2,0,0,2,2,0,2,2,0};
		FaceUtils blueFace = new FaceUtils(2,i,cube.getCube(), coords, corners);
		int[] i2 = {0,4,5,2};
		int[] coords2 = {1,2,1,0,1,2,1,2};
		int[] corners2 = {0,2,0,0,2,0,2,2,0,2,2,2,0,2,2,2};
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
		int[][] colors3 = {{3,2},{2,5},{5,4},{4,3}};
		Algorithm insert1 = new Algorithm("U R U' R' U' F' U F");
		Algorithm insert2 = new Algorithm("U U F' U F U R U' R'");
		int iter = 0;
		for(FaceUtils blueFace1: centerFaces) {
			
			blueFace1.updateUtil(cube.getCube());
			int[] colors = colors3[iter];
			Edge middleEdge = blueFace1.getEdge(0);
			boolean repeat = false;
			do {
				int iterations = 0;
				repeat = false;
				blueFace1.updateUtil(cube.getCube());
				while(!middleEdge.matchesColorCommutative(colors)) {
					if(iterations > 4) {
						repeat = true;
						break;
					}
					cube.excecuteMove(Cube.TOP_FACE_C, true);
					blueFace1.updateUtil(cube.getCube());
					iterations ++;
				}
				Algorithm alg = new Algorithm("U R U' R' U' F' U F");
				if(repeat) {
					for(FaceUtils util: centerFaces) {
						util.updateUtil(cube.getCube());
						if(util.getEdge(1).matchesColorCommutative(colors)) {
							cube.excecuteAlg(alg, true);
							blueFace1.updateUtil(cube.getCube());
							break;
						}
						alg.rotatePerspectiveLeft();
					}
					
				}
				for(FaceUtils util: centerFaces) {
					util.updateUtil(cube.getCube());
				}
			} while(repeat);
			blueFace1.updateUtil(cube.getCube());
			if(middleEdge.containsColor(0, colors[1])) {
				cube.excecuteAlg(insert2, true);
			} else {
				cube.excecuteAlg(insert1, true);
			}
			blueFace1.updateUtil(cube.getCube());
			insert2.rotatePerspectiveLeft();
			insert1.rotatePerspectiveLeft();
			iter++;
		}
	}
}
