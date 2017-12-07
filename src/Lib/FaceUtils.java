package Lib;

import java.util.ArrayList;
import java.util.Arrays;

public class FaceUtils {
	private Edge edge1, edge2, edge3, edge4;
	private Corner corner1,corner2,corner3,corner4;
	
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private ArrayList<Corner> corners = new ArrayList<Corner>();
	
	int[] edgeCoords = null;
	int[] surroundingFaces = null;
	int[] cornerCoords = null;
	
	
	private int center = 0;
	
	private int face = 0;
	
	public FaceUtils(int face, int[] surroundingFaces, int[][][] cube, int[] edgeCoords, int[] cornerCoords) {
		this.face = face;
		this.edgeCoords = Arrays.copyOf(edgeCoords, edgeCoords.length);
		this.cornerCoords = Arrays.copyOf(cornerCoords, cornerCoords.length);
		this.surroundingFaces = Arrays.copyOf(surroundingFaces, surroundingFaces.length);
		center = cube[face][1][1];
		int[] edgeColors = new int[2];
		int[] cornerColors = new int[3];
		
		edgeColors[0] = cube[face][0][1];
		edgeColors[1] = cube[surroundingFaces[0]][edgeCoords[0]][edgeCoords[1]];
		edge1 = new Edge(edgeColors,0);
		
		edgeColors[0] = cube[face][1][2];
		edgeColors[1] = cube[surroundingFaces[1]][edgeCoords[2]][edgeCoords[3]];
		edge2 = new Edge(edgeColors,1);
		
		edgeColors[0] = cube[face][2][1];
		edgeColors[1] = cube[surroundingFaces[2]][edgeCoords[4]][edgeCoords[5]];
		edge3 = new Edge(edgeColors,2);
		
		edgeColors[0] = cube[face][1][0];
		edgeColors[1] = cube[surroundingFaces[3]][edgeCoords[6]][edgeCoords[7]];
		edge4 = new Edge(edgeColors,3);
		
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		
		cornerColors[0] = cube[face][0][2];
		cornerColors[1] = cube[surroundingFaces[0]][cornerCoords[0]][cornerCoords[1]];
		cornerColors[2] = cube[surroundingFaces[1]][cornerCoords[2]][cornerCoords[3]];
		corner1 = new Corner(cornerColors,0);
		
		cornerColors[0] = cube[face][2][2];
		cornerColors[1] = cube[surroundingFaces[1]][cornerCoords[4]][cornerCoords[5]];
		cornerColors[2] = cube[surroundingFaces[2]][cornerCoords[6]][cornerCoords[7]];
		corner2 = new Corner(cornerColors,1);
		
		cornerColors[0] = cube[face][2][0];
		cornerColors[1] = cube[surroundingFaces[2]][cornerCoords[8]][cornerCoords[9]];
		cornerColors[2] = cube[surroundingFaces[3]][cornerCoords[10]][cornerCoords[11]];
		corner3 = new Corner(cornerColors,2);
		
		cornerColors[0] = cube[face][0][0];
		cornerColors[1] = cube[surroundingFaces[3]][cornerCoords[12]][cornerCoords[13]];
		cornerColors[2] = cube[surroundingFaces[0]][cornerCoords[14]][cornerCoords[15]];
		corner4 = new Corner(cornerColors,3);
		
		corners.add(corner1);
		corners.add(corner2);
		corners.add(corner3);
		corners.add(corner4);
	}
	public void updateUtil(int[][][] cube) {
		int[] edgeColors = new int[2];
		int[] cornerColors = new int[3];
		
		edgeColors[0] = cube[face][0][1];
		edgeColors[1] = cube[surroundingFaces[0]][edgeCoords[0]][edgeCoords[1]];
		edge1.setColors(edgeColors);
		
		edgeColors[0] = cube[face][1][2];
		edgeColors[1] = cube[surroundingFaces[1]][edgeCoords[2]][edgeCoords[3]];
		edge2.setColors(edgeColors);
		
		edgeColors[0] = cube[face][2][1];
		edgeColors[1] = cube[surroundingFaces[2]][edgeCoords[4]][edgeCoords[5]];
		edge3.setColors(edgeColors);
		
		edgeColors[0] = cube[face][1][0];
		edgeColors[1] = cube[surroundingFaces[3]][edgeCoords[6]][edgeCoords[7]];
		edge4.setColors(edgeColors);
		
		
		cornerColors[0] = cube[face][0][2];
		cornerColors[1] = cube[surroundingFaces[0]][cornerCoords[0]][cornerCoords[1]];
		cornerColors[2] = cube[surroundingFaces[1]][cornerCoords[2]][cornerCoords[3]];
		corner1.updateColors(cornerColors);
		
		cornerColors[0] = cube[face][2][2];
		cornerColors[1] = cube[surroundingFaces[1]][cornerCoords[4]][cornerCoords[5]];
		cornerColors[2] = cube[surroundingFaces[2]][cornerCoords[6]][cornerCoords[7]];
		corner2.updateColors(cornerColors);
		
		cornerColors[0] = cube[face][2][0];
		cornerColors[1] = cube[surroundingFaces[2]][cornerCoords[8]][cornerCoords[9]];
		cornerColors[2] = cube[surroundingFaces[3]][cornerCoords[10]][cornerCoords[11]];
		corner3.updateColors(cornerColors);
		
		cornerColors[0] = cube[face][0][0];
		cornerColors[1] = cube[surroundingFaces[3]][cornerCoords[12]][cornerCoords[13]];
		cornerColors[2] = cube[surroundingFaces[0]][cornerCoords[14]][cornerCoords[15]];
		corner4.updateColors(cornerColors);
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
	
	public Corner getCorner(int ID) {
		for(Corner corner: corners) {
			if(corner.getID() == ID) {
				return corner;
			}
		}
		return null;
	}
	
	public int findFlippedEdge(int color, int side) {
		for(Edge edge: edges) {
			if(edge.containsColor(side, color)) {
				return edge.getID();
			}
		}
		return -1;
	}
	
	public int fineEdgeColor(int color) {
		for(Edge edge: edges) {
			if(edge.matchesColor(color)) {
				return edge.getID();
			}
		}
		return -1;
	}
	
	public Edge getEdge(int ID) {
		for(Edge edge:edges) {
			if(edge.getID() == ID) {
				return edge;
			}
		}
		return null;
	}
	
	public boolean isEdgePresent(int color, int edge) {
		for(Edge edge1: edges) {
			if(edge1.getID() == edge) {
				if(edge1.matchesColor(color)) {
					return true;
				}
				return false;
			}
		}
		return false;
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
