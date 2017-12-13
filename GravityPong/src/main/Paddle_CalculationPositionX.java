package main;

public class Paddle_CalculationPositionX implements Runnable, I_Parameters
{
	private  double PosX;
	private  double deltaSx=0,Vx0=0;
	private  Paddle paddle;
	
	//Dane do pobrania
	private double VxActual=0;
	private double PositionXActual=0;
	
	//Dane do modyfikacji przed rozpczeciem w¹tku
	private double VxInput=0;
	
	
	//W¹tek
	private String ThreadName;
	Thread LocalThread;
	
	public Paddle_CalculationPositionX(Paddle paddle, String ThreadName)
	{
		this.ThreadName=ThreadName;
		this.paddle=paddle;
		
		LocalThread = new Thread(this,this.ThreadName);
		LocalThread.setDaemon(true);
	}
	private void calculationPhisicsX()
	{
		Vx0=VxInput;
		if (Vx0 > MaxSpeedX)
			Vx0 = MaxSpeedX;
		if (Vx0 < MinSpeedX)
			Vx0 = MinSpeedX;		
		
		if (Vx0 > 0)
		{
			deltaSx = (Vx0 * Paddle_t - (PaddleAccelerationX * Paddle_t * Paddle_t) / 2);
			PosX = PosX + deltaSx;
			Vx0 = Vx0 - PaddleAccelerationX * Paddle_t;			
		}
		if (Vx0 < 0)
		{
			deltaSx = (Vx0 * Paddle_t + (PaddleAccelerationX * Paddle_t * Paddle_t) / 2);
			PosX = PosX + deltaSx;
			Vx0 = Vx0 + PaddleAccelerationX * Paddle_t;
		}
		if(PosX>Screen.primaryPane.getWidth()-paddle.getPaddleWidth())
		{
			PosX=Screen.primaryPane.getWidth()-paddle.getPaddleWidth();
			Vx0=-Vx0;
		}
		if(PosX<0)
		{
			PosX=0;
			Vx0=-Vx0;
		}
		VxInput=Vx0;
		
		VxActual=Vx0;
		PositionXActual=PosX;
		
		
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
	public double getPosXActual()
	{
		return PositionXActual;
	}
	public double getVxActual()
	{
		return VxActual;
	}
	public void setVxInput(double vxInput)
	{
		VxInput = vxInput;
	}
	
}
