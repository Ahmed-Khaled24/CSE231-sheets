package Sheet2;

public class Vector {
    
    private double x, y;

    // constructors

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(){
        this(0, 0);
    }

    // getters
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    // setters
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    
    //--------------------------------------------
    
    public double magnitude(){
        return Math.sqrt( Math.pow(x, 2) + Math.pow(y,2) );
    }

    public double angle(){
        return Math.toDegrees(Math.atan(y/x));
    }

    public void print(){
        // String.format() is used to specify the number of digits after the decimal point
        System.out.println( String.format("%.1f", x) + "i " + " + " + String.format("%.1f", y) + "j" );
        System.out.println( String.format("%.2f", magnitude()) + " [" + String.format("%.2f", angle()) + "]" );
    }

    public Vector add(Vector v){
        double NewX = x + v.getX();
        double NewY = y + v.getY();
        return new Vector(NewX, NewY);
    }

    public Vector sub(Vector v){
        double NewX = x - v.getX();
        double NewY = y - v.getY();
        return new Vector(NewX, NewY);
    }
}
