package com.srakrn.dinojump;

public class Preferences {
	public static final int INITIAL_CACTUS_VELOCITY = 500;
	public static final float CACTUS_ACCELERATION = (float) 0.1;
	public static final int TIME_BEFORE_FIRST_CACTUS = 3;
	public static final float CACTUS_MIN_TIME = (float) 0.5;
	public static final float CACTUS_MAX_TIME = 2;

	public static final int INITIAL_BIRD_VELOCITY = 600;
	public static final float BIRD_ACCELERATION = (float) 0.15;
	public static final int TIME_BEFORE_FIRST_BIRD = 20;
	public static final float BIRD_MIN_TIME = 10;
	public static final float BIRD_MAX_TIME = 15;
	
	// Do not edit lines below.
	public static final float CACTUS_TIME_GAP = CACTUS_MAX_TIME-CACTUS_MIN_TIME;
	public static final float BIRD_TIME_GAP = BIRD_MAX_TIME-BIRD_MIN_TIME;
}
