package com.emmett.tea;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TitleState extends BaseState {

	public TitleState() {
		super();
		Image title = new Image(new Texture("title.png"));
		title.setPosition(500, 150);
		stage.addActor(title);
	}

}
