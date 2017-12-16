package com.srakrn.dinojump;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Buttons {
	// private DinoJumpGame dinoJumpGame;
	private World world;

	Buttons(DinoJumpGame dinoJumpGame, World world){
		// this.dinoJumpGame = dinoJumpGame;
		this.world = world;
	}
	
	private String dinosaurKeypress() {
		if(Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.SPACE)) {
			return "JUMP";
		}
		return null;
	}
	public void update(float delta) {
		if(dinosaurKeypress() == "JUMP") {
			this.world.dinosaur.jump();
			Cactus.spawn();
		}
	}
}
