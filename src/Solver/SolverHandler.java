package Solver;

import java.util.ArrayList;

import Lib.Algorithm;
import Lib.Cube;
import Lib.Move;
import Lib.ScrambleGenerator;

public class SolverHandler {
	
	public Cube cube;
	public CrossSolver solver;
	public WhiteFaceSolver solver2;
	public SecondEdgeSolver solver3;
	public OllRecognizer recog;
	public PllRecognizer pllRecog;
	public SolverCanvas canvas;
	
	public void setUtils(Cube cube, CrossSolver solver, WhiteFaceSolver solver2, SecondEdgeSolver solver3, OllRecognizer recog, PllRecognizer pllRecog, SolverCanvas canvas) {
		this.cube = cube;
		this.solver = solver;
		this.solver2 = solver2;
		this.solver3 = solver3;
		this.recog = recog;
		this.pllRecog = pllRecog;
		this.canvas = canvas;
	}
	
	public void scramble() {
		Algorithm alg = ScrambleGenerator.generateScramble(50, System.currentTimeMillis());
		ArrayList<Move> moves = alg.getMovesList();
		for(Move move: moves) {
			cube.excecuteMove(move.get(), false);
			canvas.draw();
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void solve() {
		solver.test();
		solver2.test();
		solver3.test();
		Algorithm alg1 = new Algorithm(" ");
		int i = recog.findCase(cube.getCube(), alg1);
		for(int i2 = 0; i2 < i; i2 ++) {
			cube.excecuteMove(Cube.TOP_FACE_C, true);
		}
		cube.excecuteAlg(alg1, true);
		pllRecog.excecutePLL(cube); 
		cube.printSolution();
		Algorithm solution = cube.getSolutionAlg();
		solution.reverseAlgorithm();
		cube.excecuteAlg(solution, false);
		solution.reverseAlgorithm();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ArrayList<Move> moves2 = solution.getMovesList();
		for(Move move: moves2) {
			cube.excecuteMove(move.get(), false);
			canvas.draw();
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cube.resetMoveHistory();
	}
	
	public void demonstrate() {
		this.scramble();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.solve();
	}
}
