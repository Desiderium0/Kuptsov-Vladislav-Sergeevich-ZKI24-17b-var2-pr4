import java.util.Scanner;

class App {
  public static void main(String[] args) {
    NumberCharacteristic digitCounter = new DigitCount();
    NumberCharacteristic primeFactorCounter = new UniquePrimeFactorsCount();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите целое число: ");
    String input = scanner.nextLine();
        
    // Проверка что данные состоят только из цифр и возможного знака на минус
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
    System.out.println("Количество цифр в числе: " + digitCounter.count(number));
    System.out.println("Количество уникальных простых множителей: " + primeFactorCounter.count(number));
  }
}