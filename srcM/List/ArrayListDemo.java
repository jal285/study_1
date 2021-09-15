package List;

import cn.hutool.db.Page;
import com.sun.media.sound.FFT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author badpoone
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();

        System.out.printf("Before add:arrayList.size()=%d\n",arrayList.size());


        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        System.out.printf("After add: arraylist.size: %d\n", arrayList.size());

        System.out.println("Printng elements of arrayList");

        System.out.println("索引遍历");
        for (int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i)+ " ");
        }

        Integer[] integer = arrayList.toArray(new Integer[0]);

        //page
        Page page = new Page(10,20);

        Map<String,Object> params = new HashMap<String ,Object>();
        System.out.println(page.getStartIndex());
        System.out.println(page.getEndIndex());

    }
}
