

/**
 *
 * @author Brandon Marquart
 * @version 1.0
 * @date 3/6/2024
 * 
 * This class is an implementation of a stack data structure.
 */
public class MyStack {
   private final int MENU_SIZE = 10;
   private FoodItem[] menu;
   private int index;
   FoodItem popped = new FoodItem();
   

   public MyStack() {
      menu = new FoodItem[MENU_SIZE];
      index = -1;
   }
   
   public void Push(FoodItem item) {
      if (index < MENU_SIZE) {
         index++;
         menu[index] = item;
      }
      else {
         System.out.println("Sorry the daily specials are full");
      }
   }
   
   public FoodItem Pop(){
      if (index == -1){
         System.out.println("Sorry the daily specials are empty");
         return null;
      }
      else {
         popped = menu[index];
         index--;
         return popped;
      }
   }
   
   public FoodItem Peek(){
      return menu[index];
   }
}

   
