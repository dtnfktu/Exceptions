// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
// каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов 
// не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, 
// которое пользователь может увидеть - RuntimeException, т.е. ваше.

package lesson01;

public class Task3 {
    public static void main(String[] args) {
        int[] mas1 = getArray(10,1000);
        int[] mas2 = getArray(10,100);
        System.out.println("Массив 1:");
        System.out.println(printArray(mas1));
        System.out.println("Массив 2:");
        System.out.println(printArray(mas2));
        System.out.println("Результат деления:");
        System.out.println(printArray(divArrays(mas1, mas2)));
    }

    // Генерация случайной целой последовательности заданной длины
    public static int[] getArray(int lenArray, int max) {
        int[] result = new int[lenArray];
        for (int i = 0; i < lenArray; i++) {
            result[i] = (int) (Math.random() * max);
        }
        return result;
    }

    // Перевод массива в строку для печати
    public static String printArray(int[] array) {
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < array.length; i++) {
            res.append(array[i] + " ");
        }
        return res.toString();
    }
    public static String printArray(double[] array) {
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < array.length; i++) {
            res.append(array[i] + " ");
        }
        return res.toString();
    }

     // Новый массив, полчаемый в результате деления согласно условию задачи
     public static double[] divArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Заданы массивы разной длины. Обработка невозможна");
        }

        int len = array1.length;
        double[] result = new double[len];
        for (int i = 0; i < len; i++) {
            if (array2[i] == 0) {
                // ... единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше
                throw new RuntimeException("Попытка деления на ноль. Так нельзя!");
            } else {
                result[i] = array1[i] / array2[i];
            }
        }

        return result;
    }
}
