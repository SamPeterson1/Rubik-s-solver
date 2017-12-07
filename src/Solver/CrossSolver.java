package Solver;

import java.util.ArrayList;

import Lib.Algorithm;
import Lib.Cube;
import Lib.FaceUtils;

public class CrossSolver {
	Cube cube;
	ArrayList<FaceUtils> centerFaces =  new ArrayList<FaceUtils>();
	boolean firstTime = true;
	
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
		Algorithm alg = new Algorithm("F");	
		for(FaceUtils util: centerFaces) {
			util.updateUtil(cube.getCube());
			while(true) {
				int iter = 0;
				while(util.fineEdgeColor(6) == 0) {
					if(iter > 4) {
						break;
					}
					cube.excecuteMove(Cube.TOP_FACE_C, true);
					util.updateUtil(cube.getCube());
					iter ++;
				}
				if(util.fineEdgeColor(6) == 1) {
					cube.excecuteAlg(alg, true);
					util.updateUtil(cube.getCube());
				} else if(util.fineEdgeColor(6) == 3){
					alg.reverseAlgorithm();
					cube.excecuteAlg(alg, true);
					util.updateUtil(cube.getCube());
					alg.reverseAlgorithm();
				} else if(util.fineEdgeColor(6) == 2) {
					cube.excecuteAlg(alg, true);
					cube.excecuteAlg(alg, true);
					util.updateUtil(cube.getCube());
				} else {
					break;
				}
			}
			alg.rotatePerspectiveLeft();			
		}
		
		int[] i5 = {4,1,2,3};
		int[] coords5 = {0,1,0,1,0,1,0,1};
		int[] corners5 = {0,0,0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0,0,2};
		Algorithm edgeFlip = new Algorithm("F R' D' R F F");
		FaceUtils YellowFace = new FaceUtils(0,i5,cube.getCube(),coords5,corners5);
		for(int i1 = 0; i1 < 4; i1 ++) {
			if(YellowFace.getEdge(2).getColors()[1] == 6) {
				cube.excecuteAlg(edgeFlip, true);
			}
			cube.excecuteMove(Cube.TOP_FACE_C, true);
			YellowFace.updateUtil(cube.getCube());
		}
		Algorithm bringDown = new Algorithm("F F");
		for(FaceUtils blueFace1: centerFaces) {
			blueFace1.updateUtil(cube.getCube());
			while(true) {
				int[] colors = {blueFace1.getCenter(), 6};
				if(blueFace1.getEdge(0).getColors()[0] == colors[0] & blueFace1.getEdge(0).getColors()[1] == colors[1]) {
					break;
				}
				cube.excecuteMove(Cube.TOP_FACE_C, true);
				blueFace1.updateUtil(cube.getCube());
			}
			cube.excecuteAlg(bringDown, true);
			bringDown.rotatePerspectiveLeft();
			blueFace1.updateUtil(cube.getCube());
		}
	}
	
	public void flip() {
		
	}
	
	public void setCube(Cube cube) {
		this.cube = cube;
	}
}
