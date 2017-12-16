package com.srakrn.dinojump;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	DinoJumpGame dinoJumpGame;
	Dinosaur dinosaur;
	World world;
	WorldRenderer worldRenderer;
	Buttons buttons;
	
	public GameScreen(DinoJumpGame dinoJumpGame) {
		this.dinoJumpGame = dinoJumpGame;
		this.world = new World(dinoJumpGame);
		this.worldRenderer = new WorldRenderer(dinoJumpGame, world);
		this.buttons = new Buttons(dinoJumpGame, world);
		world.dinosaur.jump();
	}

    @Override
    public void render(float delta) {
    	world.update(delta);
    	worldRenderer.render();
    	buttons.update(delta);
    }
}