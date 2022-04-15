## Trapizoidal Rule (Numerical Integration)
Let, a `n` (even number), then for `f(x)`,
```
h = (b-a)/n
s = f(a) + f(b)
for i=1 to i<n
    s = s + 2*f(a+ih)
Ans = (s*h)/2
```
