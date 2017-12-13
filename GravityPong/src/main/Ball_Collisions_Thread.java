package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

//***********************************
// Sprawdzanie zderzeñ w klasie przypisanej 
// w wenwn¹trz pi³ki nie dzia³a poprawnie
//***********************************

public class Ball_Collisions_Thread implements Runnable, I_Objects, I_Parameters
{
	
	// Sprawdzanie zderzenia dla ka¿dej pi³ki utworzona WEWNATRZ NIEJ!
	// Kazda pi³ka nas³uchuje czy nast¹pi³o zderzenie
	
	Thread LocalThread = new Thread(this, "Collisions_Thread");
	
	Ball_Collisions_Bits collisions_Bits = new Ball_Collisions_Bits();
	
	Ball ball;
	Shape BallsCollisions;
	Shape PaddleWithBall;

	
	static boolean loopTrigger_1=false;
	static boolean loopTrigger_2=false;
	static boolean loopTrigger_3=false;
	
	
	public Ball_Collisions_Thread(Ball ball)
	{
		this.ball=ball;
	}
	private void Check()
	{	
		
	//	BallsCollisions = Shape.intersect(TestBall_1.get_ball(),TestBall_2.get_ball());		
	//	collisions_Bits.setIntersects_1(!BallsCollisions.getBoundsInLocal().isEmpty());
		
		PaddleWithBall = Shape.intersect(ball.get_ball(),primaryPaddle.getPaddle());		
		collisions_Bits.setIntersects_2(!PaddleWithBall.getBoundsInLocal().isEmpty());
		
		DetectionAndRunFunction();
		
		try
		{
			Thread.sleep(1);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DetectionAndRunFunction()
	{
		if (collisions_Bits.isIntersects_2())
		{
			ball.get_ball().setFill(Color.RED);
			if (!loopTrigger_1)
			{
				Collisions_Calculations.CollisionWithPeddle(ball,primaryPaddle);
				loopTrigger_1 = true;
			}
		}
		else
		{
			ball.get_ball().setFill(Color.AQUA);
			loopTrigger_1 = false;
		}
		
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
