package tshirtstrategy.services;

import java.util.HashMap;
import java.util.List;

public interface IPaymentStrategyGenerator {
    
    public List<HashMap<String, Float>> generateStrategiesForAllTShirts();

    public List<HashMap<String, Float>> generateRandomTShirtsAndStrategies(int noOfTShirts);

    public HashMap<String, Float> generateRandomTShirtAndStrategies();
}
