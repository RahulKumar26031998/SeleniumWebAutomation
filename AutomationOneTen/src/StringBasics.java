

public class StringBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String is an object // String literal way of declaring string
		// It points to the same location and does not create new space for the same
		// value
		String s = "Rahul kumar";
		String s1 = "Rahul Kumar";

		// using new keyword operator to declare string // It creates space ven for the
		// same value
		String s3 = new String("  Rahul Kumar");
		String s4 = new String("Rahul Kumar");

		String[] x = s4.split(" ");
		String[] y = s3.split("Kumar");

		for (String i : x) {
			System.out.println(i);
		}

		for (String j : y) {
			System.out.println(j);
		}

		System.out.println(y[0].trim());

		for (int z = 0; z < s4.length(); z++) {
			System.out.println(s4.charAt(z));
		}

		for (int w = s4.length() - 1; w >= 0; w--) {
			System.out.println(s4.charAt(w));
		}
		
		Methods obj1 = new Methods();
		obj1.getData();
		

		

	}

}
