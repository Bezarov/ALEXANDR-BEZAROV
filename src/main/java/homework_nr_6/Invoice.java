package homework_nr_6;

public class Invoice {
    private String model;
    private String description;
    private int overallBoughtProducts;
    private double price;
    double getAmount(){
        if (overallBoughtProducts <= 0 || price <= 0) {
            overallBoughtProducts = 0;
            price = 0;
        }
        return this.overallBoughtProducts * this.price;
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
        if (overallBoughtProducts > 0)
            this.overallBoughtProducts = overallBoughtProducts;
        else System.out.println("Invalid overall bought product number: " + overallBoughtProducts);
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else System.out.println("Price can't be negative value: " + price);
    }
}
class Date{
    private int year;
    private int month;
    private int day;

    public int getDay() {
        return day;
    }
    public boolean check() {
        return getMonth() == 2 && getYear() % 4 == 0 && getYear() % 100 != 0 || getYear() % 400 == 0;
    }
    public void setDay(int day) {
        if (day > 0 && day <= 31)
            if (day > 28 && check()) {
                System.out.println("\n" + "Invalid value of day: " + day + "\n" + "It's leap year: " + year);
                this.day = 0;
            }
            else this.day = day;
        else System.out.println("\n" + "Invalid value of day: " + day);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 0 && month <= 12)
            this.month = month;
        else System.out.println("\n" + "Invalid value of month: " + month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0 && year <= 2023)
            this.year = year;
        else System.out.println("\n" + "Invalid value of year: " + year);
    }
}