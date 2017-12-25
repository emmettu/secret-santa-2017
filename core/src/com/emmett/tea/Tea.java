package com.emmett.tea;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

public class Tea extends ApplicationAdapter {

	public GameManager manager;
	Music music;

	@Override
	public void create () {
		manager = new GameManager();
		manager.pushState(new PlayState(manager));
		manager.pushState(new HowToPlayState(manager));
		manager.pushState(new TitleState());

		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		manager.run();
	}
	
	@Override
	public void dispose () {
		manager.cleanup();
		music.dispose();
	}
}
