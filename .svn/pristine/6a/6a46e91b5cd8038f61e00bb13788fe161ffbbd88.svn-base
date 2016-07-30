package assign3;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FibonacciNumbers {

    private Map<Integer, Integer> fibonacciMemoizedMap = new HashMap<>();;

    public FibonacciNumbers(){
        fibonacciMemoizedMap.put(0, 1);
        fibonacciMemoizedMap.put(1, 1);
    }

    public int getValueIterative(int position) {

        if(position == 0 || position == 1)
            return 1;

        Pair<Integer, Integer> initial = Pair.of(1, 1);

        return IntStream.rangeClosed(2, position)
                        .mapToObj(i -> Pair.of(i, 0))
                        .reduce(initial, (prev, ignore) -> Pair.of(prev.getRight(), prev.getLeft() + prev.getRight()))
                        .getRight();
    }

    public int getValueRecursive(int position){
        
        if(position == 0 || position == 1)
            return 1;

        return getValueRecursive(position - 1) + getValueRecursive(position - 2);
    }

    public int getValueMemoized(int position) {

        return fibonacciMemoizedMap.computeIfAbsent(position, 
          thePosition -> getValueMemoized(thePosition - 1) + getValueMemoized(thePosition - 2));
    }
}

