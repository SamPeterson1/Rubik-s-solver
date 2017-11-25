package Lib;

import java.util.Arrays;

public class Edge {
	int[] colors = null;
	int ID = 0;
	public Edge(int[] colors, int ID) {
		this.colors = Arrays.copyOf(colors, colors.length);
		this.ID = ID;
	}
	
	public boolean matches(int[] colors) {
		if(colors[0] == this.colors[0] & colors[1] == this.colors[1] || colors[0] == this.colors[1] & colors[1] == this.colors[0]) {
			return true;
		}
		System.out.println(this.colors[0] + " " + this.colors[1]);
		return false;
	}
	
	public boolean matchesColor(int color) {
		if(this.colors[0] == color | this.colors[1] == color) {
			return true;
		}
		return false;
	}
	
	public int[] getColors() {
		return this.colors.clone();
	}
	
	public void setColors(int[] colors) {
		this.colors = Arrays.copyOf(colors, colors.length);
	}
	
	public int getID() {
		return this.ID;
	}
}
