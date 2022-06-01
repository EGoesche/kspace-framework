// Erik Goesche ge76imih
package mt;

import lme.DisplayUtils;

public class Image extends Signal {
    // Dimensions of the image
    protected int width;
    protected int height;

    // Same as Signal.minIndex but for X and Y dimension
    protected int minIndexX;
    protected int minIndexY;

    // For a later exercise (no need to do anything with it in exercise 3)
    protected float[] origin = new float[]{ 0, 0 };

    // Create an image with given dimensions
    public Image(int width, int height, String name) {
        super(width * height, name);
        this.width = width;
        this.height = height;
    }

    // Create an image with given dimensions and also provide the content
    public Image(int width, int height, String name, float[] pixels) {
        super(pixels, name);
        if(pixels.length != width * height) {
            throw new IllegalArgumentException("Given width and height does not fit the dimensions of the given " +
                    "pixels array.");
        }
        this.width = width;
        this.height = height;
    }

    // Image dimensions
    public int width() { return this.width; }
    public int height() { return this.height; }

    // Minimum and maximum indices (should work like Signal.minIndex/maxIndex)
    public int minIndexX() { return this.minIndexX; }
    public int minIndexY() { return this.minIndexY; }

    public int maxIndexX() {
        return this.minIndexX + this.width - 1;
    }
    public int maxIndexY() {
        return this.minIndexY + this.height - 1;
    }

    public float atIndex(int x, int y) {
        try {
            return this.buffer[(y - this.minIndexY) * this.width + (x - this.minIndexX)];
        } catch (ArrayIndexOutOfBoundsException e) {
        return 0.0f;
    }

    }
    public void setAtIndex(int x, int y, float value) {
        buffer[(y - this.minIndexY) * this.width + (x - this.minIndexX)] = value;
    }

    //We need a method to fill the buffer for the openImage() function
    public void setBuffer(float[] buffer) {
        this.buffer = buffer;
    }

    public void show() {
        DisplayUtils.showImage(buffer, name, width(), origin, /*spacing()*/ 1.0f, /*Replace window with same name*/true);
    }

    public Image add(Image image) {
        if(this.width != image.width || this.height != image.height) {
            throw new IllegalArgumentException("Given images differ in size.");
        }
        Image result = new Image(this.width, this.height, this.name + " + " + image.name);
        for(int i = 0; i <= this.width * this.height; i++) {
            result.buffer[i] = this.buffer[i] + image.buffer[i];
        }
        return result;
    }

    public void fft(){
        DisplayUtils.FFT(buffer, name, width(), origin, /*spacing()*/ 1.0f);
    }


}
