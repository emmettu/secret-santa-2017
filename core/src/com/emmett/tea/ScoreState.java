package com.emmett.tea;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ScoreState extends BaseState {

	public ScoreState(final GameManager manager) {
		super();
		stage.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				manager.pushState(new PlayState(manager));
			}
		});

		Label.LabelStyle style = new Label.LabelStyle(new BitmapFont(), Color.BLACK);
		int score = getScore();
		Label label = new Label(String.format(getMessage(score), score), style);
		label.setFontScale(2);
		label.setPosition(150, 250);
		stage.addActor(label);
	}

	private int getScore() {
		TeaData actual = Global.actualTea;
		TeaData desired = Global.desiredTea;

		if (actual.getType() != desired.getType()) {
			return 0;
		}

		double raw = (Math.max(actual.milkLevel(), desired.milkLevel()) + 1) / (Math.min(actual.milkLevel(), desired.milkLevel()) + 1);

		return (int) Math.ceil(100 / raw);
	}

	private String getMessage(int score) {
		TeaData actual = Global.actualTea;
		TeaData desired = Global.desiredTea;
		if (actual.getType() != desired.getType()) {
			return "You used the wrong tea!";
		} else if (score >= 100) {
			return "Perfect score!\nThanks for playing,\nMerry Christmas!";
		} else if (actual.milkLevel() < desired.milkLevel()) {
			return "You scored %s!\nYou had too little milk.";
		} else if (actual.milkLevel() > desired.milkLevel()) {
			return "You scored %s!\nYou had too much milk.";
		} else {
			return "You scored %s!\nYou had the perfect amount of milk!";
		}
	}

}
