#include <iostream>
using namespace std;

int fibonacciRecursive(int);
int fibonacciLoop(int);
int fibonacciModified(int nth);

int main()
{

	int x = 7;
	cout << fibonacciRecursive(x) << endl;
	cout << fibonacciLoop(x) << endl;
    cout << fibonacciModified(x) << endl;
	return 0;
}

int fibonacciModified(int nth)
{
    //n           1    2    3    4    5    6    7
    //fib(n)      1    1    3    7   17   41   99

    // base case
    if(nth <= 0)
    {
        return 0;
    }

    if(nth <= 2)
    {
        return 1;
    }

    return fibonacciModified(nth - 2) + (fibonacciModified(nth - 1) * 2);
}

int fibonacciRecursive(int nth)
{

    if (nth <= 0)
    {
        return 0;
    }

	if(nth <= 2)
    {
		return 1;
	}

	return fibonacciRecursive(nth - 2) + fibonacciRecursive(nth - 1);
}

int fibonacciLoop(int nth)
{

    if (nth <= 0)
    {
        return 0;
    }

	if(nth <= 2)
    {
		return 1;
	}

	int firstPreceding = 1;
	int secondPreceding = 1;

	for (int i = 3; i <= nth; i++)
    {
		firstPreceding = secondPreceding + firstPreceding;
		secondPreceding = firstPreceding - secondPreceding;
	}

	return firstPreceding;
}
