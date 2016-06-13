// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Stack;
import java.util.*;

class Solution {
	public int solution(String S) {
		// write your code in Java SE 8
		Stack<Integer> intSt = new Stack<>();
		String[] inputString = S.split("\\s+");
		String inputVal = "";
		for (int i = 0; i < inputString.length; i++) {
			inputVal = inputString[i];
			if (inputVal.equals("POP")) {
				if (intSt != null) {
					intSt.pop();
				}
			}
			if (inputVal.matches("\\d+$")) {
				intSt.push(Integer.parseInt(inputVal));
				//System.out.println(intSt.peek());

			}
			if (inputVal.equals("DUP")) {
				if (intSt != null) {
					intSt.push(intSt.peek());
				}
			}
			if (inputVal.equals("+")) {
				// System.out.println(intSt.size());
				if (intSt != null && intSt.size() >= 2) {
					intSt.push(intSt.pop() + intSt.pop());
				} else
					return -1;
				// System.out.println(intSt.peek());
			}
			if (inputVal.equals("-")) {
				// System.out.println(intSt.size());
				if (intSt != null && intSt.size() >= 2) {
					intSt.push(intSt.pop() - intSt.pop());
				} else
					return -1;

			}
		}
		return intSt.peek();

	}
}