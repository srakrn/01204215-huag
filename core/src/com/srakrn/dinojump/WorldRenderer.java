package com.srakrn.dinojump;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// SOMETHING'S VERY WRONG ON STATIC/NON-STATIC HERE.
public class WorldRenderer {
	DinoJumpGame dinoJumpGame;
	World world;
	Dinosaur dinosaur;
	Texture dinosaurSprite;

	WorldRenderer(DinoJumpGame dinoJumpGame, World world){
		this.dinoJumpGame = dinoJumpGame;
		this.world = world;
		this.dinosaur = world.dinosaur;
		this.dinosaurSprite = new Texture("p1_stand.png");
	}
	
	public void updateDinosaurSprite(Dinosaur dinosaur) {
		if(dinosaur.isJumping()) {
			this.dinosaurSprite = new Texture("p1_jump.png");
		}
		else if(dinosaur.isDucking()) {
			this.dinosaurSprite = new Texture("p1_stand.png");
		}
		else {
			this.dinosaurSprite = new Texture("p1_stand.png");
		}
	}
	
	public void render() {
        SpriteBatch batch = DinoJumpGame.batch;
        batch.begin();
        // Clears screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Gets the position after movement calculation
        int x = world.dinosaur.getX();
        int y = world.dinosaur.getY();
        // Updates dinosaur sprite
        updateDinosaurSprite(world.dinosaur);
        
        batch.draw(this.dinosaurSprite, x, y);
        batch.end();
	}
}