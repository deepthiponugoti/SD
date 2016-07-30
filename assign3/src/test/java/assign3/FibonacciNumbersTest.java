package assign3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class FibonacciNumbersTest {

    private FibonacciNumbers fibonacciNumbers;

    public abstract int callGetValue(int position);

    public FibonacciNumbers getFibonacciNumbers()
    {
        return fibonacciNumbers;
    }

    @Before
    public void setUp()
    {
        fibonacciNumbers = new FibonacciNumbers();
    }

    @Test
    public void checkForZerothPositionValueFromVirtualFunction(){
        assertEquals(1, callGetValue(0));
    }

    @Test
    public void checkForFirstPositionValueFromVirtualFunction(){
        assertEquals(1, callGetValue(1));
    }

    @Test
    public void checkForFourthPositionValueFromVirtualFunction(){
        assertEquals(5, callGetValue(4));
    }

    @Test
    public void checkForSixthPositionValueFromVirtualFunction() {
        assertEquals(13, callGetValue(400));
    }
}