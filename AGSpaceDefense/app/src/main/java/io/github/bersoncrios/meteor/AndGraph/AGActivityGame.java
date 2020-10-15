/********************************************
 Class: AGAtivivityGame
 Description: Android activity class
 Author: Silvano Maneck Malfatti
 Date: 05/11/2013
 ********************************************/

//Engine package
package io.github.bersoncrios.meteor.AndGraph;

//Used packages
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import io.github.bersoncrios.meteor.AboutScreen;
import io.github.bersoncrios.meteor.GameScreen;
import io.github.bersoncrios.meteor.HelpScreen;
import io.github.bersoncrios.meteor.Losers;
import io.github.bersoncrios.meteor.MenuScreen;
import io.github.bersoncrios.meteor.SplashScreen;
import io.github.bersoncrios.meteor.Winners;

public class AGActivityGame extends Activity
{
	//Attributes
	protected AGGameManager vrManager = null;

	/********************************************
	 * Name: AGActivity
	 * Description: constructor
	 * Parameters: Activity, boolean
	 * Returns: none
	 ******************************************/
	public void init(Activity context, boolean accel)
	{
		vrManager = new AGGameManager(context, accel);
	}
	
	/********************************************
	* Name: onCreate()
	* Description: method called to create the application
	* Parameters: Bundle
	* Returns: none
	******************************************/
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		this.vrManager = new AGGameManager(this,true);

		//Instânciando as cenas no controlador de cenas
		SplashScreen splash = new SplashScreen(vrManager);
		MenuScreen menu = new MenuScreen(vrManager);
		HelpScreen help = new HelpScreen(vrManager);
		AboutScreen about= new AboutScreen(vrManager);
		GameScreen game = new GameScreen(vrManager);
		Losers loser = new Losers(vrManager);
		Winners win = new Winners(vrManager);

		vrManager.addScene(splash);//0
		vrManager.addScene(menu);//1
		vrManager.addScene(help);//2
		vrManager.addScene(about);//3
		vrManager.addScene(game);//4
		vrManager.addScene(loser);//5
		vrManager.addScene(win);//6
	}
  
	/*******************************************
	* Name: onPause()
	* Description: method called to pause application
	* Parameters: none
	* Returns: none
	******************************************/
	protected void onPause()
	{
		super.onPause();
		AGSoundManager.vrMusic.pause();
		vrManager.onPause();
	}
	
	/*******************************************
	* Name: onResume()
	* Description: method called after resume application
	* Parameters: none
	* Returns: none
	******************************************/
	protected void onResume()
	{
		super.onResume();
		vrManager.onResume();
		AGSoundManager.vrMusic.play();
	}
  
	/*******************************************
	* Name: onBackPressed()
	* Description: method called when Android back button is pressed
	* Parameters: none
	* Returns: none
	*****************************************/
	public void onBackPressed()
	{
		AGInputManager.vrTouchEvents.bBackButtonClicked = true;
	}
  
	/*******************************************
	* Name: onDestroy()
	* Description: method called when applicatin is destroyed
	* Parameters: none
	* Returns: none
	*****************************************/
	protected void onDestroy()
	{
		super.onDestroy();
		vrManager.release();
		vrManager = null;
		System.gc();
	}
}
