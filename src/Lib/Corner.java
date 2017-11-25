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
		if(colors[0] == this.colors[0] & colors[1] == this.colors[1] & colors[2] == this.colors[2]) {
			return true;
		}
		return false;
	}
}
