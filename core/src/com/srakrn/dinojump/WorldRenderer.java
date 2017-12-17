package com.srakrn.dinojump;

import java.util.ArrayList;

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
	Cactus cactus;
	Texture cactusSprite;
	Bird bird;
	Texture birdSprite;
	Texture cloudSprite;
	Texture floorTileTexture;
	Texture gameOverOverlay;

	WorldRenderer(DinoJumpGame dinoJumpGame, World world){
		this.dinoJumpGame = dinoJumpGame;
		this.world = world;
		this.dinosaur = world.dinosaur;
		this.dinosaurSprite = new Texture("p1_stand.png");
		this.cactusSprite = new Texture("cactus.png");
		this.birdSprite = new Texture("bat.png");
		this.cloudSprite = new Texture("cloud1.png");
		this.floorTileTexture = new Texture("floor_tile.png");
		this.gameOverOverlay = new Texture("gameover.png");
	}
	
	public void updateDinosaurSprite(Dinosaur dinosaur) {
		if(!dinosaur.isAlive()) {
			this.dinosaurSprite = new Texture("p1_hurt.png");
		}
		else if(dinosaur.isJumping()) {
			this.dinosaurSprite = new Texture("p1_jump.png");
		}
		else if(dinosaur.isDucking()) {
			this.dinosaurSprite = new Texture("p1_duck.png");
		}
		else {
			this.dinosaurSprite = new Texture("p1_stand.png");
		}
	}
	
	public void render() {
		SpriteBatch batch = DinoJumpGame.batch;
		batch.begin();
		// Clears screen
		Gdx.gl.glClearColor((float)0.875,(float) 0.9648,(float) 0.9804,(float) 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Clouds
		ArrayList<Integer> cloudsPosition = Cloud.getCactiPosition();
		for(int i=0; i<cloudsPosition.size(); i++) {
			batch.draw(cloudSprite, cloudsPosition.get(i), World.DEFAULT_Y*2);
		}
		
		// Draws background
		batch.draw(floorTileTexture, 0, 0);
		
		// Gets the position after movement calculation
		int x = world.dinosaur.getX();
		int y = world.dinosaur.getY();
		// Updates dinosaur sprite
		updateDinosaurSprite(world.dinosaur);
		// and draw
		batch.draw(this.dinosaurSprite, x, y);
		
		// Cactus
		ArrayList<Integer> cactiPosition = Cactus.getCactiPosition();
		for(int i=0; i<cactiPosition.size(); i++) {
			batch.draw(cactusSprite, cactiPosition.get(i), World.DEFAULT_Y);
		}

		// Birds
		ArrayList<Integer> birdsPosition = Bird.getBirdsPosition();
		for(int i=0; i<birdsPosition.size(); i++) {
			batch.draw(birdSprite, birdsPosition.get(i), World.DEFAULT_Y+80);
		}

		if(!dinosaur.isAlive()) {
			batch.draw(gameOverOverlay, 0, 0);
		}
		batch.end();
	}
}