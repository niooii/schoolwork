public class Person {
   private String name;
   private int age;
   private String addr;
   private String phoneNumber;
   
   public Person(String name, int age, String addr, String phoneNumber) {
       this.name = name;
       this.age = age;
       this.addr = addr;
       this.phoneNumber = phoneNumber;
   }

   public String toString() {
       return "Name: " + name + "\n" +
              "Age: " + age + "\n" +
              "Address: " + addr + "\n" +
              "Phone Number: " + phoneNumber + "\n";
   }
   
   public void greet() {
       System.out.println("Hello, my name is " + name + " and i am " + age + " years old.");
   }
   
   public String getName() {
       return name;
   }
   
   public void setName(String name) {
       this.name = name;
   }
   
   public int getAge() {
       return age;
   }
   
   public void setAge(int age) {
       this.age = age;
   }
   
   public String getAddress() {
       return addr;
   }
   
   public void setAddress(String addr) {
       this.addr = addr;
   }
   
   public String getPhoneNumber() {
       return phoneNumber;
   }
   
   public void setPhoneNumber(String phoneNumber) {
       this.phoneNumber = phoneNumber;
   }
}
