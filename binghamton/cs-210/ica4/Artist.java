public class Artist {
	private String name;
	private int numFans;

	public Artist(){
		name = "Alan Turing";
		numFans = 2000000000;
	}
	
	public Artist(String name, int numFans){
		this.name = name;
		this.numFans = numFans;
	}

	public Artist(Artist anotherArtist) {
		this.name = anotherArtist.name;
		this.numFans = anotherArtist.numFans;
	}

	public void setInfo(String name, int numFans){
		this.name = name;
		this.numFans = numFans;	
	}

	public void drawSomething() {
		System.out.println("i am drawing something...");
	}
}
