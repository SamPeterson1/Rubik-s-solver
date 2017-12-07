package Solver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


import Lib.Algorithm;
import Lib.Cube;
import Lib.Map;
import Lib.Move;
import Lib.ScrambleGenerator;

public class SolverMain {
	
	
	public static void main(String args[]) {
		SolverEventQueue queue = new SolverEventQueue();
		SolverEvent event = null;
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
		SolverHandler handler = new SolverHandler();
		solver.setCube(cube);
		solver2.setCube(cube);
		solver3.setCube(cube);
		handler.setUtils(cube, solver, solver2, solver3, recog, pllRecog, canvas);
		while(true) {
			canvas.updateCubeData(cube.getCube());
			if(queue.isEventToProcess()) {
				event = queue.getEvent();
				if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'Q') {
					handler.demonstrate();
				} else if(event.getType() == SolverEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseLeftButton()) {
					int x = event.getMouseX();
					int y = event.getMouseY();
					if(inBounds(x,y, 500, 0, 300, 300)) {
						cube.excecuteMove(Cube.TOP_FACE_C, false);
					}
					if(inBounds(x,y, 800, 300, 300, 300)) {
						cube.excecuteMove(Cube.RIGHT_FACE_C, false);
					}
					if(inBounds(x,y, 500, 300, 300, 300)) {
						cube.excecuteMove(Cube.FRONT_FACE_C, false);
					}
					if(inBounds(x,y, 200, 300, 300, 300)) {
						cube.excecuteMove(Cube.LEFT_FACE_C, false);
					}
					if(inBounds(x,y, 1100, 300, 300, 300)) {
						cube.excecuteMove(Cube.BACK_FACE_C, false);
					}
					if(inBounds(x,y, 500, 600, 300, 300)) {
						cube.excecuteMove(Cube.BOTTOM_FACE_C, false);
					}
				} else if(event.getType() == SolverEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseRightButton()) {
					int x = event.getMouseX();
					int y = event.getMouseY();
					if(inBounds(x,y, 500, 0, 300, 300)) {
						cube.excecuteMove(Cube.TOP_FACE_CC, false);
					}
					if(inBounds(x,y, 800, 300, 300, 300)) {
						cube.excecuteMove(Cube.RIGHT_FACE_CC, false);
					}
					if(inBounds(x,y, 500, 300, 300, 300)) {
						cube.excecuteMove(Cube.FRONT_FACE_CC, false);
					}
					if(inBounds(x,y, 200, 300, 300, 300)) {
						cube.excecuteMove(Cube.LEFT_FACE_CC, false);
					}
					if(inBounds(x,y, 1100, 300, 300, 300)) {
						cube.excecuteMove(Cube.BACK_FACE_CC, false);
					}
					if(inBounds(x,y, 500, 600, 300, 300)) {
						cube.excecuteMove(Cube.BOTTOM_FACE_CC, false);
					}
				} else if(event.getType() == SolverEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseMiddleButton()) {
					int x = event.getMouseX();
					int y = event.getMouseY();
					if(inBounds(x,y, 500, 0, 300, 300)) {
						cube.excecuteMove(Cube.TOP_FACE_TWICE, false);
					}
					if(inBounds(x,y, 800, 300, 300, 300)) {
						cube.excecuteMove(Cube.RIGHT_FACE_TWICE, false);
					}
					if(inBounds(x,y, 500, 300, 300, 300)) {
						cube.excecuteMove(Cube.FRONT_FACE_TWICE, false);
					}
					if(inBounds(x,y, 200, 300, 300, 300)) {
						cube.excecuteMove(Cube.LEFT_FACE_TWICE, false);
					}
					if(inBounds(x,y, 1100, 300, 300, 300)) {
						cube.excecuteMove(Cube.BACK_FACE_TWICE, false);
					}
					if(inBounds(x,y, 500, 600, 300, 300)) {
						cube.excecuteMove(Cube.BOTTOM_FACE_TWICE, false);
					}
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'R') {
					cube.setCube(new Cube().getCube());
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 's') {
					handler.scramble();
				} else if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'S') {
					handler.solve();
				}
			}
			canvas.draw();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean inBounds(int x1, int y1, int x2, int y2, int width, int height) {
		if(x1 >= x2 & x1 <= x2 + width & y1 >= y2 & y1 <= y2 + height) {
			return true;
		}
		return false;
	}
}
