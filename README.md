# Assignment 3 – Java Complex Module (Fashion E-Retail Platform)

This repository contains the complex module for Assignment 3.  
It demonstrates:

- Product variant example  
- Inventory reservation  
- Payment Strategy Pattern (Stripe / PayPal)  
- Order state changes (PENDING → PAID / FAILED)  
- Fully runnable Java demo using `Main.java`

---

## How to Run the Program

### 1. Go inside the `src` folder:
cd src

shell
Copy code

### 2. Compile the program:
javac Main.java

shell
Copy code

### 3. Run the program:
java Main

yaml
Copy code

You will see:
- Stock reserved  
- Payment processed  
- Order marked as **PAID**

---

## Switching Payment Method (Optional)

Inside `Main.java`, change:

PaymentStrategy paymentMethod = new StripePayment();

css
Copy code

to:

PaymentStrategy paymentMethod = new PayPalPayment();

yaml
Copy code

Then re-compile and run.

---

## Files Included
- src/Main.java (complete complex module)

This repository satisfies the Part A requirement for Assignment 3.
