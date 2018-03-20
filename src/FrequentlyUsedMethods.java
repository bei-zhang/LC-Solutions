import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class FrequentlyUsedMethods {

	public static void frequentlyUsedMethods(){

		//Frequent used methods with char
		char a ='a',  ch ='8', A='A' ;
		System.out.println((int) A); // result: 65
		System.out.println(a); // result: 'a'
		System.out.println((int)a); // result:97
		System.out.println(a > 80); // result:true
		System.out.println(a >= 'a' && a <= 'z'); // result:true
		
		System.out.println(Character.isLetter(a)); // result:true
		System.out.println(ch >= '0' && ch <= '9'); // result:true //DO NOT USE built-in method like Character.isDigit()
		
		char upper = Character.toUpperCase(a); // convert to upper case.
		// convert to lower case.  upper remains unchanged (still upper case).
		char lower = Character.toLowerCase(upper); 
	
	
	
		
		//Frequent used methods with String
		String input ="alphanumeric includes alphabetic and numeric characters.";
		char[] charArray = input.toCharArray(); // String - > char[]
		charArray[2] = 'B';
		String newWord = String.valueOf(charArray); // char[] -> String
		
		int length = input.length(); //String 长度  length() method in String.
		length = charArray.length; //数组长度
		Arrays.toString(charArray); //array to string 
	
		
		String lowerStr = input.toLowerCase(); //input remains unchanged.
		String upperStr = input.toUpperCase(); //input remains unchanged.
		
		//java.lang.Integer
		int maxSum = Integer.MIN_VALUE;
		int minSum = Integer.MAX_VALUE;
		
		//int, long 可以互相 强转
		int a2 = 0;
		long b2 = a2; 		// int -> long 直接赋值，因为integer range 小于 long range
		int c2 = (int)b2;	// long -> int 必须强转
		
		
		//java.lang.Math
		int sum=0;
		maxSum = Math.max(maxSum, sum - minSum);
	    minSum = Math.min(minSum, sum);
	    int abs = Math.abs(maxSum - minSum);
	    Math.sqrt(2);
	    //三角形 a^2 + b^2 = c^2;
	    int x=3, y=4;
	    int distanceSqt =x*x + y*y; 
	    double eps = 1e-12; //表示精度到小数点后12位  1*10^-12  
	    
	    	
		
		//java.util.ArrayList
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(3);
		nums.set(0, 8); //Replaces the element at the specified position in this list with the specified element.
		System.out.println(nums.get(0));  //result is 8 
		Object[] arr = nums.toArray();

       //java.uti.HashMap
	    HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
	    //get all keys
		Set<Integer> keySet = hashMap.keySet();
		//#1 approach to get all values
		List<List<String>> result = new ArrayList<>(hashMap.values());
		//#2 approach to get all values
		Iterator<ArrayList<String>> it = hashMap.values().iterator();
		while(it.hasNext()){
			ArrayList<String> value = it.next();
		}
		
		
		//Heap
		//PriorityQueue by default is minHeap in Java
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		//passing customized Comparator can be maxHeap
		//Starting Java 8, no need to specify INITIAL_CAPACITY
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		int size = maxHeap.size();
		maxHeap.offer(2);
		maxHeap.poll();
		maxHeap.peek();
		
		List<Integer> topKList = new ArrayList<>();
        Iterator<Integer> it2 = minHeap.iterator();
        while(it.hasNext()){
            topKList.add(it2.next());
        }
        
        //Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        int pop = stack.pop();
        int peek = stack.peek();
        boolean empty = stack.isEmpty();
        
        
		
        Collections.reverse(topKList); //Just use reverse method -- Preferred 
       // Collections.sort(topKList, Collections.reverseOrder()); // or specify ReverseComparator 
		
		//sort array
		Integer[] intArr = new Integer[8];
		Arrays.sort(intArr, Collections.reverseOrder());
		Arrays.asList(intArr);
	
		
	    
	}
	
	
	public static void main(String[] args) throws Exception {
		//frequentlyUsedMethods();

		//testingDate();
		short a = 3;
		int b= a;
		long l = 1L << 55;
		System.out.println(l);
		System.out.println("Integer max:  "+Integer.MAX_VALUE);
		System.out.println("Long max:  "+Long.MAX_VALUE);
		System.out.println("Float max: "+ Float.MAX_VALUE);
		System.out.println("Double max: "+ Double.MAX_VALUE);
		
		float f = l;
		System.out.println(f);
		int size = 3;
		System.out.println(size++);
	}
	
	private static void testingDate() throws ParseException{
		Calendar cal = Calendar.getInstance();
		Date date1 = cal.getTime();
		String inputStr = "2017-08-28 13:35:08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date -> String
		String dateStr = sdf.format(date1);
		
		//String -> Date
		Date date = sdf.parse(inputStr);
		
		System.out.println(dateStr);
		System.out.println(sdf.format(date));
		
		
		
	}

}
