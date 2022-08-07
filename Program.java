package Aplication;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrdemStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Program {

  public static void main(String[] args) throws ParseException {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    System.out.println("Dados do Cliente");
    System.out.print("Nome :");
    String name = sc.nextLine();
    System.out.print("Email :");
    String email = sc.nextLine();
    System.out.print("Data de Nascimento :");
    Date birthdate = sdf.parse(sc.next());

    Client client = new Client(name, email, birthdate);

    System.out.println("Dados do Pedido");
    System.out.print("Status :");
    OrdemStatus status = OrdemStatus.valueOf(sc.next());

    Order order = new Order(new Date(), status, client);


    System.out.print("Quantidade de Pedidos :");
    int n = sc.nextInt();

    System.out.println();

    for (int i = 1; i <= n; i++) {

      sc.nextLine();
      System.out.println("Dados do #" + i + " Pedido");
      System.out.print("Produto :");
      String productName = sc.nextLine();
      System.out.print("Preço : ");
      double productPrice = sc.nextDouble();

      Product product = new Product(productName, productPrice);

      System.out.print("Quantidade :");
      int quantity = sc.nextInt();

      OrderItem it = new OrderItem(quantity, productPrice, product);

      order.addItens(it);
    }

    System.out.println();
    System.out.println("Resumo do Pedido");
    System.out.print(order);
    

    sc.close();
  }
}
