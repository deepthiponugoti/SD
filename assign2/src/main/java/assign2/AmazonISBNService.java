package assign2;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmazonISBNService implements ISBNService {

    @Override
    public ImmutablePair<String, Integer> parseInfoForISBN(String isbn){
        try {

            final String AMAZON_URL = "http://www.amazon.com/exec/obidos/ASIN/";
            URL amazon = new URL(AMAZON_URL + isbn);

            URLConnection webServiceConnection = getConnection(amazon);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    webServiceConnection.getInputStream()));

            return patternMatching(in);

        } catch (IOException e) {
            throw new RuntimeException("Invalid ISBN");
        }
    }

    URLConnection getConnection(URL amazon) throws IOException {

        return amazon.openConnection();
    }

    ImmutablePair<String, Integer> patternMatching(BufferedReader in) throws IOException{
        String patternTitle = "<span id=\"productTitle\"(.*)";
        String patternReviews = "<span id=\"acrCustomerReviewText\"(.*)";
        String inputLine;
        String titleOfTheBook = null;
        Integer numberOfReviews = null;

        while((inputLine = in.readLine()) != null) {

            Pattern patternTitleObject = Pattern.compile(patternTitle);
            Matcher matcherTitleObject = patternTitleObject.matcher(inputLine);

            Pattern patternReviewsObject = Pattern.compile(patternReviews);
            Matcher matcherReviewsObject = patternReviewsObject.matcher(inputLine);

            if (matcherTitleObject.find()) {
                titleOfTheBook = getTitleDetailsForInputLine(inputLine);
            }

            if (matcherReviewsObject.find()) {
                numberOfReviews = getReviewDetailsForInputLine(inputLine);
            }
        }

        return ImmutablePair.of(titleOfTheBook, numberOfReviews);
    }

    public String getTitleDetailsForInputLine(String inputLine){
        String tokenizer[] = inputLine.split(">");

        return tokenizer[1].replace("</span","");
    }

    public int getReviewDetailsForInputLine(String inputLine){
        String tokenizer[] = inputLine.split(">");

        return Integer.parseInt(tokenizer[1].replace(" customer reviews</span", "").replace(",",""));
    }
}