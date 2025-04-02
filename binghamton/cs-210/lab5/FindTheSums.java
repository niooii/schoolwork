public class FindTheSums {
	public static String arrayToString(int[][] a) {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				out.append(a[i][j] + (j == (a[0].length - 1) ? "" : " "));
			}
			if (i != a.length - 1)
				out.append('\n');
		}
		
		return out.toString();
	}

	public static int[][] horizontalSums(int[][] a, int sumToFind) {
		// simple brute force 
		int[][] ret = new int[a.length][a[0].length]; 

		final int x_max = a[0].length;
		for (int y = 0; y < a.length; y++) {
			// xa = x anchor
			for (int xa = 0; xa < x_max; xa++) {
				int sum = 0;
				for (int x = xa; x < x_max; x++) {
					final int num = a[y][x];
					sum += num;
					
					if (sum > sumToFind) 
						break;
					else if (sum == sumToFind) {
						// now set all the values we searched in the result array
						// xs = x set
						for (int xs = xa; xs <= x; xs++)
							ret[y][xs] = a[y][xs];
						break;
					}
				}
			}
		}
		
		return ret;
	}

	public static int[][] verticalSums(int[][] a, int sumToFind) {
		int[][] ret = new int[a.length][a[0].length]; 

		final int y_max = a.length;
		for (int x = 0; x < a[0].length; x++) {
			for (int ya = 0; ya < y_max; ya++) {
				int sum = 0;
				for (int y = ya; y < y_max; y++) {
					final int num = a[y][x];
					sum += num;
					
					if (sum > sumToFind) 
						break;
					else if (sum == sumToFind) {
						// now set all the values we searched in the result array
						for (int ys = ya; ys <= y; ys++)
							ret[ys][x] = a[ys][x];
						break;
					}
				}
			}
		}
		
		return ret;
	}
}
