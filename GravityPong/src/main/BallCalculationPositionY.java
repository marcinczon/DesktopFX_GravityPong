package main;

public class BallCalculationPositionY implements Runnable , Parameters, Objects
{
	private  double t=0.05;
	private  double deltaSy=0, Vy0=0,Vy1=0,VyLost=1,g=9.8;
	private  double PositionY=0;
	private  double Radius;
	
	//Prêdkoœc która mo¿e byæ pobierana - zabezpieczenie przed pobraniem nie obliczonej do konca predkosci Vy0 z w¹tku
	private  double VyActual=0;
	private  double PositionYActual=0;
	
	public Thread LocalThread;
	private String ThreadName;
	private Ball ball;
	
	
	public BallCalculationPositionY(Ball ball,double Vy0,double Radius, String ThreadName)
	{
		this.ball=ball;
		this.ThreadName=ThreadName;
		this.Radius=Radius;
		this.Vy0=Vy0;
		
		LocalThread = new Thread(this, this.ThreadName);
	}

	public void calculationPhisicsY()
	{
		Vy0=ball.getVyActual();
		if(Vy0>100)
		{
			Vy0=100;
		}
		Vy1 = Vy0 + g * t;
		Vy0 = Vy1;
		deltaSy =( Vy0 * t + (g * t * t) / 2);		
		PositionY=PositionY+deltaSy;
		
		//Zderzenie ze scianami
		if(PositionY>=primaryScene.getHeight()-Radius)
		{
			PositionY=(int)primaryScene.getHeight()-Radius;
			Vy0=-(Vy0-VyLost);
		}
		if(PositionY<=0)
		{
			Vy0=-Vy0;
			PositionY=0;
		}
		VyActual=Vy0;
		PositionYActual=PositionY;
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
				Thread.sleep(BallSleepTimeAxiesThread);
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

	public double getPositionY()
	{
		return PositionYActual;
	}

	public double getVyActual()
	{
		return VyActual;
	}
}
