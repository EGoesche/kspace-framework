// Erik Goesche ge76imih
package mt;

public class LinearImageFilter extends Image implements ImageFilter {

    public LinearImageFilter(int width, int height, String name) {
        super(width, height, name);
        minIndexX = (int) - width / 2;
        minIndexY = (int) - height / 2;
    }

    public void normalize() {
        double sum = sum();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] /= sum;
        }
    }

    public void apply(Image image, Image result) {
        for(int y = minIndexY; y < maxIndexY(); y++) {
            for(int x = minIndexX; x < maxIndexX(); x++) {
                // TODO: Implement conv
            }
        }
    }
}