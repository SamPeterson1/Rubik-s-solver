package Lib;

import java.util.ArrayList;

public class FaceUtils {
	private Edge edge1, edge2, edge3, edge4;
	private Corner corner1,corner2,corner3,corner4;
	
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private ArrayList<Corner> corners = new ArrayList<Corner>();
	
	private int center = 0;
	
	private int face = 0;
	
	public FaceUtils(int face, int[] surroundingFaces, int[][][] cube) {
		this.face = face;
		
		center = cube[face][1][1];
		int[] edgeColors = new int[2];
		int[] cornerColors = new int[3];
		
		edgeColors[0] = cube[face][0][1];
		edgeColors[1] = cube[surroundingFaces[0]][0][1];
		edge1 = new Edge(edgeColors);
		
		edgeColors[0] = cube[face][1][2];
		edgeColors[1] = cube[surroundingFaces[1]][0][1];
		edge2 = new Edge(edgeColors);
		
		edgeColors[0] = cube[face][2][1];
		edgeColors[1] = cube[surroundingFaces[2]][0][1];
		edge3 = new Edge(edgeColors);
		
		edgeColors[0] = cube[face][1][0];
		edgeColors[1] = cube[surroundingFaces[3]][0][1];
		edge4 = new Edge(edgeColors);
		
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		
		cornerColors[0] = cube[face][2][2];
		cornerColors[1] = cube[surroundingFaces[0]][0][0];
		cornerColors[2] = cube[surroundingFaces[1]][0][2];
		corner1 = new Corner(cornerColors);
		
		cornerColors[0] = cube[face][2][0];
		cornerColors[1] = cube[surroundingFaces[1]][0][0];
		cornerColors[2] = cube[surroundingFaces[2]][0][2];
		corner2 = new Corner(cornerColors);
		
		cornerColors[0] = cube[face][0][0];
		cornerColors[1] = cube[surroundingFaces[2]][0][0];
		cornerColors[2] = cube[surroundingFaces[3]][0][2];
		corner3 = new Corner(cornerColors);
		
		cornerColors[0] = cube[face][0][2];
		cornerColors[1] = cube[surroundingFaces[3]][0][0];
		cornerColors[2] = cube[surroundingFaces[0]][0][2];
		corner4 = new Corner(cornerColors);
		
		corners.add(corner1);
		corners.add(corner2);
		corners.add(corner3);
		corners.add(corner4);
		
		for(Edge edge: edges) {
			System.out.println(edge.getColors()[0] + " " + edge.getColors()[1]);
		}
		
		for(Corner corner: corners) {
			System.out.println(corner.getColors()[0] + " " + corner.getColors()[1] + " " + corner.getColors()[2]);
		}
	}
	public int findEdge(int[] colors) {
		int i = 0;
		for(Edge edge: edges) {
			if(edge.matches(colors)) {
				return i;
			}
			i ++;
		}
		return -1;
	}
	
	public int findCorner(int[] colors) {
		int i = 0;
		for(Corner corner: corners) {
			if(corner.matches(colors)) {
				return i;
			}
			i ++;
		}
		return -1;
	}
	
	public int getCenter() {
		return this.center;
	}
	
	public int getFace() {
		return this.face;
	}
}
