package model.service;

public interface OnlinePayment {

    Double paymentFee(Double amount);

    Double paymentInterest(Double amount, Integer months);


}
