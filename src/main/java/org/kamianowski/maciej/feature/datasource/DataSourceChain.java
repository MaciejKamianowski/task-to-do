package org.kamianowski.maciej.feature.datasource;

import org.kamianowski.maciej.feature.model.NumberList;

import java.util.List;
import java.util.Optional;

public class DataSourceChain {

    private final List<DataSource> sources;

    public DataSourceChain(List<DataSource> sources) {
        this.sources = sources;
    }

    public NumberList load() {
        return sources.stream()
                .map(DataSource::load)
                .flatMap(Optional::stream)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No valid data source found!"));
    }
}
