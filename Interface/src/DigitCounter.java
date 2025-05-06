/**
 * Реализует подсчет количества цифр в числе.
 * @summary Класс для подсчета цифр в числе с использованием лямбда-выражения.
 */
class DigitCounter implements NumberCharacteristic {
  /**
  * Лямбда-выражение для подсчета цифр.
  * Реализует основной алгоритм подсчета через деление числа на 10.
  */
  private NumberCharacteristic counter = (num) -> {  // Лямбда-выражение для count
    int n = Math.abs(num);
    if (n == 0) return 1;
    int count = 0;
    while (n > 0) {
      n /= 10;
      count++;
    }
    return count;
  };

  public int count(int number) {
    return counter.count(number); // Вызываем лямбда-выражение через метод
  }
}
