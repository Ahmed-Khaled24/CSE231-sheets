package Sheet3;

public class main {
    public static void testVectorClass(){
        Vector v1 = new Vector(3, 4);
        Vector v2 = new Vector(6, 8);
        Vector v3 = new Vector(1, 1);
        Vector v4 = new Vector();

        System.out.println("Test read(). \n-----------------------------");
        v4.read(5, 5);
        v4.print();


        System.out.println("\n\nTest magnitude() and angle(). \n-----------------------------");
        System.out.println(v1.magnitude());
        System.out.println(v2.angle());

        System.out.println("\n\nTest add() and sub(). \n-----------------------------");
        v3.print();
        v3 = Vector.add(v1, v2);
        v3.print();
        v3 = Vector.sub(v2, v1);
        v3.print();
    }
    public static void testLineClass(){
        Line line = new Line(1, 1, 1, 1);
        line.print();
    }
    public static void testMyStringClass(){
        MyStringBuffer string = new MyStringBuffer("Hello");
        string.print();
        System.out.println("indexOf(l): " + string.indexOf('l'));
        System.out.println("length of string: " + string.length());
        string.erase(1, 2);
        string.print();
        string.insert(1, "el");
        string.insert(5, " world");
        string.print();
    }

    public static void main(String[] args) {
    testMyStringClass();
    }
}
