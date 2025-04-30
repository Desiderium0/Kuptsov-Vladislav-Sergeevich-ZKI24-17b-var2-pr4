import java.util.Scanner;

class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите целое число: ");
    String input = scanner.nextLine();
      
    // Проверка корректности ввода
    boolean isValid = true;
    if (input.isEmpty()) {
      isValid = false;
    }
    else {
      int startIdx = 0;
      if (input.charAt(0) == '-') {
        startIdx = 1;
        if (input.length() == 1) isValid = false;
      }
          
      for (int i = startIdx; i < input.length(); i++) {
        if (!Character.isDigit(input.charAt(i))) {
          isValid = false;
          break;
        }
      }
    }
      
    if (!isValid) {
      System.out.println("Ошибка: введено не число");
      return;
    }
      
    // Преобразование строки в число
    int number = 0;
    boolean isNegative = false;
    int startIdx = 0;
      
    if (input.charAt(0) == '-') {
      isNegative = true;
      startIdx = 1;
    }
      
    for (int i = startIdx; i < input.length(); i++) {
      char c = input.charAt(i);
      number = number * 10 + (c - '0');
    }
      
    if (isNegative) {
      number = -number;
    }
      
    // Лямбда-выражения
    NumberCharacteristic digitCounter = num -> {
      if (num == 0) return 1;
      int n = num < 0 ? -num : num;
      int count = 0;
      while (n > 0) {
        n /= 10;
        count++;
      }
      return count;
    };
      
    NumberCharacteristic primeFactorCounter = num -> {
      if (num == 0 || num == 1 || num == -1) return 0;
      int n = num < 0 ? -num : num;
      int count = 0;
          
      if (n % 2 == 0) {
        count++;
        while (n % 2 == 0) n /= 2;
      }
          
      for (int i = 3; i <= Math.sqrt(n); i += 2) {
        if (n % i == 0) {
          count++;
          while (n % i == 0) n /= i;
        }
      }
          
      if (n > 1) count++;
      return count;
    }; 
    System.out.println("Количество цифр в числе: " + digitCounter.count(number));
    System.out.println("Количество уникальных простых множителей: " + primeFactorCounter.count(number));
  }
}