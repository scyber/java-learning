

class TwoDShape2 {

	private double width;
	private double height;
	
	double getWidth() {return width;}
	double getHeight() {return height;}
	
	void setWidth (double w) {
		width = w;
	}
	void setHeight (double h){
		height = h;
	}
	void showDim() {
		System.out.println(" Width and height here " + width + " and " + height);
	}
	
}
class Triangle2 extends TwoDShape2 {
	private String style;
	
	Triangle2 () {
		
	}
	Triangle2 (String s, double w, double h) {
		setWidth (w);
		setHeight (h);
		style = s;
	}	
	double area() {
			return (getWidth() * getHeight() / 2 ) ;
		}
	void showStyle() {
		System.out.println("Triangle is " + style);
	}
	
}
class ColorTriangle extends Triangle2 {
	
	private String color;
	
	ColorTriangle (String c, String s, double w, double h) {
		
		super(s, w, h);
		color = c;
	}
	String getColor() {return color;}
	
	void showColor() {
		System.out.println("Color is " + color );
	}
	
}


	class Shape6 {
	
	public static void main (String args[]) {
	
		ColorTriangle t1 = new ColorTriangle("Blue", "isosceles", 8.0, 12.0);
		ColorTriangle t2 = new ColorTriangle("Red", "right", 2.0, 2.0);
		
		System.out.println("Info for t1: ");
		t1.showStyle();
		t1.showDim();
		System.out.println("Area is " + t1.area());
		t1.showColor();
		
		System.out.println();
		
		System.out.println("Info for t2: ");
		t2.showStyle();
		t2.showDim();
		System.out.println("Area is " + t2.area());
		t2.showColor();
	}
	

}

