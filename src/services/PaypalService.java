package services;

import services.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService {


    private static final double fee_percentage = 0.02;
    private static final double monthly_interest = 0.01;

    @Override
    public Double paymentFee(Double amount) {
        return amount * fee_percentage;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * monthly_interest * months;
    }
}
