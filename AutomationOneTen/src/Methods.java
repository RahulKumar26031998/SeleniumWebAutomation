
public class Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Methods obj = new Methods();
		obj.getData();
		
		String name = getData3();

	}
	// declare the method outside the main block always
	public void getData() {
		System.out.println("Hello");
	}
	
	public int getData1() {
		return 1;
	}
	
	public String getData2() {
		return "ok";
	}
	
	public static String getData3() {
		System.out.println("Hello World");
		return "hey"; 
	}
	

}
