package com.srakrn.dinojump;

public class World {
	static Dinosaur dinosaur;
	private DinoJumpGame dinoJumpGame;
	
	World(DinoJumpGame dinoJumpGame) {
		this.dinoJumpGame = dinoJumpGame;
		dinosaur = new Dinosaur(Dinosaur.DEFAULT_X, 50);
	}
	
	public static void update(float delta) {
		dinosaur.update(delta);
	}
}
