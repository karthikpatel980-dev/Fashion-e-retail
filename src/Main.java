// ASSIGNMENT 3 – COMPLEX MODULE
// Fashion E-Retail Platform – Order Processing + Payment Strategy (Simplified)

class ProductVariant {
    String name;
    double price;
    int stock;

    ProductVariant(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    boolean reserve(int qty) {
        if (stock >= qty) {
            stock -= qty;
            return true;
        }
        return false;
    }

    void release(int qty) {
        stock += qty;
    }
}

interface PaymentStrategy {
    boolean pay(double amount);
}

class StripePayment implements PaymentStrategy {
    public boolean pay(double amount) {
        System.out.println("Stripe payment processed for: $" + amount);
        return true; 
    }
}

class PayPalPayment implements PaymentStrategy {
    public boolean pay(double amount) {
        System.out.println("PayPal payment processed for: $" + amount);
        return true;
    }
}

class Order {
    String status = "PENDING";
    double total;

    Order(double total) {
        this.total = total;
    }

    void markPaid() {
        status = "PAID";
    }

    void markFailed() {
        status = "FAILED";
    }
}

public class Main {
    public static void main(String[] args) {

        ProductVariant tshirt = new ProductVariant("T-Shirt Black M", 29.99, 5);

        boolean reserved = tshirt.reserve(1);
        if (!reserved) {
            System.out.println("Stock unavailable.");
            return;
        }

        Order order = new Order(29.99);

        PaymentStrategy paymentMethod = new StripePayment();

        boolean success = paymentMethod.pay(order.total);

        if (success) {
            order.markPaid();
            System.out.println("Order Completed! Status: " + order.status);
        } else {
            order.markFailed();
            tshirt.release(1);
            System.out.println("Order Failed. Status: " + order.status);
        }
    }
}
