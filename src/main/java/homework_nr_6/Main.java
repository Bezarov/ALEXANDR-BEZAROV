package homework_nr_6;
public class Main {
    public static void main(String[] args) {
        Invoice inv = new Invoice();
        inv.setModel("Mouse");
        inv.setDescription("Cool mouse");
        inv.setPrice(-73.99);
        inv.setOverallBoughtProducts(-8);
        System.out.println("Total to pay : " + inv.getAmount() + "\n" + "You bought: " + inv.getModel()
                + "\n" +  "Product Description: " + inv.getDescription()
                + "\n" + "In value: " + inv.getOverallBoughtProducts() + "\n" + "By the price: " + inv.getPrice());

        Date date = new Date();
        date.setYear(2020);
        date.setMonth(3);
        date.setDay(29);
        System.out.println("\n" + date.getDay() + ":" + date.getMonth() + ":" + date.getYear());
    }
}
