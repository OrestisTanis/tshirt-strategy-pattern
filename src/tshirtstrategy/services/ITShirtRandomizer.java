package tshirtstrategy.services;

import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;

public interface ITShirtRandomizer {

    public Color getRandomColor();

    public Size getRandomSize();

    public Fabric getRandomFabric();

    public String getRandomName();
}
