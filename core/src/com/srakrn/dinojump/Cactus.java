package com.srakrn.dinojump;

import java.util.ArrayList;

public class Cactus {
	public static ArrayList<Float> cacti = new ArrayList<Float>();
	public final int SPEED = 30;
	private static float time = 0;
	
	public static void spawn() {
		cacti.add((float) (Math.random()*1.5+0.5 + cacti.get(cacti.size()-1)));
	}
	public static void spawnWithCustomTime(float time) {
		cacti.add(time);
	}
	public static void update(float delta) {
		time += delta;
		cacti.add((float) 0);
		while(cacti.size() < 20) {
			Cactus.spawn();
		}
		for(int i=0; i<cacti.size(); i++) {
			if(cacti.get(i) < time) {
				cacti.remove(i);
				Cactus.spawn();
			}
		}
	}
	public static ArrayList<Float> getCactiTime(){
		return cacti;
	}
}
