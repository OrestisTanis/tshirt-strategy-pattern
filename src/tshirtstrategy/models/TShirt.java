package tshirtstrategy.models;

import java.util.Objects;

/**
 *
 * 1. Color, {RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET}  
 * 2. Size, {XS, S, M, L, XL, XXL, XXXL} 
 * 3. Fabric, {WOOL, COTTON, POLYESTER, RAYON, LINEN, CASHMERE, SILK}
 *
 * Also, each product can be paid via three (3) different payment methods, 
 * 1. Credit / Debit cards 
 * 2. Money / Bank Transfer 
 * 3. Cash
 */
public class TShirt {
    
    private String name;
    private Color color;
    private Size size;
    private Fabric fabric;
    private float basePrice = 10;
    private float price;

    public TShirt() {
    }

    public TShirt(String name, Color color, Size size, Fabric fabric, float price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }
    
    public float getPrice() {
        return price;
    }
    
    // Base price = 10
    public void setPrice(float price) {
        this.price = this.basePrice + price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.color);
        hash = 67 * hash + Objects.hashCode(this.size);
        hash = 67 * hash + Objects.hashCode(this.fabric);
        hash = 67 * hash + Float.floatToIntBits(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TShirt other = (TShirt) obj;
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        if (this.fabric != other.fabric) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TShirt{" + "name=" + name + ", color=" + color + ", size=" + size + ", fabric=" + fabric + ", price=" + price + '}';
    }
}
