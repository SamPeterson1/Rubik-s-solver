package Lib;

public class Corner {
	int[] colors = null;
	int ID = 0;
	
	public Corner(int[] colors, int ID) {
		this.colors = colors.clone();
		this.ID = ID;
	}
	
	public int[] getColors() {
		return this.colors;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public boolean matches(int[] colors) {
		if(colors[0] == this.colors[0] & colors[1] == this.colors[1] & colors[2] == this.colors[2]) {
			return true;
		}
		return false;
	}
}
