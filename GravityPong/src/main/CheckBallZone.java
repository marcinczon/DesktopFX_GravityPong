package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class CheckBallZone implements Runnable,Objects,Parameters
{

	Thread LocalThread = new Thread(this, "CheckBallZone");
	Shape collisionShape1;
	Shape collisionShape2;
	Shape collisionShape3;
	Shape collisionShape4;
	Shape collisionShape5;
	Shape collisionShape6;
	Shape collisionShape7;
	Shape collisionShape8;
	
	
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
		
		
		collisionShape1 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_1);		
		zones.setIntersects_1(!collisionShape1.getBoundsInLocal().isEmpty());
		collisionShape2 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_2);		
		zones.setIntersects_2(!collisionShape2.getBoundsInLocal().isEmpty());
		collisionShape3 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_3);		
		zones.setIntersects_3(!collisionShape3.getBoundsInLocal().isEmpty());
		collisionShape4 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_4);		
		zones.setIntersects_4(!collisionShape4.getBoundsInLocal().isEmpty());
		collisionShape5 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_5);		
		zones.setIntersects_5(!collisionShape5.getBoundsInLocal().isEmpty());
		collisionShape6 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_6);		
		zones.setIntersects_6(!collisionShape6.getBoundsInLocal().isEmpty());
		collisionShape7 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_7);		
		zones.setIntersects_7(!collisionShape7.getBoundsInLocal().isEmpty());
		collisionShape8 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_8);		
		zones.setIntersects_8(!collisionShape8.getBoundsInLocal().isEmpty());
		
		if (ShowZoneActive)
		{
			if (zones.isIntersects_1())
			{
				ZoneRectangle_1.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_1.setFill(Color.TRANSPARENT);
			}

			if (zones.isIntersects_2())
			{
				ZoneRectangle_2.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_2.setFill(Color.TRANSPARENT);
			}

			if (zones.isIntersects_3())
			{
				ZoneRectangle_3.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_3.setFill(Color.TRANSPARENT);
			}

			if (zones.isIntersects_4())
			{
				ZoneRectangle_4.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_4.setFill(Color.TRANSPARENT);
			}

			if (zones.isIntersects_5())
			{
				ZoneRectangle_5.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_5.setFill(Color.TRANSPARENT);
			}

			if (zones.isIntersects_6())
			{
				ZoneRectangle_6.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_6.setFill(Color.TRANSPARENT);
			}

			if (zones.isIntersects_7())
			{
				ZoneRectangle_7.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_7.setFill(Color.TRANSPARENT);
			}

			if (zones.isIntersects_8())
			{
				ZoneRectangle_8.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_8.setFill(Color.TRANSPARENT);
			}
		}	
		else
		{
			ZoneRectangle_1.setFill(Color.TRANSPARENT);
			ZoneRectangle_2.setFill(Color.TRANSPARENT);
			ZoneRectangle_3.setFill(Color.TRANSPARENT);
			ZoneRectangle_4.setFill(Color.TRANSPARENT);
			ZoneRectangle_5.setFill(Color.TRANSPARENT);
			ZoneRectangle_6.setFill(Color.TRANSPARENT);
			ZoneRectangle_7.setFill(Color.TRANSPARENT);
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
