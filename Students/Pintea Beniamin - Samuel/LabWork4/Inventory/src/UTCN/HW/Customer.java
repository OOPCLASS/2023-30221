package UTCN.HW;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    String name;
    String email;
    String addres;

    List<Order> history = new ArrayList<Order>();

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getAddres() {
        return addres;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void addOrder(Order order) {
       history.add(order);
    }

    public void showHistory() {
        System.out.println("Customer " + name + "'s History");
        for (Order order : history) {
            order.showOrderDetails();
        }
    }

}
