
public class minesweeper {
	static int[][] resultArray = new int[4][4];

	public static void main(String[] args) {

		String[][] puzzleArray = { { ".", "m", ".", "." }, { ".", ".", ".", "." }, { ".", ".", ".", "m" },
				{ "m", ".", ".", "." } };
		solveMinesweeper(puzzleArray);
		for (int i = 0; i < resultArray.length; i++) {
			for (int j = 0; j < resultArray[0].length; j++) {
				System.out.print(resultArray[i][j] + "  ");
			}
			System.out.println();
		}

	}

	static int[][] solveMinesweeper(String[][] puzzleArray) {

		int x = resultArray.length - 1;
		int y = resultArray[0].length - 1;
		System.out.println(x);
		System.out.println(y);

		for (int i = 0; i < puzzleArray.length; i++) {
			for (int j = 0; j < puzzleArray[0].length; j++) {
				if (puzzleArray[i][j] == ".")
					resultArray[i][j] = 0;
				else
					resultArray[i][j] = -1;
			}

		}

		// find adjacent and assign value 1 or 0
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (resultArray[i][j] == -1) {
					// find adjacent of m and assign value 1
					if (isAdjacent(i, j, x, y)) {
						if (isAdjacent(i, j - 1, x, y))
							if (resultArray[i][j - 1] == 1)
								resultArray[i][j - 1] += 1;
							else
								resultArray[i][j - 1] = 1;
						if (isAdjacent(i + 1, j, x, y))
							if (resultArray[i + 1][j] == 1)
								resultArray[i + 1][j] += 1;
							else
								resultArray[i + 1][j] = 1;
						if (isAdjacent(i - 1, j, x, y))
							if (resultArray[i - 1][j] == 1)
								resultArray[i - 1][j] += 1;
							else
								resultArray[i - 1][j] = 1;
						if (isAdjacent(i, j + 1, x, y))
							if (resultArray[i][j + 1] == 1)
								resultArray[i][j + 1] += 1;
							else
								resultArray[i][j + 1] = 1;
						if (isAdjacent(i - 1, j + 1, x, y))
							if (resultArray[i - 1][j + 1] == 1)
								resultArray[i - 1][j + 1] += 1;
							else
								resultArray[i - 1][j + 1] = 1;
						if (isAdjacent(i + 1, j - 1, x, y))
							if (resultArray[i + 1][j - 1] == 1)
								resultArray[i + 1][j - 1] += 1;
							else
								resultArray[i + 1][j - 1] = 1;
						if (isAdjacent(i + 1, j + 1, x, y))
							if (resultArray[i + 1][j + 1] == 1)
								resultArray[i + 1][j + 1] += 1;
							else
								resultArray[i + 1][j + 1] = 1;
						if (isAdjacent(i - 1, j - 1, x, y))
							if (resultArray[i - 1][j - 1] == 1)
								resultArray[i - 1][j - 1] += 1;
							else
								resultArray[i - 1][j - 1] = 1;
					}
				}
			}
		}

		// assigning value 2 to directly below mine cell
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (isAdjacent(i, j, x, y))
					if (isAdjacent(i + 1, j, x, y))
						if (resultArray[i][j] == -1)
							resultArray[i + 1][j] = 2;
			}
		}

		// assigning value 0 to directly right of mine cell
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (isAdjacent(i, j, x, y))
					if (isAdjacent(i, j + 1, x, y))
						if (resultArray[i][j] == -1)
							resultArray[i][j + 1] = 0;
			}
		}

		// multiply odd rows containing mine by 3
		for (int i = 1; i <= x; i = i + 2) {
			for (int j = 0; j <= y; j++) {
				if (resultArray[i][j] == -1) {
					for (int k = 0; k <= y; k++) {
						if (resultArray[i][k] != -1)
							resultArray[i][k] *= 3;
					}
				}
			}
		}

		// double the value of diagonal cell to mine
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (resultArray[i][j] == -1) {
					if (isAdjacent(i - 1, j - 1, x, y))
						resultArray[i - 1][j - 1] *= 2;
					if (isAdjacent(i - 1, j + 1, x, y))
						resultArray[i - 1][j + 1] *= 2;
					if (isAdjacent(i + 1, j - 1, x, y))
						resultArray[i + 1][j - 1] *= 2;
					if (isAdjacent(i + 1, j + 1, x, y))
						resultArray[i + 1][j + 1] *= 2;
				}
			}
		}

		return resultArray;
	}

	static boolean isAdjacent(int i, int j, int x, int y) {
		boolean flag = false;
		if (i >= 0 && i <= x && j >= 0 && j <= y) {
			flag = true;
		}
		return flag;

	}
}
