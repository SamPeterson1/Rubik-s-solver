package Lib;

public class Corner {
	int[] colors = null;
	
	public Corner(int[] colors) {
		this.colors = colors.clone();
	}
	
	public int[] getColors() {
		return this.colors;
	}
	
	public boolean matches(int[] colors) {
		return this.colors.equals(colors);
	}
}
