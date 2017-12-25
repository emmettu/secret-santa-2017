package com.emmett.tea;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Random;

public class OrderState extends BaseState {

	public OrderState(final GameManager manager) {
		super();
		stage.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				manager.pushState(new PlayState(manager));
			}
		});

		TeaData desired = randomTea();

		Label.LabelStyle style = new Label.LabelStyle(new BitmapFont(), Color.BLACK);
		Label label = new Label("Try making an " + desired.getType() + "\nwith " + amountPhrase(desired.milkLevel()) + " milk", style);
		label.setFontScale(2);
		label.setPosition(150, 250);
		stage.addActor(label);

		Global.desiredTea = desired;
	}

	private TeaData randomTea() {
		Random random = new Random();
		TeaData data = new TeaData();
		data.setMilk(random.nextInt(51));
		data.setType(TeaType.values()[random.nextInt(TeaType.values().length - 1)]);
		return data;
	}

	private String amountPhrase(double milk) {
		if (milk == 0) {
			return "no";
		} else if (milk < 5) {
			return "a bit of";
		} else if (milk < 10) {
			return "a regular amount of";
		} else if (milk < 20) {
			return "an extra amount of";
		} else if (milk < 30) {
			return "a lot of";
		} else if (milk < 40) {
			return "a ton of";
		}  else if (milk < 50) {
			return "a huge amount of";
		} else {
			return "a ridiculous amount of";
		}
	}

}
