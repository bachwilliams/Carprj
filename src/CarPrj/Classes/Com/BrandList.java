package CarPrj.Classes.Com;

import java.util.ArrayList;
import java.util.Scanner;

public class BrandList extends ArrayList<Brand>{

	public void loadFromFile(String e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public BrandList() {
		super();
	}

	public boolean saveToFile(String e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

//	public boolean saveToFile(String){
//
//	}

	public int searchID(String ID){
            return 0;
           
	}

	public Brand getUserChoice(){
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		
	}

    public void addBrand() {
        Scanner sc = new Scanner(System.in);

        String newID;
        String newBrandname;
        String newSoundbrand;
        double price;
        int checkID;
        String s;
        double d;

        do {
            System.out.printf("Enter a new brand:");
            sc = new Scanner(System.in);
            newID = sc.nextLine().toUpperCase();
            checkID = find(newID);
            if (checkID >= 0) {
                System.out.print("Brand ID is duplicated:");
            }
        } while (checkID >= 0);

        do {
            System.out.print("Enter the brand name:");
            sc = new Scanner(System.in);
            newBrandname = sc.nextLine().toUpperCase();
            s = newBrandname;
            if (s == null) {
                System.out.print("Error!!");

            }

        } while (s == null);

        do {
            System.out.print("Enter the sound manufacturer:");
            sc = new Scanner(System.in);
            newSoundbrand = sc.nextLine().toUpperCase();
            s = newSoundbrand;
            if (s == null) {
                System.out.print("Error!!");

            }

        } while (s == null);

        do {
            System.out.print("Enter the price:");
            sc = new Scanner(System.in);
            price = sc.nextDouble();
            d = price;
            if (d <= 0) {
                System.out.printf("Erorr!!!");

            }
        } while (d <= 0);

        Brand brand = new Brand(newID, newBrandname, newSoundbrand, price);
        this.add(brand);
        System.out.println("New brand is added !");

    }

	   public void updateBrand() {
        Scanner scanner = new Scanner(System.in);
        int k;
        String id, newbrand, newmanu;
        double price;
        System.out.print("Enter the ID you need update the brand:");
        id = scanner.nextLine().toUpperCase();
        k = find(id);
        if (k >= 0) {
            do {
                System.out.print("Enter the new brand you want to update:");
                newbrand = scanner.nextLine().toUpperCase();
                if (newbrand == null) {
                    System.out.println("Fail!");
                }
            } while (newbrand == null);

            do {
                System.out.print("Enter new sound manufacturer :");
                newmanu = scanner.nextLine().toUpperCase();
                if (newmanu == null) {
                    System.out.println("Fail!");
                }

            } while (newmanu == null);

            do {
                System.out.print("Enter new price :");
                price = scanner.nextDouble();
                if (price <= 0) {
                    System.out.println("failed!");
                }
            } while (price <= 0);
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getBrandID().contains(id)) {
                    this.get(i).getBrandName();
                    this.get(i).getSoundBrand();
                    this.get(i).getPrice();
                    System.out.println("Update succesful!");
                }
            }

        } else {
            System.out.println("The ID does not exist !!!");
        }

    }

	   public void listBrands() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).getBrandID() + ", " + this.get(i).getBrandName() + ", " + this.get(i).getSoundBrand()+ ": " + this.get(i).getPrice());
        }
    }

}
