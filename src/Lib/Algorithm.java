package Lib;

import java.util.ArrayList;

public class Algorithm {
	ArrayList<Move> Moves = new ArrayList<Move>();
	int length = 0;
	
	public Algorithm(String[] moves, int length) {
		this.length = length;
		for(int i = 0; i < moves.length; i ++) {
			Moves.add(new Move(moves[i]));
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
