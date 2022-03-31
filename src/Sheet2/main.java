package Sheet2;

public class main {

    // returns the average magnitude of all vectors in the array
    public static double avg(Vector[] V){
        Vector sum = new Vector();

        for(Vector v : V)
            sum = sum.add(v);

        double total_magnitude = sum.magnitude();
        return total_magnitude / V.length;

    }


    public static void main(String[] args) {
        Vector vec1 = new Vector(3, 4);
        Vector vec2 = new Vector(1, 1);
        System.out.println(vec1.magnitude());
        System.out.println(vec1.angle());

        Vector sum = vec1.add(vec2);
        sum.print();

        Vector sub = vec1.sub(vec2);
        sub.print();

        Vector[] arr = {vec1, vec2};
        System.out.println(avg(arr));

    }

}
