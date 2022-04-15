#include<stdio.h>

int main()
{
	float f(float);
	float a,b,h,sum;
	int i,n;
	printf("Enter the values of a,b: ");
	scanf("%f%f",&a,&b);
	printf("Enter the value of n: ");
	scanf("%d",&n);
	if(n%2!=0)
	{
		printf("\nNumber of subdivision should be even");
		return 0;
	}
	h=(b-a)/n;
	sum = f(a)-f(a+n*h);
	for(i=1;i<n;i++)
		sum += 4*f(a+i*h)+2*f(a+(i+1)*h);
	sum *= h/3;
	printf("\nValue of the integration is %f",sum);
}

float f(float x)
{
	return(x*x*x);
}