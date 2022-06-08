// Erik Goesche ge76imih
package mt;

public class GaussFilter2d extends LinearImageFilter {

    public GaussFilter2d(int filterSize, float sigma) {
        super(filterSize / 2, filterSize / 2, "Gauss Filter");

        for(int x = this.minIndexX; x <= this.maxIndexX(); x++) {
            for(int y = this.minIndexY; y <= this.maxIndexY(); y++) {
                float coef = (float) (1 / (2 * Math.PI * Math.pow(sigma, 2)) *
                        Math.exp(- (Math.pow(x, 2) + Math.pow(y, 2)) / (2 * Math.pow(sigma, 2))));
                this.setAtIndex(x, y, coef);
            }
        }
        normalize();    // ensure that all coefficients sum up to one
    }
}
    