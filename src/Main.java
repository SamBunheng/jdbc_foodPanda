import controller.CustomerController;
import controller.OrderController;
import controller.ProductController;
import model.dto.CustomerDto;
import model.dto.OrderDto;
import model.dto.ProductDto;
import model.entity.Customer;
import view.MainView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        CustomerController customerController = new CustomerController();
        OrderController orderController = new OrderController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                switch (MainView.mainMenu()) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        handleProductMenu(productController, sc);
                        break;
                    case 2:
                        handleCustomerMenu(customerController, sc);
                        break;
                    case 3:
                        handleOrderMenu(orderController, sc);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static void handleProductMenu(ProductController productController, Scanner sc) {
        while (true) {
            switch (MainView.productMenu()) {
                case 0:
                    return;
                case 1:
                    System.out.print(" Input product code: ");
                    String code = sc.next();

                    System.out.print(" Input product name: ");
                    String name = sc.next();

                    System.out.print(" Input product description: ");
                    String description = sc.next();

                    Date imported_date = Date.valueOf(LocalDate.now());
                    Date expired_date = Date.valueOf(LocalDate.of(2026, 1, 1));
                    productController.addNewProduct(new ProductDto(name, code, false, imported_date, expired_date, description));
                    break;
                case 2:
                    productController.queryAllProduct().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Input product id for search: ");
                    Integer id = sc.nextInt();
                    productController.searchProductById(id);
                    break;
                case 4:
                    System.out.print("Input product id for search for delete: ");
                    Integer idf = sc.nextInt();
                    productController.deleteProduct(idf);
                    break;
                case 5:
                    System.out.print("Input product id for search for update: ");
                    Integer uId = sc.nextInt();
                    productController.updateProduct(uId);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handleCustomerMenu(CustomerController customerController, Scanner sc) {
        while (true) {
            switch (MainView.customerMenu()) {
                case 0:
                    return;
                case 1:
                    System.out.print("Input customer id: ");
                    Integer cusID = sc.nextInt();
                    System.out.print("Input customer name: ");
                    String cName = sc.next();

                    System.out.print("Input customer email: ");
                    String cusEmail = sc.next();

                    customerController.addNewCustomer(new CustomerDto(cusID, cName, cusEmail));
                    break;
                case 2:
                    customerController.queryAllCustomer().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Input customer id for search: ");
                    Integer cSid = sc.nextInt();
                    customerController.searchCustomerById(cSid);
                    break;
                case 4:
                    System.out.print("Input customer id for search for delete: ");
                    Integer idC = sc.nextInt();
                    customerController.deleteCustomer(idC);
                    break;
                case 5:
                    System.out.print("Input customer id for search for update: ");
                    Integer upCid = sc.nextInt();
                    customerController.updateCustomer(upCid);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handleOrderMenu(OrderController orderController, Scanner sc) {
        while (true) {
            switch (MainView.orderMenu()) {
                case 0:
                    return;
                case 1:
                    System.out.print("Input order name: ");
                    String orName = sc.next();
                    System.out.print("Input description: ");
                    String oDescription = sc.next();
                    System.out.print("Input customer ID: ");
                    int oCusId = sc.nextInt();
                    Date orderedDate = Date.valueOf(LocalDate.now());
                    Customer customer = Customer.builder().id(oCusId).build();
                    orderController.addNewOrder(new OrderDto(orName, oDescription, customer, orderedDate));
                    break;
                case 2:
                    orderController.queryAllOrder().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Input order id for search: ");
                    Integer oId = sc.nextInt();
                    orderController.searchOrderById(oId);
                    break;
                case 4:
                    System.out.print("Input order id for search for delete: ");
                    Integer dOid = sc.nextInt();
                    orderController.deleteOrder(dOid);
                    break;
                case 5:
                    System.out.print("Input order id for search for update: ");
                    Integer upOid = sc.nextInt();
                    orderController.updateOrder(upOid);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
