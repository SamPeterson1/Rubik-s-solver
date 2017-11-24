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
			case "U2":
				return Cube.TOP_FACE_TWICE;
			case "R2":
				return Cube.RIGHT_FACE_TWICE;
			case "F2":
				return Cube.FRONT_FACE_TWICE;
			case "L2":
				return Cube.LEFT_FACE_TWICE;
			case "B2":
				return Cube.BACK_FACE_TWICE;
			case "D2":
				return Cube.BOTTOM_FACE_TWICE;
			case "u":
				return Cube.SMALL_TOP_FACE_C;
			case "r":
				return Cube.SMALL_RIGHT_FACE_C;
			case "f":
				return Cube.SMALL_FRONT_FACE_C;
			case "l":
				return Cube.SMALL_LEFT_FACE_C;
			case "b":
				return Cube.SMALL_BACK_FACE_C;
			case "d":
				return Cube.SMALL_BOTTOM_FACE_C;
			case "u'":
				return Cube.SMALL_TOP_FACE_CC;
			case "r'":
				return Cube.SMALL_RIGHT_FACE_CC;
			case "f'":
				return Cube.SMALL_FRONT_FACE_CC;
			case "l'":
				return Cube.SMALL_LEFT_FACE_CC;
			case "b'":
				return Cube.SMALL_BACK_FACE_CC;
			case "d'":
				return Cube.SMALL_BOTTOM_FACE_CC;
			case "u2":
				return Cube.SMALL_TOP_FACE_TWICE;
			case "r2":
				return Cube.SMALL_RIGHT_FACE_TWICE;
			case "f2":
				return Cube.SMALL_FRONT_FACE_TWICE;
			case "l2":
				return Cube.SMALL_LEFT_FACE_TWICE;
			case "b2":
				return Cube.SMALL_BACK_FACE_TWICE;
			case "d2":
				return Cube.SMALL_BOTTOM_FACE_TWICE;
			case "M":
				return Cube.MIDDLE_SLICE_C;
			case "E":
				return Cube.EQUATOR_SLICE_C;
			case "S":
				return Cube.SIDE_SLIDE_C;
			case "M'":
				return Cube.MIDDLE_SLICE_CC;
			case "E'":
				return Cube.EQUATOR_SLICE_CC;
			case "S'":
				return Cube.SIDE_SLICE_CC;
			case "M2":
				return Cube.MIDDLE_SLICE_TWICE;
			case "E2":
				return Cube.EQUATOR_SLICE_TWICE;
			case "S2":
				return Cube.SIDE_SLICE_TWICE;
			default:
				System.err.println("Invalid Notation");
				return 13; 
		}
	}
}
