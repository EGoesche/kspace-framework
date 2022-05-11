// Erik Goesche ge76imih

// Mohammed Sabiya Sujith Ahamed cu01zaze
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

    public static void main(String[] args) {
        float numbers[] = {42, 25, 17, 63, 90};
        Signal s1 = new Signal(numbers, "Signal 1");
        s1.show();
    }
}
