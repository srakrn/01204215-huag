package com.srakrn.dinojump;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DinoJumpGame extends Game {
	public static SpriteBatch batch;
	
    public void create () {
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));
    }
    
	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
