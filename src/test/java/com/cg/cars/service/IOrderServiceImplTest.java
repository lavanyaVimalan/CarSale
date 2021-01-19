package com.cg.cars.service;
/** The IOrderServiceImplTest class provides testing of IOrderServiceImpl layer
 *   
 * @author Nagasri's
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

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
import com.cg.cars.beans.Customer;
import com.cg.cars.beans.Order;
import com.cg.cars.dao.IOrderRepository;
import com.cg.cars.exception.DuplicateOrderException;
import com.cg.cars.exception.OrderIdNotFoundException;
import com.cg.cars.exception.OrderNotFoundException;
@SpringBootTest
class IOrderServiceImplTest {

	
		  @MockBean
		    private IOrderRepository dao;
		    @Autowired
		    private IOrderServiceImpl orderService;
		   

			/*
			 * 
			 * This method tests whether the order details are added or not
			 * 
			 */

		    
		    @Test
		    void testAddOrder() throws DuplicateOrderException  {
		        Address address = new Address("310","gowthami","Sbe","Cbe","Tamilnadu",5556);
		         Customer c = new Customer(7,"Karthika", "abc@gamil.com","988754326",LocalDate.of(1999, 9, 8),address);
		         Order order = new Order(14L, 990, LocalDate.of(1997, 9, 8), c,"card");
		            when(dao.save(order)).thenReturn(order);
		            assertEquals(order,orderService.addOrder(order));
		        }

			/*
			 * 
			 * This method tests whether the order details are deleted or not
			 * 
			 */
			

		    @Test
			void testRemoveOrder() throws OrderIdNotFoundException { 
				Address address = new Address("321","Sri krishna nagar","Cbe","Cbe","Tamilnadu",5556);
			     Customer c = new Customer(10,"Karthi", "abc@gamil.com","988754321",LocalDate.of(1999, 9, 8),address);
				 
				Order order = new Order(351, 990.0, LocalDate.of(1999, 9, 8),c,"card");
				long orderId=order.getOrderId();
				Optional<Order> order1=Optional.of(order);
		
				Mockito.when(dao.findById(orderId)).thenReturn(order1);
				order=orderService.removeOrder(orderId);
				Optional<Order> order2=Optional.of(order);
	            assertEquals(order2,order1);
	        }
		    /*
			 * 
			 * This method tests whether the order details are updated or not
			 * 
			 */


		    @Test
		    public void testUpdateOrder() throws OrderNotFoundException {
		    	 Address address1 = new Address("310","gowthami","Sbe","Cbe","Tamilnadu",5556);
		         Customer c1 = new Customer(11,"Karthik", "abd@gamil.com","988754361",LocalDate.of(1998, 7, 8),address1);
		         Order order = new Order(15L, 990, LocalDate.of(1997, 9, 8), c1,"card");
		         order.setOrderId(12L);
		        when(dao.existsById(12L)).thenReturn(true);
				when(dao.findById(12L)).thenReturn(Optional.of(order));
					
		        when(dao.save(order)).thenReturn(order);
		         Order result=orderService.updateOrder(12L,order);
		            assertEquals(result,order);
		            
		        
		    	
		    }

			/*
			 * 
			 * This method is used to get the order details based on orderId
			 * 
			 */

		    @Test
			void testgetOrderDetails() throws  DuplicateOrderException, OrderIdNotFoundException{
				Address address = new Address("320","nandhu","Cbe","Cbi","kerala",55564);
			     Customer c = new Customer(11,"Karthik", "abd@gamil.com","988754361",LocalDate.of(1998, 7, 8),address);
				 
				Order order = new Order(351L, 990.0, (LocalDate.of(1999, 9, 8)),c,"card");
				long orderId=order.getOrderId();
				Optional<Order> order1=Optional.of(order);
				Mockito.when(dao.findById(orderId)).thenReturn(order1);
				Order order2 =orderService.getOrderDetails(orderId);
				Optional<Order> order3=Optional.of(order2);
				assertEquals(order3,order1 );
				}

			/*
			 * 
			 * This method is used to get all the order details 
			 * 
			 */

		    @Test
			void testgetAllOrders() {
		    	List<Order> orderList1=new ArrayList<Order>();
		    	Address address = new Address("320","nandhu","Cbe","Cbi","kerala",55564);
			     Customer c = new Customer(11,"Karthik", "abd@gamil.com","988754361",LocalDate.of(1998, 7, 8),address);
				 
				Order order = new Order(351L, 990.0, (LocalDate.of(1999, 9, 8)),c,"card");
				Order order1 = new Order(351L, 990.0, (LocalDate.of(1999, 9, 8)),c,"card");
				Order order2 = new Order(351L, 990.0, (LocalDate.of(1999, 9, 8)),c,"card");
				orderList1.add(order);
				orderList1.add(order1);
				orderList1.add(order2);
				Mockito.when(dao.findAll()).thenReturn(orderList1);
				
				assertEquals(orderService.getAllOrders(), orderList1);
				

			}
			

	}


