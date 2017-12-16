package com.srakrn.dinojump;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private DinoJumpGame dinoJumpGame;
	private Dinosaur dinosaur;
	static Texture dinosaurSprite;
	
	public GameScreen(DinoJumpGame dinoJumpGame) {
		this.dinoJumpGame = dinoJumpGame;
		this.dinosaur = new Dinosaur(Dinosaur.DEFAULT_X, 50);
		dinosaurSprite = new Texture("p1_stand.png");
		dinosaur.jump();
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
        this.dinosaur.jumpMovement();
        // Gets the position after movement calculation
        int x = this.dinosaur.getX();
        int y = this.dinosaur.getY();
        // Sets the delta time passed
        this.dinosaur.updateDelta(delta);
        
        batch.draw(dinosaurSprite, x, y);
        batch.end();
    }
}
