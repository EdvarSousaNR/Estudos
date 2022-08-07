package entities;

import entities.Client;
import entities.enums.OrdemStatus;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.LinkedList;

public class Order {

  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");

  private Date moment;
  private OrdemStatus status;

  private Client client;
  private LinkedList<OrderItem> itens = new LinkedList<>();
  
  
  public Order(){}
  
  public Order(Date moment, OrdemStatus status, Client client){
    
    this.moment = moment;
    this.status = status;
    this.client = client;
  }
  
  public Date getMoment(){
    
    return moment;
    
  }
  
  public void setMoment(Date moment){
    
    this.moment = moment;
    
  }
  
  public OrdemStatus getStatus(){
    
    return status;
    
  }
  
  public Client getClient(){
    
    return client;
    
  }
  
  public void setClient(Client client){
    
   this.client = client;
   
  }
  
  private LinkedList<OrderItem> getItens(){
    
    return itens;
  }
  
  public void addItens(OrderItem item){
    
    itens.add(item);
  }
  
  public void removeItens(OrderItem item){
    
    itens.remove(item);
    
  }
  public double total(){
    
    double sum = 0.0;
    
    for(OrderItem item : itens){
      
      sum += item.subTotal();
    }return sum;
  }
  
  @Override
  public String toString(){
    
    StringBuilder sb = new StringBuilder();
    sb.append("Data do Pedido: ");
		sb.append(sdf.format(moment) +"\n");
		sb.append("Status do Pedido: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("items do Pedido:\n");
		for (OrderItem item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
           return sb.toString();
  }
  
  
}
