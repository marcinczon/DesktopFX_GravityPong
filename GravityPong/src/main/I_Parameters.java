package main;

public interface I_Parameters
{
	// General
	static int AnimationSpeed = 1; // Do parametru Sleep w w¹tkach
	static double t = 0.05; // Do obliczeñ fizycznych
	static double G = 9.8; // Grawitacja ziemska
    static double MaxSpeedX=100;
    static double MaxSpeedY=100;
    static double MinSpeedX=-100;
    static double MinSpeedY=-100;
    
    static boolean ShowVectors=false;
    
	// Paddle
    static double PaddleWidth=250;
    static double PaddleHeight=20;
    
	static double PaddlePositivAccelerationY = -70;
	static double PaddleNegativAccelerationY = 40;
	static double PaddleAccelerationX=10;
	
	static double PaddleControlLeftVelocity = -50;
	static double PaddleControllRightVelocity = 50;
	static double PaddleControllUpVelocity = -100;
	static double PaddleControllDownVelocity = 100;
	
	static int    PaddleSleepTimeThread = 1;
	
	static double Paddle_t = 0.01; // Do obliczeñ fizycznych
	
	// Balls
	
	static int    BallSleepTimeAxiesThread = 1;
	
	
	//Screen
	static int    ScreenSleepTimeThread = 1;
	static int    initScreenHeight=800;
	static int    initScreenWidth=800;
	
	
	//Zones
	
	static boolean ShowZoneActive=false;
	
	
}
