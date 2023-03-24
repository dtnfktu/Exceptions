package lesson01;

public class Task1 {
    public static void main(String[] args) {
        String[] sArray = {"строка 1", null, "строка 3"};
        int[] array = {0,7,9,15,4,89,45,35,75,11,101,221};
        division(1, 0);
        printValueByIndex(array,15);
        printStringArray(sArray);

    }
    // Деление на ноль
    public static void division(double firstNum, double secondNum){
        System.out.println("Результат деления:");
        if(secondNum ==  0) {
            throw new ArithmeticException("Деление на ноль не допустимо");
        }
        double result = firstNum / secondNum;
        System.out.printf("%.2f / %.2f = %.2f\n", firstNum, secondNum, result);
    }
    // Выход за пределы массива
    public static void printValueByIndex(int[] array, int index){
        System.out.println("Значение элемента массива по индексу:");
        if(index > array.length-1) {
            throw new ArrayIndexOutOfBoundsException("Элемент с указанным индексом не существует");
        } else {
            System.out.printf("array[%d] = %d.\n",index, array[index]);
        }
    }

    // Null pointer exception
    public static void printStringArray(String[] sArray){
        System.out.println("Вывод строк:");
        for (String item: sArray){
            if(item == null) throw new NullPointerException("Отсутствие значения элемента");
            System.out.println(item);
        }
    }
}