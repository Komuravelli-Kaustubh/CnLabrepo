#include<iostream>
using namespace std;

int main() {
    int window = 0;
    cout << "Enter window size: ";
    cin >> window;

    int sent = 0, ack, i = 0;
    while (true) {
        for (i = 0; i < window; i++) {
            cout << "Frame " << sent << " has been transmitted." << endl;
            sent++;
            if (sent == window) {
                break;
            }
        }

        cout << "Please enter the last Acknowledgement received: ";
        cin >> ack;

        if (ack == window) {
            break;
        } else {
            sent = ack;
        }
    }

    return 0;
}
