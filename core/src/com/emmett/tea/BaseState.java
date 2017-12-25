package com.emmett.tea;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class BaseState implements GameState {

	protected Stage stage;
	protected Image milk;
	protected Image mug;
	protected Image englishBreakfast;
	protected Image earlGrey;
	protected boolean over;

	public BaseState() {
		over = false;
		stage = new Stage();
		milk = new Image(new Texture("milk.png"));
		Image background = new Image(new Texture("background.png"));

		englishBreakfast = new Image(new Texture("englishbreakfast.png"));
		earlGrey = new Image(new Texture("earlgrey.png"));

		englishBreakfast.setPosition(70, 400);
		earlGrey.setPosition(295, 400);

		mug = new Image(new Texture("mug.png"));

		mug.setPosition(250, 60);
		milk.setPosition(10, 100);
		stage.addActor(background);
		stage.addActor(mug);
		stage.addActor(milk);
		stage.addActor(englishBreakfast);
		stage.addActor(earlGrey);
	}

	@Override
	public void init() {
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

	@Override
	public boolean isOver() {
		return over;
	}

}
