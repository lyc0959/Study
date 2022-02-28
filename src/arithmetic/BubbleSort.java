package arithmetic;

/**
 * @author liyunchong
 *	冒泡排序
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arry = {3,2,6,5,9,7,10};
		for(int i : arry) {
			System.out.print(i+" ");
		}
		for(int i=0;i<arry.length-1;i++) {
			for(int j=0;j<arry.length-1-i;j++) {
				if(arry[j]>arry[j+1]) {
					int temp = arry[j];
					arry[j] = arry[j+1];
					arry[j+1] = temp;
				}
			}
		}
		System.out.println("\n-------冒泡排序后----------");
		for(int i : arry) {
			System.out.print(i+" ");
		}
	}

}
