package main;

//***********************************
//Sprawdzanie zderzeñ w klasie przypisanej 
//w wenwn¹trz pi³ki nie dzia³a poprawnie
//***********************************

public class Ball_Collisions_Bits
{
	private boolean intersects_Any=false;
	private boolean intersects_1=false;
	private boolean intersects_2=false;
	private boolean intersects_3=false;

	
	public boolean isIntersects_1()
	{
		return intersects_1;
	}
	public void setIntersects_1(boolean intersects_1)
	{
		this.intersects_1 = intersects_1;
	}
	public boolean isIntersects_2()
	{
		return intersects_2;
	}
	public void setIntersects_2(boolean intersects_2)
	{
		this.intersects_2 = intersects_2;
	}
	public boolean isIntersects_3()
	{
		return intersects_3;
	}
	public void setIntersects_3(boolean intersects_3)
	{
		this.intersects_3 = intersects_3;
	}
	public boolean isIntersects_Any()
	{
		if(intersects_1 || intersects_2 || intersects_3)
		{
			intersects_Any=true;
		}
		else
		{
			intersects_Any=false;
		}
		return intersects_Any;
	}

}
