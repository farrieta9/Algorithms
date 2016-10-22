#include <iostream>
using namespace std;

int fibonacci_recursive(int);
int fibonacci_loop(int);

int main() {

	int x = 5;
	cout << fibonacci_recursive(x) << endl;
	cout << fibonacci_loop(x) << endl;
	return 0;
}


int fibonacci_recursive(int nth) {

	if(nth < 2) {
		return 1;
	} else {
		return fibonacci_recursive(nth - 2) + fibonacci_recursive(nth - 1);
	}

	return 0;
}

int fibonacci_loop(int nth) {

	if(nth < 2) {
		return 1;
	}

	int firstPreceding = 1;
	int secondPreceding = 1;

	for (int i = 1; i < nth; i++) {

		firstPreceding = secondPreceding + firstPreceding;
		secondPreceding = firstPreceding - secondPreceding;

	}

	return firstPreceding;
}
