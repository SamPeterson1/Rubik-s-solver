package Lib;

import java.util.Random;

public class ScrambleGenerator {
	public static Algorithm generateScramble(int length, long seed) {
		StringBuilder str = new StringBuilder("");
		Random rand = new Random(seed);
		for(int i = 0; i < length; i ++) {
			int move = rand.nextInt((18 - 1) + 1) + 1;
			String moveStr = Move.get(move);
			str.append(moveStr).append(" ");
		}
		return new Algorithm(str.toString());
	}
}
