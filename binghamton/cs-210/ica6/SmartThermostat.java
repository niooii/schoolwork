public class SmartThermostat extends SmartDevice {
	int temp;

	public SmartThermostat(String name, int temp) {
		super(name);
		this.temp = temp;
	}
	
	public void turnOn() {
		status = true;
		System.out.printf("%s thermostat is now %s. Temperature set to %dF.\n", name, status ? "ON" : "OFF", temp);
	}

	public void turnOff() {
		status = false;
		System.out.printf("%s thermostat is now %s.\n", name, status ? "ON" : "OFF");
	}
	
	public void adjustSettings(int temp) {
		this.temp = temp;
		System.out.printf("%s temperature adjusted to %dF.\n", name, temp);
	}
}
