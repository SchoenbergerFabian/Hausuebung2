import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    final private List<Integer> primes;

    public PrimeNumbers(int limit){
        primes = getPrimesToLimit(limit);
    }

    public boolean isPrime(int number){
        return primes.contains(number);
    }

    private List<Integer> getPrimesToLimit(int limit){
        List<Integer> primes = new ArrayList();
        List<Integer> crossed = new ArrayList();

        for(int i = 2;i<=limit;i++){
            if(!crossed.contains(i)){
                primes.add(i);
                for(int j = (int) Math.pow(i,2);j<=limit;j+=i){
                    crossed.add(j);
                }
            }
        }

        return primes;
    }
}
