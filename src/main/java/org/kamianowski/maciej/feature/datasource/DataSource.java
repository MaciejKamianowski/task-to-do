package org.kamianowski.maciej.feature.datasource;


import org.kamianowski.maciej.feature.model.NumberList;

import java.util.Optional;

public interface DataSource {
    Optional<NumberList> load();
}