package poly;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
class Grids extends Canvas 
{	
        int poly,ct,fl=0,ret=0;
        int[][] arrw=new int[20][20];
        int[][] arr1=new int[20][20];
        int[][] arro=new int[20][20];
        home parent;
  	Grids(home par) 
	{
            parent = par;  
            //this.setLayout(null);
            this.setBounds(0, 0, 600, 500);
            this.setBackground(Color.white);
  	}
        public void drawpoly(int[][] arr,int f)
        {
            fl=f;
            for(int i=0;i<20;i++)
            {
                for(int j=0;j<20;j++)
                {
                    arrw[i][j]=arr[i][j];
                    arro[i][j]=arr[i][j];
                }
            }
            repaint();
        }
        public void drawpoly(int[][] arr,int[][] arrori,int f)
        {
            fl=f;
            for(int i=0;i<20;i++)
            {
                for(int j=0;j<20;j++)
                {
                    arrw[i][j]=arr[i][j];
                    arro[i][j]=arrori[i][j];
                }
            }
            repaint();
        }
        public void reset()
        {
            fl=3;
            repaint();
        }
  	public void paint(Graphics g) 
	{
            int h=0,x1=0,x2=0,y1=0,y2=0,c=0,x3=0,y3=0;
            if(fl==3)   //RESET flag check
            {
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                       arrw[i][j]=0;
                       arr1[i][j]=0;
                    }
                }
                ret=0;
                return;
            }
            g.setColor(Color.BLACK);
            if(fl==4)   //point only flag
            {
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                        if(arrw[i][j]==1)
                        {
                            g.fillOval((i+1)*25-2,(j+1)*25-2,4,4);
                        }
                    }
                }
                return;
            }
            for(int i=0;i<20;i++)
            {
                for(int j=0;j<20;j++)
                {
                    if(arrw[i][j]==1)
                    {
                        g.fillOval((i+1)*25-2,(j+1)*25-2,4,4);
                    }
                }
            }
            g.setColor(Color.RED);
            for(int i=0;i<20;i++)
            {
                for(int j=0;j<20;j++)
                {
                    if(arrw[i][j]==1)
                    {
                        if(h==0)
                        {
                            x1=i;y1=j;
                        }
                        else
                        {
                            x2=i;y2=j;
                            g.drawLine((x1+1)*25,(y1+1)*25,(x2+1)*25,(y2+1)*25);
                        }
                        h=(h+1)%2;
                    }
                }
            }
            for(int i=0;i<20;i++)
            {
                for(int j=0;j<20;j++)
                {
                    if(arrw[j][i]==1)
                    {
                        if(h==0)
                        {
                            x1=j;y1=i;
                        }
                        else
                        {
                            x2=j;y2=i;
                            g.drawLine((x1+1)*25,(y1+1)*25,(x2+1)*25,(y2+1)*25);
                        }
                        h=(h+1)%2;
                    }
                }
            }
            if(fl==1)   //Intersection detection flag
            {
                x1=0;y1=0;h=0;c=0;
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                        arr1[i][j]=arrw[i][j];
                }
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                            if(arr1[i][j]==1)
                            {
                                h=(h+1)%2;
                                continue;
                            }
                            if(h==1)
                                arr1[i][j]=6;
                    }
                }             
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                            if(arr1[j][i]==1)
                            {
                                h=(h+1)%2;
                                continue;
                            }
                            if(h==1)
                            {
                                if(arr1[j][i]==6)
                                {
                              //      System.out.println(j+" "+i);
                                    arr1[j][i]=10;
                                    arrw[j][i]=2;
                                    ret++;
                                    g.setColor(Color.cyan);
                                    g.fillOval((j+1)*25-5,(i+1)*25-5,10,10);
                                }
                                arr1[j][i]=6;                                                
                            }
                    }
                }
                g.setColor(Color.black);
                g.drawString("Total "+ret+" intersection(s)", 5, 470);
            }
            if(fl==5)   //Intersection resolving flag
            {
                x1=0;y1=0;h=0;c=0;
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                        arr1[i][j]=arrw[i][j];
                }
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                            if(arr1[i][j]==1)
                            {
                                h=(h+1)%2;
                                continue;
                            }
                            if(h==1)
                                arr1[i][j]=6;
                    }
                }             
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                            if(arr1[j][i]==1)
                            {
                                h=(h+1)%2;
                                continue;
                            }
                            if(h==1)
                            {
                                if(arr1[j][i]==6)
                                {
                              //      System.out.println(j+" "+i);
                                    arr1[j][i]=10;
                                    arrw[j][i]=2;
                                    ret++;
                                }
                                arr1[j][i]=6;                                                
                            }
                    }
                }
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                        if(arrw[i][j]==2)
                        {
                            x1=i;y1=j;
                            x2=x1;y2=y1;
                            while(arrw[++x2][y1]!=1);
                            while(arrw[x1][++y2]!=1);
                            x3=x1;y3=y2;
                            y2=y1;
                            arrw[x1][y1]=1;
                            arrw[x2][y2]=0;
                            arrw[x3][y3]=0;
                            arrw[x2][y3]=1;
                            drawpoly(arrw,arro,6);
                            g.setColor(Color.black);
                        }
                            
                    }
                }
            }
            if(fl==6)
            {
                c=0;
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                        if(arro[i][j]!=arrw[i][j])
                            c++;
                    }
                }
                g.setColor(Color.black);
                g.drawString("Total cost to resolve intersection(s) is "+c, 5, 470);
            }
  	}
}