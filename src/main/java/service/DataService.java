package service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class DataService {

//    private static String MOCK_DATA_URL ="https://raw.githubusercontent.com/orloveste/demoTrackerDrone-app/master/MOCK_DATA%20(1).csv";
    private static String MOCK_DATA_URL ="https://raw.githubusercontent.com/orloveste/demoTrackerDrone-app/master/MOCK_DATA.json";

    @PostConstruct
    public void fetchData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MOCK_DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse.body());
//        System.out.println(MOCK_DATA_URL);
    }
}
