package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunchong
 *	ArrayList底层源码解读
 */
public class ArrayListSourceRead {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();//初始化的elementData为0；第一次扩容为10；第二次开始为原来的1.5倍，第二次为15；第三次为22以此类推
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		System.out.println(list);
		for(int i=0;i<5;i++){
			list.add(i);
		}
		System.out.println(list);
		for(int i=0;i<5;i++){
			list.add(i);
		}
		System.out.println(list);
		list.add("lyc");//此处是第四次扩容，elementData为33
	}

}
