// Erik Goesche ge76imih
package mt;

import java.lang.Math;

public class CosineWave extends Signal {

    public CosineWave(int length, int k) {
        super(length, "Cosine");
        float[] buffer = new float[length];
        for (int i = 0; i < length; i++) {
            buffer[i] = (float) Math.cos(i * k * 2 * Math.PI / length);
        }
        this.buffer = buffer;
    }
}
