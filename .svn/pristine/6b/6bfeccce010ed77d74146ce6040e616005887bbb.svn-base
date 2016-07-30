package assign2;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;

public class AmazonISBNServiceTest {

    AmazonISBNService amazonIsbnService;

    @Before
    public void setUp() {
        amazonIsbnService = new AmazonISBNService();
    }

    @Test
    public void testCanary() {
        assertTrue(true);
    }

    @Test
    public void checkForTheValidTitleName() {
        String inputLine = "<span id=\"productTitle\" class=\"a-size-large\">The Secret of the Nagas</span>";
        String bookTitle = amazonIsbnService.getTitleDetailsForInputLine(inputLine);

        assertEquals("The Secret of the Nagas", bookTitle);
    }

    @Test
    public void checkForTheValidNumberOfReviews() {
        String inputLine = "<span id=\"acrCustomerReviewText\" class=\"a-size-base\">149 customer reviews</span>";
        int bookReviews = amazonIsbnService.getReviewDetailsForInputLine(inputLine);

        assertEquals(149, bookReviews);
    }

    @Test
    public void checkTheTitleForTheInvalidInputLine() {
        try {
            String inputLine = "class=\"a-declarative\" data-action=\"acrLink-click-metrics\" data-acrLink-click-metrics=\"{}\"";
            amazonIsbnService.getTitleDetailsForInputLine(inputLine);
            fail("Exception not thrown in case of array out of bounds");
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }

    @Test
    public void checkTheReviewsForTheInvalidInputLine() {
        try {
            String inputLine = "class=\"a-declarative\" data-action=\"acrLink-click-metrics\" data-acrLink-click-metrics=\"{}\"";
            amazonIsbnService.getReviewDetailsForInputLine(inputLine);
            fail("Exception not thrown in case of array out of bounds");
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }

    @Test
    public void checkForTheValidTitleAndReviewsWhenISBNIsValid(){
            ImmutablePair<String, Integer> bookDetails = ImmutablePair.of("Campbell Biology (9th Edition)", 348);

            assertEquals(bookDetails, amazonIsbnService.parseInfoForISBN("0321558235"));
    }

    @Test
    public void checkForTheValidTitleAndReviewsWhenAnotherValidISBN(){
            ImmutablePair<String, Integer> bookDetails = ImmutablePair.of("The Immortals of Meluha", 255);

            assertEquals(bookDetails, amazonIsbnService.parseInfoForISBN("9380658745"));
    }

    @Test
    public void checkForTheTitleAndReviewsWhenISBNIsInvalid(){
        try {
            ImmutablePair<String, Integer> bookDetails = ImmutablePair.of(null, null);
            bookDetails = amazonIsbnService.parseInfoForISBN("0321558223");
            fail("Should throw an exception");
        } catch (RuntimeException e) {
            assertEquals("Invalid ISBN", e.getMessage());
        }
    }

    public void testNetworkError(){
        try{
            URL amazon = new URL("http://www.amazon.com/exec/obidos/ASIN/");
            AmazonISBNService amazonISBNServiceSpy = new AmazonISBNService();
            doThrow(new IOException()).when(amazonISBNServiceSpy).getConnection(amazon);
            amazonISBNServiceSpy.parseInfoForISBN("0456789034");
            fail("Exception not thrown in case of network error");
        }
        catch (IOException e){
        }
    }
}