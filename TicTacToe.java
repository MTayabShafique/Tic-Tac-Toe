import java.util.*;				// Tayyab Shafique	SP14-BCS-113
public class TicTacToe{				//   	Tic-Tac-Toe Game Project 
						
	// Intializing of Non-Changeable Variabels
	static final int Empty = 0;
    	static final int None = 0;
    	static final int User = 1;
    	static final int Comp = 2;
    	static final int Draw = 3;

public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	char Choice;
	
	// Do While Loop to Play again
	do
	{
		int Turn = User;
		
		// Declaration of Board
		int[][] Board = new int[3][3];

		int move;
		int Winner;
		
		// Instructions Printing
        	System.out.println("\n\t\t\t\t-*- This is a Tic-Tac-Toe Game! -*-\n");
		System.out.println("\t\t\t   -*- You are Playing Against The Computer! -*-\n");
		System.out.println("\t\t\t      -*- Enter 1-9 to Indicate your Move! -*-");
		
		//Board Printing
		PrintBoard(Board);

		// While Loop for (Game is not Over)
		while(true)
		{
			if(Turn == User)
			{
				System.out.println("\n\t\t\t   -*- It's your Move!\n");
				move = -1;
				while (move<0 || move>9 || Board[move/3][move%3] != Empty)
				{
		    			System.out.print("\t\t\t   -*- Please Enter Your Move(1-9): ");
	                    		move = input.nextInt();
					move = move-1;
                		}
      			}
			else
			{
				move = CompMove(Board);
				System.out.println("\n\t\t\t   -*- Computer's Move: " +(move+1));
	    		}

		    	// Updation of Board
		    	Board[(int)(move/3)][move%3] = Turn;

		    	// Printing of Board Again
		    	PrintBoard(Board);

		    	// In the Case Game is Over or Not
		    	Winner = CheckWinner(Board);

		    	if(Winner != None)
			break;

		    	// Turn Swaping
		    	if(Turn == User)
				Turn = Comp;
			else
				Turn = User;

		}

		// Result Printing
		switch(Winner)
		{
			case User:
	    			System.out.println("\n\t\t\t  -*- You Won!");
				System.out.println("\n\n\t\t\t\t\t  -*- Game by Muhammad Tayyab Shafique\n");
	    			break;
			case Comp:
	    			System.out.println("\n\t\t\t  -*- Computer Won!");
				System.out.println("\n\n\t\t\t\t\t  -*- Game by Muhammad Tayyab Shafique\n");
	    			break;
			default:
	    			System.out.println("\n\t\t\t  -*- Match Draw!");
				System.out.println("\n\n\t\t\t\t  -*- Game by Muhammad Tayyab Shafique\n");
	    			break;

		}
		System.out.print("\n\t\t\t  -*- Do you want to play again(Press y/Y for Yes Or n/N for Exit): ");
		Choice = input.next().charAt(0);

	}while(Choice == 'y' || Choice == 'Y');
}

// Printing of Board
public static void PrintBoard(int[][] Board)
{
	System.out.println("\n\t\t\t\t\t   1     2     3   ");
	System.out.println("\t\t\t\t\t-  -  -  -  -  -  -");
	System.out.print("\t\t\t\t\t|  ");
	System.out.print(PrintChar(Board[0][0]));
	System.out.print("  |  ");
	System.out.print(PrintChar(Board[0][1]));
	System.out.print("  |  ");
	System.out.print(PrintChar(Board[0][2]));
	System.out.print("  |\n");
	System.out.println("\t\t\t\t\t-  -  -  -  -  -  -");
	System.out.println("\t\t\t\t\t   4     5     6   ");
	System.out.println("\t\t\t\t\t-  -  -  -  -  -  -");
	System.out.print("\t\t\t\t\t|  ");
	System.out.print(PrintChar(Board[1][0]));
	System.out.print("  |  ");
	System.out.print(PrintChar(Board[1][1]));
	System.out.print("  |  ");
	System.out.print(PrintChar(Board[1][2]));
	System.out.print("  |\n");
	System.out.println("\t\t\t\t\t-  -  -  -  -  -  -");
	System.out.println("\t\t\t\t\t   7     8     9   ");
	System.out.println("\t\t\t\t\t-  -  -  -  -  -  -");
	System.out.print("\t\t\t\t\t|  ");
	System.out.print(PrintChar(Board[2][0]));
	System.out.print("  |  ");
	System.out.print(PrintChar(Board[2][1]));
	System.out.print("  |  ");
	System.out.print(PrintChar(Board[2][2]));
	System.out.print("  |\n");
	System.out.println("\t\t\t\t\t-  -  -  -  -  -  -");
	//System.out.println("\t\t\t\t\t-------------------\n");
}

// Returning of X & O instead of User & Computer
public static char PrintChar(int x)
{
	switch(x)
	{
		case Empty:
	    	return ' ';
		case User:
	    	return 'X';
		case Comp:
	    	return 'O';
	}
	return ' ';
}

// If the game is over & if someone won
public static int CheckWinner(int[][] Board)
{
	// Checking Horizontals

	// Top Row
	if((Board[0][0] == Board[0][1]) && (Board[0][1] == Board[0][2]))
	return Board[0][0];

	// Middle Row
	if((Board[1][0] == Board[1][1]) && (Board[1][1] == Board[1][2]))
	return Board[1][0];

	// Bottom Row
	if((Board[2][0] == Board[2][1]) && (Board[2][1] == Board[2][2]))
	return Board[2][0];

	// Checking verticals

	// Left Column
	if((Board[0][0] == Board[1][0]) && (Board[1][0] == Board[2][0]))
	return Board[0][0];

	// Middle Column
	if((Board[0][1] == Board[1][1]) && (Board[1][1] == Board[2][1]))
	return Board[0][1];

	// Right Column
	if((Board[0][2] == Board[1][2]) && (Board[1][2] == Board[2][2]))
	return Board[0][2];

	// Checking Diagonals
	// 1st Diagonal
	if((Board[0][0] == Board[1][1]) && (Board[1][1] == Board[2][2]))
	return Board[0][0];

	// 2nd Diagonal
	if((Board[0][2] == Board[1][1]) && (Board[1][1] == Board[2][0]))
	return Board[0][2];

	// Checking if the Board is full
	if(Board[0][0] == Empty || Board[0][1] == Empty || Board[0][2] == Empty ||
	   Board[1][0] == Empty || Board[1][1] == Empty || Board[1][2] == Empty ||
	   Board[2][0] == Empty || Board[2][1] == Empty || Board[2][2] == Empty)
	   return None;

	return Draw;
}



// Generating a Random Computer Move
public static int CompMove(int[][] Board)
{
	int move = (int)(Math.random()*9);
	while(Board[move/3][move%3] != Empty)
	move = (int)(Math.random()*9);
	return move;
}
}
