## Least Square (Curve Fitting)
Let some points `(x0, y0), (x1, y1),.....`, then for `y = ax + b` we need to follow this algorithm,
```
sumx = 0, sumy = 0, sumxy = 0, sumx2 = 0
for i=0 to i<n :
    sumx = sumx + x[i]
    sumy = sumy + y[i]
    sumx2 = sumx2 + x[i]*x[i]
    sumxy = sumxy + x[i]*y[i]
a = (n*sumxy-sumx*sumy)/(n*sumx2-sumx*sumx)
b = (n*sumy-sumx*sumxy)/(n*sumx2-sumx*sumx)
```

## Polynomial Method (Curve Fitting)
Let `n` points `(x0, y0), (x1, y1),.....`, then for `y = ax + b` we need to follow this algorithm,
```
degree = 2
x[], y[]

sumxy = 0, sumx2 = 0, sumx = 0, sumy = 0, sumx3 = 0, sumx4 = 0, sumx2y = 0
for i=0 to i<n :
    sumxy += x[i] * y[i]
    sumx2 += x[i] * x[i]
    sumx += x[i]
    sumy += y[i]
    sumx3 += x[i] * x[i] * x[i]
    sumx4 += x[i] * x[i] * x[i] * x[i]
    sumx2y += x[i] * x[i] * y[i]

a[][] = { { n, sumx, sumx2, sumy },
          { sumx, sumx2, sumx3, sumxy },
          { sumx2, sumx3, sumx4, sumx2y } }

// making uppertriangular matrix
for j=0 to j<n :
    for i=0 to i<n :
        if i>j :
            double c = a[i][j]/a[j][j];
            for k=0 to k=n :
                a[i][k] = a[i][k] - c*a[j][k]

//backward substituition
ans[]
ans[n-1] = a[n-1][n]/a[n-1][n-1]
for i=n-2 to i=0 :
    sum = 0
    for j=n-1 to j>i :
        sum+=a[i][j]*ans[j]
    ans[i] = (a[i][n]-sum)/a[i][i]
```
The array `ans[]` represents `a0, a1, a2......`  
*N:B: This algorithm is only for 2nd degree polynomial.*

## Newton's Forword Interpolation
For `n` given points `(x0, y0), (x1, y1)......`, let `x[]` represents the values of `x` and `y[][0]` represents the values of `y`. `cp` represents the point to calculate.
```
for j=1 to j<n :
    for i=0 to i<n-j :
        y[i][j] = y[i+1][j-1] - y[i][j-1]

sum = y[0][0]
h = x[1]-x[0]
hsum = 1, xsum = 1, fact = 1

for i=1 to i<n :
    xsum = xsum*(cp-x[i-1])
    hsum = hsum*h
    fact = fact*i
    sum = sum + (y[0][i]*xsum)/(hsum*fact)

print sum as answer
```

## Newton's Divided Difference Interpolation
For `n` given points `(x0, y0), (x1, y1)......`, let `x[]` represents the values of `x` and `y[][0]` represents the values of `y`. `cp` represents the point to calculate.
```
for j=1 to j<n :
    for i=0 to i<n-j :
        y[i][j] = (y[i][j-1]-y[i+1][j-1])/(x[i]-x[i+j])

sum = y[0][0]
xsum = 1

for i=1 to i<n :
    xsum = xsum*(cp-x[i-1]);
    sum = sum + xsum*y[0][i];

print sum as answer
```

## Trapizoidal Rule (Numerical Integration)
Let, a `n` (even number), `a` is lower limit and `b` is upper limit,. Then for `func(x)`,
```
h = (b-a)/n
s = func(a) + func(b)
for i=1 to i<n :
    s = s + 2*func(a+ih)
Ans = (s*h)/2
```
  
## Simpson 1/3 Rule (Numerical Integration)
Let, a `n` (even number), `a` is lower limit and `b` is upper limit,. Then for `func(x)`,
```
h = (b-a)/n
x[], fx[]
for i=0 to i=n :
    x[i] = a+ih
    fx[i] = func(x[i])

result = 0

for i=0 to i=n :
    if i==0 or i==n :
        result = result + fx[i]
    else if i%2!=0 :
        result = result + 4*fx[i]
    else :
        result = result + 2*fx[i]

result = (result*h)/3
```