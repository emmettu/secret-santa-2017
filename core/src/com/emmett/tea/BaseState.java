package com.emmett.tea;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class BaseState extends GameState {

	protected Stage stage;
	protected Image milk;
	protected Image mug;

	public BaseState() {
		stage = new Stage();
		milk = new Image(new Texture("milk.png"));
		Image background = new Image(new Texture("background.png"));

		mug = new Image(new Texture("mug.png"));

		mug.setPosition(250, 60);
		milk.setPosition(10, 100);
		stage.addActor(background);
		stage.addActor(mug);
		stage.addActor(milk);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void run() {
		stage.draw();
	}

	@Override
	public void remove() {
		stage.dispose();
	}

}
