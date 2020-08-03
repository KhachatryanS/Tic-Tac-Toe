# Tic-Tac-Toe
The game starts with empty cells and ends when someone wins or there is a draw. <br>
The first coordinate goes from left to right and the second coordinate goes from bottom to top. <br>
Also, notice that coordinates start with 1 and can be 1, 2 or 3. <br>
The bottom left cell has the coordinates (1, 1) and the top right cell has the coordinates (3, 3) like in this table: <br>
<br>
(1, 3) (2, 3) (3, 3) <br>
(1, 2) (2, 2) (3, 2) <br>
(1, 1) (2, 1) (3, 1) <br><br>
This is an example which shows how program works.
<pre><p>
Game starts.
---------
|       |
|       |
|       |
---------
Enter the coordinates: 2 2
---------
|       |
|   X   |
|       |
---------
Enter the coordinates: 2 2
This cell is occupied! Choose another one!
Enter the coordinates: two two
You should enter numbers!
Enter the coordinates: 1 4
Coordinates should be from 1 to 3!
Enter the coordinates: 1 3
---------
| O     |
|   X   |
|       |
---------
Enter the coordinates: 3 1
---------
| O     |
|   X   |
|     X |
---------
Enter the coordinates: 1 2
---------
| O     |
| O X   |
|     X |
---------
Enter the coordinates: 1 1
---------
| O     |
| O X   |
| X   X |
---------
Enter the coordinates: 3 2
---------
| O     |
| O X O |
| X   X |
---------
Enter the coordinates: 2 1
---------
| O     |
| O X O |
| X X X |
---------
X wins
</p></pre>
