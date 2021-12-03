#include <iostream>
#include <stdlib.h>
#include <fstream>
#include <string>

using namespace std;

int main()
{
    ifstream data_file;
    data_file.open("./01-2021.txt");
    if (!data_file)
    {
        cout << "Unable to open 01-2021.txt" << endl;
        exit(1);
    }
    string line;
    data_file >> line;
    cout << line << endl;
    int a = atoi(line.c_str()); // std::stoi(line)
    int res = 0;
    while (data_file >> line)
    {
        cout << line << endl;
        int b = stoi(line);
        (a < b) ? res++ : res;
    }
    data_file.close();
    cout << res << endl;
    return 0;
}
