// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        System.out.println("Hi");
        System.out.println(getFloat());
    }

    // Метод считывает ввод с клавиатуры и переводит в формат float
    // Если введён текст - ввод поторяется
    public static Float getFloat() {
        Float result = null;
        Scanner scanner = new Scanner(System.in);

        while (result == null)
        {
            System.out.println("Введите дробное число: ");
            String input = scanner.next();
            try {
                result = Float.parseFloat(input);
            } catch (Exception e){
                System.out.println("Введен некорректный формат числа");
            }
        }   
        scanner.close();




        return result;
    }
}
