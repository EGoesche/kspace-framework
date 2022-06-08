/*
 * Image.java
 * Copyright (C) 2020 Stephan Seitz <stephan.seitz@fau.de>
 *
 * Distributed under terms of the GPLv3 license.
 */

package mt;

import lme.DisplayUtils;
import mt.Signal;

public class Image extends Signal {

    protected int width;
    protected int height;
    protected int minIndexX = 0;
    protected int minIndexY = 0;

    protected float[] origin = new float[]{ 0, 0 };

    public Image(int width, int height, String name) {
        super(height * width, name);
        this.width = width;
        this.height = height;
    }

    public Image(int width, int height, String name, float[] pixels) {
        super(pixels, name);
        this.width = width;
        this.height = height;
    }

    public void show() {
        DisplayUtils.showImage(buffer, name, width(), origin, /*spacing()*/ 1.0f, /*Replace window with same name*/true);
    }
    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public float atIndex(int x, int y) {
        int xIdx = x - minIndexX;
        int yIdx = y - minIndexY;

        if (xIdx < 0 || xIdx >= width() || yIdx < 0 || yIdx >= height()) {
            return 0.f;
        } else {
            return buffer[yIdx * width() + xIdx];
        }
    }

    public void setAtIndex(int x, int y, float value) {
        int xIdx = x - minIndexX;
        int yIdx = y - minIndexY;

        if (xIdx < 0 || xIdx >= width() || yIdx < 0 || yIdx >= height()) {
            throw new RuntimeException("Index out of bounds");
        } else {
            buffer[yIdx * width() + xIdx] = value;
        }
    }


    public void setBuffer(float[] buffer) {
        this.buffer = buffer;
    }


    public int minIndexX() {
        return minIndexX;
    }

    public int minIndexY() {
        return minIndexY;
    }

    public int maxIndexX() {
        return minIndexX + width() - 1;
    }

    public int maxIndexY() {
        return minIndexY + height() - 1;
    }

    public void fft(){
        DisplayUtils.FFT(buffer, name, width(), origin, /*spacing()*/ 1.0f);
    }


    public Image add(Image image){
        Image result = new Image(width,height, name() + " + " + image.name());
        result.minIndexX = minIndexX;
        result.minIndexY = minIndexY;

        if(image.width != width || image.height != height){
            throw new RuntimeException("Images need to have the same size!");
        }
        for (int y = minIndexY; y < minIndexY + height(); ++y) {
            for (int x = minIndexX; x < minIndexX + width(); ++x) {
                float plus = image.atIndex(x,y) + atIndex(x,y);
                result.setAtIndex(x,y,plus);

            }
        }
        return result;
    }

}
