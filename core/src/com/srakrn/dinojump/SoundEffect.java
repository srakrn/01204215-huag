package com.srakrn.dinojump;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundEffect {
	public static Sound jumpSound = Gdx.audio.newSound(Gdx.files.local("dadi.mp3"));
	public static boolean isPlaying = false;

	public static void playJumpSound() {
		jumpSound.play(1.0f);
	}
}
