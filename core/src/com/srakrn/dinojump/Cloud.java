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
	private static ArrayList<Integer> cloudsPosition = new ArrayList<Integer>();

	public static float speed = 300;
	public static float time = 0;
	
	public static void spawn() {
		cloudsTime.add((float) (Math.random()*(2)+1 + cloudsTime.get(cloudsTime.size()-1)));
	}
	public static void spawnWithCustomTime(float time) {
		cloudsTime.add(time);
	}
	public static void update(float delta) {
		time += delta;
		while(cloudsTime.size() < 5) {
			Cactus.spawn();
		}
		cloudsPosition.clear();
		for(int i=0; i<cloudsTime.size(); i++) {
			cloudsPosition.add(Math.round((cloudsTime.get(i)-Cactus.time)*speed)+50);
		}
		for(int i=0; i<cloudsTime.size(); i++) {
			if(cloudsPosition.get(i) < -10) {
				cloudsTime.remove(i);
				cloudsPosition.remove(i);
			}
		}
		speed += Preferences.CACTUS_ACCELERATION;
	}
	public static ArrayList<Float> getCactiTime() {
		return cloudsTime;
	}
	public static ArrayList<Integer> getCactiPosition() {
		return cloudsPosition;
	}
}
