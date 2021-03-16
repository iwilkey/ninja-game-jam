package com.mundanepixel.dinte;

import com.badlogic.gdx.ApplicationAdapter;
import com.mundanepixel.dinte.assets.Assets;
import com.mundanepixel.dinte.clock.Clock;
import com.mundanepixel.dinte.gfx.Renderer;
import com.mundanepixel.dinte.state.GameState;
import com.mundanepixel.dinte.state.State;

public class Game extends ApplicationAdapter {

	Renderer renderer;
	Clock clock;

	@Override
	public void create () {
		renderer = new Renderer();
		clock = new Clock();
		Assets.init();
		InputHandler.init();
		Settings.init();
		State.setState(new GameState());
	}

	private void tick() {
		clock.tick(State.getCurrentState());
	}

	@Override
	public void render () {
		tick();
		renderer.render(State.getCurrentState());
	}

	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);
	}
	
	@Override
	public void dispose () {
		State.getCurrentState().dispose();
		renderer.dispose();
	}

}
