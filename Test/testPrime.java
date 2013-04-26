import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class testPrime {
    @Test
    public void should_get_5_for_15(){
        //Given
        BigInteger givenNum = new BigInteger("600851475143");
        Prime prime =new Prime();
        //When
        BigInteger result = prime.getBiggestPrimeNumber(givenNum);
        int num = result.intValue();
        //then
        assertThat(num,is(6857)) ;
        assertTrue(result.isProbablePrime(1));

    }

}
