package org.kamianowski.maciej.feature.sort;

import java.util.List;

public class MergeSort implements SortStrategy {

    @Override
    public List<Integer> sort(List<Integer> data) {
        if (data.size() <= 1) {
            return data;
        }
        int mid = data.size() / 2;
        return merge(sort(data.subList(0, mid)), sort(data.subList(mid, data.size())));
    }

    private List<Integer> merge(List<Integer> a, List<Integer> b) {
        return java.util.stream.Stream.concat(a.stream(), b.stream())
                .sorted()
                .toList();
    }
}
