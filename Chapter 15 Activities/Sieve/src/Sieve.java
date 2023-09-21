import java.util.*;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve{
    public static void main(String[] args){
        // setup
        Scanner scan = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = scan.nextInt(); scan.close();
        Set<Integer> nums = new HashSet<Integer>();
        for(int i = 2; i <= n; i++){
            nums.add(i);
        }

        // actual prime code
        for(int i = 2; i <= n; i++){
            Iterator<Integer> it = nums.iterator();
            while(it.hasNext()){
                Integer num = it.next();
                if(num % i == 0 && num != i){
                    it.remove();
                }
            }
        }

        System.out.println(nums);
    }
}
