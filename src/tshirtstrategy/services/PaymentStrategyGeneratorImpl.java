package tshirtstrategy.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import tshirtstrategy.PaymentContext;
import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;
import tshirtstrategy.models.TShirt;
import tshirtstrategy.strategy.BankPaymentImpl;
import tshirtstrategy.strategy.CardPaymentImpl;
import tshirtstrategy.strategy.CashPaymentImpl;
import tshirtstrategy.strategy.IPayment;

public class PaymentStrategyGeneratorImpl implements IPaymentStrategyGenerator {

    @Override
    public List<HashMap<String, Float>> generateStrategiesForAllTShirts() {
        List<TShirt> tShirts = getAllPossibleTShirtCombinations();
        List<HashMap<String, Float>> paymentList = new ArrayList();
        List<IPayment> payments = new ArrayList(Arrays.asList(new BankPaymentImpl(), new CardPaymentImpl(), new CashPaymentImpl()));
        PaymentContext paymentsContext = new PaymentContext(payments);
         
        for (int i = 0; i < tShirts.size(); i++) {
            TShirt ts = tShirts.get(i);
            HashMap<String, Float> pricesByPaymentMethod = new HashMap();
            pricesByPaymentMethod = paymentsContext.executePayments(ts.getPrice(), ts.getColor(), ts.getSize(), ts.getFabric());
            paymentList.add(pricesByPaymentMethod);
        }
        return paymentList;
    }

    @Override
    public List<HashMap<String, Float>> generateRandomTShirtsAndStrategies(int noOfTShirts) {
        List<HashMap<String, Float>> paymentList = new ArrayList();
        for (int i = 0; i < noOfTShirts; i++) {
            paymentList.add(generateRandomTShirtAndStrategies());
        }
        return paymentList;
    }

    @Override
    public HashMap<String, Float> generateRandomTShirtAndStrategies() {
        ITShirtRandomizer tShirtRandomizerService = new TShirtRandomizerImpl();
        // Generate random tshirt
        TShirt ts = new TShirt(tShirtRandomizerService.getRandomName(), tShirtRandomizerService.getRandomColor(), tShirtRandomizerService.getRandomSize(), tShirtRandomizerService.getRandomFabric(), 0);
        HashMap<String, Float> pricesByPaymentMethod = new HashMap();
        List<IPayment> payments = new ArrayList(Arrays.asList(new CardPaymentImpl(), new BankPaymentImpl(), new CashPaymentImpl()));
        PaymentContext paymentsContext = new PaymentContext(payments);
        pricesByPaymentMethod = paymentsContext.executePayments(ts.getPrice(), ts.getColor(), ts.getSize(), ts.getFabric());
        return pricesByPaymentMethod;
    }

    private List<TShirt> getAllPossibleTShirtCombinations() {
        ITShirtRandomizer tShirtRandomizerService = new TShirtRandomizerImpl();
        List<TShirt> tShirts = new ArrayList();

        for (int i = 0; i < 7; i++) {
            Color color = Color.values()[i];
            for (int j = 0; j < 7; j++) {
                Size size = Size.values()[j];
                for (int k = 0; k < 7; k++) {
                    Fabric fabric = Fabric.values()[k];
                    TShirt ts = new TShirt(tShirtRandomizerService.getRandomName(), Color.values()[i], Size.values()[j], Fabric.values()[k], 0);
                    tShirts.add(ts);
                }
            }
        }
        return tShirts;
    }
}
