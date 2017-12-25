package com.emmett.tea;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class TitleState extends BaseState {

	public TitleState() {
		super();
		Image title = new Image(new Texture("title.png"));
		title.setPosition(150, 200);
		stage.addActor(title);
		stage.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				over = true;
			}
		});
	}

}
