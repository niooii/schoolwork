public class SmartDeviceDriver {
	public static void main(String[] args) {
		SmartThermostat livingRoom = new SmartThermostat("Living room", 20);
		System.out.println("hey man..");
		livingRoom.displayStatus();
		livingRoom.turnOn();
		livingRoom.adjustSettings(1000);
	}
}
