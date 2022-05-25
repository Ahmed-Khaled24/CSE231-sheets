package Sheet5.Problem5;

import Sheet5.Problem4.Diamond;
import Sheet5.Problem4.Movable;
import javafx.geometry.Point2D;
import java.util.Arrays;
import java.util.Random;

public class Problem5 {
    public static void problem5Implementation(){
        final int numberOfObjectsInArray = 5;
        Movable[] movables = new Movable[numberOfObjectsInArray];

        // Populate the Array.
        for(int i = 0 ; i < numberOfObjectsInArray; i++){
            movables[i] = new Diamond (
                    new Point2D( generateRandomDouble(), generateRandomDouble()),
                    generateRandomDouble(),
                    generateRandomDouble()) ;
        }

        // Iterate and move
        for(Movable movable: movables){
            movable.move(generateRandomDouble(), generateRandomDouble());
        }

        // Sort
        Arrays.sort(movables);

        // Draw
        for(Movable movable: movables){
            if(movable instanceof Diamond diamond)
                diamond.draw();
        }

    }

    private static double generateRandomDouble(){
        int upperBound = 100;
        Random randomGenerator = new Random();
        return randomGenerator.nextDouble() * randomGenerator.nextInt(upperBound);
    }


}
