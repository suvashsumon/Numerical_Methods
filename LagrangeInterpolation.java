import java.util.Scanner;

public class LagrangeInterpolation {
    static Scanner sc = new Scanner(System.in);
    static double lagrangeInterpolation()
    {
        System.out.println("Enter the number of points : ");
        int n = sc.nextInt();
        double x[] = new double[n];
        double y[] = new double[n];
        for(int i=0; i<n; i++)
        {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }
        System.out.println("Enter the point to calculate : ");
        double cp = sc.nextDouble();
        double res = 0;
        for(int i=1; i<n; i++)
        {
            double tempProduct = 1;
            for(int j=1; j<n; j++)
            {
                if(i!=j) tempProduct *= (cp - x[j])/(x[i] - x[j]);
            }
            tempProduct *= y[i];
            res += tempProduct;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("Answer : "+lagrangeInterpolation());
    }
}