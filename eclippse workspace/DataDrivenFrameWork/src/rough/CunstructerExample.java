package rough;

public class CunstructerExample {
	
	public CunstructerExample () {
		
		System.out.println("Befor Call main Method");
	}
	
	public void sainath () {
		
		System.out.println("Sainath");
	}

	public static void main(String[] args) {
		
		CunstructerExample ana = new CunstructerExample ();
		System.out.println("ABCD");
		ana.sainath();
	}

}
