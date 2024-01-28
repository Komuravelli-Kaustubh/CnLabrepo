#include<iostream>
using namespace std;

int main() {
    int i, j, n, g, a;
    int arr[20], gen[20], q[20], s;

    cout << "Transmitter side:" << endl;
    cout << "Enter no. of data bits:";
    cin >> n;

    cout << "Enter data:";
    for(i = 0; i < n; i++)
        cin >> arr[i];

    cout << "Enter size of generator:";
    cin >> g;

    do {
        cout << "Enter generator:";
        for(j = 0; j < g; j++)
            cin >> gen[j];
    } while(gen[0] != 1);

    cout << "\nThe generator matrix:";
    for(j = 0; j < g; j++)
        cout << gen[j];

    a = n + (g - 1);

    cout << "\nThe appended matrix is:";
    for(i = 0; i < j; ++i)
        arr[n + i] = 0;

    for(i = 0; i < a; ++i)
        cout << arr[i];

    for(i = 0; i < n; ++i)
        q[i] = arr[i];

    for(i = 0; i < n; ++i) {
        if(arr[i] == 0) {
            for(j = i; j < g + i; ++j)
                arr[j] = arr[j] ^ 0;
        } else {
            arr[i] = arr[i] ^ gen[0];
            arr[i + 1] = arr[i + 1] ^ gen[1];
            arr[i + 2] = arr[i + 2] ^ gen[2];
            arr[i + 3] = arr[i + 3] ^ gen[3];
        } 
    }

    cout << "\nThe CRC is:";
    for(i = n; i < a; ++i)
        cout << arr[i];

    s = n + a;

    for(i = n; i < s; i++)
        q[i] = arr[i];

    cout << endl;
    for(i = 0; i < a; i++)
        cout << q[i];

    return 0;
}
