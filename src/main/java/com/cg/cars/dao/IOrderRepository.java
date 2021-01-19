package com.cg.cars.dao;
/** This is a repository class for Order module 
 * 
 * @author Nagasri's
 *
 */

 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.cg.cars.beans.Order;
 
public interface IOrderRepository extends JpaRepository<Order,Long>{
 
}

