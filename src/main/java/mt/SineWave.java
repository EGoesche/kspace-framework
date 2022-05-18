package mt;

import java.lang.Math;

public class SineWave extends Signal {

    public SineWave(int length, int k) {
        super(length, "Sine");
        float[] buffer = new float[length];
        for (int i = 0; i < length; i++) {
            buffer[i] = (float) (Math.sin(i * k * 2 * Math.PI / length));
        }
        this.buffer = buffer;
    }
}
