package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Showing> _showing = new ArrayList<>();
    private List<Food> _food = new ArrayList<>();
    private int _showingCount;
    private double _total;

    // adds showing to the cart
    // SBI-06
    public void add(Showing showing, int count) {
        this._showing.add(showing);
        this._showingCount += count;
        _total = _total + (showing.getPrice() * count);
    }

    // removes showing to the cart
    // SBI-07
    public void remove(Showing showing, int count) {
        this._showing.remove(showing);
        this._showingCount -= count;
        _total = _total - (showing.getPrice() * count);
    }

    // adds Food to the cart
    // SBI-06
    public void add(Food food, Food.FoodSize size) {
        this._food.add(food);
        for (Food newFood : _food) {
            if (newFood.getDescription().equals(food.getDescription())
                    && newFood.getSize() == null
                    && newFood.getPrice() == 0) {
                newFood.setSize(size);
                newFood.setPrice(5);
                _total += newFood.getPrice();
                break;
            }
        }

        // removes it if it doesn't go thru the "if" statement
        this._food.remove(food);
    }

    public int getFoodCount() {
        return _food.size();
    }

    // removes Food from the cart
    // SBI-07
    public void remove(Food food, Food.FoodSize size) {
        for (Food newFood : _food) {
            if (newFood.getDescription().equals(food.getDescription())
                    && newFood.getSize().equals(size.toString())) {
                this._food.remove(newFood);
                _total -= newFood.getPrice();
                break;
            }
        }
    }

    public double getTotal() {
        return _total;
    }

}