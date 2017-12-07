package Solver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Lib.Algorithm;
import Lib.Cube;
import Lib.Map;
import Lib.Move;

public class SolverMain {
	public static void main(String args[]) {
		SolverEventQueue queue = new SolverEventQueue();
		SolverEvent event;
		SolverFrame frame = new SolverFrame();
		SolverCanvas canvas = new SolverCanvas();
		frame.addCanvas(canvas);
		canvas.addEventQueue(queue);
		Cube cube = new Cube();
		CrossSolver solver = new CrossSolver();
		WhiteFaceSolver solver2 = new WhiteFaceSolver();
		SecondEdgeSolver solver3 = new SecondEdgeSolver();
		OllRecognizer recog = new OllRecognizer();
		PllRecognizer pllRecog = new PllRecognizer();
		solver.setCube(cube);
		solver2.setCube(cube);
		solver3.setCube(cube);
		while(true) {
			
			if(queue.isEventToProcess()) {
				event = queue.getEvent();
				if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'r') {
					cube.excecuteMove(Cube.RIGHT_FACE_C, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'R') {
					cube.excecuteMove(Cube.RIGHT_FACE_CC, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'u') {
					cube.excecuteMove(Cube.TOP_FACE_C, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'U') {
					cube.excecuteMove(Cube.TOP_FACE_CC, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'F') {
					cube.excecuteMove(Cube.FRONT_FACE_CC, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'f') {
					cube.excecuteMove(Cube.FRONT_FACE_C, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'L') {
					cube.excecuteMove(Cube.LEFT_FACE_CC, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'l') {
					cube.excecuteMove(Cube.LEFT_FACE_C, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'B') {
					cube.excecuteMove(Cube.BACK_FACE_CC, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'b') {
					cube.excecuteMove(Cube.BACK_FACE_C, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'D') {
					cube.excecuteMove(Cube.BOTTOM_FACE_CC, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'd') {
					cube.excecuteMove(Cube.BOTTOM_FACE_C, false);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'q') {
					solver.test();
				}  else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'q') {
					solver2.test();
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'z') {
					solver3.test();
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'o') {
					Algorithm alg = new Algorithm(" ");
					int i = recog.findCase(cube.getCube(), alg);
					for(int i2 = 0; i2 < i; i2 ++) {
						cube.excecuteMove(Cube.TOP_FACE_C, true);
					}
					cube.excecuteAlg(alg, true);
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'C') {
					System.out.println("HII");
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
					
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'E') {
					cube.setCube(Map.applyMap(cube.getCube(), Map.equatorSliceCounterClockwiseMap));
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'p') {
					System.out.println("HII");
					pllRecog.excecutePLL(cube);
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'P') {
					String str = "";
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					try {
						str = reader.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					Algorithm alg = new Algorithm(str);
					alg.reverseAlgorithm();
					cube.excecuteAlg(alg, false);
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'j') {
					Algorithm solution = cube.getSolutionAlg();
					ArrayList<Move> moves = solution.getMovesList();
					for(Move move: moves) {
						cube.excecuteMove(move.get(), false);
						canvas.draw();
						try {
							Thread.sleep(150);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'S') {
					System.out.print("Enter Scramble:");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String moves = "";
					try {
						moves = br.readLine();
					} catch (IOException e) {
						System.err.println("ERROR");
					}
					Algorithm alg = new Algorithm(moves);
					cube.excecuteAlg(alg, false);
				}
			}
			canvas.updateCubeData(cube.getCube());
			canvas.draw();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
