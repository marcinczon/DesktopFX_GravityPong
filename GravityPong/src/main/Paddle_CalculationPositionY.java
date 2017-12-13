package main;

public class Paddle_CalculationPositionY implements Runnable,I_Parameters
{
	private  double PosY;
	private  double deltaSy=0, Vy0=0,Vy1=0;
	private  double Acceleration_G=9.8;
	private  Paddle paddle;
	
	//Dane do pobrania
	private double VyActual=0;
	private double PositionYActual=0;
	
	//Dane do modyfikacji przed rozpczeciem w¹tku
	private double VyInput=0;
	
	//W¹tek
	private String ThreadName;
	Thread LocalThread;
	
	public Paddle_CalculationPositionY(Paddle paddle, String ThreadName)
	{
		this.ThreadName=ThreadName;
		this.paddle=paddle;
		
		LocalThread = new Thread(this,this.ThreadName);
		LocalThread.setDaemon(true);
	}
	private void calculationPhisicsY()
	{
		Vy0=VyInput;
		if (Vy0 > MaxSpeedY)
			Vy0 = MaxSpeedY;
		if (Vy0 < MinSpeedY)
			Vy0 = MinSpeedY;
		
		Vy1 = Vy0 + Acceleration_G * Paddle_t;
		Vy0 = Vy1;
		deltaSy =( Vy0 * Paddle_t + (Acceleration_G * Paddle_t * Paddle_t) / 2);		
		PosY=PosY+deltaSy;
		
		if(PosY<0)
		{
			Vy0=-Vy0;
			PosY=0;
		}
		if(PosY>Screen.primaryScene.getHeight())
		{
			Vy0=-Vy0;
			PosY=Screen.primaryScene.getHeight();
		}
		if(PosY>paddle.getBasePosY())
		{
			Acceleration_G=PaddlePositivAccelerationY;
		}
		if(PosY<paddle.getBasePosY())
		{
			Acceleration_G=PaddleNegativAccelerationY;
		}
		//Zaokr¹glanie ¿eby moc sprawdzic warunek, PosY nigdy nie bedzie mia³ dok³adnej wartosci BaseY
		if((int)PosY==(int)paddle.getBasePosY())
		{
			if (Vy0 > 0)
				Vy0=Vy0-5;
			if (Vy0 < 0)
				Vy0=Vy0+5;	
		}
		VyInput=Vy0;
		
		VyActual=Vy0;
		PositionYActual=PosY;

	}
	public void run()
	{
		while (true)
		{
			synchronized (this)
			{
				calculationPhisicsY();
			}
			try
			{
				Thread.sleep(PaddleSleepTimeThread);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	public void start()
	{
		LocalThread.start();
	}
	public double getPosYActual()
	{
		return PositionYActual;
	}
	public double getVyActual()
	{
		return VyActual;
	}
	public void setVyInput(double vyInput)
	{
		VyInput = vyInput;
	}
}
