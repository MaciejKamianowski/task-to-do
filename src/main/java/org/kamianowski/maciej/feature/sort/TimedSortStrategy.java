package org.kamianowski.maciej.feature.sort;

import java.util.List;

public class TimedSortStrategy implements SortStrategy {

    private final SortStrategy delegate;
    private long lastExecutionTimeNanos;

    public TimedSortStrategy(SortStrategy delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<Integer> sort(List<Integer> data) {
        long start = System.nanoTime();
        List<Integer> result = delegate.sort(data);
        lastExecutionTimeNanos = System.nanoTime() - start;
        return result;
    }

    public long getLastExecutionTimeNanos() {
        return lastExecutionTimeNanos;
    }
}
