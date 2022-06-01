package mt;

public class SineWave2d extends Image {
    public SineWave2d(Vector2d k, int width, int height, String name) {
        super(width, height, name);
        for(int h = - height / 2; h <= height / 2; h++) {
            for(int w = - width / 2; w <= width / 2; w++) {
                float value = (float) Math.sin(((w / width) * k.kx + (h / height) * k.ky) * 2 * Math.PI);
                this.setAtIndex(w, h, value);
            }
        }
    }
}
