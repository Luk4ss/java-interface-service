package model.service;

import model.entities.Contract;
import model.entities.Installment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private  OnlinePayment payment;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public ContractService(){

    }

    public ContractService(OnlinePayment payment){
        this.payment = payment;
    }


    public void processContract(Contract contract, Integer months) throws ParseException {

        double amount = contract.getTotalValue()/months;
        Calendar cal = Calendar.getInstance();
        cal.setTime(contract.getDate());
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year : " + year);

        for(int i = 1; i <= months ; i++ ){

            Date date = sdf.parse(day +"/" + (month+i) + "/" +year);

           double amountUpdated = payment.paymentInterest(amount, i);
           double installmentUpdated = payment.paymentFee(amountUpdated);

           contract.addInstallment(new Installment(date, installmentUpdated));

        }

    }

}
