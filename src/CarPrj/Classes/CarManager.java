/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes;

import CarPrj.Classes.Com.Brand;
import CarPrj.Classes.Com.Car;
import java.util.ArrayList;

public class CarManager {

	public static void main(String[] args) {
		// Add some cars to the ArrayList
	ArrayList<Car> cars = new ArrayList<Car>();
	cars.add(new Car("C01",new Brand(), "red", "F12345", "E12345" ));
	cars.add(new Car("C02",new Brand(), "black", "F12346", "E12346" ));
	cars.add(new Car("C03",new Brand(), "orange", "F12347", "E12347" ));
	cars.add(new Car("C04",new Brand(), "white", "F12348", "E12348" ));
	cars.add(new Car("C05",new Brand(), "pinkk", "F12349", "E12349" ));
	//them method de test chuc nang o day
		System.out.println("inter");
	}

}
