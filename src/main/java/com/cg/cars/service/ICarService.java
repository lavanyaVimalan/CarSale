package com.cg.cars.service;
/** This is an interface which defines CRUD methods for Car service
 * 
 * @author Rukumbai's
 *
 */
import java.util.List;

import com.cg.cars.beans.Car;
import com.cg.cars.exception.CarIdNotFoundException;
import com.cg.cars.exception.DuplicateCarIdFoundException;
import com.cg.cars.exception.InvalidCarTypeException;

public interface ICarService {
	public Car addCar(Car car) throws DuplicateCarIdFoundException;
	public Car removeCar(long id) throws CarIdNotFoundException;
	public Car updateCar(long id, Car car) throws CarIdNotFoundException;
	public Car getCar(long id) throws CarIdNotFoundException;
	public List<Car> getAllCars();
	public List<Car> getCarsByLocation(String registrationState) throws InvalidCarTypeException;
	public List<Car> getCarsByModel(String model) throws InvalidCarTypeException;
	public List<Car> getCarsByBrand(String brand) throws InvalidCarTypeException;
}