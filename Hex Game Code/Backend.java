import java.io.*;
import java.util.*;
public class Backend
{

	public static void main(String args[])throws IOException
	{
		int player=1;
   int row ,col;
   char ch;
   
      Scanner s=new Scanner(System.in);
		int c=0;
		int board[][]=new int[11][21];
		int new_board[][]=new int[11][11];
		int i,j;
		for(i = 0; i < 11; i++)
		{
			for(j = 0; j < 21; j++)
			{
				board[i][j]=0;
			}
		}
		for(i = 1; i < 11; i++)
		{
			for(j = i; j >= 1; j--)
			{
				board[i][j-1]=-1;
			}
		}
		for(i = 11; i < 21; i++)
		{
			for(j = i; j < 21; j++)
			{
				board[i-11][j]=-1;
			}
		}


		do
		{
			c++;
			if(c%2==0)
				player=2;
			else
				player=1;


			switch(player)
			{

			case 1:
				System.out.println("Player 1");
				System.out.println("Enter the row");
				row=s.nextInt();
				System.out.println("Enter the col");
				col=s.nextInt();
				new_board[row][col]=1;
				board[row][col]=1;

for(i=0;i<11;i++)
		{
			for(j=0;j<21;j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}


				if(check(new_board,1))
				{
					System.out.println("P1 WINS");
					System.exit(0);
				}
				break;

		/*	case 2:
				System.out.println("Player 2");
				System.out.println("Enter the row");
				row=s.nextInt();
				System.out.println("Enter the col");
				col=s.nextInt();
				new_board[row][col]=2;
				board[row][col]=2;

for(i=0;i<11;i++)
		{
			for(j=0;j<21;j++)
			{
				System.out.println(board[i][j] + " ");
			}
			System.out.println();
		}

				if(check(new_board,2))
				{
					System.out.println("P2 WINS");
					System.exit(0);
				}
				break;

	*/	
			}
			System.out.println("Do you want to continue Y/N");
			ch=s.next().charAt(0);
		}while(ch!='N' && ch!='n');


		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writefile = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Sayan\\Desktop\\"+"Board"+".txt")));

		for(i=0;i<11;i++)
		{
			for(j=0;j<21;j++)
			{
				writefile.print(board[i][j] + " ");
			}
			writefile.println();
		}
		writefile.println();
		writefile.close();
	}

	static boolean check(int arr[][],int player)
	{
		DepthFirstSearch b=new DepthFirstSearch();
		if(b.countConnected(arr,player))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
