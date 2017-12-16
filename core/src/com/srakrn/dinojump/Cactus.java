package com.srakrn.dinojump;

import java.util.ArrayList;

public class Cactus {
	private static ArrayList<Float> cactiTime = new ArrayList<Float>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add((float) 3); 
	}};
	private static ArrayList<Float> cactiDelta = new ArrayList<Float>();
	private static ArrayList<Integer> cactiPosition = new ArrayList<Integer>();
	public final static int SPEED = 400;
	public static float time = 0;
	
	public static void spawn() {
		cactiTime.add((float) (Math.random()*2+0.7 + cactiTime.get(cactiTime.size()-1)));
	}
	public static void spawnWithCustomTime(float time) {
		cactiTime.add(time);
	}
	public static void update(float delta) {
		time += delta;
		while(cactiTime.size() < 20) {
			Cactus.spawn();
		}
		cactiDelta.clear();
		for(int i=0; i<cactiTime.size(); i++) {
			cactiDelta.add(cactiTime.get(i)-Cactus.time);
		}
		cactiPosition.clear();
		for(int i=0; i<cactiTime.size(); i++) {
			cactiPosition.add(Math.round((cactiTime.get(i)-Cactus.time)*SPEED)+50);
		}
		for(int i=0; i<cactiTime.size(); i++) {
			if(cactiDelta.get(i) < -1) {
				cactiTime.remove(i);
				cactiDelta.remove(i);
				cactiPosition.remove(i);
			}
		}
	}
	public static ArrayList<Float> getCactiTime() {
		return cactiTime;
	}
	public static ArrayList<Integer> getCactiPosition() {
		return cactiPosition;
	}
}
