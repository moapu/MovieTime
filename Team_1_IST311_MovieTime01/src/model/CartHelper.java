package model;

import java.util.Scanner;

public class CartHelper {

    // purchases the item in cart
    // SBI-09
    public static void checkout(Cart cart, Payment payment) {
        if (payment.getPaymentType().equals(PaymentType.CASH)) {
            System.out.println("Your total is: " + cart.getTotal());
        } else if (payment.getPaymentType().equals(PaymentType.CREDIT)) {
            enterInformation(cart);
        }
    }

    private static void enterInformation(Cart cart) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your card number: ");
        input.nextLine();
        System.out.print("Enter your PIN: ");
        input.nextInt();
        System.out.println("Your total is: " + cart.getTotal());
    }

}
