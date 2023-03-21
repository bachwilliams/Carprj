package CarPrj.Classes.Com;

/**
 */
public class Brand {
	private String brandID;	
	private String brandName;
	private String soundBrand;
	private double price;

	public Brand() {
	}

	public Brand(String brandID, String brandName, String soundBrand, double price) {
		this.brandID = brandID;
		this.brandName = brandName;
		this.soundBrand = soundBrand;
		this.price = price;
	}

	public String getBrandID() {
		return brandID;
	}

	public void setBrandID(String brandID) {
		this.brandID = brandID;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSoundBrand() {
		return soundBrand;
	}

	public void setSoundBrand(String soundBrand) {
		this.soundBrand = soundBrand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return brandID + ", " + brandName + ", " + soundBrand + ": " + price;
	}
//	BrandList brandList;
//
//	public CarList(BrandList bList) {
//
//	}
//
//	public boolean loadFromFile(String filename) throws IOException {
//		FileReader fr = null;
//		File f = new File(filename);
//		if (!f.exists()) {
//			System.out.println("Failed");
//			return false;
//		} else {
//			fr = new FileReader(f);
//			BufferedReader br = new BufferedReader(fr);
//			String line;
//			while ((line = br.readLine()) != null) {
//				line = line.trim();
//				if (line.length() > 0) {
//					StringTokenizer stk = new StringTokenizer(line, ",");
//					String carID = stk.nextToken().trim();
//					String brandID = stk.nextToken().trim();
//					String color = stk.nextToken().trim();
//					String frameID = stk.nextToken().trim();
//					String engineID = stk.nextToken().trim();
//					int pos = brandList.find(brandID);
//					if (pos != -1) {
//						Brand b = brandList.get(pos);
//						Car newCar = new Car(carID, b, color, frameID, engineID);
//						this.add(newCar);
//					} else {
//						System.out.println("Brand with ID " + brandID + " not found in the list.");
//					}
//				}
//			}
//		}
//		return true;
//	}	

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
}
