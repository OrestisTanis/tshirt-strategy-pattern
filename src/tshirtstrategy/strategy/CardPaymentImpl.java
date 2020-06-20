package tshirtstrategy.strategy;

import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;

public class CardPaymentImpl implements IPayment {

    @Override
    public float pay(float price, Color color, Size size, Fabric fabric) {
         return (price + calculatePrice(color,size,fabric)) * 1.1f;
    }

}
