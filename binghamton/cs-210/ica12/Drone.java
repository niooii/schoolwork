public class Drone {
    float maxHeight;

    public Drone(float maxHeight) {
        // call our setter here to ensure correctness
        setMaxHeight(maxHeight);
    }

    public float getMaxHeight() { return maxHeight; }
    public void setMaxHeight(float maxHeight) { this.maxHeight = maxHeight < 0 ? 0 : maxHeight; }
}
