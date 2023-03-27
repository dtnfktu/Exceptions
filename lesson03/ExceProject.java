package lesson03;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ExceProject {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String data = inputData(scanner);
        
        while (!data.equals("")) {
            if (countSpacesNumber(data) != 0) {
                System.out.println("\u001B[31m" + "Введено неверное количество данных. Код ошибки: " + countSpacesNumber(data) + "\u001B[0m");
            } else {
                String[] toFile = parseString(data);
                switch(isDataCorrect(toFile)) {
                    case 0: writeFile(toFile[0], strForFile(toFile));
                            break;
                    case 4: System.out.println("\u001B[31m" + "Некорректно введена дата рождения" + "\u001B[0m");
                            break;
                    case 5: System.out.println("\u001B[31m" + "Некорректно введён номер телефона" + "\u001B[0m");
                            break;
                    case 6: System.out.println("\u001B[31m" + "Некорректно указан пол" + "\u001B[0m");
                            break;
                    }
            }
            data = inputData(scanner);
        }
        scanner.close();
    } 

    // Ввод строки с данными
    public static String inputData(Scanner scan) {
        System.out.println("Введите данные через пробел:");
        System.out.println("[Фамилия] [Имя] [Отчество] [Дата рождения(dd.mm.yyyy)] [Номер телефона(только цифры)] [Пол(f/m)]");
        System.out.println("Если отчество отсутствет - введите прочерк [ - ]");
        System.out.println("Завершение ввода - пустая строка");
        return scan.nextLine().replaceAll("\\s+", " "); // сразу удаляем лишние пробелы
    }

    // Приложение должно проверить введенные данные по количеству. 
    // Если количество не совпадает с требуемым, вернуть код ошибки, 
    // обработать его и показать пользователю сообщение, что он ввел меньше или больше данных, чем требуется.
    public static int countSpacesNumber(String inputStr) {
        int lastIndex = 0;
        int result = 0;
        while (lastIndex != -1) {
            lastIndex = inputStr.indexOf(" ", lastIndex);
            if (lastIndex != -1) {
                result++;
                lastIndex++;
            }
        }
        // Пробелов должно быть 5. Значит 0 - ошибок нет,< 0 - данных не хватает, > 0 - лишние данные
        // Т.е. три варианта кода ошибки: 0, больше нуля, меньше нуля
        return result - 5;  
    }

    // Пытаемся выделить данные. Предполагается, что проверка на количесто данных пройдена успешно
    public static String[] parseString(String data) {
        String[] temp = data.split(" ");    // Данные в произвольном порядке
        String[] result = new String[6];          // Предварительные данные для записи в файл
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            if (isDateValid(temp[i])) {
                result[3] = temp[i];
            } else if (isPhoneValid(temp[i])) {
                result[4] = temp[i];
            } else if (isSexValid(temp[i].toLowerCase())) { // Если пол введён в верхнем регистре - не критично
                result[5] = temp[i].toLowerCase();
            } else if (index < 3) {
                result[index++] = temp[i];
            }
        }
        return result;
    }

    // Проверяем данные перед записью в файл. Данные выстроены в необходимом порядке. Но всё ли соответствует?
    // Если что-то не соответсвует, то parseString оставил там null
    public static int isDataCorrect(String[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                return i + 1;       // Номер элемента, который не был принят по причине отсутствия или некорректности
            }
        }
        return 0; // Данные без ошибок
    }

    // Преобразование массива строк в одну строку для записи в файл
    public static String strForFile(String[] data) {
        StringBuilder out = new StringBuilder();
        for (String string : data) {
            out.append("<" + string + ">");
        }
        return out.toString();
    }


    // Проверка корректности даты - строка формата dd.mm.yyyy
    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Проверка корректности номера телефона - целое беззнаковое число без форматирования
    public static boolean isPhoneValid(String phone) {
        try {
            Integer.parseInt(phone.substring(0,1)); // проверка первого символа, что не знак (+-)
            Long.parseLong(phone);                                      // проверка всего номера
            return true;
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    // Проверка корректности пола - символ латиницей f или m
    public static boolean isSexValid(String sex) {
        return (sex.equals("f") || sex.equals("m")) ? true : false;
    }

    // Запись в файл
    public static void writeFile(String fileName, String text){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true),StandardCharsets.UTF_8));
            writer.write(text);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Проблема записи в файл");
            e.printStackTrace();
        }
    }
    
}
