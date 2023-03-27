package homework_nr_3;

public class Main {
    public static void main(String[] args) {
        Circle calculateCircle = new Circle(3.0);
        TemperatureConverter converter = new TemperatureConverter(36.6, 72.8);

        double circumArea = calculateCircle.calculateArea();
        double fromCelsius = converter.toFahrenheit();
        double fromFahrenheit = converter.toCelsius();

        System.out.println("Площадь круга " + circumArea + " от радиуса " + calculateCircle.radius);
        System.out.println("Из Цельсия " + converter.celsius + " в Фаренгейт: " + fromCelsius);
        System.out.println("из Фаренгейта " +  converter.fahrenheit + " в Цельсию: " + fromFahrenheit);
    }
}
