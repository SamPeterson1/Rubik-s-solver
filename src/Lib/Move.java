package Lib;

public class Move {
	private String Notation = null;
	
	public Move(String Notation) {
		this.Notation = Notation;
	}
	
	public int get() {
		switch(this.Notation) {
			case "U":
				return Cube.TOP_FACE_C;
			case "R":
				return Cube.RIGHT_FACE_C;
			case "F":
				return Cube.FRONT_FACE_C;
			case "L":
				return Cube.LEFT_FACE_C;
			case "B":
				return Cube.BACK_FACE_C;
			case "D":
				return Cube.BOTTOM_FACE_C;
			case "U'":
				return Cube.TOP_FACE_CC;
			case "R'":
				return Cube.RIGHT_FACE_CC;
			case "F'":
				return Cube.FRONT_FACE_CC;
			case "L'":
				return Cube.LEFT_FACE_CC;
			case "B'":
				return Cube.BACK_FACE_CC;
			case "D'":
				return Cube.BOTTOM_FACE_CC;
			default:
				System.err.println("Invalid Notation");
				return 5;
		}
	}
}
