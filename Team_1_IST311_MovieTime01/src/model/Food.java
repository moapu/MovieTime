package model;
// FoodType enum will be either POPCORN or SODA.
// FoodSize enum is S, M, or L
// @author Aleksandra Lee <ajl6251@psu.edu>

import java.util.Arrays;

public class Food
{
    private String _description; // Food descrption
    private String _size;        // Size of food
    private double _price;      // Price of food

    // @param Description the description of FoodType
    public Food(FoodType foodType)
    {
        this._description = foodType.toString();
    }

    // @param Description the description of FoodType
    // @param Size the size of FoodType
    public Food(FoodType foodType, FoodSize foodSize)
    {
        this._description = foodType.toString();
        this._size = foodSize.toString();
    }

    public enum FoodType
    {
        POPCORN, SODA
    }

    public enum FoodSize
    {
        S, M, L;
    }

    // returns the FoodType
    public FoodType returnFoodType()
    {
        return FoodType.valueOf(_description);
    }

    // Tests methods
    public static void main(String[] args)
    {
        Food food = new Food(FoodType.POPCORN, FoodSize.S);
        System.out.println(food.getAllFood());
    }

    // @return FoodType in String value
    public String getAllFood()
    {
        return Arrays.toString(FoodType.values());
    }

    // @returns Description
    public String getDescription()
    {
        return _description;
    }

    //@param Description Gets description
    public void setDescription(FoodType foodType)
    {
        this._description = foodType.toString();
    }

    // Gets Food Size
    public String getSize()
    {
        return _size;
    }

    // @param Size Sets food Size
    public void setSize(FoodSize size)
    {
        this._size = size.toString();
    }

    // @returns Price
    public double getPrice()
    {
        return _price;
    }

    // @param Price Sets price
    public void setPrice(double price)
    {
        this._price = price;
    }

}
