package CarPrj.Classes.Com;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CarList extends ArrayList<Car> {

//	Menu menu = new Menu();
//	Scanner scanner = new Scanner(System.in);
//	BrandList brandList;
//
//	//Initialize a list based on the existed brand list
//	public CarList(BrandList bList) {
//		brandList = bList;
//	}
//
//	public boolean loadFromFile(String fileName) throws IOException {
//		String carID, color, frameID, engineID;
//		Brand brand;
//		BufferedReader br;
//		String line;
//		String[] arr;
//		try {
//			br = new BufferedReader(new FileReader(fileName));
//			System.out.println("check1");
//			line = br.readLine();
//			while (line != null) {
//				System.out.println("check2");
//				arr = line.split(",");
//				carID = arr[0].trim();
//				System.out.println("check3");
//				brand = brandList.get(brandList.searchID(arr[1].trim()));
//				System.out.println("check4");
//				color = arr[2].trim();
//				frameID = arr[3].trim();
//				engineID = arr[4].trim();
//				System.out.println("check5");
//				this.add(new Car(carID, brand, color, frameID, engineID));
//				System.out.println("check6");
//				line = br.readLine();
//			}
//			br.close();
//			return true;
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found !");
//		}
//		return false;
//	}
	private BrandList brandList;

	public CarList() {
		super();
	}

	public CarList(BrandList bList) {
		this.brandList = bList;
	}

//	public boolean loadFromFile(String filename) throws IOException {
//	
//	}
	public boolean loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String carID = parts[0];
                    String brandID = parts[1];
                    String color = parts[2];
                    String frameID = parts[3];
                    String engineID = parts[4];
                    int pos = brandList.searchID(brandID);
                    Brand brand = brandList.get(pos);
                    Car car = new Car(carID, brand, color, frameID, engineID);
                    this.add(car);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }

	public boolean saveToFile(String a) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

	public int searchID(String carID) {
		int N = this.size();
		for (int i = 0; i < N; i++) {
			if (this.get(i).getCarID().equalsIgnoreCase(carID.trim()) ) {
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
		Brand b;
		String color;
		String frameID;
		String engineID;
		//CarID
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
		// menu brand
		System.out.println("Enter new Brand ID: ");
		b = (Brand) Menu.ret_getChoice(brandList);
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
			} else {
				colorBlank = false;
			}
		} while (colorBlank);
		// frame ID
		// frameID duplicate
		sc = new Scanner(System.in);
		System.out.println("format of frame ID 'F0000' ");
		System.out.println("frameID: ");
		frameID = sc.nextLine();
		String regex = "^F\\d{5}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(frameID);
		boolean frameIDisblank = true;
		do {
			if (fIDDuplicate(frameID)) {
				System.out.println("This ID is already available. Please re-Enter");
				System.out.println("frameID:");
				sc = new Scanner(System.in);
				frameID = sc.nextLine();
				fIDDuplicate(frameID);
			} else if (matcher.matches() == false) {
				System.out.println("The ID does not match the format. Please re-enter");
				System.out.println("frameID:");
				sc = new Scanner(System.in);
				frameID = sc.nextLine();
				matcher.matches();
			} else {
				frameIDisblank = false;
			}
		} while (frameIDisblank);
		//engineID
		sc = new Scanner(System.in);
		System.out.println("format of engine ID 'E0000' ");
		System.out.println("engineID: ");
		engineID = sc.nextLine();
		String regex2 = "^E\\d{5}$";
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(engineID);
		boolean engineIDisblank = true;
		do {
			if (eIDDuplicate(engineID)) {
				System.out.println("frame is blank. Please re-enter");
				System.out.println("engineID:");
				sc = new Scanner(System.in);
				frameID = sc.nextLine();

			} else if (matcher2.matches() == false) {
				System.out.println("The ID does not match the format. Please re-enter");
				System.out.println("engineID:");
				sc = new Scanner(System.in);
				frameID = sc.nextLine();
			} else {
				engineIDisblank = false;
			}
		} while (frameIDisblank);

		Car m = new Car(carID, b, color, frameID, engineID);

		this.add(m);

		System.out.println("The new car has been added.");
	}

	private boolean fIDDuplicate(String check) {
		boolean frameIDDub = false;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).getFrameID().equals(check)) {
				frameIDDub = true;
			} else {
				frameIDDub = false;
			}
		}
		return frameIDDub;
	}

	//engine ID	
	private boolean eIDDuplicate(String check) {
		boolean engineIDDub = false;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).getEngineID().equals(check)) {
				engineIDDub = true;
			} else {
				engineIDDub = false;
			}
		}
		return engineIDDub;
	}

	public void printBasedBrandName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a brand name to print all element of brand: ");
		String brand = sc.nextLine().toUpperCase();
		int count = 0;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).getBrand().getBrandID().contains(brand)) {
				System.out.println(this.get(i).getCarID() + ", " + this.get(i).getBrand().getBrandID() + ", " + this.get(i).getFrameID() + ", " + this.get(i).getEngineID());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("No car is detected!");
		}
	}

	public boolean removeCar() {
		System.out.println("Enter ID of the car you want to remove: ");
		Scanner sc1 = new Scanner(System.in);
		String carID = sc1.nextLine();
		int pos = searchID(carID);
		System.out.println(pos);
		if (pos < 0) {
			System.out.println("No car detected");
			return false;
		} else {
			this.remove(pos);
		}
		return true;
	}

	public boolean updateCar() {
		return true;
	}

	public void listCars() {
		Collections.sort(this, new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				return o1.getBrand().getBrandName().compareTo(o2.getBrand().getBrandName());
			}
		});
		int N = this.size();
		for (int i = 0; i < N; i++) {
			System.out.println(this.get(i).screenString());
		}
	}
}
