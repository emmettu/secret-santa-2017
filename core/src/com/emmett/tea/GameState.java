package com.emmett.tea;

public interface GameState {

	void run();

	void remove();

	boolean isOver();

	void init();

}
