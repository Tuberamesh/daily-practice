class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        long N = n;
        double result = 1; 

        
        boolean isNeg = false;
        if (N < 0) {
            isNeg = true;
            N = N * -1;
        }

        
        while (N > 0) {
            if (N % 2 == 1) {
                result = result * x;
                N--;
            } else {
                x = x * x;
                N = N / 2;
            }
        }

        
        if (isNeg) {
            result = 1.0 / result;
        }

        return result;
    }
}

        
        
          // convert to long to handle Integer.MIN_VALUE
        // if (N < 0) {
        //     x = 1 / x;
        //     N = -N;
        // }
        // double result = 1;
        // while (N > 0) {
        //     if ((N & 1) == 1)
        //     result *= x;  // multiply if current power is odd
        //     x *= x;                          // square x
        //     N >>= 1;                         // divide N by 2
        // }
        // return result;
 
