package main;


public class BallCalculationPositionX implements Runnable, Parameters, Objects
{
	private  double deltaSx=0, Vx0=0,VxLost=0;
	private  double PositionX=0;	
	
	//Prêdkoœc która mo¿e byæ pobierana - zabezpieczenie przed pobraniem nie obliczonej do konca predkosci Vx0 z w¹tku
	private  double  VxActual=0;
	private  double  PositionXActual=0;
	private  boolean VxReaded=true; //Flaga - czy predkoœæ zosta³a odczytana, wowczas mo¿na obliczyæ nastêpn¹ pozycje
	
	private String ThreadName;
	private Thread LocalThread;	
	private Ball ball;
	
	
	public BallCalculationPositionX(Ball ball,double Vx0,String ThreadName)
	{		
		this.ball=ball;
		this.ThreadName=ThreadName;
		this.Vx0=Vx0;
		
		LocalThread = new Thread(this, this.ThreadName);
	}
	private void calculationPhisicsX()
	{		
		Vx0=ball.getVxActual();
		if(Vx0>100)
		{
			Vx0=100;
		}
		deltaSx=Vx0*t;
		PositionX=PositionX+deltaSx;
		
		//Zderzenie ze scianami
		if(PositionX>=primaryScene.getWidth())
		{
			PositionX=(int)primaryScene.getWidth();
			Vx0=-(Vx0-VxLost);
		}
		if(PositionX<=0)
		{
			Vx0=-(Vx0+VxLost);
			PositionX=0;
		}
		VxActual=Vx0;
		PositionXActual=PositionX;
	}

	@Override
	public void run()
	{
		while (true)
		{
			synchronized (this)
			{
				calculationPhisicsX();
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

	public double getPositionX()
	{
		return PositionXActual;
	}
	public double getVxActual()
	{
		return VxActual;
	}
}
