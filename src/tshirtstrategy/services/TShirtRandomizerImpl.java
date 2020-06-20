package tshirtstrategy.services;

import java.util.Random;
import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;

public class TShirtRandomizerImpl implements ITShirtRandomizer {

    @Override
    public Color getRandomColor() {
        Color[] values = Color.values();
        return values[(int) (Math.random() * values.length)];
    }

    @Override
    public Size getRandomSize() {
        Size[] values = Size.values();
        return values[(int) (Math.random() * values.length)];
    }

    @Override
    public Fabric getRandomFabric() {
        Fabric[] values = Fabric.values();
        return values[(int) (Math.random() * values.length)];
    }

    @Override
    public String getRandomName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
