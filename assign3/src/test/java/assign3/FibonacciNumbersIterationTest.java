package assign3;

public class FibonacciNumbersIterationTest extends FibonacciNumbersTest {

    @Override
    public int callGetValue(int position) {
       return getFibonacciNumbers().getValueIterative(position);
    }
}