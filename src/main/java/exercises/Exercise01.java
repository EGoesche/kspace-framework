// Erik Goesche ge76imih
// Mohammed Sabiya Sujith Ahamed cu01zaze
/*
 * Exercise01.java
 * Copyright (C) 2020 Stephan Seitz <stephan.seitz@fau.de>
 *
 * Distributed under terms of the GPLv3 license.
 */
package exercises;


public class Exercise01 {
	public static void main(String[] args) {
		(new ij.ImageJ()).exitWhenQuitting(true);

		// float f[] = {10.10f,30.3f,40.60f,77.50f};

		// var signal = new mt.Signal(f, "Signal");
		// var cos = new mt.CosineWave(100, 1);
		// var sin = new mt.SineWave(100, 3);

		// signal.show();
		// cos.show();
		// sin.show();

		var sigsaw = new mt.SineWave(100, 1).times(1.0f/2.0f)
				.plus(new mt.SineWave(100, 3)).times(2.0f/3.0f)
				.plus(new mt.SineWave(100, 5)).times(2.0f/5.0f)
				.plus(new mt.SineWave(100, 7)).times(2.0f/7.0f)
				;
		sigsaw.show();

		/*
		var numWaves = 3;
		//TODO try to understand the code and play around with it! 

		var coolWave = new mt.SineWave(1 * numWaves, 1024)
			.plus(new mt.SineWave(2 * numWaves, 1024).times(-1.0f/2.0f))
			.plus(new mt.SineWave(3 * numWaves, 1024).times(+1.0f/3.0f))
			.plus(new mt.SineWave(4 * numWaves, 1024).times(-1.0f/4.0f))
			.plus(new mt.SineWave(5 * numWaves, 1024).times(+1.0f/5.0f))
			.plus(new mt.SineWave(6 * numWaves, 1024).times(-1.0f/6.0f))
			.plus(new mt.SineWave(7 * numWaves, 1024).times(+1.0f/7.0f))
			.plus(new mt.SineWave(8 * numWaves, 1024).times(-1.0f/8.0f))
			.plus(new mt.SineWave(9 * numWaves, 1024).times(+1.0f/9.0f))
			;

		coolWave.show();

		 */

	}
}
