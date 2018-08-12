package dataStructure.StringAndArray;

import java.util.Scanner;

public class Fraction {
	private Scanner scan = new Scanner(System.in);
	private int num = 1; //numerator
	private int denom = 1; //denominator

	public Fraction() {
	}

	public Fraction(int n, int d) {
		// Fill in code (good to use setFraction)
		setFraction(n,d);
	}

	public void setFraction(int n, int d) {
		// Fill in code ... don't forget to reduce
		this.num = n;
		this.denom = d;
		reduce();
	}

	public Fraction add(Fraction op) {
		// Fill in code ... don't forget to reduce
		// Algebra HINT: a/b + c/d = (a*d + b*c)/(b*d)
		int newNum = num* op.denom + denom * op.num;
		int newDenom = denom * op.denom;
		return new Fraction(newNum, newDenom);
	}

	public Fraction subtract(Fraction op) {
		// Fill in code ... don't forget to reduce
		// Algebra HINT: a/b - c/d = (a*d - b*c)/(b*d)
		int newNum = num* op.denom - denom * op.num;
		int newDenom = denom * op.denom;
		return new Fraction(newNum, newDenom);
	}

	public Fraction multiply(Fraction op) {
		// Fill in code ... don't forget to reduce
		// Algebra HINT: a/b * c/d = (a*c)/ (b*d)
		int newNum = num * op.num;
		int newDenom = denom * op.denom;
		return new Fraction(newNum, newDenom);
	}

	public Fraction divide(Fraction op) {
		// Fill in code ... don't forget to reduce
		// Algebra HINT: a/b / c/d = (a*d)/ (b*c)
		int newNum = num * op.denom;
		int newDenom = denom * op.num;
		return new Fraction(newNum, newDenom);
	}

	private void reduce() {
		// Pseudo code:
		// set smaller = minimum ( abs(num), abs(denom));
		// Loop through the possible divisors: 2, 3, 4, ... smaller
		// For each possible divisor:
		// while (num and denom are evenly divisible by divisor)
		// {
		// num /= divisor;
		// denom /= divisor;
		// smaller /= divisor;
		// }
		int smaller = Math.min(num, denom);
		int divisor =2;
		while(divisor <= smaller) {
			if(num % divisor ==0 && denom % divisor ==0) {
				num /= divisor;
				denom /= divisor;
				smaller /= divisor;
				divisor = 2;
			}else {
				divisor++;
			}
		}
	}

	public boolean equals(Fraction f) {
		// Assuming all fractions are reduced. Fill in code
		String str = toString();
		return str.equals(f.toString());
	}

	public String toString() {
		String str = String.valueOf(num);
		if(num != 0 && denom > 1) {
			str += "/" + denom;
		}
		return str;
	}

	public void readin(String label) {
		while (true) // Keep trying if bad input is received
		{
			System.out.print(label);
			String temp = scan.next();
			temp = temp.trim(); // get rid of white space at the beginning and end
			int index = temp.indexOf('/');
			if (index >= 0) {
				String numStr = temp.substring(0, index);
				String denomStr = temp.substring(index + 1);
				int n = Integer.parseInt(numStr);
				int d = Integer.parseInt(denomStr);
				setFraction(n, d);
				return;
			} else
				System.out.println("Input Fraction missing / ");
		} // Keep trying until you get it right
	}

	public static void main(String[] args) {
		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction();
		Fraction f3 = null;
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println(); // Add a blank line
			System.out.print("Enter operation: + - * / q (q ==> quit) : ");
			String input = scan.next();
			if (input.charAt(0) == 'q')
				break; // All done
			f1.readin("Enter Fraction 1: ");
			f2.readin("Enter Fraction 2: ");
			System.out.println("f1 = " + f1);
			System.out.println("f2 = " + f2);
			if (f1.equals(f2))
				System.out.println("f1 and f2 are equal");
			else
				System.out.println("f1 and f2 are not equal");
			switch (input.charAt(0)) {
			case '+':
				f3 = f1.add(f2);
				System.out.println("f1+f2=" + f3);
				break;
			case '-':
				f3 = f1.subtract(f2);
				System.out.println("f1-f2=" + f3);
				break;
			case '*':
				f3 = f1.multiply(f2);
				System.out.println("f1*f2=" + f3);
				break;
			case '/':
				f3 = f1.divide(f2);
				System.out.println("f1/f2=" + f3);
				break;
			default:
				System.out.println("Illegal command: " + input);
				break;
			}
		} // end of while loop
		System.out.println("Bye");
	} // end of main

}
