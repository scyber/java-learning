/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch5Demo;

/**
 *
 * @author gpiskunov
 */
class TwoDshape {

    private double width;
    private double height;
    private String name;
    
    TwoDshape () {
        width = height = 0.0;
        name = null;
    }
    TwoDshape (double w, double h, String n) {
        width = w;
        height = h;
        name = n;
    }
    TwoDshape ( double x, String n) {
        width = height = x;
        name = n;
    }
    TwoDshape (TwoDshape ob){
        width = ob.width;
        height = ob.height;
        name = ob.name;
    }
    
    double getWidth () { return width; }
    double getHeigth () { return height;}
    String getName () { return name;}
    
    void setWidth (double w) { width = w; }
    void setHeigth (double h) { height = h; }
    
    void showDim() {
        System.out.println("Width and height " + width + 
                " and " + height);
    }
    double area () {
        System.out.println("area () must be overridden ");
        return 0.0;
    }
}
class Triangle extends TwoDshape {
    private String style;
    Triangle (){
        super ();
        style = null;
    }
    Triangle( double w, double h, String s) {
        super (w, h, "triangle");
        style = s;
        
    }
    Triangle (double x){
        super (x, "triangle");
        style = "isosceles";
    }
    Triangle (Triangle ob){
        super(ob);
        style = ob.style;
    }
    double area() {
        return getWidth()*getHeigth()/2;
    }
   void showStyle() {
       System.out.println("Trianlge is " + style);
   }   
}
class Rectangle extends  TwoDshape {
    Rectangle() {
        super();
    }
    Rectangle(double w, double h){
        super (w, h, "rectangle");
    }
    Rectangle (double x){
        super(x, "rectangle");
    }
    Rectangle (Rectangle ob){
        super(ob);
    }
    boolean isSquare() {
        if (getWidth() == getHeigth()) return true;
        return false;
    }
    double area() {
        return getWidth()*getHeigth() ;
    }
}
class DynShapes {
    
    public static void main(String args[]) {
        TwoDshape shapes[] = new TwoDshape[5];
        
        shapes[0] = new Triangle(8.0, 12.0, "right");
        shapes[1] = new Rectangle(10);
        shapes [2] = new Rectangle(10, 4);
        shapes [3] = new Triangle(7.0);
        shapes[4] = new TwoDshape(10, 20, "generic");
        
        for(int i=0; i< shapes.length; i++) {
            System.out.println("Object is " + shapes[i].getName());
            System.out.println("Area is " + shapes[i].area());
            
        }
    }
    
}