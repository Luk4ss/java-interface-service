package model.service;

public class PaypalService implements OnlinePayment {

    private static final double Fee = 0.02;
    private static final double interest = 0.01;

    public Double paymentFee(Double amount){
        return amount*(1 + Fee);
    }

    public Double paymentInterest(Double amount, Integer months){

        return amount*(1 + interest*months);
    }



}
