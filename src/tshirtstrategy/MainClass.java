package tshirtstrategy;

import tshirtstrategy.facade.IPaymentDisplayer;
import tshirtstrategy.facade.PaymentDisplayer;

public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IPaymentDisplayer paymentDisplayer = new PaymentDisplayer();
        paymentDisplayer.displayPaymentsForAllTShirts();
    }
}
