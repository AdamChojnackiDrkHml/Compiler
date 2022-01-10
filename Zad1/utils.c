#include <math.h>
#include "utils.h"
#include <stdio.h>


int converge(int a, int N)
{
    if(a > 0)
    {
        return a % N;
    }
    
    while(a < 0)
    {
        a += N;
    }

    return a;
}

int add(int a, int b, int N)
{
   return a+b <N ? a+b : a+b - N;
}

int substract(int a, int b, int N)
{
    return converge(a - b, N);
}

int power(int a, int pow, int N)
{
    //printf(" %d %d %d\n", a, pow, N);

    if (pow == 0)

            return 1;

        long int b = power(a, pow/2, N);

        if (pow % 2 == 0)
        {
        //    printf(" %d a\n", (b*b) % N);
            return (int)((b*b) % N);
        }
        else
        {
        //    printf(" %d b\n", (a * b*b) % N);
            return (int)((a * b*b) % N);
        }
}

int multiply(int a, int b, int N)
{
    return (a * b) % N;
}

int modulo(int a, int b, int N)
{
    return a % b;
}

int neg(int a, int N)
{
   return a > 0 ? -a + N : a;
}

int gcdExtended(int a, int b, int *x, int *y);
 
// Function to find modulo inverse of b. It returns
// -1 when inverse doesn't
int modInverse(int b, int m)
{
    int x, y; // used in extended GCD algorithm
    int g = gcdExtended(b, m, &x, &y);
 
    // Return -1 if b and m are not co-prime
    if (g != 1)
        return -1;
 
    // m is added to handle negative x
    return (x%m + m) % m;
}
 
// Function to compute a/b under modulo m
int divide(int a, int b, int N)
{
    a = a % N;
    int inv = modInverse(b, N);
    if (inv == -1)
        return -1;
    else
    {
        int c = (inv * a) % N;
        return c;
    }
}
 
// C function for extended Euclidean Algorithm (used to
// find modular inverse.
int gcdExtended(int a, int b, int *x, int *y)
{
    // Base Case
    if (a == 0)
    {
        *x = 0, *y = 1;
        return b;
    }
 
    int x1, y1; // To store results of recursive call
    int gcd = gcdExtended(b%a, a, &x1, &y1);
 
    // Update x and y using results of recursive
    // call
    *x = y1 - (b/a) * x1;
    *y = x1;
 
    return gcd;
}