package Solver;

import java.util.ArrayList;
import java.util.Arrays;

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
		if(firstTime) {
			centerFaces.add(blueFace);
			centerFaces.add(redFace);
			centerFaces.add(greenFace);
			centerFaces.add(orangeFace);
			firstTime = false;
		}
		int index = 0;
		Algorithm alg = new Algorithm("F");	
		for(FaceUtils util: centerFaces) {
			util.updateUtil(cube.getCube());
			while(true) {
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
				} else {
					break;
				}
			}
			alg.rotatePerspectiveLeft();	
			index ++;
		}
		int[] i5 = {3,4,1,2};
		int[] coords5 = {0,1,0,1,0,1,0,1};
		Algorithm edgeFlip = new Algorithm("F R U' R'");
		FaceUtils YellowFace = new FaceUtils(0,i5,cube.getCube(),coords5);
		int iterdsfr = 0;
		while(YellowFace.findFlippedEdge(6, 1) != -1) {
			iterdsfr++;
			int flippedEdge = YellowFace.findFlippedEdge(6, 1) - 1;
			if(iterdsfr > 5) {
				System.out.println(" " + "NOTIFHYYYY");
				break;
			}
			System.out.println(flippedEdge);
			switch(flippedEdge) {
				case 0:
					cube.excecuteMove(Cube.TOP_FACE_TWICE);
					break;
				case 1:
					cube.excecuteMove(Cube.TOP_FACE_C);
					break;
				case 3:
					cube.excecuteMove(Cube.TOP_FACE_CC);
					break;
			}
			cube.excecuteAlg(edgeFlip);
			YellowFace.updateUtil(cube.getCube());
		}
		Algorithm bringDown = new Algorithm("F F");
		boolean redo = false;
		int facede = 0;
		for(int t2i = 0; t2i < 4; t2i ++) {
			for(FaceUtils blueFace1: centerFaces) {
				facede++;
				blueFace1.updateUtil(cube.getCube());
				int iter = 0;
				while(!(blueFace1.getEdge(0).getColors()[0] == blueFace1.getCenter() & blueFace1.getEdge(0).getColors()[0] == 6)) {
					cube.excecuteMove(Cube.TOP_FACE_C);
					blueFace1.updateUtil(cube.getCube());
					for(int ij = 0; ij < 4; ij ++) {
						if(!(blueFace1.getEdge(0).getColors()[0] == 6)) {
							cube.excecuteMove(Cube.TOP_FACE_C);
							blueFace1.updateUtil(cube.getCube());
						}
					}
					iter ++;
				}
				cube.excecuteAlg(bringDown);
				bringDown.rotatePerspectiveLeft();
			}
		}
	}
	
	public void flip() {
		int[] i = {0,1,5,3};
		int[] coords = {2,1,1,0,0,1,1,2};
		FaceUtils blueFacew = new FaceUtils(2,i,cube.getCube(), coords);
		System.out.println((blueFacew.getEdge(0).getColors()[0] == blueFacew.getCenter()));
	}
	
	public void setCube(Cube cube) {
		this.cube = cube;
	}
}
