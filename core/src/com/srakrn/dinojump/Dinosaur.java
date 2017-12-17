package com.srakrn.dinojump;


public class Dinosaur {
	private int x, y, init_y;
	private boolean alive;
	public static float GRAVITY = -2000;
	public static float INITIAL_SPEED = 600;
	public static int DEFAULT_X = 100;

	private boolean jumping;
	private boolean ducking;
	
	private float time_counter = 0;
	
	// Instead of using `Vector2`, we decided to
	// use plain integer instead, as x is a 
	// totally constant value.
    public Dinosaur(int x, int y) {
        this.x = x;
        this.y = y;
        this.init_y = y;
        this.alive = true;
        this.jumping = false;
        this.ducking = false;
    }    
 
    public int getX() {
        return x;    
    }
    public int getY() {
        return y;    
    }
    public boolean isJumping() {
    	return jumping;
    }
    public void jump() {
    	if(!this.jumping) {
			SoundEffect.playJumpSound();
    	}
    	this.jumping = true;
    }
    public boolean isDucking() {
    	return this.ducking;
    }
    public void duck() {
    	this.ducking = true;
    }
    public void unDuck() {
    	this.ducking = false;
    }
    public boolean isAlive() {
    	return this.alive;
    }

    public void update(float delta) {
    	if(this.alive) {
			for(int i=0; i < Bird.getBirdsPosition().size(); i++) {
				if(Math.abs(Dinosaur.DEFAULT_X - Bird.getBirdsPosition().get(i)) < 50 && !this.isDucking()) {
					this.alive = false;
				}
			}
			for(int i=0; i < Cactus.getCactiPosition().size(); i++) {
				if(Math.abs(Cactus.getCactiPosition().get(i) - Dinosaur.DEFAULT_X) < 50 && !this.isJumping()) {
					this.alive = false;
				}
			}
			
			if(this.jumping) {
				if(time_counter <= .6) {
					this.y = init_y + (int) ((INITIAL_SPEED*time_counter)+0.5*GRAVITY*Math.pow(time_counter, 2));
				}
				else {
					time_counter = 0;
					this.jumping = false;
					this.y = this.init_y;
				}
				time_counter += delta;
			}
    	}
    }
}
