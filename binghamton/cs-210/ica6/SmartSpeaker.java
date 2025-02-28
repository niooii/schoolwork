public class SmartSpeaker extends SmartDevice {
	int vol;
	public SmartSpeaker(String name, int vol) {
		super(name);
		this.vol = vol;
	}
	
	public void turnOn() {
		status = true;
		System.out.printf("%s speaker is now %s. Volume set to %d%%.\n", name, status ? "ON" : "OFF", vol);
	}

	public void turnOff() {
		status = false;
		System.out.printf("%s speaker is now %s.\n", name, status ? "ON" : "OFF");
	}
	
	public void adjustSettings(int vol) {
		this.vol = vol;
		System.out.printf("%s volume adjusted to %d%%.\n", name, vol);
	}
}
