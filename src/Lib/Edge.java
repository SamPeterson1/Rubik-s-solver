package Lib;

public class Edge {
	int[] colors = null;
	public Edge(int[] colors) {
		this.colors = colors.clone();
	}
	
	public boolean matches(int[] colors) {
		return colors.equals(this.colors);
	}
	public int[] getColors() {
		return this.colors.clone();
	}
}
