package showdown;

import java.util.Collection;
import java.util.Map;

/**
 * Utility static methods for JSP.
 * @author Ben
 */
public class Contains {

    /**
     * Checks if a collection contains the object.
     * @param list collection
     * @param o object
     * @return if the collection contains the object
     */
    public static boolean contains(Collection list, Object o) {
        if (list == null || o == null) {
            return false;
        } else {
            return list.contains(o);
        }
    }

    /**
     * Checks if the map contains an entry with the specified key.
     * @param map map
     * @param key key
     * @return if the map contains an entry with the specified key
     */
    public static boolean containsKey(Map map, Object key) {
        if (map == null || key == null) {
            return false;
        } else {
            return map.containsKey(key);
        }
    }
}
