// Erik Goesche ge76imih
package mt;

public class DerivativeFilter2d extends LinearImageFilter {

    public DerivativeFilter2d(boolean transpose) {
        super(3, 3, "Derivative Filter");
        if (transpose) {
            setAtIndex(-1, 0, -1.f);
            setAtIndex(0, 0, 0.f);
            setAtIndex(1, 0, 1.f);
        } else {
            setAtIndex(0, -1, -1.f);
            setAtIndex(0, 0, 0.f);
            setAtIndex(0, 1, 1.f);
        }
    }
}