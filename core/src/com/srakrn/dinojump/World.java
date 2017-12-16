package com.srakrn.dinojump;

public class World {
	Dinosaur dinosaur;
	private DinoJumpGame dinoJumpGame;
	
	World(DinoJumpGame dinoJumpGame) {
		this.dinoJumpGame = dinoJumpGame;
		dinosaur = new Dinosaur(Dinosaur.DEFAULT_X, 50);
	}
	
	public void update(float delta) {
		dinosaur.update(delta);
	}
}
