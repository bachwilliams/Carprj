/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes;

import CarPrj.Classes.Com.Brand;
import CarPrj.Classes.Com.BrandList;
import CarPrj.Classes.Com.Car;
import CarPrj.Classes.Com.CarList;
import CarPrj.Classes.Com.Menu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {

	public static void main(String[] args) throws IOException { // IO Exception de catch loi o chuc nang loadFromfile
		// Add some cars to the ArrayList
		//option in menu
		ArrayList<String> options = new ArrayList<String>();
		options.add("List all brands");
		options.add("Add a new brand");
		options.add("Search a brand based on its ID");
		options.add("Update a brand");
		options.add("Save brands to the file, named brands.txt");
		options.add("List all cars in ascending order of brand names");
		options.add("List cars based on a part of an input brand name");
		options.add("Add a car");
		options.add("Remove a car based on its ID");
		options.add("Update a car based on its ID");
		options.add("Save cars to file, named cars.txt");
		options.add("Exit");

		BrandList blist = new BrandList();
		String projectPath = System.getProperty("user.dir");            // cau lenh trich xuat duong dan cua project 
		blist.loadFromFile(projectPath + "\\src\\CarPrj\\Brands.txt"); // dong lenh nay de doc file Brand.txt va ghi ra mang ArrayList<Brand>
		CarList clist = new CarList(blist);                            // de truyen thong tin mang brandList vao Carlist 
		clist.loadFromFile(projectPath + "\\src\\CarPrj\\Cars.txt");  // dong lenh nay de doc file Brand.txt va ghi ra mang ArrayList<Brand>

		int choice = 0;
		do {
			System.out.println("\nCar managing Program");
			choice = Menu.int_getChoice(options);
			switch (choice) {
				case 1:
					blist.listBrands();
					break;
				case 2:
					blist.addBrand();
					break;
				case 3: {
					Scanner sc = new Scanner(System.in);
					System.out.print("Enter the ID you want to search :");
					String ID = sc.nextLine();
					blist.searchID1(ID);
					break;
				}
				case 4:
					blist.updateBrand();
					break;
				case 5:
					blist.saveToFile(projectPath + "\\src\\CarPrj\\Brands.txt");
					break;
				case 6:
					clist.listCars();
					break;
				case 7:
					clist.printBasedBrandName();
					break;
				case 8:
					clist.addCar();
					break;
				case 9:
					clist.removeCar();
					break;
				case 10:
					clist.updateCar();
					break;
				case 11:
					clist.saveToFile(projectPath + "\\src\\CarPrj\\Cars.txt");
					break;
				default:
					System.out.println("Bye!");
			}
		} while (choice > 0 && choice <= 11);
	}
}
