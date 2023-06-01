public class HotDrinks extends Water {
    private int temperature;

    public HotDrinks(String name, int price) {
        super(name, price);
    }

    public HotDrinks(String name, int price, int temperature) {
        super(name, price);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getTemperature() + "\u00B0";
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
