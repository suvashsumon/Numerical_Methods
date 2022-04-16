# MATH2232 : Numerical Methods Lab
*Created by: Suvash Kumar, CSE RU, Batch 27*

## 01. Bisection Method (Root Finding)
Let, `f(x)` has a root between `a` and `b`.
```
EPS = 0.01
if f(a)*f(b)>=0 :
    Print -> Wrong Assumption

c = a
while (b-a)>=EPS :
    c = (a+b)/2
    if f(c)==0 :
        break
    else if f(c)*f(a)<0 :
        b = c
    else
        a = c
Root = c
```

## 02. False Position/Regula-falsi (Root Finding)
Let, `f(x)` has a root between `a` and `b`.
```
MX_ITR = 0.01
if f(a)*f(b)>=0 :
    Print -> Wrong Assumption

c = a
for i=0 to i=MX_ITR :
    c = (a*f(b)-b*f(a))/(f(b)-f(a))
    if f(c)==0 :
        break
    else if f(c)*f(a)<0 :
        b = c
    else
        a = c
Root = c
```
## 03. Newton Raphson Method (Root Finding)
Let, `f'(x)` is the first derivative of `f(x)`. If initial assumption of root is `a` then the root of `f(x)` can be calculated by following algorithm.
```
EPS = 0.01
h = f(a)/f'(a)
while absolute(h)>=EPS :
    h = f(a)/f'(a)
    a = a - h
Root = a
```
## 04. Secant Method (Root Finding)
Let, a function `f(x)` and it's two initial approximation `a` and `b`. Then the root of `f(x)` can be find by following equation and algorithm.
<p style="text-align:center;"><img src="https://render.githubusercontent.com/render/math?math=root=a-\frac{f(b)(a-b)}{f(a)-f(b)}" style="text-align:center;"></p>  
and        
<p style="text-align:center;"><img src="https://render.githubusercontent.com/render/math?math=next=root-\frac{f(root)(a-root)}{f(a)-f(root)}"></p>

```
EPS = 0.001
root = a - ((f(b)*(a-b))/(f(a)-f(b)))
next = root
while absolute(next-a) > EPS :
    next = root - ((f(root)*(b-root))/(f(b)-f(root)))
    b = root
    root = next
Return root
```

## 05. Least Square (Curve Fitting)
Let some points `(x0, y0), (x1, y1),.....`, then for `y = ax + b` we need to follow this equation and algorithm,
<p style="text-align:center;"><img src="https://render.githubusercontent.com/render/math?math=a=\frac{n\sum{xy}-\sum{x}\sum{y}}{n\sum{x^2}-(\sum{x})^2}"></p>
and
<p style="text-align:center;"><img src="https://render.githubusercontent.com/render/math?math=b=\frac{n\sum{y}-\sum{x}\sum{xy}}{n\sum{x^2}-(\sum{x})^2}"></p>
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

## 06. Polynomial Method (Curve Fitting)
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

## 09. Newton's Forword Interpolation
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

## 10. Lagrange Interpolation
For `n` given points `(x0, y0), (x1, y1)......`, let `x[]` represents the values of `x` and `y[][0]` represents the values of `y`. `cp` represents the point to calculate.
```
Begin
   res := 0 and tempSum := 0
   for i := 1 to i<n, do
      tempProd := 1
      for j := 1 to i<n, do
         if i ≠ j, then
            tempProd := tempProd * (cp – x[j])/(x[i] – x[j])
      done

      tempPord := tempProd * fx[i]
      res := res + tempProd
   done
   return res
End
```

## 11. Newton's Divided Difference Interpolation
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

## 12. Trapizoidal Rule (Numerical Integration)
Let, a `n` (even number), `a` is lower limit and `b` is upper limit,. Then for `func(x)`,
```
h = (b-a)/n
s = func(a) + func(b)
for i=1 to i<n :
    s = s + 2*func(a+ih)
Ans = (s*h)/2
```
  
## 13. Simpson 1/3 Rule (Numerical Integration)
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
