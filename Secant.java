public class Secant 
{
    static double eps = 0.001;

    static double f(double x)
    {
        //return Math.pow(x,3)-2*x-5;
        return x*Math.exp(x)-1;
    }
    static void secant(double x0,double x1)
    {
        double root = x0 - ((f(x1)*(x0-x1))/(f(x0)-f(x1)));
        double next = root;
        while(Math.abs(next-x1)>eps)
        {
            next = root - ((f(root)*(x1-root))/(f(x1)-f(root)));
            x1 = root;
            root = next;
        }
        System.out.println("Root = " + root);
    }
    public static void main(String[] args) {
        double x0 = 0;
        double x1 = 1;
        secant(x0, x1);
    }
}