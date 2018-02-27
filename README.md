# Minesweeper
Minesweeper game

Rules:

Given a 2D array string with few mines as "m" and other places as ".".
e.g. String[][] puzzleArray = { { ".", "m", ".", "." }, { ".", ".", ".", "." }, { ".", ".", ".", "m" }, { "m", ".", ".", "." } };

Apply following rules to proceed the Minesweeper game:
1. Find all the adjacent of mine and give it the value 1, else 0.
2. Every cell directly below the mine has value 2.
3. Every cell directly to the right of mine has value 0.
4. Odd rows containing the mine are multiplied by 3.
5. Diagnol cells of mine are doubled.
6. The cells with mines "m" are given value -1.

e.g.
Step 1:
Given array

 . m . .
 
 . . . .
 
 . . . m
 
 m . . .

Step 2: 
Find all the adjacent of mine and give it the value 1.

1 m 1 0

1 1 2 1

1 1 1 m

m 1 1 1

Step 3:
Every cell directly below the mine has value 2

1 m 1 0

1 2 2 1

1 1 1 m

m 1 1 2

Step 3:
Every cell directly to the right of mine has value 0

1 m 0 0

1 2 2 1

1 1 1 m

m 0 1 2

Step 4:
Odd rows containing the mine are multiplied by 3.

1 m 0 0

1 2 2 1

1 1 1 m

m 0 3 6

Step 5:
Diagnol cells of mine are doubled.

1 m 0 0

2 2 8 1

1 2 1 m

m 0 6 6

Step 6:
putting -1 to mines

1 -1 0 0

2 2 8 1

1 2 1 -1

-1 0 6 6
