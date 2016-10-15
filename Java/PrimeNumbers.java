public class PrimeNumbers {
    public static void main(String[] args) {

        int[] x = getNPrimeNumber(100);

        System.out.println("First " + x.length + " prime numbers are: ");
        for(int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    private static int[] getNPrimeNumber(int n) {

        int[] listOfPrimeNumbers = new int[n];

        int i = 1;
        int pos = 0;
        while (pos < n) {
            if(isPrime(i)) {
                listOfPrimeNumbers[pos] = i;
                pos++;
            }
            i++;
        }

        return listOfPrimeNumbers;
    }

    private static boolean isPrime(int x) {

        if (x == 1 | x == 0) {
            // zero and one is not prime by definition
            return false;
        }

        if (x < 4) {
            // 2 & 3 are prime
            return true;
        }

        for (int i = 2; i < x / 2; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
