import java.util.Scanner;

public class SimpsonsRule {
    public static double f(double x)
    {
        return 1/(1+x*x);
    }

    public static double simpsonRule(double a, double b)
    {
        double n = 4;
        double h = (a-b)/n;
        double x[] = new double[10000];
        double fx[] = new double[10000];
        for(int i=0; i<=n; i++)
        {
            x[i] = a + i*h;
            fx[i] = f(x[i]);
            System.out.println(x[i] + " = " + f(x[i]));
        }
        double result = 0;
        for(int i=0; i<=n; i++)
        {
            if(i==0 || i==n) result += fx[i];
            else if(i%2 != 0) result += 4*fx[i];
            else result += 2*fx[i];
        }
        return (result*h)/3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.println("Ans : "+simpsonRule(a, b));
    }
}
