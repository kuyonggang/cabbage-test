package javaLang;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * least recently used
 */
public class LRUCache extends LinkedHashMap {

    private static final int MAX_SIZE = 4;

    public LRUCache(){
        super(16,0.75F,true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_SIZE;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.put("a","1");
        lruCache.put("b","2");
        lruCache.put("c","3");
        lruCache.put("d","4");
        lruCache.get("b");
        lruCache.get("c");
        System.out.println(lruCache);
        lruCache.put("f","5");

        System.out.println(lruCache);
    }
}
