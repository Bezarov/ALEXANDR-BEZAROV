package homework_nr_3;

public class Main {
    public static void main(String[] args) {
        double radius = 3.0;
        double celsius = 36.6;
        double fahrenheit = 72.8;
        Circle calculateCircle = new Circle();
        TemperatureConverter converter = new TemperatureConverter();

        double circumArea = calculateCircle.calculateArea(radius);
        double fromCelsius = converter.toFahrenheit(celsius);
        double fromFahrenheit = converter.toCelsius(fahrenheit);

        System.out.println("Площадь круга " + circumArea + " от радиуса " + radius );
        System.out.println("Из Цельсия " + celsius + " в Фаренгейт: " + fromCelsius);
        System.out.println("из Фаренгейта " +  fahrenheit + " в Цельсию: " + fromFahrenheit);
    }
}
