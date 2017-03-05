#include<iostream>
#include<iomanip>
using namespace std;

int main() {

    int n = 12;
    cout << right;
    const int WIDTH = 5;

    cout << setw(WIDTH - 2) << " ";
    for(int i = 1; i <= n; i++) {
        cout << setw(WIDTH);
        cout << i;
    }
    cout << endl;
    cout << setw(3) << "";
    cout << setfill('-');
    for(int i = 1; i <= n; i++) {
        cout << setw(WIDTH) << "";
    }
    cout << setfill(' ');
    cout << endl;
    
    for(int i = 1; i <= n; i++) {
        
        cout << setw(2) << i << "|";
        for(int j = 1; j <= n; j++) {
            cout << setw(WIDTH) << j * i;
        }
        cout << endl;
    }


    return 0;
}