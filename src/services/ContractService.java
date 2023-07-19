package services;
import entities.Contract;
import entities.Installment;

import java.time.LocalDate;
import java.util.Date;

public class ContractService {

    private  OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract,
                                Integer months) {

        double basicQuota = contract.getTotalValue() /  months;

        for (int i=1; i <= months; i++) {

            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest =  onlinePaymentService.interest(basicQuota, i);
            double paymentFee = onlinePaymentService.paymentFee(basicQuota);
            double quota = basicQuota + interest + paymentFee;
            contract.getInstallments().add(new Installment(dueDate, quota));


        }




    }




}
