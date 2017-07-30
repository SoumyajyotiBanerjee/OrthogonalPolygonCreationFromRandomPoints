package poly;
import java.io.*;
public class setit
{
    int cost=0,ci=0,cj=0,hoz=0,vert=0,flag=0,flagb=0,temp,tmp,x,y,p,q,total=0;
    int[] hor=new int[20];
    int[]ver=new int[20];
    int[] notx=new int[20];
    int[]noty=new int[20];
    setit(int[][] set,int point)
    {
        int r=20,flag=0,SIZE=20;    
        if(point==1)
        {
            for(int i=0;i<SIZE;i++)
            {
		for(int j=0;j<SIZE;j++)
                {
			if(flag==0)
			{
			        if(set[i][j]==1)
				{
					if(i<((SIZE)-1) && j<((SIZE)-1))
					{
						set[i+1][j+1]=1;
						set[i][j+1]=1;
						set[i+1][j]=1;
						cost+=3;     
					}
					else if(i==((SIZE)-1) && j<((SIZE)-1))
					{
						set[i-1][j+1]=1;
						set[i-1][j]=1;
						set[i][j+1]=1;
						cost+=3;     
					}
					else if(i<((SIZE)-1) && j==((SIZE)-1))
					{
						set[i+1][j-1]=1;
						set[i+1][j]=1;
						set[i][j-1]=1;
						cost+=3;
					}
					else if(i==((SIZE)-1) && j==((SIZE)-1))
					{
						set[i-1][j-1]=1;
						cost++;
					}
					flag=1;						
				}
			}
		}
			
	}
    }
    for(int i=0;i<SIZE;i++)
    {
	hor[i]=0;
	ver[i]=0;
        notx[i]=0;
	noty[i]=0;
    }
    for(int i=0;i<SIZE;i++)
	{
		for(int j=0;j<SIZE;j++)
		{
			if(set[i][j]==1)
			{
				hor[i]++;
				ver[j]++;
				
			}
		}
	}	
	for(int i=0;i<SIZE;i++)
	{
		if(hor[i]%2!=0 && hor[i]!=0)
		{
			notx[ci]=i;
			ci++;
		}
		if(ver[i]%2!=0 && ver[i]!=0)
		{
			noty[cj]=i;
			cj++;
		}
              
	}
	hoz=ci;
	vert=cj;
	
	//=====================================================================================//
		flag=1;int ii;
		tmp=notx[0];
		for(ii=0;ii<(hoz-1);ii++)
		{
		
			if(notx[ii+1]!=noty[ii+1])
			{
				notx[ii]=notx[ii+1];
				flag=0;
			}
			else
			{
				break;	
			}
			
		}
		//notx[(hoz-1)]=tmp;
		if(flag==0)
		{
			notx[ii]=tmp;
		}

	
	
	//====================================================================================//
	int i=0;
	int j=0;
	while(i<ci && j<cj)
	{
		x=notx[i];
		y=noty[j];
		if(set[x][y]!=1)
		{
			set[x][y]=1;
			i++;
			j++;
			hor[x]++;
			ver[y]++;
                        cost++;
		}
		else
		{
			set[x][y]=0;
			i++;
			j++;
			hor[x]--;
			ver[y]--;
                        cost++;
		}
		
	}
       
	p=i;
	q=j;
	flagb=0;
	if(p<ci)
	{
		if((ci-p)%2==0)
		{
			flagb=0;
			for(i=0;i<SIZE;i++)
			{
				if(set[notx[p]][i]==0 && set[notx[p+1]][i]==0)
				{
					set[notx[p]][i]=1;
					set[notx[p+1]][i]=1;
					flagb=1;
                                        cost+=2;
				}
				if(flagb==1)
				{
					p=p+2;
					flagb=0;
					i=-1;
					if(p>=ci)
					{
						break;
					}
				}
			}
		}
		if((ci-p)%2==1)
		{
			
			temp=ci-1;
			flag=0;
			for(i=0;i<SIZE;i++)
			{
				
					if(set[notx[temp]][i]==1 && flag==0)
					{
						set[notx[temp]][i]=1;
						flag=1;
                                                cost++;
					}
				
			}
			for(i=0;i<SIZE;i++)
			{
				if(set[notx[p]][i]==0 && set[notx[p+1]][i]==0)
				{
					set[notx[p]][i]=1;
					set[notx[p+1]][i]=1;
					flagb=1;
                                        cost+=2;
				}
				if(flagb==1)
				{
					p=p+2;
					flagb=0;
					i=-1;
					if(p>=temp)
					{
						break;
					}
				}
			}
		}
	}
	if(q<cj)
	{
		flagb=0;
		flag=0;
		if((cj-q)%2==0)
		{
			for(i=0;i<SIZE;i++)
			{
				if(set[i][noty[q]]==0 && set[i][noty[q+1]]==0)
				{
					set[i][noty[q]]=1;
					set[i][noty[q+1]]=1;
					flagb=1;
                                        cost+=2;
				}
				if(flagb==1)
				{
					q=q+2;
					flagb=0;
					i=-1;
					if(q>=cj)
					{
						break;
					}
				}
			}
		}
		if((cj-q)%2==1)
		{
			flag=0;
			temp=cj-1;
			flagb=0;
			for(i=0;i<SIZE;i++)
			{
			
				if(set[i][noty[temp]]==1 && flag==0)
				{
					set[i][noty[temp]]=0;
					flag=1;
                                        cost++;
				}
			}
			for(i=0;i<SIZE;i++)
			{
				if(set[i][noty[q]]==0 && set[i][noty[q+1]]==0)
				{
					set[i][noty[q]]=1;
					set[i][noty[q+1]]=1;
					flagb=1;
                                        cost+=2;
				}
				if(flagb==1)
				{
					q=q+2;
					flagb=0;
					i=-1;
					if(q>=temp)
					{
						break;
					}
				}
			}
		}
	}
        for(i=0;i<SIZE;i++)
	{
		for(j=0;j<SIZE;j++)
		{
			if(set[i][j]>0)
			{
				total++;
			}
		}
	}
        point=total;
    }
}