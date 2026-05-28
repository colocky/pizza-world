# Pizza World

Pizza World is a Java console point-of-sale application for a custom pizza shop. The application allows customers to create a new order, customize pizzas, add drinks, add garlic knots, review the order, and save a receipt when checkout is confirmed.


---

## Project Description

Pizza World helps automate the ordering process for a custom pizza shop. Customers can build pizzas by choosing a size, crust, toppings, sauces, sides, and stuffed crust. They can also add drinks and garlic knots to the order.

When the customer checks out, the application displays the full order details and total price. If the order is confirmed, a receipt file is created in the `receipts` folder using the order date and time.

Receipt filename format:

```text
yyyyMMdd-HHmmss.txt
```

Example:

```text
20230329-121523.txt
```

---

## Features

- Start a new order
- Cancel an order
- Add customized pizzas
- Choose pizza size:
    - Personal 8"
    - Medium 12"
    - Large 16"
- Choose crust:
    - Thin
    - Regular
    - Thick
    - Cauliflower
- Add meat toppings
- Add cheese toppings
- Add regular toppings
- Add sauces
- Add sides:
    - Red Pepper
    - Parmesan
- Choose extra toppings
- Add stuffed crust
- Add drinks by size and flavor
- Add garlic knots
- Display full order details at checkout
- Display total order price
- Save receipts to a `receipts` folder
- Store newest order items first

---

## Project Structure

```text
pizza-world/
│
├── Diagrams/
│   └── Diagram.md
│
├── receipts/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── pizzaworld/
│                   ├── Program.java
│                   │
│                   ├── data/
│                   │   └── Menu.java
│                   │
│                   ├── models/
│                   │   ├── Crust.java
│                   │   ├── Drink.java
│                   │   ├── GarlicKnots.java
│                   │   ├── Order.java
│                   │   ├── OrderItem.java
│                   │   ├── Pizza.java
│                   │   ├── PizzaSize.java
│                   │   ├── PizzaTopping.java
│                   │   ├── ProductSize.java
│                   │   ├── Sauce.java
│                   │   └──toppings/
│                   │       ├── CheeseTopping.java
│                   │       ├── MeatTopping.java
│                   │       ├── RegularTopping.java
│                   │       └── Topping.java
│                   │
│                   ├── services/
│                   │   └── ReceiptWriter.java
│                   │
│                   │
│                   └── ui/
│                       └── UserInterface.java
│
├── .gitignore
├── pom.xml
└── README.md
```

---

## Main Screens

### Home Screen

The home screen allows the user to:

```text
1) Start a Fresh Order
0) Exit
```
![img.png](screenshots/img.png)

### Order Screen

The order screen allows the user to:

```text
1) Build Your Pizza
2) Add a Drink
3) Add Garlic Knots
4) Checkout
0) Cancel Order
```
![img_1.png](screenshots/img_1.png)
### Add Pizza Screen

The pizza screen walks the customer through:

```text
Pizza size
Crust style
Meat toppings
Cheese toppings
Regular toppings
Sauces
Sides
Stuffed crust
```

### Checkout Screen

The checkout screen displays:

```text
Order details
Pizza customization
Drink details
Garlic knots
Total price
Confirm or cancel options
```

## Class Diagram

```mermaid
classDiagram

class Program {
  +main(String[] args)
}

class UserInterface {
  -Scanner scanner
  -Order currentOrder
  -ReceiptWriter receiptWriter
  +showHomeScreen()
  +showOrderScreen()
  +showAddPizzaScreen()
  +showAddDrinkScreen()
  +showAddGarlicKnotsScreen()
  +showCheckoutScreen() boolean
  -addToppingsFromCategory(Pizza pizza, ArrayList toppings, String title)
  -addSauces(Pizza pizza)
  -addSides(Pizza pizza)
  -readInt(String prompt) int
  -readString(String prompt) String
  -readYesNo(String prompt) boolean
  -chooseFromList(ArrayList items, String prompt)
}

class Menu {
  +getPizzaSizes() ArrayList
  +getCrusts() ArrayList
  +getMeatToppings() ArrayList
  +getCheeseToppings() ArrayList
  +getRegularToppings() ArrayList
  +getSauces() ArrayList
  +getSides() ArrayList
  +getDrinkSizes() ArrayList
  +getDrinkFlavors() ArrayList
}

class ReceiptWriter {
  -String receiptDirectory
  +ReceiptWriter(String receiptDirectory)
  +saveReceipt(Order order)
}

class Order {
  -ArrayList items
  -LocalDateTime orderDateTime
  +Order()
  +addItem(OrderItem item)
  +removeItem(OrderItem item)
  +getItems() ArrayList
  +getOrderDateTime() LocalDateTime
  +getTotal() double
  +isValidOrder() boolean
  +getOrderDetails() String
}

class OrderItem {
  <<interface>>
  +getName() String
  +getPrice() double
  +getDetails() String
}

class Pizza {
  -double stuffedCrustPrice
  -PizzaSize size
  -Crust crust
  -ArrayList toppings
  -ArrayList sauces
  -ArrayList sides
  -boolean stuffedCrust
  +Pizza(PizzaSize size, Crust crust)
  +addTopping(PizzaTopping topping)
  +addSauce(Sauce sauce)
  +addSide(PizzaTopping side)
  +setStuffedCrust(boolean stuffedCrust)
  +getSize() PizzaSize
  +getCrust() Crust
  +getToppings() ArrayList
  +getSauces() ArrayList
  +getSides() ArrayList
  +hasStuffedCrust() boolean
  +getName() String
  +getPrice() double
  +getDetails() String
}

class Drink {
  -ProductSize size
  -String flavor
  +Drink(ProductSize size, String flavor)
  +getSize() ProductSize
  +getFlavor() String
  +getName() String
  +getPrice() double
  +getDetails() String
}

class GarlicKnots {
  -double price
  -int quantity
  +GarlicKnots(int quantity)
  +getQuantity() int
  +getName() String
  +getPrice() double
  +getDetails() String
}

class PizzaSize {
  -String name
  -int inches
  -double basePrice
  +PizzaSize(String name, int inches, double basePrice)
  +getName() String
  +getInches() int
  +getBasePrice() double
  +toString() String
}

class ProductSize {
  -String name
  -double price
  +ProductSize(String name, double price)
  +getName() String
  +setName(String name)
  +getPrice() double
  +setPrice(double price)
  +toString() String
}

class Crust {
  -String name
  +Crust(String name)
  +getName() String
  +toString() String
}

class Sauce {
  -String name
  +Sauce(String name)
  +getName() String
  +toString() String
}

class PizzaTopping {
  -Topping topping
  -boolean extra
  +PizzaTopping(Topping topping, boolean extra)
  +getTopping() Topping
  +isExtra() boolean
  +getPrice(PizzaSize size) double
  +getDetails() String
}

class Topping {
  <<abstract>>
  -String name
  +Topping(String name)
  +getName() String
  +getPrice(PizzaSize size, Boolean extra) double
  +toString() String
}

class MeatTopping {
  +MeatTopping(String name)
  +getPrice(PizzaSize size, Boolean extra) double
}

class CheeseTopping {
  +CheeseTopping(String name)
  +getPrice(PizzaSize size, Boolean extra) double
}

class RegularTopping {
  +RegularTopping(String name)
  +getPrice(PizzaSize size, Boolean extra) double
}

Program --> UserInterface
UserInterface --> Order
UserInterface --> ReceiptWriter
UserInterface --> Menu
UserInterface --> Pizza
UserInterface --> Drink
UserInterface --> GarlicKnots
UserInterface --> PizzaTopping

ReceiptWriter --> Order

Order "1" o-- "0..*" OrderItem

OrderItem <|.. Pizza
OrderItem <|.. Drink
OrderItem <|.. GarlicKnots

Pizza --> PizzaSize
Pizza --> Crust
Pizza "1" o-- "0..*" PizzaTopping
Pizza "1" o-- "0..*" Sauce

PizzaTopping --> Topping
Topping <|-- MeatTopping
Topping <|-- CheeseTopping
Topping <|-- RegularTopping

Drink --> ProductSize

Menu ..> PizzaSize
Menu ..> Crust
Menu ..> Sauce
Menu ..> ProductSize
Menu ..> MeatTopping
Menu ..> CheeseTopping
Menu ..> RegularTopping
```

---

## Receipt Example

```text
PIZZA WORLD Receipt
═══════════════════════════════════════════════
Order Time: 2026-05-28T14:30:15

Item 1:
Medium pizza base: $12.00
Crust: Regular
Meats:
 Pepperoni               $ 2.00
Meat total: $ 2.00
Cheeses:
 Extra Mozzarella        $ 2.10
Cheese total: $ 2.10
Regular toppings:
 Onions                  $ 0.00
Regular toppings total: $ 0.00
Sauces:
 Marinara                $ 0.00
Sauces total: $ 0.00
Stuffed crust: $ 2.00
Sides:
 Red Pepper              $ 0.00
Sides total: $ 0.00
--------------------------------
Total: $18.10

Total: $18.10
```