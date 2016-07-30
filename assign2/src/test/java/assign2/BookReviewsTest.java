package assign2;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookReviewsTest {

    BookReviews bookReviews;
    ISBNService mockService;
    ImmutablePair<String, Integer> greatJob = ImmutablePair.of("great job", 12);
    ImmutablePair<String, Integer> ball = ImmutablePair.of("ball", 2);
    ImmutablePair<String, Integer> anotherBall = ImmutablePair.of("ball", 3);
    ImmutablePair<String, Integer> zebra = ImmutablePair.of("zebra", 5);
    ImmutablePair<String, Integer> fan = ImmutablePair.of("fan", 3);
    String ISBNNotFound = "0321558236: Error processing the ISBN: ISBN not found";
    String InvalidISBN = "0321558237: Error processing the ISBN: Invalid ISBN";
    String NotAnISBN = "0321558235: Error processing the ISBN: Not an ISBN number";
    List<String> isbnList = Arrays.asList("0321558235","0321558236","0321558237");

    @Test
    public void testCanary() {
        assertTrue(true);
    }

    @Before
    public void setUp(){
        bookReviews = new BookReviews();
        mockService = mock(ISBNService.class);
        bookReviews.setService(mockService);
    }

    @Test
    public void checkForTheSumOfReviewsOfZeroBooks() {
        List<ImmutablePair<String, Integer>> books = new ArrayList<>();
        int totalreviews = bookReviews.totalNumberOfReviews(books);
        assertEquals(0, totalreviews);
    }

    @Test
    public void checkForTheSumOfReviewsOfOneBook() {
        List<ImmutablePair<String, Integer>> books = Arrays.asList(greatJob);
        int totalreviews = bookReviews.totalNumberOfReviews(books);
        assertEquals(12, totalreviews);
    }

    @Test
    public void checkForTheSumOfReviewsOfThreeBooks() {
        List<ImmutablePair<String, Integer>> books = Arrays.asList(greatJob, fan, ball);
        int totalreviews = bookReviews.totalNumberOfReviews(books);
        assertEquals(17, totalreviews);
    }

    @Test
    public void checkForTheSumOfReviewsOfTwoBooksIfTheTitlesAreIdentical() {
        List<ImmutablePair<String, Integer>> books = Arrays.asList(ball, anotherBall);
        int totalreviews = bookReviews.totalNumberOfReviews(books);
        assertEquals(5, totalreviews);
    }

    @Test
    public void checkForTheSortingOfZeroBooks() {
        List<ImmutablePair<String, Integer>> books = new ArrayList<>();
        List<ImmutablePair<String, Integer>> sortedBooks = new ArrayList<>();
        books = bookReviews.sortList(books);
        assertEquals(sortedBooks, books);
    }

    @Test
    public void checkForTheSortingOfOneBook() {
        List<ImmutablePair<String, Integer>> books = Arrays.asList(greatJob);
        List<ImmutablePair<String, Integer>> sortedBooks = Arrays.asList(greatJob);
        books = bookReviews.sortList(books);
        assertEquals(sortedBooks, books);
    }

    @Test
    public void checkForTheSortingOfTwoBooks() {
        List<ImmutablePair<String, Integer>> books = Arrays.asList(greatJob, ball);
        List<ImmutablePair<String, Integer>> sortedBooks = Arrays.asList(ball, greatJob);
        books = bookReviews.sortList(books);
        assertEquals(sortedBooks, books);
    }

    @Test
    public void checkForTheSortingOfThreeBooks() {
        List<ImmutablePair<String, Integer>> books = Arrays.asList(zebra, greatJob, ball);
        List<ImmutablePair<String, Integer>> sortedBooks = Arrays.asList(ball, greatJob, zebra);
        books = bookReviews.sortList(books);
        assertEquals(sortedBooks, books);
    }

    @Test
    public void checkForTheSortingOfThreeBooksInWhichTwoBooksAreIdentical() {
        List<ImmutablePair<String, Integer>> books = Arrays.asList(zebra, ball, anotherBall);
        List<ImmutablePair<String, Integer>> sortedBooks = Arrays.asList(ball, anotherBall, zebra);
        books = bookReviews.sortList(books);
        assertEquals(sortedBooks, books);
    }

    @Test
    public void getInfoForISBNReturnsDetailsForValidISBN(){
        when(mockService.parseInfoForISBN(anyString())).thenReturn(zebra);
        ImmutablePair<ImmutablePair<String, Integer>, Exception> isbnInfo = bookReviews.getInfoForISBN("0321558235");

        assertEquals(zebra, isbnInfo.getLeft());
        assertEquals(null, isbnInfo.getRight());
    }

    @Test
    public void getErrorWhenTheISBNIsNotValid(){
        String message = "er123456wr: Error processing the ISBN: Invalid ISBN";
        when(mockService.parseInfoForISBN(anyString())).thenThrow(new RuntimeException("Invalid ISBN"));
        ImmutablePair<ImmutablePair<String, Integer>, Exception> isbnInfo = bookReviews.getInfoForISBN("er123456wr");
        ImmutablePair<String, Integer> noBook = null;

        assertEquals(noBook, isbnInfo.getLeft());
        assertEquals(message, isbnInfo.getRight().getMessage());
    }

    @Test
    public void getDataWhenThreeValidISBNsAreGivenAsInput(){
        when(mockService.parseInfoForISBN(anyString())).thenReturn(zebra).thenReturn(greatJob).thenReturn(ball);
        List<ImmutablePair<String, Integer>> expectedBooks = Arrays.asList(ball, greatJob, zebra);
        List<String> expectedErrors = new ArrayList<>();
        int expectedTotalNumberOfReviews = 19;
        ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> expectedReviewInformation =
          ImmutableTriple.of(expectedBooks, expectedTotalNumberOfReviews, expectedErrors);
        ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> reviewInformation =
          bookReviews.getReviewsForISBNs(isbnList);

        assertEquals(expectedReviewInformation, reviewInformation);
    }

    @Test
    public void getDataWhenTwoValidISBNsAndOneInvalidISBNIsGivenAsInput(){
        when(mockService.parseInfoForISBN("0321558235")).thenReturn(zebra);
        when(mockService.parseInfoForISBN("0321558236")).thenReturn(greatJob);
        when(mockService.parseInfoForISBN("0321558237")).thenThrow(new RuntimeException("Invalid ISBN"));
        List<ImmutablePair<String, Integer>> expectedBooks = Arrays.asList(greatJob, zebra);
        List<String> expectedErrors = Arrays.asList(InvalidISBN);
        int expectedTotalNumberOfReviews = 17;
        ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> expectedReviewInformation =
          ImmutableTriple.of(expectedBooks, expectedTotalNumberOfReviews, expectedErrors);
        ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> reviewInformation =
          bookReviews.getReviewsForISBNs(isbnList);

        assertEquals(expectedReviewInformation, reviewInformation);
    }

    @Test
    public void getDataWhenOneValidISBNsAndTwoInvalidISBNsIsGivenAsInput(){
        when(mockService.parseInfoForISBN("0321558235")).thenReturn(zebra);
        when(mockService.parseInfoForISBN("0321558236")).thenThrow(new RuntimeException("ISBN not found"));
        when(mockService.parseInfoForISBN("0321558237")).thenThrow(new RuntimeException("Invalid ISBN"));
        List<ImmutablePair<String, Integer>> expectedBooks = Arrays.asList(zebra);
        List<String> expectedErrors = Arrays.asList(ISBNNotFound, InvalidISBN);
        int expectedTotalNumberOfReviews = 5;
        ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> expectedReviewInformation =
          ImmutableTriple.of(expectedBooks, expectedTotalNumberOfReviews, expectedErrors);
        ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> reviewInformation =
          bookReviews.getReviewsForISBNs(isbnList);

        assertEquals(expectedReviewInformation, reviewInformation);
    }

    @Test
    public void getDataWhenZeroValidISBNsAndThreeInvalidISBNsIsGivenAsInput(){
        when(mockService.parseInfoForISBN("0321558235")).thenThrow(new RuntimeException("Not an ISBN number"));
        when(mockService.parseInfoForISBN("0321558236")).thenThrow(new RuntimeException("ISBN not found"));
        when(mockService.parseInfoForISBN("0321558237")).thenThrow(new RuntimeException("Invalid ISBN"));
        List<ImmutablePair<String, Integer>> expectedBooks = new ArrayList<>();
        List<String> expectedErrors = Arrays.asList(NotAnISBN, ISBNNotFound, InvalidISBN);
        int expectedTotalNumberOfReviews = 0;
        ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> expectedReviewInformation =
          ImmutableTriple.of(expectedBooks, expectedTotalNumberOfReviews, expectedErrors);
        ImmutableTriple<List<ImmutablePair<String, Integer>>, Integer, List<String>> reviewInformation =
          bookReviews.getReviewsForISBNs(isbnList);

        assertEquals(expectedReviewInformation, reviewInformation);
    }
}