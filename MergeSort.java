import java.util.*;

public class MergeSort
{
	public static void main(String arg[])
	{
		Scanner sn = new Scanner(System.in);

		System.out.print("Enter Number of elements : ");
		int numberOfElements = sn.nextInt();

		int array[] = new int[numberOfElements];
		for(int i=0; i<numberOfElements; i++)
			array[i] = sn.nextInt();

		Merge obj = new Merge();
		obj.mergeSort(array, 0, array.length-1);

		System.out.println("The sorted array is :");
		for(int i=0; i< array.length; i++)
		{
		    System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

class Merge
{
	// divide
	public void mergeSort(int array[], int lb, int ub)
	{
		if(lb < ub)
		{
			int mid = (lb+ub)/2;
			mergeSort(array, lb, mid);
			mergeSort(array, mid+1, ub);
			merging(array, lb, mid, ub); // conquer
		}
	}
	
	// mergw
	public void merging(int array[], int lb, int mid, int ub)
	{
		int[] temArray = new int[array.length];
		int i =lb;
		int j = mid+1;
		int k = lb;
		while(i <=mid && j <=ub)
		{
			if(array[i] < array[j])
			{
				temArray[k] = array[i];
				i++;
			}
			else
			{
				temArray[k] = array[j];
				j++;
			}
			k++;
		}
		if(i>mid)
		{
			while(j <= ub)
			{
				temArray[k] = array[j];
				j++; k++;
			}
		}
		else if(j > ub)
		{
			while(i<=mid)
			{
				temArray[k] = array[i];
				i++; k++;
			}
		}
		for(int x=lb; x<=ub; x++)
		{
			array[x] = temArray[x];
		}
	}
}

