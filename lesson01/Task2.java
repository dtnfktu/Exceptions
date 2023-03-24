// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. 
// Если длины массивов не равны, необходимо как-то оповестить пользователя.

package lesson01;

public class Task2 {
    public static void main(String[] args) {
        int[] mas1 = getArray(10);
        int[] mas2 = getArray(9);
        System.out.println("Массив 1:");
        System.out.println(printArray(mas1));
        System.out.println("Массив 2:");
        System.out.println(printArray(mas2));
        System.out.println("Разность элементов массивов:");
        System.out.println(printArray(diffArrays(mas1, mas2)));
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
    
    // Новый массив, полчаемый в результате вычитания согласно условию задачи
    public static int[] diffArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Заданы массивы разной длины. Обработка невозможна");
        }

        int len = array1.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = array1[i] - array2[i];
        }

        return result;
    }
}
