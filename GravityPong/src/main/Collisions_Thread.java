package main;

import javafx.scene.shape.Shape;

public class Collisions_Thread implements Runnable, I_Objects, I_Parameters
{
	Thread LocalThread = new Thread(this, "Collisions");
	Shape BallsCollisions;
	Shape PaddleWithBall_1;
	Shape PaddleWithBall_2;
	
	private void Check()
	{	
		
		BallsCollisions = Shape.intersect(TestBall_1.get_ball(),TestBall_2.get_ball());		
		collisions_Bits.setIntersects_1(!BallsCollisions.getBoundsInLocal().isEmpty());
		
		PaddleWithBall_1 = Shape.intersect(TestBall_1.get_ball(),primaryPaddle.getPaddle());		
		collisions_Bits.setIntersects_2(!PaddleWithBall_1.getBoundsInLocal().isEmpty());
		
		PaddleWithBall_2 = Shape.intersect(TestBall_2.get_ball(),primaryPaddle.getPaddle());		
		collisions_Bits.setIntersects_3(!PaddleWithBall_2.getBoundsInLocal().isEmpty());
		
	}

	@Override
	public void run()
	{
		while (true)
		{
			synchronized (this)
			{
				Check();
			}
		}
		
	}
	public void start()
	{
		LocalThread.start();
	}

}
