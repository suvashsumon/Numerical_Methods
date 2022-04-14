import java.util.Scanner;

public class TrapizoidalRule {
    public static double f(double x)
    {
        return 1/(1+x); // set your function
    }
    public static double trapizoidalRule(double a, double b)
    {
        int n = 6; // just set a value
        double h = (b-a)/n;
        double s = f(a)+f(b);
        for(int i=1; i<n; i++)
        {
            s += 2*f(a+i*h);
        }

        return (s*h)/2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        System.out.println("Ans : "+trapizoidalRule(a, b));
    }
}
