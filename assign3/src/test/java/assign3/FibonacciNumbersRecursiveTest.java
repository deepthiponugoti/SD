package assign3;

public class FibonacciNumbersRecursiveTest extends FibonacciNumbersTest
{
    @Override
    public int callGetValue(int position) {
     return  getFibonacciNumbers().getValueRecursive(position);
    }
}