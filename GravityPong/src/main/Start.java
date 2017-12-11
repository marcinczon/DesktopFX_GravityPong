package main;
import javafx.application.Application;
import javafx.stage.Stage;


//***
//Dodaæ zabezpieczenie od przenikania siê obiektów
//Dodaæ trajektorie lotu pi³ki
//Dodaæ podwojne przyciskanie 
//Dodaæ nad wektorami predkosci odczyt prêdkoœæi
//Dodaæ rotacje pi³ki
//Mozna dodaæ ³adowanie "mocy" podskoku, im d³uzej tym wieksza prêdkoœæ poczatkowa
//Uruchomiæ timer kiedy zostanie wcisniety przycisk, po "Released" obliczyæ now¹ prêdkoœæ
//Przeskalowanie parametru t predkosci i przyspieszeñ zrobiæ oddzieln¹ klase albo interfejs
//Utworzyæ jedn¹ funkcjê do obliczeñ po³ozenia i wywo³ywaæ j¹ z kazdej pi³ki zamiast tworzyæ nowe obiekty
//***


public class Start extends Application implements Objects
{
	Screen _Screen = new Screen();
	public static void main(String[] args)
	{
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setScene(primaryScene);
		primaryStage.show();
		
	}
}
