import java.util.Scanner;

public class LeastSquare{
    public static void leastSquare()
    {
        System.out.println("Enter the nubmer of point : ");
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        System.out.println("Enter the points : x y");
        double x[] = new double[n];
        double y[] = new double[n];

        double sum_xy = 0, sum_x = 0, sum_y = 0, sum_xx = 0;

        for(int i=0; i<n; i++)
        {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();

            sum_x += x[i];
            sum_y += y[i];
            sum_xx += x[i]*x[i];
            sum_xy += x[i]*y[i];
        }

        double a = (n*sum_xy - sum_x*sum_y)/(n*sum_xx -sum_x*sum_x);
        double b = (sum_xx*sum_y - sum_x*sum_xy)/(n*sum_xx -sum_x*sum_x);

        if(b>=0) System.out.println("y = "+a+"x + "+b);
        else System.out.println("y = "+a+"x - "+Math.abs(b));

        sc.close();
    }
    public static void main(String[] args) {
        leastSquare();
    }
}