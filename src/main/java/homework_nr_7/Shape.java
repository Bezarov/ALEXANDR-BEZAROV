package homework_nr_7;

public abstract class Shape {
    double side;
    double radius;
    double diameter;
    final double PI = 3.1428;
    public Shape(double side, double diameter) {
        this.side = side;
        this.diameter = diameter;
    }
    public abstract double area ();
}
