package com.emmett.tea;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Random;

public class PlayState extends BaseState {

	private TeaData tea;

	public PlayState(final GameManager manager) {
		super();
		tea = new TeaData();

		final Image teaMug = new Image(new Texture("teamug.png"));
		teaMug.setPosition(250, 60);
		teaMug.setVisible(false);
		final Image pour = new Image(new Texture("milkpour.png"));
		pour.setPosition(270, 150);
		pour.setVisible(false);

		final Image sugarPour = new Image(new Texture("sugarpour.png"));
		sugarPour.setPosition(270, 195);
		sugarPour.setVisible(false);

		stage.addActor(pour);
		stage.addActor(sugarPour);
		stage.addActor(teaMug);

		milk.addListener(
				new InputListener() {
					@Override
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						milk.setVisible(false);
						pour.setVisible(true);
						tea.receivingMilk();
						return true;
					}

					@Override
					public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
						milk.setVisible(true);
						pour.setVisible(false);
						tea.notReceivingMilk();
					}
				}
		);

		sugar.addListener(
				new InputListener() {
					@Override
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						sugar.setVisible(false);
						sugarPour.setVisible(true);
						tea.receivingSugar();
						return true;
					}

					@Override
					public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
						sugar.setVisible(true);
						sugarPour.setVisible(false);
						tea.notReceivingSugar();
					}
				}
		);

		earlGrey.addListener(
				new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						mug.setVisible(false);
						teaMug.setVisible(true);
						tea.setType(TeaType.EARL_GREY);
					}
				}
		);

		irish.addListener(
				new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						mug.setVisible(false);
						teaMug.setVisible(true);
						tea.setType(TeaType.IRISH_BREAKFAST);
					}
				}
		);

		englishBreakfast.addListener(
				new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						mug.setVisible(false);
						teaMug.setVisible(true);
						tea.setType(TeaType.ENGLISH_BREAKFAST);
					}
				}
		);

		teaMug.addListener(
				new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						manager.pushState(new ScoreState(manager));
					}
				}
		);

		TeaData desired = randomTea();

		Label.LabelStyle style = new Label.LabelStyle(new BitmapFont(), Color.BLACK);
		final Label label = new Label("Try making an "
				+ desired.getType()
				+ "\nwith "
				+ amountPhrase(desired.milkLevel())
				+ " milk and a\n"
				+ amountPhrase(desired.sugarLevel())
				+ " sugar", style);
		label.setFontScale(2);
		label.setPosition(150, 270);
		stage.addActor(label);

		Global.desiredTea = desired;
		Global.actualTea = tea;

		stage.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event,float x, float y, int pointer, int button){
				label.setVisible(false);
				return true;
			}
		});

	}

	@Override
	public void run() {
		super.run();
		if (tea.isReceivingMilk()) {
			tea.addMilk(Gdx.graphics.getDeltaTime() * 10);
		}
		if (tea.isReceivingSugar()) {
			tea.addSugar(Gdx.graphics.getDeltaTime() * 5);
		}
	}

	private TeaData randomTea() {
		Random random = new Random();
		TeaData data = new TeaData();
		data.setMilk(random.nextInt(51));
		data.setSugar(random.nextInt(51));
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
