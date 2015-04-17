package aPackage;

public class EquivalenceRelaterer
{
	public static void main(String[] args)
	{
		int[][] matrix = new int[][]
			{
				{ 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 0 },
				{ 0, 0, 1, 1, 0 },
				{ 0, 1, 0, 0, 1 }
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
		boolean transitive = true; // TODO
		
		for (int i = 0; i < columns; i++)
		{
			if (matrix[0][0] != matrix[i][i])
			{
				System.out.println("(" + i + "," + i + ") was found not to be reflexive!");
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
				{
					int cursor = matrix[i][j];
					while (cursor == 1)
					{
						
					}
				}
			}
		}
		return symmetric && reflexive && transitive;
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
