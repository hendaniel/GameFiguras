package com.example.gamefiguras;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    /* Hecho por Henry Daniel Martinez Rodriguez y David Eduardo Segura Rodriguez*/

    private Button firstButton;
    private Button secondButton;
    private Button thirdButton;
    private ImageView shape;
    private TextView title;
    private TextView posCounterLabel;
    private TextView negCounterLabel;
    private int posCounter = 0;
    private int negCounter = 0;
    private String shapeTag;
    private String colorTag;
    private ArrayList<String> shapesNames = new ArrayList<>(Arrays.asList("Square", "Circle", "Rectangle"));
    private ArrayList<String> colorsNames = new ArrayList<>(Arrays.asList("Purple", "Blue", "Yellow"));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posCounterLabel = findViewById(R.id.contador_pos);
        negCounterLabel = findViewById(R.id.contador_neg);
        title = findViewById(R.id.question);
        firstButton = findViewById(R.id.first_button);
        secondButton = findViewById(R.id.second_button);
        thirdButton = findViewById(R.id.third_button);
        shape = findViewById(R.id.shape);
        randomize();

    }


    public void randomize() {
        Random random = new Random();

        int[] shapes = {R.drawable.circle, R.drawable.square, R.drawable.triangle};
        int[] colors = {R.color.azul, R.color.purple, R.color.yellow};

        int randomShape = random.nextInt(3);
        int randomColor = random.nextInt(3);
        int randomLabel = random.nextInt(2);

        if(shapes[randomShape] == R.drawable.circle){
            shapeTag = "Circle";

        } else if(shapes[randomShape] == R.drawable.square){
            shapeTag = "Square";

        } else if(shapes[randomShape] == R.drawable.triangle){
            shapeTag = "Rectangle";
        }
        if(colors[randomColor] == R.color.azul){
            colorTag = "Blue";

        } else if(colors[randomColor] == R.color.purple){
            colorTag = "Purple";

        } else if(colors[randomColor] == R.color.yellow){
            colorTag = "Yellow";
        }

        shape.setBackground(getDrawable(shapes[randomShape]));
        shape.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), colors[randomColor]));

        if(randomLabel==0){
            Collections.shuffle(shapesNames);
            firstButton.setText(shapesNames.get(0));
            secondButton.setText(shapesNames.get(1));
            thirdButton.setText(shapesNames.get(2));
            title.setText("SHAPE!!!!");
        }
        else{
            Collections.shuffle(colorsNames);
            firstButton.setText(colorsNames.get(0));
            secondButton.setText(colorsNames.get(1));
            thirdButton.setText(colorsNames.get(2));
            title.setText("COLOR!!!!");
        }
    }

    private void verify(Button bt) {
        String val = bt.getText().toString();
        if(val.equalsIgnoreCase(shapeTag)||val.equalsIgnoreCase(colorTag) ){
            posCounter++;
        }
        else{
            negCounter++;
        }
        posCounterLabel.setText("Aciertos:"+posCounter);
        negCounterLabel.setText("Errores:"+negCounter);

    }


    @Override
    public void onClick(View v) {

        if(v.getId() == firstButton.getId()){
            verify(firstButton);
            randomize();
        }
        if(v.getId() == secondButton.getId()){
            verify(secondButton);
            randomize();
        }
        if(v.getId() == thirdButton.getId()){
            verify(thirdButton);
            randomize();
        }
    }

}
