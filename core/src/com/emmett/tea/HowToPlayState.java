package com.emmett.tea;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class HowToPlayState extends BaseState {

	public HowToPlayState(final GameManager manager) {
		super();
		stage.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				manager.pushState(new PlayState(manager));
			}
		});

		Label.LabelStyle style = new Label.LabelStyle(new BitmapFont(), Color.BLACK);
		Label label = new Label("Welcome to Tea Time!\nClick items to use them, when\nyour tea is ready, click the mug.\nClick anywhere to begin!", style);
		label.setFontScale(2);
		label.setPosition(150, 270);
		stage.addActor(label);
	}

}
