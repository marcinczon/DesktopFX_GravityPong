package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class ZoneBall_Thread implements Runnable,I_Objects,I_Parameters
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
	
	
	public ZoneBall_Thread()
	{
	
	}
	private void CheckZone()
	{	
		
		collisionShape1 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_1);		
		zonesBit.setIntersects_1(!collisionShape1.getBoundsInLocal().isEmpty());
		collisionShape2 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_2);		
		zonesBit.setIntersects_2(!collisionShape2.getBoundsInLocal().isEmpty());
		collisionShape3 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_3);		
		zonesBit.setIntersects_3(!collisionShape3.getBoundsInLocal().isEmpty());
		collisionShape4 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_4);		
		zonesBit.setIntersects_4(!collisionShape4.getBoundsInLocal().isEmpty());
		collisionShape5 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_5);		
		zonesBit.setIntersects_5(!collisionShape5.getBoundsInLocal().isEmpty());
		collisionShape6 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_6);		
		zonesBit.setIntersects_6(!collisionShape6.getBoundsInLocal().isEmpty());
		collisionShape7 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_7);		
		zonesBit.setIntersects_7(!collisionShape7.getBoundsInLocal().isEmpty());
		collisionShape8 = Shape.intersect(TestBall_1.get_ball(), ZoneRectangle_8);		
		zonesBit.setIntersects_8(!collisionShape8.getBoundsInLocal().isEmpty());
		
		if (ShowZoneActive)
		{
			if (zonesBit.isIntersects_1())
			{
				ZoneRectangle_1.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_1.setFill(Color.TRANSPARENT);
			}

			if (zonesBit.isIntersects_2())
			{
				ZoneRectangle_2.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_2.setFill(Color.TRANSPARENT);
			}

			if (zonesBit.isIntersects_3())
			{
				ZoneRectangle_3.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_3.setFill(Color.TRANSPARENT);
			}

			if (zonesBit.isIntersects_4())
			{
				ZoneRectangle_4.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_4.setFill(Color.TRANSPARENT);
			}

			if (zonesBit.isIntersects_5())
			{
				ZoneRectangle_5.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_5.setFill(Color.TRANSPARENT);
			}

			if (zonesBit.isIntersects_6())
			{
				ZoneRectangle_6.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_6.setFill(Color.TRANSPARENT);
			}

			if (zonesBit.isIntersects_7())
			{
				ZoneRectangle_7.setFill(Color.AZURE);
			} else
			{
				ZoneRectangle_7.setFill(Color.TRANSPARENT);
			}

			if (zonesBit.isIntersects_8())
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
