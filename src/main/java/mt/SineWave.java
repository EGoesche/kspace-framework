package mt;

import java.lang.Math;

public class SineWave extends Signal {

    public SineWave(int length, String name, int k) {
        super(length, name);
        float buffer[] = new float[length];
        for (int i = 0; i < length; i++) {
            buffer[i] = (float) Math.sin((k / length) * 2 * Math.PI);
        }


    }
}
