// Erik Goesche ge76imih
// Mohammed Sabiya Sujith Ahamed <your partner's idm>
package mt;

import lme.DisplayUtils;
import ij.gui.Plot;

public class Signal {
    protected float[] buffer; // Array to store signal values
    protected String name;    // Name of the signal

    // Create signal with a certain length (set values later)
    public Signal(int length, String name) {
        this.buffer = new float[length];
        this.name = name;
    }

    // Create a signal from a provided array
    public Signal(float[] buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    // Size of the signal
    public int size() {
        return this.buffer.length;
    }

    // Get the internal array
    public float[] buffer() {
        return this.buffer;
    }

    // Get the name of the signal
    public String name() {
        return this.name;
    }

    // Visualize the signal
    public void show() {
        DisplayUtils.showArray(this.buffer, this.name, /*start index=*/0, /*distance between values=*/1);
    }

    // Adds the signal with another one elementwise
    // Checks if both signals have the same size otherwise throws an error
    public Signal plus(Signal other) {
        if (this.size() != other.size()) {
            throw new ArithmeticException("Signal have not the same size");
        }
        float newbuffer[] = new float[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newbuffer[i] = this.buffer()[i] + other.buffer()[i];
        }

        return new Signal(newbuffer, this.name() + " + " + other.name());
    }

    // Multiplies the signal with a scalar
    public Signal times(float scalar) {
        float newbuffer[] = new float[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newbuffer[i] = this.buffer()[i] * scalar;
        }

        return new Signal(newbuffer, this.name() + " * " + scalar);
    }

    public static void main(String[] args) {
        float numbers[] = {42, 25, 17, 63, 90};
        Signal s1 = new Signal(numbers, "Signal 1");
        s1.show();
    }
}
