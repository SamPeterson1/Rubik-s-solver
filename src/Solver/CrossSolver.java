package Solver;

import java.util.ArrayList;
import java.util.Arrays;

import Lib.Algorithm;
import Lib.Cube;
import Lib.FaceUtils;

public class CrossSolver {
	Cube cube;
	ArrayList<FaceUtils> centerFaces =  new ArrayList<FaceUtils>();
	
	public void test() {
		int[] i = {0,1,5,3};
		int[] coords = {2,1,1,0,0,1,1,2};
		FaceUtils blueFace = new FaceUtils(2,i,cube.getCube(), coords);
		int[] i2 = {0,4,5,2};
		int[] coords2 = {1,2,1,0,1,2,1,2};
		FaceUtils redFace = new FaceUtils(1,i2,cube.getCube(), coords2);
		int[] i3 = {0,3,5,1};
		int[] coords3 = {0,1,1,0,2,1,1,2};
		FaceUtils greenFace = new FaceUtils(4,i3,cube.getCube(), coords3);
		int[] i4 = {0,2,5,4};
		int[] coords4 = {1,0,1,0,1,0,1,2};
		FaceUtils orangeFace = new FaceUtils(3,i4,cube.getCube(), coords4);
		centerFaces.add(blueFace);
		centerFaces.add(redFace);
		centerFaces.add(greenFace);
		centerFaces.add(orangeFace);
		int index = 0;
		Algorithm alg = new Algorithm("F");	
		for(FaceUtils util: centerFaces) {
				System.out.println("STUCKKKKK");
				int iter = 0;
				while(util.fineEdgeColor(6) == 0) {
					if(iter > 3) {
						break;
					}
					cube.excecuteMove(Cube.TOP_FACE_C);
					util.updateUtil(cube.getCube());
					iter ++;
				}
				if(util.fineEdgeColor(6) == 1) {
					cube.excecuteAlg(alg);
					util.updateUtil(cube.getCube());
				} else if(util.fineEdgeColor(6) == 3){
					alg.reverseAlgorithm();
					cube.excecuteAlg(alg);
					util.updateUtil(cube.getCube());
					alg.reverseAlgorithm();
				} else if(util.fineEdgeColor(6) == 2) {
					cube.excecuteAlg(alg);
					cube.excecuteAlg(alg);
					util.updateUtil(cube.getCube());
				}
			alg.rotatePerspectiveLeft();	
			index ++;
		}
	}
	
	public void setCube(Cube cube) {
		this.cube = cube;
	}
}
