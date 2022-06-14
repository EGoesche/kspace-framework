/*
 * ImageTransformer.java
 * Copyright (C) 2020 Stephan Seitz <stephan.seitz@fau.de>
 *
 * Distributed under terms of the GPLv3 license.
 */
package mt;

public class ImageTransformer implements ImageFilter {

    // Transformation parameters
    public float shiftX; // tx
    public float shiftY; // ty
    public float rotation; // theta
    public float scale; // s
    
    @Override
    public String name() {
        return "Image Transformer";
    }

    public void apply(Image input, Image output) {
        for (int yPrime = output.minIndexY; yPrime < output.minIndexY + output.height(); yPrime++) {
            for (int xPrime = output.minIndexX; xPrime < output.minIndexX + output.width(); xPrime++) {
                // apply translation
                float x = xPrime - shiftX;
                float y = yPrime - shiftY;

                // apply rotation
                x = (float) (x * Math.cos(rotation) + y * Math.sin(rotation));
                y = (float) - (x * Math.sin(rotation) + y * Math.cos(rotation));

                // apply scaling
                x /= scale;
                y /= scale;

                // set output image value
                output.setAtIndex(xPrime, yPrime, input.interpolatedAt(x, y));
            }
        }
    }
}
