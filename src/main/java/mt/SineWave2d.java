// Erik Goesche ge76imih
package mt;

public class SineWave2d extends Image {
    public SineWave2d(Vector2d k, int width, int height, String name) {
        super(width, height, name);
        this.minIndexX = - width / 2;
        this.minIndexY = - height / 2;
        for(int h = - height / 2; h < height / 2; h++) {
            for(int w = - width / 2; w < width / 2; w++) {
                // add * 1.0 to formula, so it becomes a float division
                float value = (float) Math.sin(((w * 1.0 / width) * k.kx + (h * 1.0 / height) * k.ky) * 2 * Math.PI);
                this.setAtIndex(w, h, value);
            }
        }
    }
}
