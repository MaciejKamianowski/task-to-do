package org.kamianowski.maciej.feature.util;

import org.kamianowski.maciej.feature.model.NumberList;

import java.util.Arrays;
import java.util.List;

public class JsonParser {

    public static NumberList parse(String json) {
        String inside = json
                .replaceAll("[^0-9,\\-]", "");

        List<Integer> values = Arrays.stream(inside.split(","))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .toList();

        return new NumberList(values);
    }
}
