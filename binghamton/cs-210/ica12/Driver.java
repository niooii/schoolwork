public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Drone drone = new Drone(10);
        ShippingContainer<Drone> droneBox = new ShippingContainer<>(drone, 10);
        System.out.println(droneBox);

        Camera cam = new Camera(10);
        ShippingContainer<Camera> camBox = new ShippingContainer<>(cam, 3);
        System.out.println(camBox);
    }
}
