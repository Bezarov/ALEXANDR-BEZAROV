package homework_nr_6;

public class Invoice {
    String model;
    String description;
    int overallBoughtProducts;
    double price;

    public Invoice(String model, String description, int overallBoughtProducts, double price) {
        this.model = model;
        this.description = description;
        this.overallBoughtProducts = overallBoughtProducts;
        this.price = price;
    }
    double getAmount(){
        if (overallBoughtProducts > 0 && price > 0)
            return price * overallBoughtProducts;
        else setOverallBoughtProducts(0); setPrice(0);
        return getOverallBoughtProducts();
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOverallBoughtProducts() {
        return overallBoughtProducts;
    }

    public void setOverallBoughtProducts(int overallBoughtProducts) {
        this.overallBoughtProducts = overallBoughtProducts;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
