package model;

import java.util.List;

public class FoodHelper
{
    private static FakeDataStorage _dataStorage = new FakeDataStorage();

    public static void main(String[] args)
    {
        List<Food> results = FoodHelper.getAll();
        for (Food food : results)
        {
            // the size will be null
            // but its expected
            System.out.println(food.getDescription() + " | " + food.getSize());
        }

        System.out.println("-----------");

        List<Food> results2 = FoodHelper.getFood(Food.FoodType.POPCORN);
        for (Food food : results2)
        {
            System.out.println(food.getDescription() + " | " + food.getSize());
        }
    }

    // @author Junyu Ren <jxr5525@psu.edu>
    // returns a list of food
    // SBI-08
    public static List<Food> getAll()
    {
        return _dataStorage.getAllFood();
    }

    // @author Junyu Ren <jxr5525@psu.edu>
    // return a list of same food name
    public static List<Food> getFood(Food.FoodType foodType)
    {
        return _dataStorage.getFood(foodType);
    }
}
