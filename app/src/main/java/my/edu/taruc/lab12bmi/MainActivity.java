package my.edu.taruc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight,editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult=(TextView)findViewById(R.id.textViewBMI);
        imageViewResult=(ImageView)findViewById(R.id.imageViewResult);

    }
    public void calculateBMI(View view){
        double weight,height ,bmi;

        String BodyCond;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());

        //set image during run time
        imageViewResult.setImageResource(R.drawable.normal);

        bmi = weight/(Math.pow((height*0.1),2));

        if (bmi > 18.5){
            imageViewResult.setImageResource(R.drawable.over);
            BodyCond="Over weight";
        }
        else if(bmi == 18.5){
            imageViewResult.setImageResource(R.drawable.normal);
            BodyCond="Normal weight";
        }
        else{
            imageViewResult.setImageResource(R.drawable.under);
            BodyCond="Under weight";
        }



        textViewResult.setText("Your BMI is " + bmi + ".You are " + BodyCond);


    }

    public void Reset(View view)
    {
        imageViewResult.setImageResource(R.drawable.empty);
        editTextHeight.setText("");
        editTextWeight.setText("");
        textViewResult.setText("BMI");
    }
}
