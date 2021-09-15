package 剑指offer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author badpoone
 * No.705
 */
public class MyHashSet {

    int key;
    private static final int  BASE = 769;
    private LinkedList[] data;

    public MyHashSet(){
        data = new LinkedList[BASE];
        for(int i=0;i<BASE;i++){
            data[i] = new LinkedList<Integer>();
        }
    }
    public void  add(int key){
        int h = hash(key);
        Iterator<Integer>iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if(element == key){
              return;
            }
        }
        data[h].offerLast(key);
    }


    public void remove(int key){
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
       while (iterator.hasNext()){
           Integer element                              = iterator.next();
           if(element==key){
               data[h].remove(element);
               return;
           }
       }
    }
    /**Return true if this set contais the specified element **/
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }

}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 *
 *
 */
