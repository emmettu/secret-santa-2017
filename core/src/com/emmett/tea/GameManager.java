package com.emmett.tea;

import java.util.Stack;

public class GameManager {

	private Stack<GameState> stack = new Stack<GameState>();

	public void pushState(GameState state) {
		stack.push(state);
		state.init();
	}

	public GameState popState() {
		return stack.pop();
	}

	public void run() {
		if (stack.peek().isOver()) {
			stack.pop().remove();
			stack.peek().init();
		}
		stack.peek().run();
	}

	public void cleanup() {
		while (!stack.empty()) {
			stack.pop().remove();
		}
	}

}
