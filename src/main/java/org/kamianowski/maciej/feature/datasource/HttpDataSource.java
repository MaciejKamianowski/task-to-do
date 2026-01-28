package org.kamianowski.maciej.feature.datasource;

import org.kamianowski.maciej.feature.model.NumberList;
import org.kamianowski.maciej.feature.util.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class HttpDataSource implements DataSource {

    private final URI uri;

    public HttpDataSource(URI uri) {
        this.uri = uri;
    }

    @Override
    public Optional<NumberList> load() {
        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return Optional.empty();
            }
            return Optional.of(JsonParser.parse(response.body()));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            return Optional.empty();
        }
    }
}
