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
}