package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Collisions_Detection implements I_Objects, I_Parameters
{
	//Zabezpiecznie przed wielokrotnym powtorzeniem
		static boolean loopTrigger_1=false;
		static boolean loopTrigger_2=false;
		static boolean loopTrigger_3=false;
		
		public static void CreateCollisionDetectObjects()
		{
			// *********************************************** //
			// Proba Stworzenia obiektu Shape z kazdej pi³ki 
			// Jezeli obiekt powstaie to znaczy ze nastapi³o zdezenie
			// Sprawdzanie kazdej pi³ki z kazda za duzo oblicen potzebnych
			// Warto dodaæ listenera
			// *********************************************** //
			
			
			// Tworzenie pilek
			
			for(int i=0;i<NumbersOfBalls;i++)
			{
				Ball _Ball = new Ball((double)Random.nextInt((int)primaryScene.getWidth()),(double)Random.nextInt((int)primaryScene.getHeight()), (double)Random.nextInt(50), Color.AQUAMARINE);
				Balls.add(_Ball);
			}
			
			// Tworzenie obiektow do wykrywania zdezenia
			
			for (Ball index : Balls)
			{
				for (Ball index2 : Balls)
				{
					if (!index.equals(index2))
					{					
						Shape collisionShape = Shape.intersect(index.get_ball(), index2.get_ball());
						CollisionShapes.add(collisionShape);
					}
				}
			}
			
			// Dodanie pi³ek na ekran
			
			for(Ball index:Balls)
			{
				primaryPane.getChildren().addAll(index.getNodes());
			}
		}
		public static void Collision_Detection_1()
		{
			// *********************************************** //
			// Sprawdzanie co milisekunde czy ktoryœ z obiektów siê zdezy³
			//
			// *********************************************** //
			for(Shape index:CollisionShapes)
			{
				boolean intersects = index.getBoundsInLocal().isEmpty();
				if(!intersects)
				{
					System.out.println("Collision");
					//CollisionVelocityCalculation();
				}
			}
			
		}
		public static void Collision_Detection_2()
		{
			// *********************************************** //
			// Sprawdzanie ka¿dej pi³ki z ka¿d¹, 2 dzialaja wiecej nie
			// *********************************************** //

			for (Ball index : Balls)
			{
				for (Ball index2 : Balls)
				{
					if (!index.equals(index2))
					{
						Shape collisionShape = Shape.intersect(index.get_ball(), index2.get_ball());
						boolean intersects = collisionShape.getBoundsInLocal().isEmpty();
						if (!intersects)
						{
							if (!loopTrigger_1)
							{
								Collisions_Calculations.CollisionTwoBall(index,index2);

								System.out.println("Collision");
								loopTrigger_1 = true;
							}
						} else
						{
							loopTrigger_1 = false;
						}
					}
				}
			}

		}
		public static void Collision_Detection_3()
		{		
			Shape collisionShape = Shape.intersect(TestBall_1.get_ball(), primaryPaddle.getPaddle());		
			boolean intersects_1 = collisionShape.getBoundsInLocal().isEmpty();
			
			if (!intersects_1)
			{
				primaryPaddle.getPaddle().setFill(Color.RED);
				if (!loopTrigger_1)
				{
					Collisions_Calculations.CollisionWithPeddle(TestBall_1,primaryPaddle);
					loopTrigger_1 = true;
				}
			}
			else
			{
				primaryPaddle.getPaddle().setFill(Color.CHARTREUSE);
				loopTrigger_1 = false;
			}
			collisionShape = Shape.intersect(TestBall_2.get_ball(), primaryPaddle.getPaddle());		
			boolean intersects_2 = collisionShape.getBoundsInLocal().isEmpty();
			
			if (!intersects_2)
			{
				if (!loopTrigger_2)
				{
					Collisions_Calculations.CollisionWithPeddle(TestBall_2,primaryPaddle);
					loopTrigger_2 = true;
				}
			}
			else
			{
				loopTrigger_2 = false;
			}		
			
			collisionShape = Shape.intersect(TestBall_1.get_ball(), TestBall_2.get_ball());					
			boolean intersects_3 = collisionShape.getBoundsInLocal().isEmpty();
			
			if (!intersects_3)
			{
				if (!loopTrigger_3)
				{			
					Collisions_Calculations.CollisionTwoBall(TestBall_1,TestBall_2);	
					//System.out.println("Balls Collision");
					loopTrigger_3 = true;
				}
			} else
			{
				loopTrigger_3 = false;
			}	
		}

		
}
