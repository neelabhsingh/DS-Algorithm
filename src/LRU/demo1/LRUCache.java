package LRU.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neelabhsingh on 21/01/17.
 */
public class LRUCache {
    private DoublyLinkedList pageList;
    private Map<Integer, Node> pageMap;
    private final int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        pageMap = new HashMap<>();
        pageList = new DoublyLinkedList(cacheSize);
    }
    public void accessPage(int pageNumber){
        Node pageNode=null;
        if(pageMap.containsKey(pageNumber)){
            pageNode = pageMap.get(pageNumber);
            pageList.movePageToHead(pageNode);
        }else{
            if(pageList.getCurrSize() == pageList.getSize()){
                pageMap.remove(pageList.getTail().getPageNumber());
            }
            pageNode =pageList.addPageToList(pageNumber);
            pageMap.put(pageNumber, pageNode);
        }
    }
    public void printCacheState(){
        pageList.printList();
        System.out.println();
    }

    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
    }
}
