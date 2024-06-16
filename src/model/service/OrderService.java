package model.service;

import model.dto.OrderDto;
import model.entity.Order;
import model.entity.Product;

import java.util.List;

public interface OrderService {
    List<OrderDto> queryAllNewOrder();
    int updateOrderById(Integer id);
    int deleteOrderById(Integer id);
    void addNewOrder(OrderDto orderDto);
    OrderDto searchOrderById(Integer id);
}