package aPackage;

import java.util.List;

public class QuickSorterer
{
	private List list;
	
	private void exchange(int k, int j)
	{
		Object obk = list.get(k);
		list.set(k, list.get(j));
		list.set(j, obk);
	}
	
	private void quickSort(int low, int high)
	{
		if (low < high)
		{
			int p = partition(low, high);
			quickSort(low, p - 1);
			quickSort(p + 1, high);
		}
	}
	
	private int partition(int low, int high)
	{
		int e = (int) list.get(low);
		int i = low + 1;
		int j = high;
		while (i <= j)
		{
			if ((int) list.get(i) <= e)
				i++;
			else if ((int) list.get(j) > e)
				j--;
			else
			{
				exchange(i, j);
				i++;
				j--;
			}
		}
		exchange(low, j);
		return j;
	}
	
	public void qSort(List<Integer> list)
	{
		this.list = list;
		quickSort(0, list.size() - 1);
	}
}