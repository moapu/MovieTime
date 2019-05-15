package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException {
        DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Cart cart = new Cart();
        cart.add(new Food(Food.FoodType.SODA), Food.FoodSize.S);
        cart.add(new Showing("8 PM",
                new Movie("Airplane", _dateFormat.parse("1980-07-02")),
                new Theater("#3"),
                12.00), 2);
        //cart.remove(new Food(Food.FoodType.SODA), Food.FoodSize.S);
        CartHelper.checkout(cart, new Payment(PaymentType.CASH));
    }

}
