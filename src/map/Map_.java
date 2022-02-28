package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_ {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("No1","张无忌");
        hashMap.put("No2","张三丰");
        hashMap.put("No3","张翠山");
        System.out.println(hashMap);
        Set set = hashMap.entrySet();
        for(Object o : set){
            Map.Entry entry = (Map.Entry)o;
            System.out.println("key="+entry.getKey()+",value="+entry.getValue());;

        }
        Set keySet = hashMap.keySet();
        System.out.println(keySet.getClass());
        for(Object o : keySet){
            System.out.println(o);
        }
        Collection values = hashMap.values();
        System.out.println(values.getClass());
    }
}
