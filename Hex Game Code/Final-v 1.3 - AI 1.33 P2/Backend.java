/*VERSION 1.3*/
/*
 *THE VARIABLES WITH NAME "ROW" AND "COL" HAVE THE ROW AND COLUMN INDEX*/

import java.io.*;
import java.util.*;
public class Backend extends DepthFirstSearch
{
	static boolean visited[][]=new boolean[11][11];
	static int count=0;
	  
	public static void main(String args[])throws IOException
	{
		StringTokenizer st;
		Scanner s=new Scanner(System.in);
		int c=0;
		int board[][]=new int[11][21];
		int new_board[][]=new int[11][11];
		Random r=new Random();
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
		
		AI a=new AI();
		char ch;
		int row,col,player;
		boolean won=false;
		boolean allowed;
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
				do
				{
					allowed=true;
					System.out.println("Player 1");
					for(i=0;i<11;i++)
					{
						for(j=0;j<21;j++)
						{
							if(board[i][j]!=-1)
							{
								System.out.print(board[i][j] + " ");
							}
							else
							{
								System.out.print(" ");
							}
						}
						System.out.println();
					}
					System.out.println("Enter the row");
					row=s.nextInt();
					System.out.println("Enter the col");
					col=s.nextInt();

					if((row>=0&&row<11)&&(col>=0&&col<11))
					{
					
						if(visited[row][col]==true&&new_board[row][col]==2)
						{
							allowed=false;
							System.out.println("Invalid! Enter Again");
						}
						else
						{
							allowed=true;
							new_board[row][col]=1;
							board[row][col+row]=1;
							a.select(a.node(row,col));
							
							
						}
					}
					else
					{
						allowed=false;
						System.out.println("Invalid! Enter Again");
					}

				}while(!allowed);

				visited[row][col]=true;
				if(check(new_board,1))
				{
					for(i=0;i<11;i++)
					{
						for(j=0;j<21;j++)
						{
							if(board[i][j]!=-1)
							{
								System.out.print(board[i][j] + " ");
							}
							else
							{
								System.out.print(" ");
							}
						}
						System.out.println();
					}
					System.out.println();
					System.out.println("CONGRATULATIONS!!!!");
					System.out.println("P1 WINS");
					won=true;
					
					System.exit(0);
				}
				break;
				
			case 2:
				do
				{
					allowed=true;
					System.out.println("Player 2");
					for(i=0;i<11;i++)
					{
						for(j=0;j<21;j++)
						{
							if(board[i][j]!=-1)
							{
								System.out.print(board[i][j] + " ");
							}
							else
							{
								System.out.print(" ");
							}
						}
						System.out.println();
					}
					
					row=0;col=0;
					if(count==0)
					{
						row=r.nextInt(9)+2;
						col=0;
						a.path(row);
					}
					else
					{
					
						if(a.checkdel())
						{
							st=new StringTokenizer(a.get_Next()," ");
							row=Integer.parseInt(st.nextToken());
							col=Integer.parseInt(st.nextToken());
						}
						else
						{
							count=-1;
							
						}
						
					
						
					}
					count++;
									
					if((row>=0&&row<11)&&(col>=0&&col<11))
					{

						if(visited[row][col]==true&&new_board[row][col]==1)
						{
							allowed=false;
							System.out.println("Invalid! Enter Again");
						}
						else
						{
							allowed=true;
							new_board[row][col]=2;
							board[row][col+row]=2;
						}
					}
					else
					{
						allowed=false;
						System.out.println("Invalid! Enter Again");
					}

				}while(!allowed);
				visited[row][col]=true;
				if(check(new_board,2))
				{
					for(i=0;i<11;i++)
					{
						for(j=0;j<21;j++)
						{
							if(board[i][j]!=-1)
							{
								System.out.print(board[i][j] + " ");
							}
							else
							{
								System.out.print(" ");
							}
						}
						System.out.println();
					}
					System.out.println();
					System.out.println("CONGRATULATIONS!!!!");
					System.out.println("PLAYER 2 WINS");
					won=true;

					System.exit(0);
				}
				break;
					
					
					
				
			}
		}while(won==false);
			
		
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writefile = new PrintWriter(new BufferedWriter(new FileWriter("E:\\Rajath\\ADA Project\\ADA Project\\"+"Board"+".txt")));
		
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
		int i,j;
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