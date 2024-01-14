## Inventory Management System for a Store

### Description:
You are tasked with developing an inventory management system for a retail store. The system should allow the store to keep track of its products, customer orders, and customer purchase history. This system should help the store manage its inventory and provide insights into customer buying habits.

### Key Features:

1. **Product Class:**
   - Create a `Product` class to represent items available in the store. Each product should have attributes like a unique ID, name, description, price, and quantity in stock.
   - Implement methods for adding new products to the inventory and updating product information.
   - Implement a method to display product details.

2. **Order Class:**
   - Create an `Order` class to represent a customer's order. Each order should have a unique order ID, a reference to the customer who placed the order, and a list of products in the order along with their quantities.
   - Implement methods for adding products to an order, calculating the total order amount, and displaying the order details.

3. **Customer Class:**
   - Create a `Customer` class to represent store customers. Each customer should have a unique customer ID, name, contact information, and a history of orders placed.
   - Implement methods for creating a new order, adding it to the customer's order history, and displaying the customer's order history.

4. **Inventory Management:**
   - Develop a system to manage the store's inventory, allowing the addition of new products, updating quantities when products are sold, and tracking product availability.
   - Implement methods to display the list of available products and their stock levels.

### Main Class:
   - Create a main class that demonstrates the functionality of the system.
   - Initialize some products and add them to the store's inventory.
   - Create customer profiles and have them place orders.
   - Display product details, customer order history, and the current list of available products in the store.

By creating and interacting with instances of the `Product`, `Order`, and `Customer` classes within the inventory management system, students will gain a solid understanding of how to design classes and work with objects, methods, and attributes in an OOP context. This problem will also introduce the concept of maintaining relationships between different classes.
