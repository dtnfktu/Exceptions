### Исключения в программировании и их обработка

[Урок 1. Обработка ошибок в программировании](#lesson01)  
  
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