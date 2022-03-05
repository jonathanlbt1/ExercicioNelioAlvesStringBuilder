package Application;

import Entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter cliente Data: ");
        System.out.print("Name: ");
        String name = scan.nextLine();

        System.out.print("Email: ");
        String email = scan.next();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(scan.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scan.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int n = scan.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            scan.nextLine();
            String productName = scan.nextLine();
            System.out.print("Product price: ");
            double productPrice = scan.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int quantity = scan.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            order.addItems(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);

        scan.close();

    }
}
