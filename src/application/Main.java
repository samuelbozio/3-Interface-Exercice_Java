package application;

import entities.Contract;
import services.ContractService;
import entities.Installment;
import services.PaypalService;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Entre com os dados do contrato: ");
        System.out.println("Numero: ");
        Integer numero = sc.nextInt();
        System.out.println("Data: ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.println("Valor do Contrato: ");
        Double valor = sc.nextDouble();


        Contract contract = new Contract(numero, date, valor);
        System.out.println("Numero de Parcelas: ");
        Integer parcelas = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, parcelas);

        System.out.println("Parcelas: ");

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment.toString());
        }


        sc.close();


    }
}