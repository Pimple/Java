package aPackage;

public class Hate {

	public static void main(String[] args)
	{
		int x = 2;
		int y = 2;
		int z = -599;
		System.out.println("Max = " + hate(x, y, z));
	}
	
	private static int hate(int x, int y, int z)
	{
		int max = -1;
		if (x > y && x > z)
			max = x;
		else if (y > x && y > z)
			max = y;
		else if (!(x > y && x > z) && !(y > x && y > z))
			max = z;
		return max;
	}
}
