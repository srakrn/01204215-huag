package com.srakrn.dinojump;

public class World {
	public static final int DEFAULT_Y = 69;
	public static boolean dead = false;
	Dinosaur dinosaur;
	// private DinoJumpGame dinoJumpGame;
	
	World(DinoJumpGame dinoJumpGame) {
		// this.dinoJumpGame = dinoJumpGame;
		dinosaur = new Dinosaur(Dinosaur.DEFAULT_X, World.DEFAULT_Y);
        SoundEffect.playStartSound();
	}
	
	public void update(float delta) {
		if(dinosaur.isAlive()) {
			dinosaur.update(delta);
			Cactus.update(delta);
			Bird.update(delta);
			Cloud.update(delta);
		}
	}
}
