import java.util.*;
import java.io.*;
import java.util.*;
public class Backend1 extends DepthFirstSearch
{
	static boolean visited[][]=new boolean[11][11];
	static int count=0;
	 //static AI a=new AI(); 
	public int[] cpu(int board[][], int new_board[][],AI a)
	{
		StringTokenizer st;
		Scanner s=new Scanner(System.in);
		int c=0;
	//	int board[][]=new int[11][21];
		//int new_board[][]=new int[11][11];
		Random r=new Random();
		int i,j;
		
		
		char ch;
		int row,col,player;
		boolean won=false;
		boolean allowed;
 do
 {
				
			
					allowed=true;
					
					if(count==0)
					{
						row=0;
						
						col=r.nextInt(9)+2;
						
						a.path(col);
					}
					else
					{
					
						if(a.checkdel()&&!a.f)
						{
							st=new StringTokenizer(a.get_Next()," ");
							row=Integer.parseInt(st.nextToken());
							col=Integer.parseInt(st.nextToken());
						}
						else
						{
							count=-1;
                     row=0;
							col=r.nextInt(9)+2;
							
						}
			        }
                 
                 count++;

         System.out.println(new_board[row][col]);
         if(new_board[row][col]!=0)
         allowed=false;
         else
         {	new_board[row][col]=1;
				board[row][col+row]=1;
		      allowed=true;
          }
                  
     
            	
       }while(allowed==false);						
					//if((row>=0&&row<11)&&(col>=0&&col<11))
				//	{

						/*if(visited[row][col]==true&&new_board[row][col]==2)
						{
							allowed=false;
							System.out.println("Invalid! Enter Again");
						}
						else
						{
							allowed=true;
        (/             
							new_board[row][col]=1;
							board[row][col+row]=1;
						
                  }
				//	}
				/*	else
					{
						allowed=false;
						System.out.println("Invalid! Enter Again");
					}*/
						
					//}
								//visited[row][col]=true;
      //}while(!allowed);
     
    int p[]=new int[2];
    p[0]=row;
    p[1]=col;
    return p;
      }
}