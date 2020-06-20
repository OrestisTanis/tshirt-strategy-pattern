package tshirtstrategy;

import java.util.HashMap;
import java.util.List;
import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;
import tshirtstrategy.strategy.IPayment;

public class PaymentContext {

    IPayment payment;
    List<IPayment> payments;

    public PaymentContext(IPayment payment) {
        this.payment = payment;
    }

    public PaymentContext(List<IPayment> payments) {
        this.payments = payments;
    }

    public IPayment getPayment() {
        return payment;
    }

    public void setPayment(IPayment payment) {
        this.payment = payment;

    }

    public float executePayment(float price, Color color, Size size, Fabric fabric) {
        return payment.pay(price, color, size, fabric);
    }

    public HashMap<String, Float> executePayments(float price, Color color, Size size, Fabric fabric) {
        HashMap<String, Float> paymentPrices = new HashMap<String, Float>();
        for (int i = 0; i < payments.size(); i++) {
            IPayment payment = payments.get(i);
            String className = payment.getClass().getSimpleName();
            paymentPrices.put(className.substring(0, className.indexOf("Payment")), payment.pay(price, color, size, fabric));
        }
        return paymentPrices;
    }
}
