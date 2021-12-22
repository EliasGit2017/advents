#include <iostream>
#include <stdlib.h>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int main()
{
    ifstream data_file;
    data_file.open("../2021/data_inputs/01-2021.txt");
    if (!data_file)
    {
        cout << "Unable to open 01-2021.txt" << endl;
        exit(1);
    }
    int res;
    vector<int> numbers ;
    string line;
    data_file >> line;
    numbers.push_back(stoi(line));
    while (data_file >> line)
    {
        //numbers.push_back(atoi(line.c_str()));
        (numbers.back() < stoi(line)) ? res++ : res;
        numbers.push_back(stoi(line));
    }
    cout << to_string(res) << endl;
    data_file.close();
    
    return 0;
}