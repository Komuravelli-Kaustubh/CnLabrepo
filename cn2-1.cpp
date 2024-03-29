#include<iostream>
using namespace std;

int main() {
    int n, f, frames[30], i;
    cout << "Enter window size: ";
    cin >> n;
    cout << "Enter number of frames to transmit: ";
    cin >> f;
    cout << "Enter " << f << " frames:" << endl;
    for(i = 1; i <= f; i++) {
        cin >> frames[i];
    }
    cout << "\nWith sliding window protocol, the frames will be sent in the following manner (assuming no corruption of frames)\n\n";
    cout << "After sending " << n << " frames at each stage, sender waits for acknowledgement sent by the receiver\n\n";

    for(i = 1; i <= f; i++) {
        if(i % n == 0) {
            cout << frames[i] << " ";
            cout << "\nAcknowledgement of above frames sent is received by sender\n\n";
        } else {
            cout << frames[i] << " ";
        }
    }

    if(f % n != 0) {
        cout << "\nAcknowledgement of above frames sent is received by sender\n";
    }

    return 0;
}
