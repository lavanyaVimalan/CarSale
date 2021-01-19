package com.cg.cars.dao;
/** This is a repository class for Car module 
 * 
 * @author Rukumbai's
 *
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.cars.beans.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long>{
	Car deleteById(long carId);
	List<Car> findByRegistrationState(String registrationState);
	List<Car> findByModel(String model);
	List<Car> findByBrand(String brand);
	

	

}