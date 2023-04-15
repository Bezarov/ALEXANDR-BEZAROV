package homework_nr_7;

public class TwoDimensionalShape extends Shape {
    public TwoDimensionalShape(double side, double diameter) {
        super(side, diameter);
    }
    @Override
    public double area() { return side * side; }
    public double circlePerimeter(){
        radius = diameter / 2;
        return 2 * PI * radius;
    }
}
