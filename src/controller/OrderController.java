package controller;

import model.dto.CustomerDto;
import model.dto.OrderDto;
import model.service.CustomerService;
import model.service.CustomerServiceImpl;
import model.service.OrderService;
import model.service.OrderServiceImpl;

import java.util.List;

public class OrderController {
    OrderService orderService = new OrderServiceImpl();
    public void addNewOrder(OrderDto orderDto){orderService.addNewOrder(orderDto);}
    public List<OrderDto> queryAllOrder(){return orderService.queryAllNewOrder();}
    public void searchOrderById(Integer id) {
        orderService.searchOrderById(id);
    }
    public void deleteOrder(Integer id){orderService.deleteOrderById(id);}
    public void updateOrder(Integer id){orderService.updateOrderById(id);}
}