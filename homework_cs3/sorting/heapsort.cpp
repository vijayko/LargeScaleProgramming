/*
	author: Vijay Chaudhary
*/
/*
	This is a C++ implementation of heap sort. 
*/
#include <iostream>
#include <unordered_map>
#include <cstdlib>
#include <ctime>
using namespace std;

//This method is to max-heapify a given subtree at a particular node. Here, I am using an array to represent a tree where the root is at index 1 
//and it's children are at index 2 and 3 and the children of node at index 2 are at index 4 and 5 and so on.
//@param: array, position of node to a subtree and total numner of nodes in the heap tree structure. 
void max_heapify(int *array, int position, int num)
{
	int j , temp;
	temp = array[position];
	j = 2 * position;
	while(j <= num)
	{
		if(j < num && array[j+1] > array[j])
			j++;
		if (temp > array[j])
			break;
		else if(temp <= array[j])
		{
			array[j/2] = array[j];
			j = 2 * j;
		}
	}
	array[j/2] = temp;
}

//This method swaps the first element with the last element, and heapify the array from index 1 to N-i where i is the number of swaps. 
//Essentially, this is the heapsort, which uses the max_heapify to sort an array. 
//@param: array, num = number of elements of the array
void heapsort(int *array, int num)
{
	int i, temp;
	for(i = num; i >= 2; i--)
	{
		temp = array[i];
		array[i] = array[1];
		array[1] = temp;
		max_heapify(array, 1, i-1);
	}
}

//This method simply builds a max-heap using the entire array. It is required considering the way heapsort method has been implemented. 
//The first iteration in the heapsort required an already built max-heap to swap the first element (Largest) with the last element of the array.
//@param: array, num = number of elements of the array
void build_maxheap(int *array, int num)
{
	int i;
	for(i = num / 2; i >= 1; i--)
	{
		max_heapify(array, i, num);
	}
}

int main()
{
	srand(time(NULL));

	int N = 1000000;
	int a[N];

	unordered_map<int, int>my_map;
	int temp_val, item = 1;
	unordered_map<int, int>::iterator it;
	while(item <= N)
	{
		temp_val = rand() % (N) + 1;
		it = my_map.find(temp_val);
		if(it != my_map.end())
		{
			//
		}
		else
		{
			my_map[temp_val] = item;
			item++;
		}
	}


	unordered_map<int, int>::iterator iter;

	//populating array, a, with random and unique numbers from 1 to 1000000.
	int index = 1;
	for(iter = my_map.begin(); iter != my_map.end(); iter++)
	{
		a[index] = iter -> first;
		index++;
	}
	
	clock_t rand_start, rand_end;

	rand_start = clock();

	//sorting the randomized array using heapsort.
	build_maxheap(a, N);
	heapsort(a, N);

	rand_end = clock();

	double rand_duration = (rand_end - rand_start) / (double) CLOCKS_PER_SEC;

	cout << "rand time: " << rand_duration << endl;
	return 0;
}	
