package poly;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
class Grids extends Canvas 
{	
        int poly,ct,fl=0;
	int[][] arr1=new int[20][20];
        int[][] arrw=new int[20][20];
        home parent;
  	Grids(home par) 
	{
            parent = par;  
            //this.setLayout(null);
            this.setBounds(0, 0, 600, 500);
            this.setBackground(Color.white);
  	}
        public void drawpoly(int[][] arr,int cont,int f)
        {
            if(f==6)
            {
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                        if(arr[i][j]==1)
                        {
                            if(arrw[i][j]==0)
                            {
                                arrw[i][j]=1;
                                arr1[i][j]=1;
                            }
                        }
                    }
                }
            }
            else if(f!=1&&f!=6)
            {
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                        arr1[i][j]=arr[i][j];
                }
            }
            else
            {
                for(int i=0;i<20;i++)
                {
                    for(int j=0;j<20;j++)
                    {
                        arrw[i][j]=arr[i][j];
                        arr1[i][j]=arr[i][j];
                    }
                }
            }
            ct=cont;
            poly=0;
            fl=f;
            if(cont==0)
                fl=0;
            repaint();
        }
        public void reset()
        {
            fl=0;
            repaint();
        }
  	public void paint(Graphics g) 
	{
  		int k,h,x1=0,y1=0,co=0,c=0,c1=0,x3=0,y3=0,x2=0,y2=0,f,i=0,j=0,flag;
                if(fl==0)
                {
                    for(int x=0;x<20;x++)
                    {
                        for(int y=0;y<20;y++)
                        {
                            arrw[x][y]=0;
                            arr1[x][y]=0;
                        }
                    }
                    return;
                }
                if(fl==1||fl==2)
                {
                    for(i=0;i<20;i++)
                    {
                        for(j=0;j<20;j++)
                        {
                            if(arrw[i][j]==1)
                            {
                                g.fillOval((i+1)*25-2,(j+1)*25-2,4,4);
                            }
                        }
                    }
                }
                if(fl==1)
                {
                    return;
                }
                else if(fl==2||fl==3||fl==6)
                {
                    for(i=0;i<20;i++)
                    {
                        for(j=0;j<20;j++)
                        {
                            if(arr1[i][j]==1&&arrw[i][j]==1)
                            {
                                g.setColor(Color.black);
                                g.fillOval((i+1)*25-2,(j+1)*25-2,4,4);
                            }
                            else if(arr1[i][j]==1&&arrw[i][j]==0)
                            {
                                g.setColor(Color.green);
                                g.fillOval((i+1)*25-2,(j+1)*25-2,4,4);
                            }
                            else if(arr1[i][j]==0&&arrw[i][j]==1)
                            {
                                g.setColor(Color.red);
                                g.fillOval((i+1)*25-2,(j+1)*25-2,4,4);
                            }
                        }
                    }
                    if(fl==3||fl==6)
                        return;
                }
                else if(fl==4||fl==5)
                {
                    g.setColor(Color.black);
                    for(i=0;i<20;i++)
                    {
                        for(j=0;j<20;j++)
                        {
                            if(arr1[i][j]==1)
                            {
                                g.fillOval((i+1)*25-2,(j+1)*25-2,4,4);
                            }
                        }
                    }
                    if(fl==5)
                        return;
                }
                for(i=0;i<20;i++)
		{
			c=0;
			for(j=0;j<20;j++)
			{
				if(arr1[i][j]==1)
                                    c++;
			}
			if(c%2!=0)
				break;
		}
		if(c%2!=0)
		{
			g.drawString("Point set not correct!!!! please set....", 0, 470);
			return;
		}		
		for(i=0;i<20;i++)
		{
			c=0;
			for(j=0;j<20;j++)
			{
				if(arr1[j][i]==1)
					c++;
			}
			if(c%2!=0)
				break;
		}
          /*      for(i=0;i<20;i++)
                {
                    for(j=0;j<20;j++)
                    {
                        if(arr1[i][j]==1)
                        {
                            g.fillOval((i+1)*25,(j+1)*25,1,1);
                        }
                    }
                }*/
                if(c%2!=0)
		{
			g.drawString("Point set not correct!!!! please set....", 0, 470);
			return;
		}
             // g.setColor(Color.red);
		while(true)
		{
                        if(poly%3==0)
                            g.setColor(Color.red);
                        else if(poly%3==1)
                            g.setColor(Color.blue);
                        else
                            g.setColor(Color.green);
			h=1;poly++;
			for(i=0;i<20;i++)
			{
				for(j=0;j<20;j++)
				{
					if(arr1[i][j]==1)
					{
						arr1[i][j]=2;
						x1=i;y1=j;h=0;
						co++;
						break;
					}
				}
				if(h==0)
					break;
			}
			flag=0;
			while(true)
			{
				try{
  					//do what you want to do before sleeping
  					Thread.sleep(300);//sleep for 1000 ms
  					//do what you want to do after sleeptig
				}
				catch(Exception ie){
					//If this thread was intrrupted by nother thread 
				}
				c=0;
				if(h==0)
				{
					for(k=0;k<20;k++)
					{
						if(k==y1)
							break;
						if(arr1[x1][k]==1)
						{
							x2=x1;y2=k;
							c++;
						}
						else if(arr1[x1][k]==2)
						{
							x3=x1;y3=k;
						}
					}
					if(c%2==0)
					{
						c1=0;f=1;
						for(k=y1+1;k<20;k++)
						{
							if(arr1[x1][k]==1)
							{
								if(f==1)
								{
									x2=x1;y2=k;
									f=0;
								}
								c1++;
							}
							else if(arr1[x1][k]==2)
							{
								x3=x1;y3=k;
							}
							
						}
						if(c1%2==0)
						{
							g.drawLine((x1+1)*25,(y1+1)*25,(x3+1)*25,(y3+1)*25);
							arr1[x1][y1]=0;
							arr1[x3][y3]=0;
							break;
						}
						else
						{
							g.drawLine((x1+1)*25,(y1+1)*25,(x1+1)*25,(y2+1)*25);
							if(flag==0)
								flag=1;
							else
								arr1[x1][y1]=0;
							arr1[x2][y2]=0;
							x1=x2;y1=y2;
							co++;
						}
					}
					else
					{
						g.drawLine((x1+1)*25,(y1+1)*25,(x2+1)*25,(y2+1)*25);
						if(flag==0)
							flag=1;
						else
							arr1[x1][y1]=0;
						arr1[x2][y2]=0;
						x1=x2;y1=y2;
						co++;
					}
					h=1;
				}
				else
				{
					for(k=0;k<20;k++)
					{
						if(k==x1)
							break;
						if(arr1[k][y1]!=0)
						{
							x2=k;y2=y1;
							c++;
						}
						if(arr1[k][y1]==2)
						{
							x3=k;y3=y1;
						}
					}
					if(c%2==0)
					{
						c1=0;f=1;
						for(k=x1+1;k<20;k++)
						{
							if(arr1[k][y1]!=0)
							{
								if(f==1)
								{
									x2=k;y2=y1;
									f=0;
								}
								c1++;
							}
							if(arr1[k][y1]==2)
							{
								x3=k;y3=y1;
							}
							
						}
						if(c1%2==0)
						{
							g.drawLine((x1+1)*25,(y1+1)*25,(x3+1)*25,(y3+1)*25);
							arr1[x1][y1]=0;
							arr1[x3][y3]=0;
							break;
						}
						else
						{
							g.drawLine((x1+1)*25,(y1+1)*25,(x2+1)*25,(y2+1)*25);
							if(flag==0)
								flag=1;
							else
								arr1[x1][y1]=0;
							arr1[x2][y2]=0;
							if(x2==x3&&y2==y3)
								break;
							x1=x2;y1=y2;
							co++;
						}
					}
					else
					{
						g.drawLine((x1+1)*25,(y1+1)*25,(x2+1)*25,(y2+1)*25);
						if(flag==0)
							flag=1;
						else
							arr1[x1][y1]=0;
						arr1[x2][y2]=0;
						if(x2==x3&&y2==y3)
							break;
						x1=x2;y1=y2;
						co++;
					}
					h=0;
				}
			}
			//System.out.println(co+" "+ct);
			if(co==ct)
			{
                                g.setColor(Color.black);
                                g.drawString("Total "+poly+" polygon(s)", 5, 470);
				//System.out.println("Total "+poly+" polygons constructed");
				//System.exit(0);
				return;
			}
		}		
  	}
}