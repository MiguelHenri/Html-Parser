import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HtmlParser {
    /*
     * The main function receives an URL as an argument and gets its HTML.
     * Then, it gets and prints the text at the deepest level of the HTML structure.
     */
    public static void main(String[] args) {

        // Assuming the args will always be correct
        String url = args[0];
        HttpResponse<String> response = null;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).build();
            
            // Getting HTML data from the URL
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            System.out.println("URL connection error");
        }

        // Creating and building Html Tree
        HtmlTree htmlTree = new HtmlTree(response.body());
        htmlTree.buildHtmlTree();

        // Getting the text at the deepest level
        String answer = htmlTree.getDeepestText();

        System.out.println(answer);

    }

}