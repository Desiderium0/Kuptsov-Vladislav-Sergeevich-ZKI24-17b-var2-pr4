public class DigitCount implements NumberCharacteristic {
  public int count(int number) {
    if (number == 0) return 1;
        
    int n = number < 0 ? -number : number;
        
    int count = 0;
    while (n > 0) {
      n /= 10;
      count++;
    }
      return count;
  }
}
