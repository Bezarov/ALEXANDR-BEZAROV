package homework_nr_3;

public class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        double circumArea = 3.14 * radius * radius;
        return circumArea;
    }
}
