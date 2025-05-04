class DigitCounter implements NumberCharacteristic {
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
