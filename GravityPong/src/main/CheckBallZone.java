package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class CheckBallZone implements Runnable,Objects,Parameters
{

	Thread LocalThread = new Thread(this, "CheckBallZone");
	Shape collisionShape;
	boolean intersects_1;
	boolean intersects_2;
	boolean intersects_3;
	boolean intersects_4;
	boolean intersects_5;
	boolean intersects_6;
	boolean intersects_7;
	boolean intersects_8;
	
	public CheckBallZone()
	{
	
	}
	private void CheckZone()
	{
		//Ustawienie koloru
//		//ZoneRectangle_1.setFill(Color.TRANSPARENT);
//		ZoneRectangle_2.setFill(Color.TRANSPARENT);
//		ZoneRectangle_3.setFill(Color.TRANSPARENT);
//		ZoneRectangle_4.setFill(Color.TRANSPARENT);
//		ZoneRectangle_5.setFill(Color.TRANSPARENT);
//		ZoneRectangle_6.setFill(Color.TRANSPARENT);
//		ZoneRectangle_7.setFill(Color.TRANSPARENT);
//		ZoneRectangle_8.setFill(Color.TRANSPARENT);
		
		
		collisionShape = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_1);		
		intersects_1 = collisionShape.getBoundsInLocal().isEmpty();
		collisionShape = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_2);		
		intersects_2 = collisionShape.getBoundsInLocal().isEmpty();
		collisionShape = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_3);		
		intersects_3 = collisionShape.getBoundsInLocal().isEmpty();
		collisionShape = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_4);		
		intersects_4 = collisionShape.getBoundsInLocal().isEmpty();
		collisionShape = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_5);		
		intersects_5 = collisionShape.getBoundsInLocal().isEmpty();
		collisionShape = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_6);		
		intersects_6 = collisionShape.getBoundsInLocal().isEmpty();
		collisionShape = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_7);		
		intersects_7 = collisionShape.getBoundsInLocal().isEmpty();
		collisionShape = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_8);		
		intersects_8 = collisionShape.getBoundsInLocal().isEmpty();
		
		if(!intersects_1)
		{
			ZoneRectangle_1.setFill(Color.BLUE);			
		}
		else
		{
			ZoneRectangle_1.setFill(Color.TRANSPARENT);
		}		
		
		if(!intersects_2)
		{
			ZoneRectangle_2.setFill(Color.RED);
		}
		else
		{
			ZoneRectangle_2.setFill(Color.TRANSPARENT);
		}
		
		if(!intersects_3)
		{
			ZoneRectangle_3.setFill(Color.RED);
		}
		else
		{
			ZoneRectangle_3.setFill(Color.TRANSPARENT);
		}		
		
		if(!intersects_4)
		{
			ZoneRectangle_4.setFill(Color.RED);
		}
		else
		{
			ZoneRectangle_4.setFill(Color.TRANSPARENT);
		}
		
		if(!intersects_5)
		{
			ZoneRectangle_5.setFill(Color.RED);
		}
		else
		{
			ZoneRectangle_5.setFill(Color.TRANSPARENT);
		}		
		
		if(!intersects_6)
		{
			ZoneRectangle_6.setFill(Color.RED);
		}
		else
		{
			ZoneRectangle_6.setFill(Color.TRANSPARENT);
		}
		
		if(!intersects_7)
		{
			ZoneRectangle_7.setFill(Color.RED);
		}
		else
		{
			ZoneRectangle_7.setFill(Color.TRANSPARENT);
		}		
		
		if(!intersects_8)
		{
			ZoneRectangle_8.setFill(Color.RED);
		}
		else
		{
			ZoneRectangle_8.setFill(Color.TRANSPARENT);
		}
		

		
	}
		
	
	
	
	@Override
	public void run()
	{
		while (true)
		{
			synchronized (this)
			{
				CheckZone();
			}
		}
		// TODO Auto-generated method stub
		
	}
	public void Start()
	{
		LocalThread.start();
	}
	

}
