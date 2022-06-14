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
        
    }
}
