package mt;

public class CosineWave extends Signal {

    public CosineWave(int length, int k) {
        super(length, "Cosine");
        float buffer[] = new float[length];
        for (int i = 0; i < length; i++) {
            buffer[i] = (float) Math.cos((k / length) * 2 * Math.PI);
        }
        this.buffer = buffer;
    }
}
