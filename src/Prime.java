import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Prime {
    public static List <BigInteger> primeList= new ArrayList<BigInteger>();
    public static void main(String args[]){
        Prime prime=new Prime();
        BigInteger num=new BigInteger("600851475143");
        BigInteger result=prime.getBiggestPrimeNumber(num);
        System.out.print(result.intValue());
    }
    public void savePrimeFactorInList(BigInteger givenNum) {
        if(givenNum.isProbablePrime(1)) {
            primeList.add(givenNum);
            return;
        }
        BigInteger maxLoopNum = givenNum.divide(new BigInteger("2")) ;
        for(BigInteger i=BigInteger.ONE;i.compareTo(maxLoopNum)<0;i=i.add(BigInteger.ONE)){
            if(i.isProbablePrime(1)){
                if(givenNum.mod(i).compareTo(BigInteger.ZERO)==0){
                    primeList.add(i);
                    BigInteger newGivenNum=givenNum.divide(i);
                    if(newGivenNum.isProbablePrime(1)) {
                        primeList.add(newGivenNum);
                        return;
                    }else {
                        savePrimeFactorInList(newGivenNum);
                    }
                    break;
                }

            }
        }
    }

    public BigInteger getBiggestPrimeNumber(BigInteger givenNum) {
        savePrimeFactorInList(givenNum);
        BigInteger biggestPrimeNum = BigInteger.ONE;
        for(int i = 0;i < primeList.size();i++){
            BigInteger temp = primeList.get(i);
            biggestPrimeNum = biggestPrimeNum.max(temp);
        }
        return biggestPrimeNum;
    }
}
