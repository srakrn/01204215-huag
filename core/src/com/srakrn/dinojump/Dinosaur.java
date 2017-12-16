package com.srakrn.dinojump;


public class Dinosaur {
	private int x, y, init_y;
	public static float GRAVITY = -3000;
	public static float INITIAL_SPEED = 900;
	public static int DEFAULT_X = 100;

	private boolean jumping = false;
	
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
    public boolean isJumping() {
    	return jumping;
    }
    public void jump() {
    	this.jumping = true;
    }
    public void update(float delta) {
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
    	else {
    	}
    }
}
