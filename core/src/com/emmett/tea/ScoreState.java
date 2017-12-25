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
		Label label = new Label(getMessage(score), style);
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

		double rawM = (Math.max(actual.milkLevel(), desired.milkLevel()) + 1) / (Math.min(actual.milkLevel(), desired.milkLevel()) + 1);
		double rawS = (Math.max(actual.sugarLevel(), desired.sugarLevel()) + 1) / (Math.min(actual.sugarLevel(), desired.sugarLevel()) + 1);

		return (int) (Math.ceil(100 / (rawM + rawS)) * 2);
	}

	private String getMessage(int score) {
		TeaData actual = Global.actualTea;
		TeaData desired = Global.desiredTea;
		if (actual.getType() != desired.getType()) {
			return "You used the wrong tea!";
		} else if (score >= 200) {
			return "Perfect score!\nThanks for playing,\nMerry Christmas!";
		}
		return getAmountMessage(score);
	}

	private String getAmountMessage(int score) {
		TeaData actual = Global.actualTea;
		TeaData desired = Global.desiredTea;

		String sugar = actual.sugarLevel() > desired.sugarLevel() ? "too much sugar" : "too little sugar";
		String milk = actual.milkLevel() > desired.milkLevel() ? "too much milk" : "too little milk";

		return String.format("You scored %s\nYou had %s\nand %s", score, sugar, milk);
	}

}
