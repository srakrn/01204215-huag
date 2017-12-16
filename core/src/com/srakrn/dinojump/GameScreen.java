package com.srakrn.dinojump;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	DinoJumpGame dinoJumpGame;
	Dinosaur dinosaur;
	World world;
	WorldRenderer worldRenderer;
	
	public GameScreen(DinoJumpGame dinoJumpGame) {
		this.dinoJumpGame = dinoJumpGame;
		this.world = new World(dinoJumpGame);
		this.worldRenderer = new WorldRenderer(dinoJumpGame, world);
		World.dinosaur.jump();
	}

    @Override
    public void render(float delta) {
    	World.update(delta);
    	WorldRenderer.render();
    }
}