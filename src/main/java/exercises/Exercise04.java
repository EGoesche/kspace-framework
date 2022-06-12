package exercises;

import mt.*;

public class Exercise04 {
    public static void main(String[] args) {
        (new ij.ImageJ()).exitWhenQuitting(true);

        Image image = lme.DisplayUtils.openImageFromInternet("https://mt2-erlangen.github.io/pacemaker.png", ".png");
        image.show();
        // Image image_hand = lme.DisplayUtils.openImage("data/hand.png");
        // image_hand.show();

        // Initialize, apply and show all filters
        DerivativeFilter2d derivx = new DerivativeFilter2d(false);
        Image derivx_output = derivx.apply(image);
        derivx_output.show();

        AverageFilter2d avg = new AverageFilter2d(10);
        Image avg_output = avg.apply(image);
        avg_output.show();

        SharpeningFilter2d sharp = new SharpeningFilter2d(8.f);
        Image sharp_output = sharp.apply(image);
        sharp_output.show();

        DerivativeFilter2d derivy = new DerivativeFilter2d(true);
        Image derivy_output = derivy.apply(image);
        derivy_output.show();
    }
}
