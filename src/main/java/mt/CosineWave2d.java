package mt;

public class CosineWave2d extends Image {
    public CosineWave2d(Vector2d k, int width, int height, String name) {
        super(width, height, name);
        for(int h = - height / 2; h <= height / 2; h++) {
            for(int w = - width / 2; w <= width / 2; w++) {
                float value = (float) Math.cos(((w / width) * k.kx + (h / height) * k.ky) * 2 * Math.PI);
                this.setAtIndex(w, h, value);
            }
        }
    }
}