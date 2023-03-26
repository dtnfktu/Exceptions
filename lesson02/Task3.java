public class Task3 {
public static void main(String[] args) {
    int[] intArray = {1, 5, 4, 3, 7, 9, 2, 1};
    
    try {
        int d = 0;
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
     } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
        System.out.println("Catching exception: " + e);
     }
}
     
}
