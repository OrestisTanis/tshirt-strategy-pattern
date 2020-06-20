package tshirtstrategy.facade;

import tshirtstrategy.facade.IPaymentDisplayer;
import tshirtstrategy.services.IPaymentStrategyGenerator;
import tshirtstrategy.services.PaymentStrategyGeneratorImpl;

/**
 *
 * @author Walter
 */
public class PaymentDisplayer implements IPaymentDisplayer {
    IPaymentStrategyGenerator paymentStrategyGeneratorService;

    public PaymentDisplayer() {
        paymentStrategyGeneratorService = new PaymentStrategyGeneratorImpl(); 
    }
    
    @Override
    public void displayPaymentsForAllTShirts() {
        paymentStrategyGeneratorService.generateStrategiesForAllTShirts().forEach(hashmap -> {
            System.out.println("******************************************************************");
            hashmap.entrySet().forEach(entry -> {
                System.out.println("Payment price via " + entry.getKey() + ": " + entry.getValue());
            });
        });
    }
}
