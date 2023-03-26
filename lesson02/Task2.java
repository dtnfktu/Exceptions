import java.util.Scanner;

// Разработайте программу, которая выбросит Exception, 
// когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

public class Task2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // Проверяем, что введена не пуста строка
        if (input.equals("")) {
            scanner.close();
            throw new Exception("Пустые строки вводить нельзя");
        }
        scanner.close();
        System.out.println("Введена строка:");
        System.out.println(input);
    }
}
