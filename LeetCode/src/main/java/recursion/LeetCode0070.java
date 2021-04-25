package recursion;

class LeetCode0070 {
	public static void main(String[] args) {
		int n = 3;
		LeetCode0070 lt70 = new LeetCode0070();
		System.out.println(lt70.climbStairs(n));
		
	}
	public int climbStairs(int n){
		int result = 0;
		if(n == 1)
			result = 1;
		if (n == 2) {
			result = 2;
		}
		if (n > 2) {
			result = climbStairs(n - 1) + climbStairs(n - 2);
		}
		prints(); 
		return result;
		
	}
	public void prints(){
		System.out.println("test method");
	}
	
}