package com.srakrn.dinojump;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	DinoJumpGame dinoJumpGame;
	Dinosaur dinosaur;
	World world;
	static Texture dinosaurSprite;
	
	public GameScreen(DinoJumpGame dinoJumpGame) {
		this.dinoJumpGame = dinoJumpGame;
		this.world = new World(dinoJumpGame);
		dinosaurSprite = new Texture("p1_stand.png");
		world.dinosaur.jump();
	}

    @Override
    public void render(float delta) {
        SpriteBatch batch = DinoJumpGame.batch;
        batch.begin();
        // Clears screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Draws dinosaur

        // Triggers jumping movements
        world.update(delta);
        // Gets the position after movement calculation
        int x = world.dinosaur.getX();
        int y = world.dinosaur.getY();
        
        batch.draw(dinosaurSprite, x, y);
        batch.end();
    }
}
