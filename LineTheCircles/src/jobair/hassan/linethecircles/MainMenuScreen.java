package jobair.hassan.linethecircles;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import jobair.hassan.linethecircles.R;
 
public class MainMenuScreen extends Activity {
 
	@Override
	public void onCreate(Bundle savedInstanceState) { 
		final MediaPlayer buttons = MediaPlayer.create(this, R.raw.gamepiece_menu_select);
		final MediaPlayer bgSound = MediaPlayer.create(this, R.raw.gamepiece_bg);
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_menu);
		bgSound.start();
		bgSound.setLooping(true);
 
		((Button) findViewById(R.id.one_player)).setOnClickListener(new OnClickListener() {
			public void onClick(View V) {
				buttons.start();
				bgSound.setLooping(false);
				bgSound.stop();
				Log.d("DEBUG", "One Player Button Pressed!");
				Intent intent = new Intent(MainMenuScreen.this, MainActivity.class);
				intent.putExtra("gameType", true);
				startActivityForResult(intent, 0);
			}
		});
 
		
 
		((Button) findViewById(R.id.exit_game)).setOnClickListener(new OnClickListener() {
			public void onClick(View V) {
				buttons.start();
				bgSound.setLooping(false);
				bgSound.stop();
				Log.d("DEBUG", "Exit Game Button Pressed!");
				MainMenuScreen.this.finish();
			}
		});
	}
}