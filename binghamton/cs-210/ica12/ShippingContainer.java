public class ShippingContainer<T> {
    T content;
    float weight;

    public ShippingContainer(T item, float weight) {
        this.content = item;
        this.weight = weight;
    }

    public T getContent() { return content; }
    public void setContent(T content) { this.content = content; }

    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }

    public String toString() {
        return String.format("Container with %s inside, weighing %f lbs", content.toString(), weight);
    }
}
