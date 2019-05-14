package movieTime01;

import model.Cart;
import model.Food;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksandra Lee <ajl6251@psu.edu>
 */
public class CartTest
{
    @Test
    // SBI-16 As a developer, I want to test that if I put a food item in the cart and remove it,
    // then the cart is empty, so I know the code works
    public void test_remove_AddFoodItemThenRemoveIt_Returns0()
    {
        Cart cart = new Cart();
        cart.add(new Food(Food.FoodType.POPCORN), Food.FoodSize.S); // adds in cart
        cart.remove(new Food(Food.FoodType.POPCORN), Food.FoodSize.S); // Then, removes from cart

        assertEquals("should be empty", 0, cart.getFoodCount());
    }

    @Test
    // SBI-17 As a developer, I want to test that if I put 3 food items in the cart that the total amount is correct,
    // then the cart is empty, so I know the code works
    public void test_remove_AddMultipleProductToCartToGetTotal_Returns0()
    {
        Cart cart = new Cart();
        Food food1 = new Food(Food.FoodType.POPCORN);
        Food food2 = new Food(Food.FoodType.SODA);
        Food food3 = new Food(Food.FoodType.POPCORN);

        cart.add(food1, Food.FoodSize.S);
        cart.add(food2, Food.FoodSize.M);
        cart.add(food3, Food.FoodSize.L);

        assertEquals("should be 15.0", String.valueOf(15.0), String.valueOf(cart.getTotal()));

        cart.remove(food1, Food.FoodSize.S);
        cart.remove(food2, Food.FoodSize.M);
        cart.remove(food3, Food.FoodSize.L);

        assertEquals("should be empty", 0, cart.getFoodCount());

    }
}
