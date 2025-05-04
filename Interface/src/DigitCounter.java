class DigitCounter implements NumberCharacteristic {
  public int count(int number) {
    int num = Math.abs(number);
    if (num == 0) return 1;
    int count = 0;
    while (num > 0) {
      num /= 10;
      count++;
    }
    return count;
  }
}