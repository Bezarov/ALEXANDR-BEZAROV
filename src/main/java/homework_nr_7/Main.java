package homework_nr_7;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Dima", "str.Titkina 16");
        Student student = new Student("Alex", "str.Titkina 116", "Java", 1992, 180.39);
        Staff staff = new Staff("Skot", "str.Titkina 226", "Tekwill", 12345.6789);

        System.out.println(person.toString());
        System.out.println(student.toString());
        System.out.print(staff.toString() + "\n");

        TwoDimensionalShape twodmshp = new TwoDimensionalShape( 20.00,12.18);
        System.out.println("Area of the two dimensional Square: " + twodmshp.area());
        System.out.println("Perimeter of the two dimensional Circle: " + twodmshp.circlePerimeter());

        ThreeDimensionalShape thredmshp = new ThreeDimensionalShape(25.23,8);
        System.out.println("Area of the three dimensional Square: " + thredmshp.area());
        System.out.println("Volume of the three dimensional Sphere: " + thredmshp.calculateVolumeSphere());
        System.out.println("Volume of the three dimensional Cube: " + thredmshp.calculateVolumeCube());
    }
}
