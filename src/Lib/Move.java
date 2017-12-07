package Lib;

public class Move {
	private String Notation = null;
	
	public Move(String Notation) {
		this.Notation = Notation;
	}
	
	public void setMove(String move) {
		this.Notation = move;
	}
	
	public String getNotation() {	
		return this.Notation;
	}
	public String getInverse(String move) {
		String retVal = move;
		if(Notation.contains("'")) {
			retVal = retVal.replace("'", "");
		} else if(!retVal.contains("2")){
			retVal += "'";
		}
		return retVal;
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
				System.err.println("Invalid Notation" + this.Notation);
				return 13; 
		}
	}
	
	public static String get(int Notation) {
		switch(Notation) {
			case Cube.TOP_FACE_C:
				return "U";
			case Cube.RIGHT_FACE_C:
				return "R";
			case Cube.FRONT_FACE_C:
				return "F";
			case Cube.LEFT_FACE_C:
				return "L";
			case Cube.BACK_FACE_C:
				return "B";
			case Cube.BOTTOM_FACE_C:
				return "D";
			case Cube.TOP_FACE_CC:
				return "U'";
			case Cube.RIGHT_FACE_CC:
				return "R'";
			case Cube.FRONT_FACE_CC:
				return "F'";
			case Cube.LEFT_FACE_CC:
				return "L'";
			case Cube.BACK_FACE_CC:
				return "B'";
			case Cube.BOTTOM_FACE_CC:
				return "D'";
			case Cube.TOP_FACE_TWICE:
				return "U2";
			case Cube.RIGHT_FACE_TWICE:
				return "R2";
			case Cube.FRONT_FACE_TWICE:
				return "F2";
			case Cube.LEFT_FACE_TWICE:
				return "L2";
			case Cube.BACK_FACE_TWICE:
				return "B2";
			case Cube.BOTTOM_FACE_TWICE:
				return "D2";
			case Cube.SMALL_TOP_FACE_C:
				return "u";
			case Cube.SMALL_RIGHT_FACE_C:
				return "r";
			case Cube.SMALL_FRONT_FACE_C:
				return "f";
			case Cube.SMALL_LEFT_FACE_C:
				return "l";
			case Cube.SMALL_BACK_FACE_C:
				return "b";
			case Cube.SMALL_BOTTOM_FACE_C:
				return "d";
			case Cube.SMALL_TOP_FACE_CC:
				return "u'";
			case Cube.SMALL_RIGHT_FACE_CC:
				return "r'";
			case Cube.SMALL_FRONT_FACE_CC:
				return "f'";
			case Cube.SMALL_LEFT_FACE_CC:
				return "l'";
			case Cube.SMALL_BACK_FACE_CC:
				return "b'";
			case Cube.SMALL_BOTTOM_FACE_CC:
				return "d'";
			case Cube.SMALL_TOP_FACE_TWICE:
				return "u2";
			case Cube.SMALL_RIGHT_FACE_TWICE:
				return "r2";
			case Cube.SMALL_FRONT_FACE_TWICE:
				return "f2";
			case Cube.SMALL_LEFT_FACE_TWICE:
				return "l2";
			case Cube.SMALL_BACK_FACE_TWICE:
				return "b2";
			case Cube.SMALL_BOTTOM_FACE_TWICE:
				return "d2";
			case Cube.MIDDLE_SLICE_C:
				return "M";
			case Cube.EQUATOR_SLICE_C:
				return "E";
			case Cube.SIDE_SLIDE_C:
				return "S";
			case Cube.MIDDLE_SLICE_CC:
				return "M'";
			case Cube.EQUATOR_SLICE_CC:
				return "E'";
			case Cube.SIDE_SLICE_CC:
				return "S'";
			case Cube.MIDDLE_SLICE_TWICE:
				return "M2";
			case Cube.EQUATOR_SLICE_TWICE:
				return "E2";
			case Cube.SIDE_SLICE_TWICE:
				return "S2";
		}
		return "";
	}
}
