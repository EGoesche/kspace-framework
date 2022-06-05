/*
 * Excercise03.java
 * Copyright (C) 2020 Stephan Seitz <stephan.seitz@fau.de>
 *
 * Distributed under terms of the GPLv3 license.
 */
// Erik Goesche ge76imih

package exercises;

import mt.CosineWave;
import mt.CosineWave2d;
import mt.Image;
import mt.Vector2d;
//import mt.Vector2d;

public class Exercise03 {
	public static void main(String[] args) {
		(new ij.ImageJ()).exitWhenQuitting(true);

		Image image = lme.DisplayUtils.openImageFromInternet("https://mt2-erlangen.github.io/pacemaker.png", ".png");
		// image.show();
		// image.fft();

		// TODO: Create Cosine wave and compute fft
		CosineWave2d wave = new CosineWave2d(new Vector2d(1, 1), 500, 500, "wave");
		// wave.show();
		// wave.fft();

		// TODO: Generate checkboard patterns
		var checkerboard = new CosineWave2d(new Vector2d(-30, -30), 500, 500, "c1")
				.add(new CosineWave2d(new Vector2d(30, -30), 500, 500, "c2"));
		checkerboard.show();
	}
}
