package entertainment.milan.slotmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class Slot extends AppCompatActivity {

    int money = 1000;
    int valueUlog = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);

        final TextView Novci = (TextView) findViewById(R.id.textMoney);
        Novci.setText("" + money);

        final EditText Ulog = (EditText)findViewById(R.id.textUlog);
        Button Igraj = (Button) findViewById(R.id.btnPlay);
        final ImageView imgOne= (ImageView) findViewById(R.id.imageSlotOne);
        final ImageView imgTwo= (ImageView) findViewById(R.id.imageSlotTwo);
        final ImageView imgThree= (ImageView) findViewById(R.id.imageSlotThree);


        Igraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = Ulog.getText().toString();
                if(str.equals("")) {
                    valueUlog = 1;
                } else {
                    valueUlog = Integer.parseInt(str);
                }
                if ((valueUlog > 0) && (valueUlog <= money)) {

                    Random randOne = new Random();
                    int SlotOne = randOne.nextInt(3);
                    if (SlotOne == 0) {
                        imgOne.setImageResource(R.drawable.one);
                    } else if (SlotOne == 1) {
                        imgOne.setImageResource(R.drawable.two);
                    } else if (SlotOne == 2) {
                        imgOne.setImageResource(R.drawable.three);
                    }
                    Random randTwo = new Random();
                    int SlotTwo = randTwo.nextInt(3);

                    if (SlotTwo == 0) {
                        imgTwo.setImageResource(R.drawable.one);
                    } else if (SlotTwo == 1) {
                        imgTwo.setImageResource(R.drawable.two);
                    } else if (SlotTwo == 2) {
                        imgTwo.setImageResource(R.drawable.three);
                    }

                    Random randThree = new Random();
                    int SlotThree = randThree.nextInt(3);

                    if (SlotThree == 0) {
                        imgThree.setImageResource(R.drawable.one);
                    } else if (SlotThree == 1) {
                        imgThree.setImageResource(R.drawable.two);
                    } else if (SlotThree == 2) {
                        imgThree.setImageResource(R.drawable.three);
                    }

                    if ((SlotOne == SlotTwo) && (SlotOne == SlotThree)) {
                        money = money + (2 * valueUlog);
                        Novci.setText("" + money);
                    }
                    else {
                        money = money - valueUlog;
                        Novci.setText("" + money);
                    }
                }
            }
        });
    }
}