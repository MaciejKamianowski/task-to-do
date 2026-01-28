package org.kamianowski.maciej;

import org.kamianowski.maciej.feature.datasource.DataSourceChain;
import org.kamianowski.maciej.feature.datasource.FileDataSource;
import org.kamianowski.maciej.feature.datasource.HttpDataSource;
import org.kamianowski.maciej.feature.model.NumberList;
import org.kamianowski.maciej.feature.sort.MergeSort;
import org.kamianowski.maciej.feature.sort.SortStrategy;
import org.kamianowski.maciej.feature.sort.TimedSortStrategy;

import java.net.URI;
import java.nio.file.Path;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        DataSourceChain chain = new DataSourceChain(List.of(
                new FileDataSource(Path.of("C:/data/list_of_values.json")),
                new HttpDataSource(URI.create("https://zaiks.pl/example/data/list_of_values.json"))
        ));

        NumberList data = chain.load();

        SortStrategy strategy = new TimedSortStrategy(new MergeSort());
        TimedSortStrategy timed = (TimedSortStrategy) strategy;

        List<Integer> sorted = strategy.sort(data.elements());

        System.out.println("Sorted data: " + sorted);
        System.out.println("Sorting time in ns: " + timed.getLastExecutionTimeNanos());
    }
}
