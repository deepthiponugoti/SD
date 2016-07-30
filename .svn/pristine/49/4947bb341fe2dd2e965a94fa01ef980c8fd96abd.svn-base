package assign2.driver;

import assign2.*;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AmazonISBNServiceDriver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("inputISBNNumbers.txt"));
        String inputISBN;
        List<String> ISBNNumbers = new ArrayList<>();
        while ((inputISBN = br.readLine()) != null) {
            ISBNNumbers.add(inputISBN);
        }

        BookReviews bookReviews = new BookReviews();
        AmazonISBNService amazonISBNService = new AmazonISBNService();
        bookReviews.setService(amazonISBNService);
        ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> finalOutput = bookReviews.getReviewsForISBNs(ISBNNumbers);

        System.out.println("BOOK TITLES AND NUMBER OF REVIEWS:");

        finalOutput.getLeft().forEach( bookTitleAndReview -> System.out.println(bookTitleAndReview.getLeft() + ": " + bookTitleAndReview.getRight()));

        System.out.println("\nERROR INFORMATION FOR INVALID ISBN:");

        finalOutput.getRight().forEach( errorMessage -> System.out.println(errorMessage));

        System.out.println("\nTOTAL NUMBER OF REVIEWS:");
        System.out.println(finalOutput.getMiddle());
    }
}
