package assign2;

import org.apache.commons.lang3.tuple.ImmutablePair;

public interface ISBNService {

    public ImmutablePair<String, Integer> parseInfoForISBN(String isbn);
}
