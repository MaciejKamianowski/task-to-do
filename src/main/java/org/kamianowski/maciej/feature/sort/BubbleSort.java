package org.kamianowski.maciej.feature.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements SortStrategy {

    @Override
    public List<Integer> sort(List<Integer> data) {
        List<Integer> list = new ArrayList<>(data);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
        return list;
    }
}
