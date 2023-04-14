package homework_nr_7;

public class ThreeDimensionalShape extends Shape {
    public ThreeDimensionalShape(double side, double diameter) {
        super(side, diameter);
    }
    @Override
    public double area() { return side * side; }
    public double calculateVolumeCube() { return side * side * side; }
    public double calculateVolumeSphere() {
        radius = diameter / 2;
        return (4.0/3.0) * PI * (radius * radius * radius);
    }
}
