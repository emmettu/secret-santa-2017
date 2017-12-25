package com.emmett.tea;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PlayState extends BaseState {

	public PlayState() {
		super();
		final Image teaMug = new Image(new Texture("teamug.png"));
		teaMug.setPosition(250, 60);
		teaMug.setVisible(false);

		final Image pour = new Image(new Texture("milkpour.png"));
		pour.setPosition(270, 150);
		pour.setVisible(false);

		stage.addActor(pour);
		stage.addActor(teaMug);

		milk.addListener(
				new InputListener() {
					@Override
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						milk.setVisible(false);
						pour.setVisible(true);
						return true;
					}

					@Override
					public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
						milk.setVisible(true);
						pour.setVisible(false);
					}
				}
		);

		mug.addListener(
				new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						mug.setVisible(false);
						teaMug.setVisible(true);
					}
				}
		);
	}

}
