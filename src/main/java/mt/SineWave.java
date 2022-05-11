package mt;

import java.lang.Math;

public class SineWave extends Signal {

    public SineWave(int length, int k) {
        super(length, "Sine");
        float buffer[] = new float[length];
        for (int i = 0; i < length; i++) {
            buffer[i] = (float) Math.sin((k / length) * 2 * Math.PI);
        }
        this.buffer = buffer;
    }
}
