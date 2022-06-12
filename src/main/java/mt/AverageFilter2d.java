// Erik Goesche ge76imih
package mt;

public class AverageFilter2d extends LinearImageFilter {

    public AverageFilter2d(int filterSize) {
        super(filterSize / 2, filterSize / 2, "Average Filter");
        for (int x = minIndexX; x <= maxIndexX(); x++) {
            for (int y = minIndexY; y <= maxIndexY(); y++) {
                this.setAtIndex(x, y, 1.0f / (filterSize * filterSize));
            }
        }
    }
}