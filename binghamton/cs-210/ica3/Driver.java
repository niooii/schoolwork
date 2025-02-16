public class Driver {
	public static void main(String[] args) {
		Person person1 = new Person("daniel", 24, "address", "242 535 8383");
		System.out.println(person1);
		person1.greet(); 
		Person person2 = new Person("jack", 12, "earth", "757 535 8343");
		System.out.println(person2);
		person2.greet();
	}
}
