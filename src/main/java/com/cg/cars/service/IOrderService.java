package com.cg.cars.service;
/** This is an interface which defines CRUD methods for Order service
 * 
 * @author Nagasri's
 *
 */

 

import java.util.List;

 

import com.cg.cars.beans.Order;
import com.cg.cars.exception.DuplicateOrderException;
import com.cg.cars.exception.OrderIdNotFoundException;
import com.cg.cars.exception.OrderNotFoundException;

 


public interface IOrderService {
    public Order addOrder(Order order) throws DuplicateOrderException ;
    public Order removeOrder(long id) throws OrderIdNotFoundException;
    public Order  updateOrder(long id, Order order) throws  OrderNotFoundException ; 
    public Order  getOrderDetails(long id) throws OrderIdNotFoundException ;
    public List<Order> getAllOrders(); 

 

}