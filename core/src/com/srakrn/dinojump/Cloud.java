package com.srakrn.dinojump;

import java.util.ArrayList;

public class Cloud {
	private static ArrayList<Float> cloudsTime = new ArrayList<Float>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add((float) 0); 
	}};
	public static float speed = Preferences.INITIAL_CACTUS_VELOCITY;
	public static float time = 0;
	
	public static void spawn() {
		cactiTime.add((float) (Math.random()*(Preferences.CACTUS_TIME_GAP)+(Preferences.CACTUS_MIN_TIME) + cactiTime.get(cactiTime.size()-1)));
	}
	public static void spawnWithCustomTime(float time) {
		cactiTime.add(time);
	}
	public static void update(float delta) {
		time += delta;
		while(cactiTime.size() < 5) {
			Cactus.spawn();
		}
		cactiDelta.clear();
		for(int i=0; i<cactiTime.size(); i++) {
			cactiDelta.add(cactiTime.get(i)-Cactus.time);
		}
		cactiPosition.clear();
		for(int i=0; i<cactiTime.size(); i++) {
			cactiPosition.add(Math.round((cactiTime.get(i)-Cactus.time)*speed)+50);
		}
		for(int i=0; i<cactiTime.size(); i++) {
			if(cactiDelta.get(i) < -1) {
				cactiTime.remove(i);
				cactiDelta.remove(i);
				cactiPosition.remove(i);
			}
		}
		speed += Preferences.CACTUS_ACCELERATION;
	}
	public static ArrayList<Float> getCactiTime() {
		return cactiTime;
	}
	public static ArrayList<Integer> getCactiPosition() {
		return cactiPosition;
	}
}
