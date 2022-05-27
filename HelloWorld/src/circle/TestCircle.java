package circle;

public class TestCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1 = new Circle(1);
		Circle c2 = new Circle(2);
		Circle c3 = new Circle(8.3, "yellow");
		
		Square s1 = new Square(Math.sqrt(2));
		Square s2 = new Square(4);
		
		System.out.print("r1:" + c1.getRadius() + "  ");
		System.out.println("a1:" + c1.getArea());
		System.out.print("r2:" + c2.getRadius() + "  ");
		System.out.println("a2:" + c2.getArea());
		System.out.print("r3:" + c3.getRadius() + "  ");
		System.out.println("a3:" + c3.getArea());
		
		System.out.println(c1.inscribed(s1));
		
	}

}
