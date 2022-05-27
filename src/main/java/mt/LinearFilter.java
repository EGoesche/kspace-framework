package mt;

import static java.lang.Math.abs;

public class LinearFilter extends Signal {
    public LinearFilter(float[] coefficients, String name) {
        super(coefficients, name);
        minIndex = - coefficients.length / 2;

        if(1 != (coefficients.length % 2)) {
            throw new RuntimeException("Filler not even");
        }
    }

    public Signal apply(Signal input) {
        float[] output = new float[input.size()];
        for(int i = 0; i <= input.maxIndex(); i++) {
            for(int j = this.minIndex(); j <= this.maxIndex(); j++) {
                output[i] += input.atIndex(i - j) * this.atIndex(j);
            }
        }
        return new Signal(output, input.name() + " * " + this.name());
    }

}
