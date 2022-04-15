import java.util.Scanner;

public class NewtonDividedDifference {
    public static Scanner sc = new Scanner(System.in);

    static void newtonForwordInterpolation()
    {
        System.out.println("Enter the number of data : ");
        int n = sc.nextInt();
        double x[] = new double[n];
        double y[][] = new double[n][n];
        for(int i=0; i<n; i++)
        {
            x[i] = sc.nextDouble();
            y[i][0] = sc.nextDouble();
        }
        System.out.println("Enter the point of calculation : ");
        double cp = sc.nextDouble();
        for(int j=1; j<n; j++)
        {
            for(int i=0; i<n-j; i++)
            {
                y[i][j] = (y[i][j-1]-y[i+1][j-1])/(x[i]-x[i+j]);
            }
        }

        double sum = y[0][0];
        double xsum = 1;
        for(int i=1; i<n; i++)
        {
            xsum = xsum*(cp-x[i-1]);
            sum = sum + xsum*y[0][i];
        }
        System.out.println("Sum : "+sum);

    }
    public static void main(String[] args) {
        newtonForwordInterpolation();
    }
}