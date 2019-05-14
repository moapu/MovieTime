package model;
// @author Aleksandra Lee <ajl6251@psu.edu>


// Select Payment Type
public class Payment
{
    private PaymentType _payment;

    public Payment(PaymentType payment)
    {
        this._payment = payment;
    }

    public PaymentType getPaymentType()
    {
        return _payment;
    }
}
