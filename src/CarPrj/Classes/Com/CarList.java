package CarPrj.Classes.Com;

import java.util.ArrayList;
import java.util.Scanner;

public class CarList extends ArrayList<Car> {

	BrandList brandList;

	public CarList(BrandList bList) {

	}

	public boolean loadFromFile(String a) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

	public boolean saveToFile(String a) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

	public int searchID(String carID) {
		int N = this.size();
		for (int i = 0; i < N; i++) {
			if (this.get(i).getCarID() == carID) {
				return i;
			}
		}
		return -1;
	}

	public int searchFrame(String fID) {
		int N = this.size();
		for (int i = 0; i < N; i++) {
			if (this.get(i).getFrameID() == fID) {
				return i;
			}
		}
		return -1;
	}

	public int searchEngine(String eID) {
		int N = this.size();
		for (int i = 0; i < N; i++) {
			if (this.get(i).getEngineID() == eID) {
				return i;
			}
		}
		return -1;
	}

	public void addCar() {
		Scanner sc = new Scanner(System.in);
		String carID;
		Brand brand;
		String color;
		String frameID;
		String engineID;
		System.out.println("CarID: ");
		carID = sc.nextLine();
		boolean carIDDub = false;
		do {
			for (int i = 0; i < this.size(); i++) {
				if (this.get(i).getCarID().equals(carID)) {
					System.out.println("This ID is already available. Please re-Enter");
					carIDDub = true;
					System.out.println("CarID: ");
					sc = new Scanner(System.in);
					carID = sc.nextLine();
				} else {
					carIDDub = false;
				}

			}
		} while (carIDDub);
		// menu band
		// enter color
		sc = new Scanner(System.in);
		System.out.println("Color:");
		color = sc.nextLine();
		boolean colorBlank = true;
		do {
			if (color.isEmpty()) {
				System.out.println("color is blank. Please re-enter");
				colorBlank = true;
				System.out.println("Color:");
				sc = new Scanner(System.in);
				color = sc.nextLine();
			}else{
				colorBlank = false;
			}
		} while (colorBlank);
		
	}

	public void printBasedBrandName() {

		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public boolean removeCar() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

	public boolean updateCar() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

	public void listCars() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

}
