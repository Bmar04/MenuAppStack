
import java.util.InputMismatchException;
import java.util.Scanner;



/**
 *
 * @author brandonmarquart
 */
public class MenuApp {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      boolean exit = false;
      char userIn = 'z';
      FoodItem popped = new FoodItem();
      

      System.out.println("Menu stack manager:");
      
      //creates a stack of type MyStack;
      MyStack topMenuItems = new MyStack();
      
      //Pushes some initial items into the stack
      topMenuItems.Push(new Appetizer("Nachos", 10.00));
      topMenuItems.Push(new Drink("Soda", 3.00));
      topMenuItems.Push(new MainDish("Steak", 25.00));
      
      //Loop for the program to continuously run until ready to exit
      while (!exit) {
         System.out.println("Welcome: Please select and option below");
         System.out.println("A - Display top menu item for the day");
         System.out.println("B- Add new recomendation to the stack");
         System.out.println("C - Remove recomendation from the stack");
         System.out.println("D - Exit the program");
            
         //Takes the users input
         userIn = scnr.next().charAt(0);
         
         //Switch to decide what the program should do
         switch(Character.toLowerCase(userIn)) {
           
            //Returns the top menu item for the day
            case 'a':
               System.out.println("");
               System.out.println(topMenuItems.Peek());
               System.out.println("");
               break;
            
            //Adds new menu item to the stack
            case 'b':
               try {
                  topMenuItems.Push(addItem(scnr));
                  System.out.println("");
                  System.out.println("Item has been added to menu");
                  System.out.println("");
               }
               catch (InputMismatchException imException){
                  System.out.println("Invalid input try again");
               }
            break;
            //Removes the top menu item from the stack
            case 'c':
               //Calls the pop method
               popped = topMenuItems.Pop();
               //Checks if the stack is empty
               if (popped != null) {
                  System.out.print(popped);
                  System.out.print(" has been removed from the stack");
                  System.out.println("");
               }
              
            break;
            //Exit case for the program loop   
            case 'd':
               exit = true;
               System.out.println("Program is now finished");
               break;
               
            //Checks if the input is valid   
            default:
               System.out.println("");
               System.out.println("Invalid input try again");
               System.out.println("");
               break;
         }
         
         
      }
   }
   
   /**
    * This method is used to find the information of a new item to add to the stack
    * @param scnr A Scanner used for user input
    * @return A item of type FoodItem with the respective category.
    */
   public static FoodItem addItem(Scanner scnr) {
      char userIn = 'z';
      String name;
      double price;
      
      System.out.println("Please enter what kinda of item you would like to add");
      System.out.println("A - Appetizer");
      System.out.println("B - Main Dish");
      System.out.println("C - Drink");
      System.out.println("D - Dessert");
      
      //takes the users input
      userIn = scnr.next().charAt(0);
      System.out.println("Enter a name for the item");
      scnr.nextLine();
      name = scnr.nextLine();
      System.out.println("Enter a price for the item");
      price = scnr.nextDouble();
      
      //switch to see which kind of item to add to the stack
      switch (Character.toLowerCase(userIn)) {
         
         case 'a' -> {
            return new Appetizer(name, price);
         }
         
         case 'b' -> {
            return new MainDish(name, price);
         }
         
         case 'c' -> {
            return new Drink(name, price);
         }
         
         case 'd' -> {
            return new Dessert(name, price);
         }
         
         //Makes sure the input is valid
         default -> {
            throw new InputMismatchException("Invalid input");
         }
      }
      
   }
}
