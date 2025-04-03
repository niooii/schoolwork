public class Driver {
    // For testing purposes
    public static void main(String[] args) {
        ListADT myArrayBasedList = new ArrayBasedList();
        ListADT myLinkedBasedList = new LinkedBasedList();
        performListOperations(myArrayBasedList);
        performListOperations(myLinkedBasedList);
    }


    public static void performListOperations(ListADT list){
        list.add(0, "Milk");
        list.add(0, "Cheese");
        list.add(1, "Bread");
        list.add(3, "Beef");
        System.out.println("List Contents: " + list.print(","));
        System.out.println("Removed: " + list.remove(0));
        System.out.println("List Contents: " + list.print(","));
        try {
            System.out.println(list.getIndex(1));
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        list.clear();
        list.add(7, "Yogurt");
        System.out.println("List Contents: " + list.print(","));
        System.out.println("Removed: " + list.remove(3));
        try {
            System.out.println(list.getIndex(1));
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println("****************************************");

    }
}
