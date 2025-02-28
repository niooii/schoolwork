public class Tailgater {

	static int drinksInCooler = 10;
	static int numTailgaters = 0;

	String name;
	boolean isBingFan;
	int drinks;

	public Tailgater(String name, boolean isBingFan) {
		this.isBingFan = isBingFan;
		this.name = name;
		this.drinks = 0;
		numTailgaters++;

		if (!isBingFan) {
			for (int i = 0; i < 20; i++) {
				System.out.println("Go Binghamton!!!!!");
			}
		}
	}
	
	public String getName() {
		return this.name;
	}

	public boolean isBingFan() {
		return this.isBingFan;
	}

	public static boolean isCoolerEmpty() {
		return drinksInCooler == 0;
	} 
	
	public void getDrinkInCooler() {
		if (!isCoolerEmpty()) {
			drinksInCooler--;
		} else {
			System.out.println("Cooler empty...");
		}
	}

	public void addDrinksToCooler(int numDrinks) {
		drinksInCooler += numDrinks;
		System.out.printf("There are now %d drinks in the cooler! wow", drinksInCooler);
	}
		
}
