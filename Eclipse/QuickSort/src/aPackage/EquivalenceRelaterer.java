package aPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquivalenceRelaterer
{
	public static void main(String[] args)
	{
//		int[][] matrix = new int[][]
//			{
//				{ 1, 1, 1, 0, 0 },
//				{ 1, 1, 0, 0, 1 },
//				{ 1, 0, 1, 1, 0 },
//				{ 0, 0, 1, 1, 0 },
//				{ 0, 1, 0, 0, 1 }
//			};
		int[][] matrix = new int[][]
				{
					{ 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1 },
					{ 1, 0, 1, 0, 1 }
				};
		
		printMatrix(matrix);
		System.out.println("\nYou think this is an equivalence relation? " + isEquivalenceRelation(matrix) + ".");
	}
	
//	Point[] list = new Point[5];
//	...
//	for (int i=0; i<list.length; i++) {
//	    // checking Reflexive
//	    if (list[i].x == list[i].y) System.out.println("Reflexive" + list[i]);
//	    for (int j=i+1; j<list.length; j++) {
//	        // checking Symmetric
//	        if (list[i].x == list[j].y && list[i].y == list[j].x) ...
//	        for (int k=j+1; k<list.length; k++) {
//	            // checking Transitive
//	            if (list[i].x == list[k].x && list[i].y == list[j].x && ...
//	        }
//	    }
//	}
	
	private static boolean isEquivalenceRelation(int[][] matrix)
	{
		int columns = matrix[0].length;
		int rows = matrix.length;
		boolean symmetric = true;
		boolean reflexive = true;
		boolean transitive = true;
		
		for (int i = 0; i < columns; i++)
		{
			if (matrix[0][0] != matrix[i][i])
			{
				System.out.println("(" + i + "," + i + ") was found not to match (0,0); therefore, the matrix is not reflexive!");
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
			if (matrix[toCheck][i] == 1)
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
	
	private static boolean isTransitive(int[][] matrix, int y, int x, int rows, int columns)
	{
		boolean transitive = true;
		
		for (int i = x; i < columns; i++)
			if (i != x)
				if (matrix[x][i] == 1)
					transitive = isTransitive(matrix, i, y, rows, columns);
				else
				{
					transitive = false;
					System.out.println("Matching (" + y + "," + x + ") against (" + y + "," + i + "), "
							+ "the matrix was found not to be transitive!");
				}
		
		return transitive;
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
