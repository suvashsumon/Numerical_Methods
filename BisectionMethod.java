public class BisectionMethod {
    static final float eps = (float)0.01;
    public static double func(double x)
    {
        //return x*x*x - x*x + 2;
        return x*x*x-x-1;
    }
    public static double getRoot(double a, double b)
    {
        if(func(a)*func(b)>=0)
        {
            System.out.println("Worng assumption.");
            return -0.0000001;
        }
        double c = a;
        while((b-a)>=eps)
        {
            c = (a+b)/2;
            if(func(c)==0.0)
            {
                break;
            }
            else if(func(c)*func(a)<0)
            {
                b = c;
            }
            else
            {
                a = c;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        double a = 1;
        double b = 2;
        System.out.println("Root : "+getRoot(a, b));
    }
}
