package circle;

public class Square {
	private double edge;
	
	public Square(double edge) {
		this.edge = edge;
	}
	
	public boolean inscribed(Circle c) {
		return c.radius() <= edge/2;
	}
	
	public double edge() {
		return edge;
	}
}
