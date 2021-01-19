package com.cg.cars.service;
/** The ICarServiceImplTest class provides testing of ICarServiceImpl layer
 *   
 * @author Rukumbai's
 * 
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.beans.Address;
import com.cg.cars.beans.Car;
import com.cg.cars.beans.Customer;
import com.cg.cars.dao.ICarRepository;
import com.cg.cars.exception.CarIdNotFoundException;
import com.cg.cars.exception.InvalidCarTypeException;
@SpringBootTest
class ICarServiceImplTest {

@MockBean
ICarRepository  carRepo;


@Autowired
public ICarServiceImpl service;
LocalDate date;

	@Test
	void AddCarDetailsPassed() throws Exception {
		
		Address address=new Address("3A","JPNNagar","Miyaour","Hyd","TS",1234);
		Customer customer=new Customer(2,"ruku","abc@gmail.com","998844534",LocalDate.of(1999, 12, 2),address);
		Car car=new Car(100,"RollsRoyce","vewlar2","e345",LocalDate.of(1999, 12, 1),"TS",customer);
		when(carRepo.save(car)).thenReturn(car);
		assertEquals(car,service.addCar(car));
	}

	@Test
	void RemoveCarDetailsBasedOnId() throws CarIdNotFoundException {
		Address address=new Address("3A","JPNNagar","Miyaour","Hyd","TS",1234);
		Customer customer=new Customer(2,"ruku","abc@gmail.com","998844534",LocalDate.of(1999, 12, 2),address);
		Car car=new Car(15,"RollsRoyce","vewlar2","e345",LocalDate.of(1999, 12, 1),"TS",customer);
		long carId=car.getCarId();
		Optional<Car> cars=Optional.of(car);
		when(carRepo.findById(carId)).thenReturn(cars);
		Mockito.when(carRepo.deleteById(carId)).thenReturn(car);
		assertEquals(service.removeCar(carId),car);
	}

	@Test
	void testUpdateCar() throws CarIdNotFoundException {
		Car car=new Car();
		car.setCarId(15L);
		when(carRepo.existsById(15L)).thenReturn(true);
		when(carRepo.findById(15L)).thenReturn(Optional.of(car));
		when(carRepo.save(car)).thenReturn(car);
		Car result=service.updateCar(15L, car);
		assertEquals(car,result);
		
	}

	@Test
	void testGetCarDetailsBasedOnId() throws CarIdNotFoundException {
		Address address=new Address("3A","JPNNagar","Miyaour","Hyd","TS",1234);
		Customer customer=new Customer(2,"ruku","abc@gmail.com","998844534",LocalDate.of(1999, 12, 2),address);
		Car car=new Car(1,"RollsRoyce","vewlar2","e345",LocalDate.of(1999, 12, 1),"TS",customer);
		long carId=car.getCarId();
		Optional<Car> cars=Optional.of(car);
		when(carRepo.findById(carId)).thenReturn(cars);
		Car cars2=service.getCar(carId);
		Optional<Car> cars3=Optional.of(cars2);
		assertEquals(cars3,cars);
	}

	@Test
	void testGetAllCars() {
		Address address=new Address("3A","JPNNagar","Miyaour","Hyd","TS",1234);
		Customer customer=new Customer(2,"ruku","abc@gmail.com","998844534",LocalDate.of(1999, 12, 2),address);
		Car car=new Car(1,"RollsRoyce","vewlar2","e345",LocalDate.of(1999, 12, 1),"TS",customer);
		Car car1=new Car(2,"Mercedes","mer12","e346",LocalDate.of(1999, 12, 1),"TS",customer);
		List<Car> cars=new ArrayList<Car>();
		cars.add(car);
		cars.add(car1);
		Mockito.when(carRepo.findAll()).thenReturn(cars);
		assertEquals(service.getAllCars(), cars);
		
	}

	@Test
	void testGetCarsByLocation() throws InvalidCarTypeException {
		Address address=new Address("3A","JPNNagar","Miyaour","Hyd","TS",1234);
		Customer customer=new Customer(2,"ruku","abc@gmail.com","998844534",LocalDate.of(1999, 12, 2),address);
		Car car=new Car(1,"RollsRoyce","vewlar2","e345",LocalDate.of(1999, 12, 1),"TS",customer);
		Car car1=new Car(2,"Mercedes","mer12","e346",LocalDate.of(1999, 12, 1),"AP",customer);
		List<Car> cars=new ArrayList<Car>();
		cars.add(car);
		cars.add(car1);
		Mockito.when(carRepo.findByRegistrationState("TS")).thenReturn(cars);
		assertEquals(service.getCarsByLocation("TS"),cars);
	}

	@Test
	void testGetCarsByModel() throws InvalidCarTypeException {
		Address address=new Address("3A","JPNNagar","Miyaour","Hyd","TS",1234);
		Customer customer=new Customer(2,"ruku","abc@gmail.com","998844534",LocalDate.of(1999, 12, 2),address);
		Car car=new Car(1,"RollsRoyce","vewlar2","e345",LocalDate.of(1999, 12, 1),"TS",customer);
		Car car1=new Car(2,"Mercedes","mer12","e346",LocalDate.of(1999, 12, 1),"AP",customer);
		List<Car> cars=new ArrayList<Car>();
		cars.add(car);
		cars.add(car1);
		Mockito.when(carRepo.findByModel("vewlar2")).thenReturn(cars);
		assertEquals(service.getCarsByModel("vewlar2"),cars);
	}

	@Test
	void testGetCarsByBrand() {
		Address address=new Address("3A","JPNNagar","Miyaour","Hyd","TS",1234);
		Customer customer=new Customer(2,"ruku","abc@gmail.com","998844534",LocalDate.of(1999, 12, 2),address);
		Car car=new Car(1,"RollsRoyce","vewlar2","e345",LocalDate.of(1999, 12, 1),"TS",customer);
		Car car1=new Car(2,"Mercedes","mer12","e346",LocalDate.of(1999, 12, 1),"AP",customer);
		List<Car> cars=new ArrayList<Car>();
		cars.add(car);
		cars.add(car1);
		Mockito.when(carRepo.findByBrand("Mercedes")).thenReturn(cars);
		
		
	}

}
