package com.example.matthewmolloy.simulationprototype;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CDT extends CountDownTimer {

    public View view;

    public CDT(long startTime, long interval) {
        super(startTime, interval);
    }

    @Override
    public void onFinish() {
		Player player = MainActivity.player;

        EditText resources = (EditText) view.findViewById(R.id.shareInput);
        EditText invested = (EditText) view.findViewById(R.id.investInput);
        resources.setText("");
        invested.setText("");

        // increment turn counter and quarterly give resources
        player.turnCounter++;
        if( player.turnCounter % 5 == 0 )
        {
            TextView resourcesDisplay = (TextView) view.findViewById(R.id.resourcesLabel);

            player.resources += 100;
            resourcesDisplay.setText(Integer.toString(player.resources));
        }

        // display in console
        System.out.println(player.printPlayer() + " Turn: " + player.turnCounter);

        // reset
        start();
    }

    public void onTick(long millisUntilFinished) {
        TextView mTextField = (TextView) view.findViewById(R.id.timer);
        mTextField.setText("Seconds remaining: " + (millisUntilFinished / 1000));
    }
}
