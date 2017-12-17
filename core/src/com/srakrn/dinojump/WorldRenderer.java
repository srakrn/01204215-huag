package com.srakrn.dinojump;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

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
	BitmapFont kanitFont;

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
		this.kanitFont = new BitmapFont(Gdx.files.internal("kanit_regular_32pt.fnt"));
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
		ArrayList<Vector2> cloudsPosition = Cloud.getCloudsPosition();
		for(int i=0; i<cloudsPosition.size(); i++) {
			batch.draw(cloudSprite, (int)cloudsPosition.get(i).x, (int)cloudsPosition.get(i).y);
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
		for(int i=0; i<Cactus.getCactiPosition().size(); i++) {
			batch.draw(cactusSprite, Cactus.getCactusPosition(i), World.DEFAULT_Y);
		}

		// Birds
		for(int i=0; i<Bird.getBirdsPosition().size();  i++) {
			batch.draw(birdSprite, Bird.getBirdPosition(i), World.DEFAULT_Y+80);
		}
		
		if(dinosaur.isAlive()) {
			kanitFont.draw(batch, "" + Math.round(Cactus.time*5), 10, 30);
		}
		else {
			batch.draw(gameOverOverlay, 0, 0);
			kanitFont.draw(batch, "Your score is " + Math.round(Cactus.time*5), 600, 100);
		}
		batch.end();
	}
}