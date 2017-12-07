package Lib;

import java.util.ArrayList;

public class Algorithm {
	ArrayList<Move> Moves = new ArrayList<Move>();
	int length = 0;
	int ID = 0;
	
	public Algorithm(String moves) {
		String[] splitMoves = null;
		splitMoves = moves.split(" ");
		this.length = splitMoves.length;
		for(int i = 0; i < splitMoves.length; i ++) {
			Moves.add(new Move(splitMoves[i]));
		}
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return this.ID;
	}
	
	@SuppressWarnings("unchecked")
	public void setMoves(ArrayList<Move> moves) {
		this.Moves = (ArrayList<Move>) moves.clone();
		this.length = moves.size();
	}
	
	public ArrayList<Move> getMovesList() {
		return this.Moves;
	}
	
	public void rotatePerspectiveLeft() {
		String[] moves = this.getMovesAsString();
		moves = AlgorithmMap.applyMap(moves, AlgorithmMap.rotatePerspectiveLeft);
		int i = 0;
		for(Move move: Moves) {
			move.setMove(moves[i]);
			i ++;
		}
	}
	
	
	public void addMoves(String[] moves) {
		for(int i = 0; i < moves.length; i ++) {
			Moves.add(new Move(moves[i]));
			length ++;
		}
	}
	
	public void rotatePerspectiveRight() {
		String[] moves = this.getMovesAsString();
		moves = AlgorithmMap.applyMap(moves, AlgorithmMap.rotatePerspectiveRight);
		int i = 0;
		for(Move move: Moves) {
			move.setMove(moves[i]);
			i ++;
		}
	}
	
	public String getMoveAsString(int index) {
		return Moves.get(index).getNotation();
	}
	
	public String[] getMovesAsString() {
		String[] retVal = new String[Moves.size()];
		int index = 0;
		for(Move move: Moves) {
			retVal[index] = move.getNotation();
			index ++;
		}
		return retVal;
	}
	
	@SuppressWarnings("unchecked")
	public void reverseAlgorithm() {
		for(Move move: Moves) {
			move.setMove(move.getInverse(move.getNotation()));
		}
		Object backup = Moves.clone();
		int j = Moves.size();
		for(int i = 0; i < Moves.size(); i ++) {
			j --;
			Moves.set(i, ((ArrayList<Move>) backup).get(j));
		}
	}
	
	public int[] getMoves() {
		int[] retval = new int[length];
		int i = 0;
		for(Move move: Moves) {
			retval[i] = move.get();
			i++;
		} 
		return retval;
	}
}
