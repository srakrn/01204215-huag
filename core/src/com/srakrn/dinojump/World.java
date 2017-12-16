package com.srakrn.dinojump;

public class World {
	public static final int DEFAULT_Y = 50;
	Dinosaur dinosaur;
	// private DinoJumpGame dinoJumpGame;
	
	World(DinoJumpGame dinoJumpGame) {
		// this.dinoJumpGame = dinoJumpGame;
		dinosaur = new Dinosaur(Dinosaur.DEFAULT_X, World.DEFAULT_Y);
	}
	
	public void update(float delta) {
		dinosaur.update(delta);
		Cactus.update(delta);
	}
}
