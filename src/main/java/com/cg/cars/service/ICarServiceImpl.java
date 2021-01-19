package com.cg.cars.service;
/** The IPaymentServiceImpl class provides access to repository methods to CRUD operations Car details 
 * 
 * 
 * @author Rukumbai's
 *
 */
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.beans.Car;
import com.cg.cars.dao.ICarRepository;
import com.cg.cars.exception.CarIdNotFoundException;
import com.cg.cars.exception.DuplicateCarIdFoundException;
import com.cg.cars.exception.InvalidCarTypeException;
@Service
public class ICarServiceImpl implements ICarService{
	
	private static final Logger logger = LogManager.getLogger(ICarServiceImpl.class);
	@Autowired
	private ICarRepository carRepository;
	

	public ICarRepository getCarRepository() {
		return carRepository;
	}

	public void setCarRepository(ICarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public Car addCar(Car car) throws DuplicateCarIdFoundException {
		if(carRepository.existsById(car.getCarId())) {
			throw new DuplicateCarIdFoundException(DuplicateCarIdFoundException.MESSAGE);
		}
		Car car2=carRepository.save(car);
		logger.info("Car Details Added Successfully...!");
		return car2;
	}

	@Override
	public Car removeCar(long id) throws CarIdNotFoundException{
		Optional<Car> car=carRepository.findById(id);
		if(car.isPresent()) {
		logger.info("Car Deleted Successfully..!");
		return 	carRepository.deleteById(id);
		} else {
			throw new CarIdNotFoundException(CarIdNotFoundException.MESSAGE);
			
		}
			}

	@Override
	public Car updateCar(long id, Car car) throws CarIdNotFoundException{
	if(carRepository.existsById(id)) {
		logger.info("Car Updated Successfully..!");
		return carRepository.save(car);
	}else {
		throw new CarIdNotFoundException(CarIdNotFoundException.MESSAGE);
	}
	}

	@Override
	public Car getCar(long id)  throws CarIdNotFoundException{
		Optional<Car> car=carRepository.findById(id);
		if(car.isPresent()) {
		 logger.info("Retrieved Car Details By Id Successfully..!");
			return car.get();
		} else {
			throw new CarIdNotFoundException(CarIdNotFoundException.MESSAGE);
		}
	}

	@Override
	public List<Car> getAllCars() {
		logger.info("Retrieved All Car Details Successfully...!");
		return carRepository.findAll();
	}

	@Override
	public List<Car> getCarsByLocation(String registrationState) throws InvalidCarTypeException{
		List<Car>cars= carRepository.findByRegistrationState(registrationState);
		if(!cars.isEmpty()) {
			logger.info("Retrieved All Car Details by Location Successfully...!");
				return carRepository.findByRegistrationState(registrationState);
		}else 
			throw new InvalidCarTypeException(InvalidCarTypeException.MESSAGE);
	}

	@Override
	public List<Car> getCarsByModel(String model) throws InvalidCarTypeException{
		logger.info("Retrieved All Car Details by Model Successfully...!");
		return carRepository.findByModel(model);
		
		
	}

	@Override
	public List<Car> getCarsByBrand(String brand) throws InvalidCarTypeException{
		List<Car> cars=carRepository.findByBrand(brand);
		if(!cars.isEmpty()) {
			logger.info("Retrieved All Car Details by Brand Successfully...!");
				return carRepository.findByBrand(brand);
		}else 
			throw new InvalidCarTypeException(InvalidCarTypeException.MESSAGE);
		
	}

	
	


}