package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Collisions_Calculations implements I_Objects, I_Parameters
{
	public static void CollisionTwoBall(Ball Ball_1, Ball Ball_2)
	{
		// *********************************************** //
		// Obliczanie predkosci dwoch pilek na podstawie energi i pêdu
		// mV^/2=E i p=mv => Wikipedia
		// *********************************************** //
		double Ux1 = Ball_1.getVxActual();
		double Ux2 = Ball_2.getVxActual();

		double Uy1 = Ball_1.getVyActual();
		double Uy2 = Ball_2.getVyActual();

		double m1 = Ball_1.getWeight();
		double m2 = Ball_2.getWeight();

		double Vx1 = 0, Vx2 = 0, Vy1 = 0, Vy2 = 0;

		Vx1 = (Ux1 * (m1 - m2) + 2 * m2 * Ux2) / (m1 + m2);
		Vy1 = (Uy1 * (m1 - m2) + 2 * m2 * Uy2) / (m1 + m2);

		Vx2 = (Ux2 * (m2 - m1) + 2 * m1 * Ux1) / (m2 + m1);
		Vy2 = (Uy2 * (m2 - m1) + 2 * m1 * Uy1) / (m2 + m1);

		Ball_1.setVxActual(Vx1);
		Ball_2.setVxActual(Vx2);

		Ball_1.setVyActual(Vy1);
		Ball_2.setVyActual(Vy2);
		//CalculateAngelAndPointOfCollision();	

	}	
	public static void CollisionWithPeddle(Ball _Ball, Paddle _Paddle)
	{
		// *********************************************** //
		// Obliczanie predkosci pilki odbitej od paletki
		// mV^/2=E i p=mv => Wikipedia
		// *********************************************** //
		
		double Ux1 = _Ball.getVxActual();
		double Ux2 = _Paddle.getVxActual();

		double Uy1 = _Ball.getVyActual();
		double Uy2 = _Paddle.getVyActual();

		double m1 = _Ball.getWeight();
		double m2 = _Paddle.getWeight();

		double Vx1, Vx2, Vy1 = 0, Vy2 = 0;
		double Vx = 0;

		
// Sprêzyste rowanie pedu
		
		Vx1 = (Ux1 * (m1 - m2) + 2 * m2 * Ux2) / (m1 + m2);
		Vx2 = (Ux2 * (m2 - m1) + 2 * m1 * Ux1) / (m2 + m1);

		
		Vy1 = (Uy1 * (m1 - m2) + 2 * m2 * Uy2) / (m1 + m2);		
		Vy2 = (Uy2 * (m2 - m1) + 2 * m1 * Uy1) / (m2 + m1);
		
		
// Nie sprezyste rownanie pêdu
// Czyli cia³a siê "³¹cz¹" po zderzeniu
		
		Vx=(Ux1*m1+Ux2*m2)/(m1+m2);		
		
//		1  |	 2		| 3
//		___|____________|___
//	4   ___|____________|___  5
//		   |            |
//		6  |	7    	| 8
		   
		// Rownania dla odpowiednich zderzeñ
		
		if ((paddleZone_Bits.isIntersects_4() && (paddleZone_Bits.isIntersects_1() || paddleZone_Bits.isIntersects_6()))
				|| (paddleZone_Bits.isIntersects_5() && (paddleZone_Bits.isIntersects_3() || paddleZone_Bits.isIntersects_8())))
		{
			if (Vx1 > 0 && Vx2 > 0)
			{
				Vx1 = Vx1 * -1;
			}
			if (Vx1 < 0 && Vx2 < 0)
			{
				Vx1 = Vx1 * -1;
			}
			_Ball.setVxActual(Vx1);
			_Paddle.setVxActual(Vx2);
		} else
		{
			// Vx tylko jak uderza od gory i od do³u
			_Ball.setVxActual(Vx1);
			_Paddle.setVxActual(Vx2);
		}
		_Ball.setVyActual(Vy1);
		_Paddle.setVyActual(Vy2);

	}
}
//	public void CalculateAngelAndPointOfCollision()
//	{
//		// *********************************************** //
//		// Obliczenia konta i punktu zderzenia siê pi³ek 
//		// Do testow uzywane s¹ Ball_1, Ball_2.
//		// *********************************************** //
//		
//		Shape collisionShape = Shape.intersect(TestBall_1.get_ball(), TestBall_2.get_ball());
//
//		boolean intersects = collisionShape.getBoundsInLocal().isEmpty();
//		if (!intersects)
//		{
//
//			if (!loopTrigger_1)
//			{
//
//				// Obliczenia trygonometryczne
//
//				double sumaX = 0, sumaY, sumaR, AlfaDegree, AlfaRadians, SinAlfa, CosAlfa;
//				sumaX = TestBall_1.getPositionX() - TestBall_2.getPositionX();
//
//				if (TestBall_1.getPositionX() > TestBall_2.getPositionX())
//				{
//					sumaX = TestBall_1.getPositionX() - TestBall_2.getPositionX();
//				} else if (TestBall_1.getPositionX() < TestBall_2.getPositionX())
//				{
//					sumaX = TestBall_2.getPositionX() - TestBall_1.getPositionX();
//				} else
//				{
//					sumaX = 0;
//				}
//
//				sumaY = TestBall_1.getPositionY() - TestBall_2.getPositionY();
//				if (TestBall_1.getPositionY() > TestBall_2.getPositionY())
//				{
//					sumaY = TestBall_1.getPositionY() - TestBall_2.getPositionY();
//				} else if (TestBall_1.getPositionY() < TestBall_2.getPositionY())
//				{
//					sumaY = TestBall_2.getPositionY() - TestBall_1.getPositionY();
//				} else
//				{
//					sumaY = 0;
//				}
//
//				sumaR = TestBall_1.get_ball().getRadius() + TestBall_2.get_ball().getRadius();
//
//				SinAlfa = sumaY / sumaR;
//				CosAlfa = sumaX / sumaR;
//
//				double X1, X2, Y1, Y2;
//
//				X1 = TestBall_1.get_ball().getRadius() * CosAlfa;
//				X2 = TestBall_2.get_ball().getRadius() * CosAlfa;
//
//				Y1 = TestBall_1.get_ball().getRadius() * SinAlfa;
//				Y2 = TestBall_2.get_ball().getRadius() * SinAlfa;
//
//				if (TestBall_1.getPositionX() > TestBall_2.getPositionX())
//				{
//					CollisionPoint.setCenterX(TestBall_2.getPositionX() + X2);
//
//				} else if (TestBall_1.getPositionX() < TestBall_2.getPositionX())
//				{
//					CollisionPoint.setCenterX(TestBall_2.getPositionX() - X2);
//
//				} else
//				{
//					CollisionPoint.setCenterX(0);
//				}
//
//				if (TestBall_1.getPositionY() > TestBall_2.getPositionY())
//				{
//					CollisionPoint.setCenterY(TestBall_2.getPositionY() + Y2);
//
//				} else if (TestBall_1.getPositionY() < TestBall_2.getPositionY())
//				{
//					CollisionPoint.setCenterY(TestBall_2.getPositionY() - Y2);
//
//				} else
//				{
//					CollisionPoint.setCenterY(0);
//				}
//
//				CollisionPoint.setRadius(3);
//				CollisionPoint.setFill(Color.RED);
//
//				loopTrigger_1 = true;
//
//			}
//		} else
//		{
//			loopTrigger_1 = false;
//		}
//
//	}
//
//}
