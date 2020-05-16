public class Circle implements GeometricObject {
	protected double radius = 1.0;

	Circle(double radius) {
		this.radius = radius;
	}

	public double getPerimeter() {
		return Math.PI * 2 * radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}
}
