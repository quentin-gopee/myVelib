package circle;

public class Circle {
	private double radius;
	private String color;
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public Circle(double radius) {
		this.radius = radius;
		this.color = "red";
	}
	
	public double getRadius() {
		return 2*Math.PI*radius;
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
	
	public double radius() {
		return radius;
	}
	
	public String color() {
		return color;
	}
	
	public boolean inscribed(Square s) {
		return Math.sqrt(2)*s.edge() <= radius;
	}
}
