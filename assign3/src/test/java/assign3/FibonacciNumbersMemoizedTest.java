package assign3;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FibonacciNumbersMemoizedTest extends FibonacciNumbersTest {

    @Override
    public int callGetValue(int position) {
        return getFibonacciNumbers().getValueMemoized(position);
    }

    @Test
    public void checkForTheSpeedOfMemoizedVersionIfValueIsAlreadyComputed(){
        long recursiveTime = computeTime(() -> getFibonacciNumbers().getValueRecursive(40));
        long memoizedTime = computeTime(() -> getFibonacciNumbers().getValueMemoized(40));

        assertTrue(recursiveTime > 10 * memoizedTime);
    }

    private long computeTime(Runnable code){
        long startTime = System.nanoTime();
        code.run();
        long endTime = System.nanoTime();

        return  endTime - startTime;
    }
}
