#include <bits/stdc++.h>
using namespace std;
float a[100][100];
float x[100];
class GaussElimination
{
private:
    float ratio;
    int n;

public:
    GaussElimination(int n)
    {
        this->n = n;
    }

    void display()
    {
        this->solve();
        for (int i = 1; i <= n; i++)
        {
            cout << x[i] << endl;
        }
    }
    void solve()
    {
        for (int i = 1; i <= this->n - 1; i++)
        {
            if (a[i][i] == 0.0)
            {
                cout << "Mathematical Error!";
                exit(0);
            }
            for (int j = i + 1; j <= this->n; j++)
            {
                ratio = a[j][i] / a[i][i];

                for (int k = 1; k <= this->n + 1; k++)
                {
                    a[j][k] = a[j][k] - ratio * a[i][k];
                }
            }
        }
        /* Obtaining Solution by Back Substitution Method */
        x[this->n] = a[this->n][this->n + 1] / a[this->n][this->n];

        for (int i = this->n - 1; i >= 1; i--)
        {
            x[i] = a[i][this->n + 1];
            for (int j = i + 1; j <= this->n; j++)
            {
                x[i] = x[i] - a[i][j] * x[j];
            }
            x[i] = x[i] / a[i][i];
        }
    }
};

int main()
{
    cout << "Enter the number of unknowns : ";
    int n;
    cin >> n;
    cout << "Enter the co-officients one by one :" << endl;
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            //cout << "a[i][j] : ";
            cin >> a[i][j];
        }
        cout << endl;
    }

    GaussElimination gussel(n);
    gussel.display();
    return 0;
}