// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
// каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов 
// не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, 
// которое пользователь может увидеть - RuntimeException, т.е. ваше.

package lesson01;

public class Task3 {
    public static void main(String[] args) {
        int[] mas1 = getArray(10);
        int[] mas2 = getArray(9);
        System.out.println("Массив 1:");
        System.out.println(printArray(mas1));
        System.out.println("Массив 2:");
        System.out.println(printArray(mas2));
    }

    // Генерация случайной целой последовательности заданной длины
    public static int[] getArray(int lenArray) {
        int[] result = new int[lenArray];
        for (int i = 0; i < lenArray; i++) {
            result[i] = (int) (Math.random() * 100);
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

    // 
}
