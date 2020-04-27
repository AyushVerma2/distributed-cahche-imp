import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    @Test
    public void testValid() {
        LRUCache<String,String> lruCache = new LRUCache(5);

        lruCache.put("1", "A");
        lruCache.put("2", "B");
        lruCache.put("3", "C");
        lruCache.put("4", "D");
        lruCache.put("5", "E");

        Assertions.assertEquals(lruCache.get("4"), "D");
    }
    @Test
    public void testValid_ForInt() {
        LRUCache<String,Integer> lruCache = new LRUCache(5);

        lruCache.put("1", 100);
        lruCache.put("2", 200);
        lruCache.put("3", 300);

        Assertions.assertEquals(lruCache.get("2"), 200);
    }
    @Test
    public void testINValid() {
        LRUCache<String,String>  lruCache = new LRUCache(5);

        lruCache.put("1", "A");
        lruCache.put("2", "B");
        lruCache.put("3", "C");
        lruCache.put("4", "D");
        lruCache.put("5", "E");

        Assertions.assertEquals(lruCache.get("7"), null);
    }

    @Test
    public void testValid_01() {
        LRUCache<String,String>  lruCache = new LRUCache(5);

        lruCache.put("1", "A");
        lruCache.put("2", "B");
        lruCache.put("3", "C");
        lruCache.put("4", "D");
        lruCache.put("5", "E");

        // adding element beyond capacity
        //it will remove the Least recently used i.e. 1
        lruCache.put("6", "F");
        Assertions.assertEquals(lruCache.get("1"), null);
        Assertions.assertEquals(lruCache.get("6"), "F");

    }

    @Test
    public void testValid_02() {
        // when cache has no elements
        LRUCache<String,String>  lruCache = new LRUCache(5);
        // update the value
        lruCache.put("5", "E");
        lruCache.put("5", "Update");

        Assertions.assertEquals(lruCache.get("5"), "Update");

    }

    @Test
    public void testValid_03() {

        LRUCache<String,String>  lruCache = new LRUCache(5);

        Assertions.assertEquals(lruCache.get("1"), null);

    }
}
