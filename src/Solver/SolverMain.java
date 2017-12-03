package Solver;

import Lib.Algorithm;
import Lib.Cube;
import Lib.Map;

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
					cube.excecuteMove(Cube.RIGHT_FACE_C);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'R') {
					cube.excecuteMove(Cube.RIGHT_FACE_CC);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'u') {
					cube.excecuteMove(Cube.TOP_FACE_C);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'U') {
					cube.excecuteMove(Cube.TOP_FACE_CC);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'F') {
					cube.excecuteMove(Cube.FRONT_FACE_CC);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'f') {
					cube.excecuteMove(Cube.FRONT_FACE_C);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'L') {
					cube.excecuteMove(Cube.LEFT_FACE_CC);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'l') {
					cube.excecuteMove(Cube.LEFT_FACE_C);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'B') {
					cube.excecuteMove(Cube.BACK_FACE_CC);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'b') {
					cube.excecuteMove(Cube.BACK_FACE_C);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'D') {
					cube.excecuteMove(Cube.BOTTOM_FACE_CC);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'd') {
					cube.excecuteMove(Cube.BOTTOM_FACE_C);
					canvas.updateCubeData(cube.getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'c') {
					solver.test();
				}  else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'C') {
					solver2.test();
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'z') {
					solver3.test();
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'o') {
					Algorithm alg = new Algorithm(" ");
					int i = recog.findCase(cube.getCube(), alg);
					for(int i2 = 0; i2 < i; i2 ++) {
						cube.excecuteMove(Cube.TOP_FACE_C);
					}
					cube.excecuteAlg(alg);
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'S') {
					solver.test();
					solver2.test();
					solver3.test();
					Algorithm alg = new Algorithm(" ");
					int i = recog.findCase(cube.getCube(), alg);
					for(int i2 = 0; i2 < i; i2 ++) {
						cube.excecuteMove(Cube.TOP_FACE_C);
					}
					cube.setCube(pllRecog.findCase(cube).getCube());
					
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'E') {
					cube.setCube(Map.applyMap(cube.getCube(), Map.equatorSliceCounterClockwiseMap));
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'p') {
					cube.setCube(pllRecog.findCase(cube).getCube());
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
