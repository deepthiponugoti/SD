package assign2;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class BookReviews {

    ISBNService service;

    public void setService(ISBNService isbnService) {
        service = isbnService;
    }

    public int totalNumberOfReviews(List<ImmutablePair<String, Integer>> books){

        return books.stream()
                    .mapToInt(ImmutablePair::getRight)
                    .sum();
    }

    public List<ImmutablePair<String, Integer>> sortList(List<ImmutablePair<String, Integer>> books){

        return books.stream()
                    .sorted(comparing(ImmutablePair::getRight))
                    .sorted(comparing(ImmutablePair::getLeft))
                    .collect(toList());
    }

    public ImmutablePair<ImmutablePair<String, Integer>, Exception> getInfoForISBN(String isbn){
        try {
            ImmutablePair<String, Integer> bookAndReviews = service.parseInfoForISBN(isbn);

            return ImmutablePair.of(bookAndReviews, null);
        }
        catch (RuntimeException ex){
            String message = String.format(isbn+": "+"Error processing the ISBN: %s",ex.getMessage());

            return ImmutablePair.of(null, new RuntimeException(message));
        }
    }

    public ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> getReviewsForISBNs(
      List<String> isbnList){

        List<ImmutablePair<ImmutablePair<String, Integer>, Exception>> results =
             isbnList.stream()
                     .map(isbn -> getInfoForISBN(isbn))
                     .collect(toList());

        List<ImmutablePair<String, Integer>> titleAndNumberOfReviews =
             results.stream()
                    .filter(info -> info.getRight() == null)
                    .map(info -> info.getLeft())
                    .collect(toList());

        List<String> errors =
             results.stream()
                    .filter(info -> info.getRight() != null)
                    .map(info -> info.getRight().getMessage())
                    .collect(toList());

        titleAndNumberOfReviews = sortList(titleAndNumberOfReviews);
        int totalReviews = totalNumberOfReviews(titleAndNumberOfReviews);

        return ImmutableTriple.of(titleAndNumberOfReviews, totalReviews, errors);
    }
}


