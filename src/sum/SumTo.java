package sum;

public class SumTo {
    public int sumTo(int n) {
       if (n == 0) return 0;
        return n+sumTo(n-1);
    }

}
