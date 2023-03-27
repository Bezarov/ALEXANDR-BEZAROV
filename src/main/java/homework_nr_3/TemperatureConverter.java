package homework_nr_3;

public class TemperatureConverter {
    double celsius;
    double fahrenheit;

    public TemperatureConverter(double celsius, double fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    public double toCelsius() {
        double to_Celsius  = ((fahrenheit-32)*5)/9;
        return to_Celsius;
    }
    public double toFahrenheit(){
        double to_Fahrenheit = (celsius * 1.8) + 32;
        return to_Fahrenheit;
    }


}




