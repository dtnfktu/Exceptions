### Исключения в программировании и их обработка

[Урок 1. Обработка ошибок в программировании](#lesson01)  
[Урок 2. Исключения и их обработка](#lesson02) 
  
## <a id="lesson01"/> Задания с семинара 1 - папка lesson01  

**Реализуйте 3 метода, чтобы в каждом из них получить разные исключения**   
Реализованы три метода, выдающие исключения:  
- деление на ноль  (ArithmeticException)
- выход за пределы массива  (ArrayIndexOutOfBoundsException)
- пустой элемент (Null pointer exception)  
[Здесь текст на Java](https://github.com/dtnfktu/Exceptions/blob/main/lesson01/Task1.java).  Реализовано в Visual Studio Code.  
  

**Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.**  
Здесь решение в методе *diffArrays(int[] array1, int[] array2)*. Если заданы массивы разной длины, то кидается исключение *RuntimeException* с спояснением *Заданы массивы разной длины. Обработка невозможна*  
[Здесь текст на Java](https://github.com/dtnfktu/Exceptions/blob/main/lesson01/Task2.java).  Реализовано в Visual Studio Code. 
  
  **Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.**  
  Задачка схожа с предыдущей - длины массивов должны быть одинаковы, иначе кидается исключение. Кроме того, речь идёт о делении. Без обработки при попытке деления на ноль будет исключение *ArithmeticException*. Но по условию должно быть только *RuntimeException*. Поэтому в методе *public static double[] divArrays(int[] array1, int[] array2)* в цикле перед каждым делением идёт проверка делителя, и если он равен нулю, то кидается исключение *RuntimeException*.  
  [Здесь текст на Java](https://github.com/dtnfktu/Exceptions/blob/main/lesson01/Task3.java).  Реализовано в Visual Studio Code.  
    
  ## <a id="lesson02"/> Задания с семинара 2 - папка lesson02  

**Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должен приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных**  
Реализован метод *public static Float getFloat()*. В данном методе считывается строка, после чего с помощью *Float.parseFloat* производится попытка ковертировать строку в вещественный тип данных. При неудачной попытке (в ведённой строке содержатся символы, не относящиеся к дробному числу) кидается исключение, оповещающее о он некорректном формате введённых данных. Процесс зациклен до тех пор, пока не будут введены корректные данные. Метод возвращает число типа *float*.  
[Здесь текст на Java](https://github.com/dtnfktu/Exceptions/blob/main/lesson02/Task01.java).  Реализовано в Visual Studio Code.  
  
  **Если необходимо, исправьте данный код**  
01  try {  
02   int d = 0;  
03   double catchedRes1 = intArray[8] / d;  
04   System.out.println("catchedRes1 = " + catchedRes1);  
05  } catch (ArithmeticException e) {  
06   System.out.println("Catching exception: " + e);  
07  }  
В данном коде отслеживается попытка деления на ноль. Казалось бы, что *ArithmeticException* отлавливается, и всё нормально. Но здесь ещё идёт обращение к элементу массива (строка 03). Т.е. возможно ещё одно исключение - *ArrayIndexOutOfBoundsException*, которое в представленном коде не обрабатывается. Строку 06 исходного кода стоит заменить на:  
***05 } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {  ***
Т.е. более корректно предложенный код будет выглядеть так:  
01  try {  
02   int d = 0;  
03   double catchedRes1 = intArray[8] / d;  
04   System.out.println("catchedRes1 = " + catchedRes1);  
*05 } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {*   
06   System.out.println("Catching exception: " + e);  
07  } 
  
**Дан следующий код, исправьте его там, где требуется**  
01  public static void main(String[] args) throws Exception {  
02     try {  
03         int a = 90;  
04         int b = 3;  
05         System.out.println(a / b);  
06         printSum(23, 234);  
07         int[] abc = { 1, 2 };  
08         abc[3] = 9;  
09     } catch (Throwable ex) {  
10         System.out.println("Что-то пошло не так...");  
11     } catch (NullPointerException ex) {  
12         System.out.println("Указатель не может указывать на null!");  
13     } catch (IndexOutOfBoundsException ex) {  
14         System.out.println("Массив выходит за пределы своего размера!");  
15     }  
16  }  
17  public static void printSum(Integer a, Integer b) throws FileNotFoundException {  
18     System.out.println(a + b);  
19  }  
  
Здесь при отлавливании исключений первым идёт *Throwable*, которое является исключением верхнего уровня для остальных отслеживаемых в данном коде исключений. Среда разработки не даёт скомпилировать код. Чтобы всё заработало следует строки 09-10 поместить после строки 15. Работающий код выглядит следующим образом:  
01  public static void main(String[] args) throws Exception {  
02     try {  
03         int a = 90;  
04         int b = 3;  
05         System.out.println(a / b);  
06         printSum(23, 234);  
07         int[] abc = { 1, 2 };  
08         abc[3] = 9;  
11     } catch (NullPointerException ex) {  
12         System.out.println("Указатель не может указывать на null!");  
13     } catch (IndexOutOfBoundsException ex) {  
14         System.out.println("Массив выходит за пределы своего размера!");  
09     } catch (Throwable ex) {  
10         System.out.println("Что-то пошло не так...");  
15     }  
16  }  
17  public static void printSum(Integer a, Integer b) throws FileNotFoundException {  
18     System.out.println(a + b);  
19  }   
  
**Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.**   
Здесь всё просто: считывается строка, затем проверяется на наличие хоть чего-то в ней (*input.equals("")*). Если строка пустая, то выбрасывается исключение *throw new Exception("Пустые строки вводить нельзя")*. При необходимости, можно зациклить, пока не будет введена непустая строка.  
[Здесь текст на Java](https://github.com/dtnfktu/Exceptions/blob/main/lesson02/Task2.java).  Реализовано в Visual Studio Code. 