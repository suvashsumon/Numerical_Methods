## Least Square (Curve Fitting)
Let some points `(x0, y0), (x1, y1),.....`, then for `y = ax + b` we need to follow this two equation,
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