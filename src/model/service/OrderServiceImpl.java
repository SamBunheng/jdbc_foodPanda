package model.service;

import mapper.Mapper;
import model.dao.OrderDao;
import model.dao.OrderDaoImpl;
import model.dto.CustomerDto;
import model.dto.OrderDto;
import model.dto.ProductDto;
import model.entity.Order;
import model.entity.Product;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private final OrderDao orderDao = new OrderDaoImpl();
    @Override
    public List<OrderDto> queryAllNewOrder() {
        return orderDao.queryAllOrders().stream().map(Mapper::fromOrderToOrderDto).toList();
    }

    @Override
    public int updateOrderById(Integer id) {
        Order existingOrder = orderDao.searchOrderById(id);
        if (existingOrder != null) {
            // Update the order with new details. For simplicity, let's just set a new description
            existingOrder.setOrderDescription("Updated Description");
            orderDao.updateOrderById(existingOrder.getId());
            return 1; // Indicate success
        }
        return 0; // Indicate failure
    }

    @Override
    public int deleteOrderById(Integer id) {
        Order existingOrder = orderDao.searchOrderById(id);
        if (existingOrder != null) {
            orderDao.deleteOrderById(existingOrder.getId());
            return 1; // Indicate success
        }
        return 0; // Indicate failure
    }

    @Override
    public void addNewOrder(OrderDto orderDto) {
        Order order = Order.builder()
                .orderName(orderDto.orderName())
                .orderDescription(orderDto.orderDescription())
                .orderAt(orderDto.orderAt())
                .id(orderDto.customer().getId())
                .build();
        orderDao.addNewOrder(order);
    }

    @Override
    public OrderDto searchOrderById(Integer id) {
        Order order = orderDao.searchOrderById(id);
        if (order != null) {
            OrderDto orderDto = Mapper.fromOrderToOrderDto(order);
            System.out.println("Order Name: " + orderDto.orderName());
            System.out.println("Order Description: " + orderDto.orderDescription());
            System.out.println("Customer ID: " + orderDto.customer().getId());
            System.out.println("Order At: " + orderDto.orderAt());
            return orderDto;
        } else {
            System.out.println("[!] Order not found");
            return null;
        }
    }
}