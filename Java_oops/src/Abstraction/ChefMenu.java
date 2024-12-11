package Abstraction;


import java.util.*;
//Abstract class representing a Restaurant Menu
abstract class RestaurantMenu {
abstract void prepareDish();  // Abstract method - no implementation

void displayMenu() {  // Concrete method
   System.out.println("Welcome to the restaurant! Please choose from our menu.");
}
}

//Concrete class representing a specific dish (e.g., Pizza)
class Pizza extends RestaurantMenu {
@Override
void prepareDish() {
   System.out.println("Preparing a delicious pizza with cheese, tomato sauce, and pepperoni.");
}
}

//Concrete class representing a specific dish (e.g., Salad)
class Salad extends RestaurantMenu {
@Override
void prepareDish() {
   System.out.println("Preparing a fresh garden salad with lettuce, tomatoes, and cucumbers.");
}
}

public class ChefMenu {
public static void main(String[] args) {
   RestaurantMenu myDish;  // Declare a reference of type RestaurantMenu

   myDish = new Pizza();  // Abstraction - Pizza order
   myDish.displayMenu();
   myDish.prepareDish();

   myDish = new Salad();  // Abstraction - Salad order
   myDish.prepareDish();
}
}