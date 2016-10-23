#include <iostream>


int linearFirstSearch(int list[], int size, int value);
void printArray(int array[], int size);
void swap(int& a, int& b);
int *bubbleSort(int array[], int size);
int binarySearch(int array[], int size, int value);
int *selectionSort(int array[], int size);

int main()
{
    const int sizeOfList = 10;
    int list[sizeOfList] = {5, 7, 2, 1, 9, 4, 3, 6, 8, 4};
    int searchValue = 4;

    std::cout << "Before sorting" << std::endl;
    printArray(list, sizeOfList);
    std::cout << "LinearFirstSearch -> index of value " << searchValue << " is: " << linearFirstSearch(list, sizeOfList, searchValue) << std::endl;

    // sort
    // bubbleSort(list, sizeOfList);
    selectionSort(list, sizeOfList);
    printArray(list, sizeOfList);
    std::cout << "\n\n";

    std::cout << "After sorting" << std::endl;
    std::cout << "LinearFirstSearch -> index of value " << searchValue << " is: " << linearFirstSearch(list, sizeOfList, searchValue) << std::endl;
    std::cout << "BinarySearch -> index of value " << searchValue << " is: " << binarySearch(list, sizeOfList, searchValue)<< std::endl;


    return 0;
}


int *selectionSort(int array[], int size)
{
    for(int i = 0; i < size; i++)
    {
        int minimum = i;
        for(int j = i; j < size; j++)
        {
            if (array[minimum] > array[j]) {
                minimum = j;
            }
        }

        swap(array[minimum], array[i]);
    }

    return array;
}


int linearFirstSearch(int list[], int size, int value)
{
    for (int i = 0; i < size; i++) {
        if (list[i] == value) {
            return i;
        }
    }

    return -1;
}


void printArray(int array[], int size)
{
    for (int i = 0; i <size; i++) {
        std::cout << array[i] << " ";
    }
    std::cout << std::endl;
}


void swap(int& a, int& b)
{
    int temp = a;
    a = b;
    b = temp;
}


int *bubbleSort(int array[], int size)
{

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size - 1; j++) {
            if (array[j] > array[j + 1]) {
                swap(array[j], array[j + 1]);
            }
        }
    }

    return array;
}


int binarySearch(int array[], int size, int value)
{
    // Array must be in ascending order
    int lowIndex = 0;
    int highIndex = size;
    int position = -1;

    while (lowIndex <= highIndex) {
        int midIndex = (highIndex + lowIndex) / 2;

        if (array[midIndex] < value)
        {
            lowIndex = midIndex;
        }
        else if (array[midIndex] > value)
        {
            highIndex = midIndex + 1;
        }
        else
        {
            position = midIndex;
            lowIndex = highIndex + 1; // to exit the loop
        }
    }

    return position;
}
