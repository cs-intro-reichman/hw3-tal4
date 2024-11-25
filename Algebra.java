// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while(x2 != 0) {
			if (x2 < 0) {
				x1--;
				x2++;
			}
			else {
				x1++;
				x2--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		while (x2 != 0) {
			if (x2 < 0) {
				x1++;
				x2++;
			}
			else {
				x1--;
				x2--;
			}
		}
		return x1;
	}


	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int res = 0;
		while (x2 != 0) {
			if (x2 > 0) {
				res = plus(res, x1);
				x2--;
			}
			else {
				res = minus(res, x1);
				x2++;
			}
		}
		return res;		
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int res = 1;
		for(;n > 0; n--) {
			res = times(res, x);
		}
		return res;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int res = 0;
		int sum = 0;
		if(x1 > 0) {
			while(sum <= x1) {
				if(x2 > 0) {
					sum = plus(sum, x2);
					res++;
				}
				else {
					sum = minus(sum, x2);
					res--;
				}				
			}
		}
		else {
			while(sum >= x1) {
				if(x2 > 0) {
					sum = minus(sum, x2);
					res--;
				}
				else {
					sum = plus(sum, x2);
					res++;
				}
			}
		}
		if(res > 0) return res - 1;
		else return res + 1;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int res = minus(x1, times(x2, div(x1, x2)));
		if(res < 0) res = plus(x2, res);
		return res;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int low = 0, high = x;
		int guess = div(minus(high, low), 2);
		boolean isLowerThanRoot = pow(guess, 2) <= x;
		boolean isGreaterThanRoot = x < pow(plus(guess, 1), 2);
		while(!isLowerThanRoot || !isGreaterThanRoot) {
			if (isLowerThanRoot) {
				guess++;
				low = guess;
			}
			else {
				guess--;
				high = guess;
			}
			guess = div(low + high, 2);
			isLowerThanRoot = pow(guess, 2) <= x;
			isGreaterThanRoot = x < pow(plus(guess, 1), 2);
		}
		return guess;
	}	  	  
}