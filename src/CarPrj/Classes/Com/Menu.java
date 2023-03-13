package CarPrj.Classes.Com;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public int int_getChoice(ArrayList options) {
		for (int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + "-" + options.get(i));
		}
		System.out.print("Enter your number :");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
