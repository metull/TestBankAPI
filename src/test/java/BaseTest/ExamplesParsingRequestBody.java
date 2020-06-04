package BaseTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ExamplesParsingRequestBody {

    public boolean recursiveObjectCheck(Object o) {
        if (o == null) {
            System.out.println("Element '%s' was null");
            return false;
        }
        if (o instanceof Map) {
            return ((Map<?, ?>) o).keySet().stream().allMatch(this::recursiveObjectCheck);
        }
        if (o.getClass().isArray()) {
            return Arrays.asList(o).stream().allMatch(this::recursiveObjectCheck);
        }
        if (o instanceof Collection) {
            return ((Collection) o).stream().allMatch(this::recursiveObjectCheck);
        }
        return true;
    }

    public boolean recursiveObjectCheck2(String bind, Object property) {
        if (property == null) {
            System.out.println(String.format("Element '%s' was null", bind));
        }
        if (property instanceof Map) {
      boolean bool = ((Map<?,?>) property).entrySet().stream().allMatch
                    (o -> recursiveObjectCheck2(bind + "-> " +  o.getKey(), o.getValue()));
            System.out.println("Map");
            return bool;
        }
        if (property instanceof Collection) {
            int i = 0;
            boolean bool = ((List<?>) property).stream().allMatch
                    (o -> recursiveObjectCheck2(bind + "[" + i + "]", ((List<?>) property).get(i)));
            System.out.println("Collection");
            return  bool;
        }
        return true;
    }

    public void checkForEquality(String json, String json2) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();

        final JsonNode tree1 = mapper.readTree(json);
        final JsonNode tree2 = mapper.readTree(json2);

        assert tree1.equals(tree2);
    }
}