package mapper;

import model.dto.CustomerDto;
import model.dto.OrderDto;
import model.dto.ProductDto;
import model.entity.Customer;
import model.entity.Order;
import model.entity.Product;

public class Mapper {
    public static CustomerDto fromCustomerDtoToCustomerDto(Customer customer){
        if (customer == null){
            return  null;
        }
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
    public static ProductDto fromProductDtoToProductDto(Product product){
        if (product == null){
            return null;
        }
        return ProductDto.builder()
                .productCode(product.getProductCode())
                .productName(product.getProductName())
                .isDeleted(product.getIsDeleted())
                .importDated(product.getImportDated())
                .expiredDate(product.getExpiredDate())
                .description(product.getDescription())
                .build();
    }
    public static OrderDto fromOrderToOrderDto(Order order){
        if (order == null){
            return null;
        }
        return OrderDto.builder()
                .orderName(order.getOrderName())
                .orderDescription(order.getOrderDescription())
                .customer(order.getCustomer())
                .orderAt(order.getOrderAt())
                .build();
    }
}