package org.kamianowski.maciej.feature.datasource;

import org.kamianowski.maciej.feature.model.NumberList;
import org.kamianowski.maciej.feature.util.JsonParser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class FileDataSource implements DataSource {

    private final Path path;

    public FileDataSource(Path path) {
        this.path = path;
    }

    @Override
    public Optional<NumberList> load() {
        try {
            if (!Files.exists(path)) {
                return Optional.empty();
            }
            return Optional.of(JsonParser.parse(Files.readString(path)));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            return Optional.empty();
        }
    }
}
