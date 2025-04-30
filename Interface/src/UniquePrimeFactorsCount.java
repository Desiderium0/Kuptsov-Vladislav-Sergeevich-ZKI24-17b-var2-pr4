public class UniquePrimeFactorsCount implements NumberCharacteristic {
  public int count(int number) {
    if (number == 0 || number == 1 || number == -1) return 0;
        
    int n = number < 0 ? -number : number;
    int count = 0;
        
    if (n % 2 == 0) {
      count++;
      while (n % 2 == 0) {
        n /= 2;
      }
    }
        
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0) {
        count++;
        while (n % i == 0) {
          n /= i;
        }
      }
    }
        
    if (n > 1) count++;    
    return count;
  }
}