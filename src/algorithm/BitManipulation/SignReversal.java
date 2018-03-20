package algorithm.BitManipulation;

public class SignReversal {

	public static int signReversal(int a ){
		return a^-1 + 1;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(SignReversal.signReversal(10));
		System.out.println(SignReversal.signReversal(-20));
	}

}
