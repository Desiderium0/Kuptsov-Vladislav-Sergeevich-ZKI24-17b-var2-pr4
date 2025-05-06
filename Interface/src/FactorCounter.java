/**
* Подсчитывает количество уникальных простых делителей числа.
* @summary Реализует подсчет простых делителей через лямбда-выражение.
*/
class FactorCounter implements NumberCharacteristic {
  /**
  * Лямбда-выражение, реализующее алгоритм подсчета уникальных простых делителей.
  * 1. Обрабатывает случай для четных чисел
  * 2. Проверяет нечетные делители до квадратного корня из числа
  * 3. Учитывает оставшийся делитель, если число > 1 после обработки
  */
  private NumberCharacteristic counter = (num) -> {
    if (num == 0 || num == 1 || num == -1) return 0;
    int n = Math.abs(num);
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

  public int count(int number) {
    return counter.count(number); // Вызываем лямбда-выражение через метод
  }
}