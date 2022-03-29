package application;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int contractNumber = sc.nextInt();

        System.out.print("Date (dd/MM/yyyy): ");
        Date contractDate = sdf.parse(sc.next());

        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);

        System.out.print("Enter number of installments: ");
        int numberOfInstallments = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());

        service.processContract(contract, numberOfInstallments);

        for(Installment install : contract.getInstallments()){
            System.out.println(sdf.format(install.getDueDate()) + " - $ "+ install.getAmount());
        }





    }
}
