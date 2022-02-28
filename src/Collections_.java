import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collections_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        for(int i=0;i<5;i++){
            list.add("john"+i);
        }
//        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
