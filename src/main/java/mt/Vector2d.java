package mt;

public class Vector2d {
    float kx,ky;

    public Vector2d(float kx, float ky) {
        this.kx = kx;
        this.ky = ky;
    }

    public float dot(Vector2d other) {
        return this.kx * other.kx + this.ky * other.ky;
    }
}
