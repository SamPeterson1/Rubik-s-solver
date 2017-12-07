package Solver;

import java.util.ArrayList;

import Lib.Algorithm;
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
		int[][] colors3 = {{3,2,6},{2,5,6},{5,4,6},{4,3,6}};
		int in = 0;
		Algorithm insertSide = new Algorithm("F' U' F");
		Algorithm insertTop = new Algorithm("F' U F U U F' U' F");
		Algorithm insertFront = new Algorithm("R U R'");
		for(FaceUtils blueFace1: centerFaces) {
		in ++;
		blueFace1.updateUtil(cube.getCube());
		Corner bottomCorner = blueFace1.getCorner(1);
		Corner activeCorner = blueFace1.getCorner(0);
		int[] colors = colors3[in - 1];
		if(bottomCorner.contains(6) & !bottomCorner.matches(colors)) {
			insertSide.reverseAlgorithm();
			cube.excecuteAlg(insertSide, true);
			insertSide.reverseAlgorithm();
		}
		int[] colors2 = colors3[in - 1];
		boolean search = false;
		do {
			int index = 0;
			search = false;
			blueFace1.updateUtil(cube.getCube());
			if(!bottomCorner.matches(colors2)) {
				while(!activeCorner.matchesColorCommutative(colors2)) {
					index ++;
					if(index > 4) {
						search = true;
						break;
					}
					cube.excecuteMove(Cube.TOP_FACE_C, true);
					blueFace1.updateUtil(cube.getCube());
					
				}
				Algorithm Itop = new Algorithm("R U R'");
				if(search) {
					for(FaceUtils util: centerFaces) {
						if(util.getCorner(1).matchesColorCommutative(colors2)) {
							cube.excecuteAlg(Itop, true);
							break;
						}
						Itop.rotatePerspectiveLeft();
					}
					
				}
				for(FaceUtils util: centerFaces) {
					util.updateUtil(cube.getCube());
				}
			}
		} while (search);
		blueFace1.updateUtil(cube.getCube());
		int whiteLocation = 0;
		for(whiteLocation = 0; whiteLocation < 3; whiteLocation ++) {
			if(activeCorner.getColors()[whiteLocation] == 6) {
				break;
			}
		}
		if(!bottomCorner.matches(colors2)) {
			switch(whiteLocation) {
				case 0:
					cube.excecuteAlg(insertSide, true);
					break;
				case 1:
					cube.excecuteAlg(insertTop, true);
					break;
				case 2:
					cube.excecuteAlg(insertFront, true);
					break;
			}
		}
		insertSide.rotatePerspectiveLeft();
		insertTop.rotatePerspectiveLeft();
		insertFront.rotatePerspectiveLeft();
		}
	}
	
	public void setCube(Cube cube) {
		this.cube = cube;
	}
}
