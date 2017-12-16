package com.srakrn.dinojump;

import java.util.ArrayList;

public class Bird {
	private static ArrayList<Float> birdsTime = new ArrayList<Float>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add((float) 20); 
	}};
	private static ArrayList<Float> birdsDelta = new ArrayList<Float>();
	private static ArrayList<Integer> birdsPosition = new ArrayList<Integer>();
	public static float speed = 600;
	public static float time = 0;
	
	public static void spawn() {
		birdsTime.add((float) (Math.random()*(5)+5 + birdsTime.get(birdsTime.size()-1)));
	}
	public static void spawnWithCustomTime(float time) {
		birdsTime.add(time);
	}
	public static void update(float delta) {
		time += delta;
		while(birdsTime.size() < 5) {
			Bird.spawn();
		}
		birdsDelta.clear();
		for(int i=0; i<birdsTime.size(); i++) {
			birdsDelta.add(birdsTime.get(i)-Cactus.time);
		}
		birdsPosition.clear();
		for(int i=0; i<birdsTime.size(); i++) {
			birdsPosition.add(Math.round((birdsTime.get(i)-Cactus.time)*speed)+50);
		}
		for(int i=0; i<birdsTime.size(); i++) {
			if(birdsDelta.get(i) < -1) {
				birdsTime.remove(i);
				birdsDelta.remove(i);
				birdsPosition.remove(i);
			}
		}
		speed += 0.2;
	}
	public static ArrayList<Float> getBirdsTime() {
		return birdsTime;
	}
	public static ArrayList<Integer> getBirdsPosition() {
		return birdsPosition;
	}
}
