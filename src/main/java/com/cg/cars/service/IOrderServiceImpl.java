package com.cg.cars.service;

/** The IOrderServiceImpl class provides access to repository methods to CRUD operations Order details 
 * 
 * 
 * @author Nagasri's
 *
 */
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.beans.Order;
import com.cg.cars.dao.IOrderRepository;
import com.cg.cars.exception.DuplicateOrderException;
import com.cg.cars.exception.OrderIdNotFoundException;
import com.cg.cars.exception.OrderNotFoundException;

@Service
public class IOrderServiceImpl implements IOrderService {
	
	private static final Logger logger = LogManager.getLogger(IOrderServiceImpl.class);
	
	@Autowired
	private IOrderRepository dao;

	@Override
	public Order addOrder(Order order) throws DuplicateOrderException {
		Order order1 = dao.save(order);
		if (order1 != null) {
			logger.info("Order Added Successfully...!");
			return order1;
		} else {
			throw new DuplicateOrderException(DuplicateOrderException.MESSAGE);
		}
	}

	@Override
	public Order removeOrder(long id) throws OrderIdNotFoundException {
		Order order = dao.findById(id)
				.orElseThrow(() -> new OrderIdNotFoundException(OrderIdNotFoundException.MESSAGE));
		dao.delete(order);
		logger.info("Order Deleted Successfully..!");
		return order;
	}

	@Override
	public Order updateOrder(long id, Order order) throws OrderNotFoundException {
		if (dao.existsById(id)) {
			logger.info("Order Updated Successfully...!");
			return dao.save(order);
		}
		throw new OrderNotFoundException(OrderNotFoundException.MESSAGE);
	}

	@Override
	public Order getOrderDetails(long id) throws OrderIdNotFoundException {
		Optional<Order> order = dao.findById(id);
		if (order.isPresent()) {
			logger.info("Retrieved Order By Id Successfully..!");
			return order.get();
		}
		throw new OrderIdNotFoundException(OrderIdNotFoundException.MESSAGE);
	}

	@Override
	public List<Order> getAllOrders() {
		logger.info("Retrieved All Orders Successfully...!");
		return dao.findAll();
	}

}