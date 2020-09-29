import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbers {

    final private boolean[] primes;

    public PrimeNumbers(int limit){
        primes = getPrimesToLimit(limit);
    }

    public boolean isPrime(int number){
        if(number-2>=primes.length||number<2){
            return false;
        }
        return primes[number-2];
    }

    private boolean[] getPrimesToLimit(int limit){
        if(limit>=2){
            boolean[] primes = new boolean[limit-1];
            Arrays.fill(primes, true);

            for(int i = 0;i<primes.length;i++){
                if(primes[i]){
                    for(int j = (int) Math.pow(i+2,2)-2;j<primes.length;j+=i+2){
                        primes[j] = false;
                    }
                }
            }

            return primes;
        }
        return new boolean[0];
    }
}
