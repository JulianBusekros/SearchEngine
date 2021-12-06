import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private URL website;

    public void userInput() throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your link: ");
        String webLink = sc.nextLine();
        website = new URL(webLink);
    }
    public void scanWebsiteForTitle() throws IOException{
        userInput();
        try (InputStream input = website.openStream()){
            Pattern p = Pattern.compile("(<title>)(.*?)(</title>)");
            Scanner scanner = new Scanner(input);
            String html = scanner.useDelimiter("\\*").next();
            Matcher m = p.matcher(html);
            while(m.find()){
                System.out.println(m.group(2));
            }
        }
    }
}
