package aPackage;

import java.util.List;

public class QuickSorterer
{
	/*@ requires list != null && k <= 0 && j <= 0;
	  @ list.size() > k && list.size() > j
	  @*/
	public void swap(List<Integer> list, int k, int j)
	{
		Integer obk = list.get(k);
		list.set(k, list.get(j));
		list.set(j, obk);
	}
	
	/*@ requires list != null && low <= high;
	  @ ensures (\forall int i; low <= i && i < high ==> list.get(i) <= list.get(i+1));
	  @*/
	public void sort(List<Integer> list, int low, int high)
	{
		if (low < high)
		{
			int p = partition(list, low, high);
			sort(list, low, p - 1);
			sort(list, p + 1, high);
		}
	}
	
	/*@ requires list != null && 0 <= low && low < high;
	  @*/
	public int partition(List<Integer> list, int low, int high)
	{
		int e = (int) list.get(low);
		int i = low + 1;
		int j = high;
		
		//@ loop_invariant 0<=i && i<=list.size() && low <= high && low <= 0 && high <= low;
		//@ decreasing i;
		while (i <= j)
		{
			if ((int) list.get(i) <= e)
				i++;
			else if ((int) list.get(j) > e)
				j--;
			else
			{
				swap(list, i, j);
				i++;
				j--;
			}
		}
		swap(list, low, j);
		return j;
	}
	
	/*@ requires list != null && list.size() > 0;
	  @ ensures (\forall int i; 0 <= i && i < list.size()-1 ==> list.get(i) <= list.get(i+1));
	  @*/
	public void sort(List<Integer> list)
	{
		sort(list, 0, list.size() - 1);
	}
}