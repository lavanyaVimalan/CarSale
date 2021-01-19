package com.cg.cars.controller;
/** This is a Controller class for Order module 
 * 
 * @author Nagasri's
 *
 */
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;

 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.cars.beans.Order;
import com.cg.cars.exception.CarIdNotFoundException;
import com.cg.cars.exception.DuplicateCarIdFoundException;
import com.cg.cars.exception.DuplicateOrderException;
import com.cg.cars.exception.OrderIdNotFoundException;
import com.cg.cars.exception.OrderNotFoundException;
import com.cg.cars.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private IOrderService orderService;
    /** This method adds the order details 
	 * 
	 * @param Order entity details
     * @throws DuplicateOrderException 
	 * 
	 * 
	 */


    //http://localhost:9092/orders/addOrder- method POST

    @PostMapping("/addOrder")
    public ResponseEntity<String> addOrder(@RequestBody Order order) throws DuplicateOrderException {
        Order order1=orderService.addOrder(order);
        ResponseEntity<String> response;
        if(order1!=null) {
            response=new ResponseEntity<String>("Order with "+order.getOrderId()+" is added.",HttpStatus.CREATED);
        }else {
            response=new ResponseEntity<String>("Order with "+order.getOrderId()+" is not  added.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
        }

	/** This method deletes the Order details 
	 * 
	 * @param Order entity details and Order - orderId
	 * 
	 * 
	 */

    //http://localhost:9092/orders/deleteOrder- method DELETE	

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<String> removeOrder(@PathVariable(value="orderId") long id)throws OrderIdNotFoundException {
        Order order=orderService.removeOrder(id);
        ResponseEntity<String> response;
        if(order!=null) {
            response=new ResponseEntity<String>("Order with "+order.getOrderId()+" is deleted.",HttpStatus.CREATED);
        }else {
            response=new ResponseEntity<String>("Order with "+order.getOrderId()+" is not  found.",HttpStatus.NOT_FOUND);
        }
        return response;
        }

	/** This method updates the Order details 
	 * 
	 * @param Order entity details and Order - orderId
	 * 
	 * 
	 */
	

  //http://localhost:9092/orders/updateOrder- method PUT

    @PutMapping("/updateOrder/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value="orderId") long id,@RequestBody Order order) throws OrderNotFoundException {
        if(orderService.updateOrder(id, order)!=null) {
            return new ResponseEntity<Order>(order,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("Order with "+order.getOrderId()+"is not found",HttpStatus.NOT_FOUND) ;
    }
    /** This method returns the Order details based on orderId
	 * 
	 * @param Order - orderId 
	 * 
	 * 
	 */

    //http://localhost:9092/orders/getOrderDetails- method GET

    @GetMapping("/getOrderDetails/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable(value="orderId") long id)throws OrderIdNotFoundException {
        Order order=orderService.getOrderDetails(id);
        if(order==null) {
            return new ResponseEntity("Order  with "+order.getOrderId()+"is not found. ",HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<Order>(order,HttpStatus.OK);
    
    }
    /** 
	 * 
	 *This method returns the list of Order details  
	 * 
	 * 
	 */

  //http://localhost:9092/orders/getAllOrders- method GET

    @ResponseStatus(value=HttpStatus.OK)
    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders(); 
    }
    @ExceptionHandler(value=OrderIdNotFoundException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR,reason="Duplicate Id Found")
	public void handleException(OrderIdNotFoundException e) {
		
	}
	@ExceptionHandler(value=OrderNotFoundException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR,reason="Duplicate Id Found")
	public void handleException(OrderNotFoundException e) {
		
	}
    
}