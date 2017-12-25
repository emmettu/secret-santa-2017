package com.emmett.tea;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Tea extends ApplicationAdapter {
	Texture img;
	Image image;
	Image pour;
	Stage stage;

	@Override
	public void create () {
		stage = new Stage();
		img = new Texture("milk.png");
		Texture pourTexture = new Texture("milkpour.png");

		Image background = new Image(new Texture("background.png"));

		Texture mugTex = new Texture("mug.png");
		final Image mug = new Image(mugTex);

		Texture teaTex = new Texture("teamug.png");
		final Image teaMug = new Image(teaTex);

		teaMug.setPosition(250, 60);
		mug.setPosition(250, 60);

		teaMug.setVisible(false);

		pour = new Image(pourTexture);
		image = new Image(img);
		pour.setPosition(270, 150);
		pour.setVisible(false);
		stage.addActor(background);
		stage.addActor(image);
		stage.addActor(pour);
		stage.addActor(mug);
		stage.addActor(teaMug);
		image.addListener(
				new InputListener() {
					@Override
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						image.setVisible(false);
						pour.setVisible(true);
						return true;
					}

					@Override
					public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
						image.setVisible(true);
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
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
		// Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// batch.begin();
		// batch.draw(img, 0, 0);
		// batch.end();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}
}
