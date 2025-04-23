public class Camera {
    // Camera res in megapixels
    float resolution;

    public Camera(float resolution) {
        setResolution(resolution);
    }

    public void setResolution(float resolution) { this.resolution = resolution < 1 ? 1 : resolution; }
    public float getResolution() { return resolution; }
}
