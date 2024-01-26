import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		String myname = "Rahul Kumar";
		char x = 'r';
		double my_var = 2.99;
		Boolean my_card = true;

		System.out.println(my_card);
		System.out.println("The value of a is : " + a);

		// Array
		int[] my_arr = new int[5];
		my_arr[0] = 1;
		my_arr[1] = 2;
		my_arr[2] = 3;
		my_arr[3] = 4;
		my_arr[4] = 5;

		int[] my_arr1 = { 1, 2, 3, 4, 5 };

		String[] my_arr2 = { "Rahul", "Kumar" };

		System.out.println(my_arr[3]);

		for (int i = 0; i < my_arr1.length; i++) {
			System.out.println(my_arr1[i]);
//			System.out.println(i);
		}

		for (int i = 0; i < my_arr2.length; i++) {
			System.out.println(my_arr2[i]);
//			System.out.println(i);
		}

		for (String s : my_arr2) {
			System.out.println(s);
		}

		int[] z = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0; i < z.length; i++) {
			if (z[i] % 2 == 0) {
				System.out.println(z[i]);

			}
		}
		// array list
		ArrayList<String> arr_list = new ArrayList<String>();
		arr_list.add("Rahul");
		arr_list.add("Kumar");
		arr_list.add("Automation");
		arr_list.add("Test Engineer");

		System.out.println(arr_list.get(3));

		for (int j = 0; j < arr_list.size(); j++) {
			System.out.println(arr_list.get(j));
		}
		System.out.println("*******************************");

		for (String val : arr_list) {
			System.out.println(val);
		}

		System.out.println(arr_list.contains("Automation"));

		List<String> conv_list = new ArrayList<>(Arrays.asList(my_arr2));
		conv_list.contains("Kumar");
	}
}
