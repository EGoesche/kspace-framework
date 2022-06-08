// Erik Goesche ge76imih
package mt;

public interface ImageFilter {
    default mt.Image apply(mt.Image image) {
        Image output = new Image(image.width(), image.height(), image.name() + " processed with " + this.name());
        apply(image, output);
        return output;
    }

    default void apply(mt.Image input, mt.Image output) {
        throw new RuntimeException("Please implement this method!");
    }

    String name();
}
