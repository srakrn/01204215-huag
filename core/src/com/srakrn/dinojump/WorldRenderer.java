package com.srakrn.dinojump;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	static DinoJumpGame dinoJumpGame;
	static World world;
	static Dinosaur dinosaur;
	static Texture dinosaurSprite;

	WorldRenderer(DinoJumpGame dinoJumpGame, World world){
		WorldRenderer.dinoJumpGame = dinoJumpGame;
		WorldRenderer.world = world;
		WorldRenderer.dinosaur = world.dinosaur;
		WorldRenderer.dinosaurSprite = new Texture("p1_stand.png");
	}
	
	public static void render() {
        SpriteBatch batch = DinoJumpGame.batch;
        batch.begin();
        // Clears screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Gets the position after movement calculation
        int x = world.dinosaur.getX();
        int y = world.dinosaur.getY();
        
        batch.draw(WorldRenderer.dinosaurSprite, x, y);
        batch.end();
	}
}