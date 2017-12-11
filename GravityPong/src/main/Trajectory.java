package main;

public class Trajectory implements Runnable
{
	private double x,y;
	private long time;
	
	public Trajectory(double x,double y,long t)
	{
		this.x=x;
		this.y=y;
		this.time=t;
	}
	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public long getTime()
	{
		return time;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public void setTime(int t)
	{
		this.time = t;
	}
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}
}
