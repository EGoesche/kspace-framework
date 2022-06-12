// Erik Goesche ge76imih
package mt;

public class SharpeningFilter2d extends LinearImageFilter {

    public SharpeningFilter2d(float focus) {
        super(3, 3, "Sharpening Filter");
        for (int x = minIndexX; x <= maxIndexX(); x++) {
            for (int y = minIndexY; y <= maxIndexY(); y++) {
                if (x == 0 && y == 0) {
                    setAtIndex(x, y, focus);
                    continue;
                }
                setAtIndex(x, y, - (focus - 1.0f) / 8);
            }
        }
    }
}