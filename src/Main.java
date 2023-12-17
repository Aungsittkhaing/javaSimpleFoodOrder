import project.ask.Food;

import javax.swing.*;
import java.util.Arrays;
public class Main {
    String title = "Food Service Bar";
    String loginMsg = "Please Insert Your member codes";
    String orderMore = "Would you like to buy again?";
    int orderCount = 0;
    int[] orders = new int[10];
    String[] memberCodes = {"1001","1002","1003","1004","1005"};

    Food[] foods = {
            new Food("1. Chicken Curry", 1, 5000),
            new Food("2. Pork Curry", 2, 4000),
            new Food("3. Fish Curry", 3, 3000),
            new Food("4. Beef Curry", 4, 6000),
            new Food("5. French Fried", 5, 5500),
            new Food("6. M-150", 6, 1000),
            new Food("7. Beer Chan", 7, 8000),
            new Food("8. Red-Bull", 8, 1500),
            new Food("9. Pepsi", 9, 2000),
            new Food("10. Coca Cola", 10, 2200),

    };

    public static void main(String[] args) {
        Main main = new Main();
        if (main.memberLogin()){
            String result = main.showInputDialog("1. Foods \t 2. Drinks");
            if (result.contentEquals("1")){
                main.orderFood(main.getFood());
            }else {
                main.orderFood(main.getDrink());
            }
        }
    }
    //order foods with order lists
    public void orderFood(String orderList){
        boolean bol = true;
        int i = 0;
        while (bol){
            String order = showInputDialog(orderList);
            orders[i++] = Integer.parseInt(order);
            orderCount++;
            System.out.println(Arrays.toString(orders));
            int ret = showConfirmDialog(orderMore);
            //to display yes, no, no
            switch (ret){
                case 0:
                    bol = true;
                    break;
                case 1:
                    bol = false;
                    break;
                case 2:
                    bol = false;
                    break;
            }
            if (!bol){
                showBill();
            }
        }
    }
    //to display the bill
    public void showBill(){
        String bill = "";
        int total = 0;
        for (int i = 0; i< orderCount; i++){
            bill += getCurrentFood(orders[i]).getName() + "\t" + getCurrentFood(orders[i]).getPrice();
            total += getCurrentFood(orders[i]).getPrice();
        }
        showMessageDialog(bill,total);
    }
    //show message dialog with orders and total prices
    public void showMessageDialog(String orders, int total){
        JOptionPane.showMessageDialog(null, orders + "\n Total price =>" + total );
    }
    //to display current foods
    public Food getCurrentFood(int id){
        Food food = null;
        for (int i = 0; i < foods.length; i++){
            if (foods[i].getId() == id){
                food = foods[i];
                break;
            }
        }
        return food;
    }
    public int showConfirmDialog(String message){
        return JOptionPane.showConfirmDialog(null, message);
    }
    //user login
    public boolean memberLogin(){
        boolean auth = true;
        while (auth){
           String code = showInputDialog(loginMsg);
           boolean bol = Arrays.asList(memberCodes).contains(code);
           auth = !bol;
        }
        return true;
    }
    //to display foods
    public String getFood(){
        String data = "";
        for (int i = 0; i< foods.length/2; i++){
            data += foods[i].getName() + "\n";
        }
        return data;
    }
    //to display drinks
    public String getDrink(){
        String data = "";
        for (int i = 5; i< foods.length; i++){
            data += foods[i].getName() + "\n";
        }
        return data;
    }
    //user input with dialog
    public String showInputDialog(String message){
        return JOptionPane.showInputDialog(message);
    }
}