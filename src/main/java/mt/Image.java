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
        DisplayUtils.showImage(buffer, name, width(), origin, spacing(), /*Replace window with same name*/true);
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

    // store the origin points x,y as a class variable
    public void setOrigin(float x, float y) {
        origin[0] = x;
        origin[1] = y;
    }

    // the origin() returns the {x,y} as float array from the stored origin class variable.
    public float[] origin() {
        return origin;
    }

    // Sets the origin to the center of the image
    public void centerOrigin() {
        origin[0] = width / 2.f;
        origin[1] = height / 2.f;
    }

    public float interpolatedAt(float x, float y) {
        x -= origin[0];
        y -= origin[1];
        x /= spacing;
        y /= spacing;
        int x1 = (int) Math.floor(x);
        int x2 = (int) Math.ceil(x);
        int y1 = (int) Math.floor(x);
        int y2 = (int) Math.ceil(x);
        float diff_x_x1 = x - x1;
        float diff_y_y1 = y - y1;
        float xu = linearInterpolation(atIndex(x1, y2), atIndex(x2, y2), diff_x_x1);
        float xl = linearInterpolation(atIndex(x1, y1), atIndex(x2, y1), diff_x_x1);
        return linearInterpolation(xu, xl, diff_y_y1);
    }

    // Definition of arguments
    // diff_x_x1 = x - x_1 compute the difference between point x and x_1
    // fx_1 = f(x_1), pixel value at point x_1
    // fx_2 = f(x_2), pixel value at point x_2
    private float linearInterpolation(float fx_1, float fx_2, float diff_x_x1) {
        return fx_1 + diff_x_x1 * (fx_2 - fx_1);
    }



}
