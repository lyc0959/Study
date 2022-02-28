package arithmetic;

/**
 * @author liyunchong
 *	二分查找
 */
public class ErFenChaZhao {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		ErFenChaZhao erfen = new ErFenChaZhao();
		int returnNum = erfen.search(nums,-1);
		System.out.println(returnNum);

	}
	
	 public int search(int[] nums, int target) {
	        int left = 0;
	        int right = nums.length-1;
	        while(left<=right){
	            int mid = left + (right-left)/2;
	            if(nums[mid]==target){
	                return mid;
	            }else if(nums[mid]<target) {
	                left = mid + 1;
	            }else {
	                right = mid - 1;
	            }
	        }
	        return -1;
	    }

}
