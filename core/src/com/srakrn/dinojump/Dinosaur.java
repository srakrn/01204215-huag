package com.srakrn.dinojump;

import com.badlogic.gdx.graphics.Texture;

public class Dinosaur {
	private int x, y, init_y;
	private float v_y;
	public static float GRAVITY = -2000;
	public static float INITIAL_SPEED = 600;
	public static int DEFAULT_X = 100;

	private boolean jumping = false;
	
	private float delta = 0;
	private float time_counter = 0;
	
	// Instead of using `Vector2`, we decided to
	// use plain integer instead, as x is a 
	// totally constant value.
    public Dinosaur(int x, int y) {
        this.x = x;
        this.y = y;
        this.init_y = y;
    }    
 
    public int getX() {
        return x;    
    }
    public int getY() {
        return y;    
    }
    public void updateDelta(float delta) {
    	this.delta = delta;
    }
    public void jump() {
    	this.jumping = true;
    	this.v_y = INITIAL_SPEED;
    }
    public void jumpMovement() {
    	if(this.jumping) {
    		// This is bad.
    		GameScreen.dinosaurSprite = new Texture("p1_jump.png");
			if(time_counter <= .6) {
				this.y = init_y + (int) ((INITIAL_SPEED*time_counter)+0.5*GRAVITY*Math.pow(time_counter, 2));
				this.v_y = INITIAL_SPEED + GRAVITY*time_counter;
			}
			else {
				time_counter = 0;
				this.jumping = false;
				this.y = this.init_y;
			}
			time_counter += delta;
    	}
    	else {
    		GameScreen.dinosaurSprite = new Texture("p1_stand.png");
    	}
    }
}
