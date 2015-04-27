package aPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquivalenceRelaterer
{
	public static void main(String[] args)
	{
		int[][] matrix = new int[][]
				{
					{ 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1 },
					{ 1, 1, 0, 1, 1 },
					{ 1, 1, 1, 1, 1 },
					{ 1, 0, 1, 0, 1 }
				};
		
		// printMatrix(matrix);
		// System.out.println("\nYou think this is an equivalence relation? " + isEquivalenceRelation(matrix) + ".");
		
		QuickSorterer sorter = new QuickSorterer();
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(5);
		ints.add(1);
		ints.add(2412);
		ints.add(3);
		ints.add(34);
		sorter.sort(ints);
		System.out.println(ints);
	}
	
	private static boolean isEquivalenceRelation(int[][] matrix)
	{
		int columns = matrix[0].length;
		int rows = matrix.length;
		boolean symmetric = true;
		boolean reflexive = true;
		boolean transitive = true;
		
		for (int i = 0; i < columns; i++)
		{
			if (matrix[i][i] != 1)
			{
				System.out.println("(" + i + "," + i + ") is not true, so the matrix isn't reflexive!");
				reflexive = false;
			}
			for (int j = 0; j < rows; j++)
			{
				if (matrix[i][j] != matrix[j][i])
				{
					System.out.println("(" + i + "," + j + ") and " + "(" + j + "," + i + ") are not symmetric!");
					symmetric = false;
				}
				if (i != j)
					if (!isHerpDerp(matrix, j, i, j, rows, columns, new ArrayList<String>()))
						transitive = false;
			}
		}
		return symmetric && reflexive && transitive;
	}
	
	private static boolean isHerpDerp(int[][] matrix, int toCheck, int origY, int origX, int rows, int columns, List<String> alreadyChecked)
	{
		for (int i = 0; i < columns; i++)
			if (matrix[toCheck][i] == 1 && !(toCheck == origX && i == origY))
			{
				boolean check = true;
				for (String string : alreadyChecked)
					if (string.contains(origY + "") && string.contains(i + ""))
					{
						check = false;
						break;
					}
				
				if (check)
					if (matrix[origY][i] == 1)
					{
						alreadyChecked.add(origY + ":" + i);
						if (!isHerpDerp(matrix, i, origY, origX, rows, columns, alreadyChecked))
						{
							System.out.println("Checking transition path from (" + origY + "," + origX + "), the matrix was "
									+ "found to be untransitive in (" + toCheck + "," + i + ")!");
							return false;
						}
					}
					else
					{
						System.out.println("Checking transition path from (" + origY + "," + origX + "), the matrix was "
								+ "found to be untransitive in (" + toCheck + "," + i + ")!");
						return false;
					}
			}
		return true;
	}
	
	private static void printMatrix(int[][] matrix)
	{
		int columns = matrix[0].length;
		int rows = matrix.length;
		
		for (int i = 0; i < columns; i++)
		{
			String columnString = "{ ";
			
			for (int j = 0; j < rows; j++)
				columnString += matrix[i][j] + ", ";
			
			columnString = columnString.substring(0, columnString.length() - 2) + " }";
			System.out.println(columnString);
		}
		System.out.println("");
	}
}
