public abstract class SmartDevice {
	String name;
	boolean status;

	public SmartDevice(String name) {
		this.name = name;
		status = false;
	}
	
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void adjustSettings(int setting);
	public void displayStatus() {
		System.out.printf("%s is %s\n", name, status ? "ON" : "OFF");
	}
}
