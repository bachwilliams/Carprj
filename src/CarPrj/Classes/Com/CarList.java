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

	BrandList brandList;

	public CarList(BrandList bList) {

	}

	public boolean loadFromFile(String filename) throws IOException {
		FileReader fr = null;
		File f = new File(filename);
		if (!f.exists()) {
			System.out.println("Failed");
			return false;
		} else {
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			Path path = Paths.get(filename);
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line.length() > 0) {
					StringTokenizer stk = new StringTokenizer(line, ",");
					String carID = stk.nextToken().trim();
					String brandID = stk.nextToken().trim();
					String color = stk.nextToken().trim();
					String frameID = stk.nextToken().trim();
					String engineID = stk.nextToken().trim();
					int pos = brandList.find(brandID);
					if (pos != -1) {
						Brand b = brandList.get(pos);
						Car newCar = new Car(carID, b, color, frameID, engineID);
						this.add(newCar);
					} else {
						System.out.println("Brand with ID " + brandID + " not found in the list.");
					}
				}
			}
		}
		return true;
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
			} else if (matcher.matches() == false) {
				System.out.println("The ID does not match the format. Please re-enter");
				System.out.println("frameID:");
				sc = new Scanner(System.in);
				frameID = sc.nextLine();
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

		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public boolean removeCar() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

	public boolean updateCar() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

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
