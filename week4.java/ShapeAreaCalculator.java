
abstract class Shape {
    abstract double calculateArea();
}

// Rectangle subclass
class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

// Circle subclass
class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Triangle subclass
class Triangle extends Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main class
public class ShapeAreaCalculator {
    public static void main(String[] args) {
        // Create an array of Shape references
        Shape[] shapes = new Shape[] {
            new Rectangle(5, 10),
            new Circle(7),
            new Triangle(6, 4),
            new Rectangle(3.5, 2.5),
            new Circle(2.2)
        };

        double totalArea = 0;

        // Compute total area
        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            System.out.println("Area: " + area);
            totalArea += area;
        }

        System.out.println("Total Area: " + totalArea);
    }
}
