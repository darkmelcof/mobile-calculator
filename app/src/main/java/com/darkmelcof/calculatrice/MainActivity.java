package com.darkmelcof.calculatrice;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private String a = "";
    private String temp = "";
    private BigDecimal resultat = new BigDecimal(0);
    private String affichage = "";
    private String affichageRes = "";
    private short nbPoint = 0;
    private char operation = '\u0000';
    private TextView text, text2;
    private boolean done = false;


    // Initialization of interface
    public void setup(){
        Button bouton0 = (Button) findViewById(R.id.button0);
        bouton0.setOnClickListener(this);

        Button bouton1 = (Button) findViewById(R.id.button1);
        bouton1.setOnClickListener(this);

        Button bouton2 = (Button) findViewById(R.id.button2);
        bouton2.setOnClickListener(this);

        Button bouton3 = (Button) findViewById(R.id.button3);
        bouton3.setOnClickListener(this);

        Button bouton4 = (Button) findViewById(R.id.button4);
        bouton4.setOnClickListener(this);

        Button bouton5 = (Button) findViewById(R.id.button5);
        bouton5.setOnClickListener(this);

        Button bouton6 = (Button) findViewById(R.id.button6);
        bouton6.setOnClickListener(this);

        Button bouton7 = (Button) findViewById(R.id.button7);
        bouton7.setOnClickListener(this);

        Button bouton8 = (Button) findViewById(R.id.button8);
        bouton8.setOnClickListener(this);

        Button bouton9 = (Button) findViewById(R.id.button9);
        bouton9.setOnClickListener(this);

        Button boutonAddition = (Button) findViewById(R.id.addition_button);
        boutonAddition.setOnClickListener(this);

        Button boutonSoustraction = (Button) findViewById(R.id.soustraction_button);
        boutonSoustraction.setOnClickListener(this);

        Button boutonMultiplication = (Button) findViewById(R.id.multiplication_button);
        boutonMultiplication.setOnClickListener(this);

        Button boutonDivision = (Button) findViewById(R.id.division_button);
        boutonDivision.setOnClickListener(this);

        Button boutonEgal = (Button) findViewById(R.id.egal_button);
        boutonEgal.setOnClickListener(this);

        Button boutonAnnule = (Button) findViewById(R.id.AC_button);
        boutonAnnule.setOnClickListener(this);

        Button boutonPoint = (Button) findViewById(R.id.comma_button);
        boutonPoint.setOnClickListener(this);

        Button boutonEffacer = (Button) findViewById(R.id.effacer_button);
        boutonEffacer.setOnClickListener(this);

        text =  (TextView) findViewById(R.id.calcul_textView);
        text.setOnClickListener(this);

        text2 =  (TextView) findViewById(R.id.resultat_textView);
        text2.setOnClickListener(this);

        /* Partie paysage */
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            Button boutonRacine = (Button) findViewById(R.id.racine_button);
            boutonRacine.setOnClickListener(this);

            Button boutonInverse = (Button) findViewById(R.id.inverse_button);
            boutonInverse.setOnClickListener(this);

            Button boutonPi = (Button) findViewById(R.id.pi_button);
            boutonPi.setOnClickListener(this);

            Button boutonExp = (Button) findViewById(R.id.exp_button);
            boutonExp.setOnClickListener(this);

            Button boutonLn = (Button) findViewById(R.id.ln_button);
            boutonLn.setOnClickListener(this);

            Button boutonBlack = (Button) findViewById(R.id.color_black);
            boutonBlack.setOnClickListener(this);

            Button boutonRed = (Button) findViewById(R.id.color_red);
            boutonRed.setOnClickListener(this);

            Button boutonCarre = (Button) findViewById(R.id.carre_button);
            boutonCarre.setOnClickListener(this);

            Button boutonTan = (Button) findViewById(R.id.tan_button);
            boutonTan.setOnClickListener(this);

            Button boutonCos = (Button) findViewById(R.id.cos_button);
            boutonCos.setOnClickListener(this);

            Button boutonSin = (Button) findViewById(R.id.sin_button);
            boutonSin.setOnClickListener(this);
        }
    }

    // Reset command
    public void reset(){
        setDone(false);
        setTemp("");
        setAffichage("");
        setOperation('\u0000');
        setNbPoint((short) 0);
        setResultat(new BigDecimal(0));
        setA("");
        setAffichageRes("");
    }

    /*
    * Enable - Disable operations
    */
    public void disableOperation(){
        ((Button)findViewById(R.id.addition_button)).setEnabled(false);
        ((Button)findViewById(R.id.addition_button)).getBackground().setColorFilter(Color.argb(200, 255, 255, 255), PorterDuff.Mode.MULTIPLY);
        ((Button)findViewById(R.id.multiplication_button)).setEnabled(false);
        ((Button)findViewById(R.id.multiplication_button)).getBackground().setColorFilter(Color.argb(200, 255, 255, 255), PorterDuff.Mode.MULTIPLY);
        ((Button)findViewById(R.id.division_button)).setEnabled(false);
        ((Button)findViewById(R.id.division_button)).getBackground().setColorFilter(Color.argb(200, 255, 255, 255), PorterDuff.Mode.MULTIPLY);
        ((Button)findViewById(R.id.soustraction_button)).setEnabled(false);
        ((Button)findViewById(R.id.soustraction_button)).getBackground().setColorFilter(Color.argb(200, 255, 255, 255), PorterDuff.Mode.MULTIPLY);
    }
    public void enableOperation(){
        ((Button)findViewById(R.id.addition_button)).setEnabled(true);
        ((Button)findViewById(R.id.multiplication_button)).setEnabled(true);
        ((Button)findViewById(R.id.division_button)).setEnabled(true);
        ((Button)findViewById(R.id.soustraction_button)).setEnabled(true);
    }
    public void enableComma(){
        ((Button)findViewById(R.id.comma_button)).setEnabled(true);
    }
    public void disableComma(){
        ((Button)findViewById(R.id.comma_button)).setEnabled(false);
        ((Button)findViewById(R.id.comma_button)).getBackground().setColorFilter(Color.argb(200, 255, 255, 255), PorterDuff.Mode.MULTIPLY);
    }
    public void disableEffacer(){
        ((Button)findViewById(R.id.effacer_button)).setEnabled(false);
        ((Button)findViewById(R.id.effacer_button)).getBackground().setColorFilter(Color.argb(200, 255, 255, 255), PorterDuff.Mode.MULTIPLY);
    }
    public void enableEffacer(){
        ((Button)findViewById(R.id.effacer_button)).setEnabled(true);
    }

    // BigDecimal is better for float operation
    public BigDecimal calcul(String a, String b, char operation){
        BigDecimal nb1 = new BigDecimal(a);
        BigDecimal nb2 = new BigDecimal(b);

        if (operation == '+'){

            return nb1.add(nb2);
        }
        if (operation == '-'){

            return nb1.subtract(nb2);
        }
        if (operation == '*'){

            return nb1.multiply(nb2);
        }
        if (operation == '/'){

            return nb1.divide(nb2);
        }
        return nb1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.portrait_activity_main);
        }else{
            setContentView(R.layout.landscape_activity_main);
        }

        setup();
        disableOperation();
        disableEffacer();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("a", getA().toString());
        outState.putString("temp", getTemp().toString());
        outState.putString("affichage", getAffichage().toString());
        outState.putString("affichageRes", getAffichageRes().toString());
        outState.putString("resultat", getResultat().toString());
        outState.putShort("nbPoint", getNbPoint());
        outState.putChar("operation", getOperation());
        outState.putBoolean("done", isDone());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        setAffichage(savedInstanceState.getString("affichage"));
        setAffichageRes(savedInstanceState.getString("affichageRes"));
        setA(savedInstanceState.getString("a"));
        setTemp(savedInstanceState.getString("temp"));
        setResultat(new BigDecimal(savedInstanceState.getString("resultat")));
        setNbPoint(savedInstanceState.getShort("nbPoint"));
        setOperation(savedInstanceState.getChar("operation"));
        setDone(savedInstanceState.getBoolean("done"));
        text.setText(getAffichage());
        text2.setText(getAffichageRes());

    }

    // Handle the device orientation
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.landscape_activity_main);
        }else{
            setContentView(R.layout.portrait_activity_main);
        }
    }

    // Handle click on buttons
    public void onClick(View v){
        switch (v.getId()){

            case R.id.color_black:
                try {
                    LinearLayout l;
                    l = (LinearLayout)findViewById(R.id.fond);
                    l.setBackgroundColor(Color.BLACK);
                    Toast.makeText(getApplicationContext(), "Je suis noire", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Log.e("Essai", e.getMessage());
                }
                break;
            case R.id.color_red:
                try {
                    LinearLayout l;
                    l = (LinearLayout)findViewById(R.id.fond);
                    l.setBackgroundColor(Color.CYAN);
                    Toast.makeText(getApplicationContext(), "Je suis rouge...", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Log.e("Essai", e.getMessage());
                }
                break;
            case R.id.button0:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '0');
                setTemp(getTemp() + '0');

                break;

            case R.id.button1:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '1');
                setTemp(getTemp() + '1');
                break;

            case R.id.button2:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '2');
                setTemp(getTemp() + '2');
                break;

            case R.id.button3:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '3');
                setTemp(getTemp() + '3');
                break;

            case R.id.button4:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '4');
                setTemp(getTemp() + '4');
                break;

            case R.id.button5:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '5');
                setTemp(getTemp() + '5');
                break;

            case R.id.button6:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '6');
                setTemp(getTemp() + '6');
                break;

            case R.id.button7:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '7');
                setTemp(getTemp() + '7');
                break;

            case R.id.button8:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '8');
                setTemp(getTemp() + '8');
                break;

            case R.id.button9:
                if (isDone())
                    reset();
                if (getOperation() != '\u0000' && !getTemp().equals(""))
                    enableComma();
                setAffichage(getAffichage() + '9');
                setTemp(getTemp() + '9');
                break;

            case R.id.comma_button:
                try {
                    if (!text.getText().equals("") && getNbPoint() ==0){
                        setAffichage(getAffichage() + '.');
                        setTemp(getTemp() + '.');
                        setNbPoint((short)(getNbPoint() - 1));
                    }
                }catch (Exception e){
                    Log.d("Erreur", e.getMessage());
                }
                break;

            case R.id.effacer_button:
                try {

                    if (getAffichage().charAt(getAffichage().length()-1) == '.'){
                        setNbPoint((short)0);
                        enableComma();
                        setAffichage(getAffichage().substring(0, getAffichage().length() - 1));
                    }else if(getAffichage().charAt(getAffichage().length()-1) == '+'||
                            getAffichage().charAt(getAffichage().length()-1) == '-' ||
                            getAffichage().charAt(getAffichage().length()-1) == '*' ||
                            getAffichage().charAt(getAffichage().length()-1) == '/'){
                        setOperation('\u0000');
                        setAffichage(getAffichage().substring(0, getAffichage().length() - 1));
                    }else{
                        setAffichage(getAffichage().substring(0, getAffichage().length() - 1));
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Rien a effacer", Toast.LENGTH_SHORT).show();
                    reset();
                    disableOperation();
                    disableComma();
                    disableEffacer();
                }
                break;

            case R.id.AC_button:
                reset();
                disableOperation();
                disableEffacer();
                break;

            case R.id.addition_button:
                // Premier calcul
                if (!text.getText().equals("") && getOperation() == '\u0000') {
                    setAffichage(getAffichage() + '+');
                    setA(getTemp());
                    setTemp("");
                    setOperation('+');
                    setNbPoint((short)0);
                }

                // Après un calcul
                if (!text2.getText().equals("")) {
                    setAffichage(getAffichageRes() + '+');
                    setA(getAffichageRes());
                    setTemp("");
                    setOperation('+');
                    setNbPoint((short)0);
                    setDone(false);
                }
                disableOperation();
                break;
            // Radian
            case R.id.tan_button:
                try{
                    Log.e("Test", "Tangente");

                    setAffichage("tan(" + getAffichage() + ")");
                    setAffichageRes(String.valueOf(Math.tan(Double.parseDouble(getTemp()))));
                }catch(Exception e){
                    Log.e("Test", "Erreur");
                    Toast.makeText(getApplicationContext(), "0 valeur entree", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.sin_button:
                try{
                    Log.e("Test", "Sinus");
                    setAffichage("sin(" + getAffichage() + ")");
                    setAffichageRes(String.valueOf(Math.sin(Double.parseDouble(getTemp()))));
                    //}
                }catch(Exception e){
                    Log.e("Test", "Erreur");
                    Toast.makeText(getApplicationContext(), "0 valeur entree", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cos_button:
                try{
                    Log.e("Test", "Cosinus");
                    //if (!text.getText().equals("") && operation == '\u0000'){
                    setAffichage("cos(" + getAffichage() + ")");
                    setAffichageRes(String.valueOf(Math.cos(Double.parseDouble(getTemp()))));
                    //}
                }catch(Exception e){
                    Log.e("Test", "Erreur");
                    Toast.makeText(getApplicationContext(), "0 valeur entree", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.exp_button:
                try{
                    Log.e("Test", "Exponentielle");
                    //if (!text.getText().equals("") && operation == '\u0000'){
                    setAffichage("exp(" + getAffichage() + ")");
                    setAffichageRes(String.valueOf(Math.exp(Double.parseDouble(getTemp()))));
                    //}
                }catch(Exception e){
                    Log.e("Test", "Erreur");
                    Toast.makeText(getApplicationContext(), "0 valeur entree", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ln_button:
                try{
                    Log.e("Test", "logarythme neperien");
                    //if (!text.getText().equals("") && operation == '\u0000'){
                    setAffichage("ln(" + getAffichage() + ")");
                    setAffichageRes(String.valueOf(Math.log(Double.parseDouble(getTemp()))));
                    //}
                }catch(Exception e){
                    Log.e("Test", "Erreur");
                    Toast.makeText(getApplicationContext(), "0 valeur entree", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.carre_button:
                try{
                    Log.e("Test", "carre");
                    //if (!text.getText().equals("") && operation == '\u0000'){
                    setAffichage("(" + getAffichage() + ")^2");
                    setAffichageRes(String.valueOf(Math.pow(Double.parseDouble(getTemp()), 2)));
                    //}
                }catch(Exception e){
                    Log.e("Test", "Erreur");
                    Toast.makeText(getApplicationContext(), "0 valeur entree", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.racine_button:
                try{
                    Log.e("Test", "racine");
                    //if (!text.getText().equals("") && operation == '\u0000'){
                    setAffichage("rac(" + getAffichage() + ")");
                    setAffichageRes(String.valueOf(Math.sqrt(Double.parseDouble(getTemp()))));
                    //}
                }catch(Exception e){
                    Log.e("Test", "Erreur");
                    Toast.makeText(getApplicationContext(), "0 valeur entree", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.inverse_button:
                try{
                    Log.e("Test", "Inverse");
                    //if (!text.getText().equals("") && operation == '\u0000'){
                    setAffichage("1/(" + getAffichage() + ")");
                    setAffichageRes(String.valueOf(Math.pow(Double.parseDouble(getTemp()),(-1))));
                    //}
                }catch(Exception e){
                    Log.e("Test", "Erreur");
                    Toast.makeText(getApplicationContext(), "0 valeur entree", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.pi_button:
                try{
                    Log.e("Test", "pi");

                    if (isDone())
                        reset();
                    setAffichage(getAffichage() + "PI");
                    setTemp(String.valueOf(Math.PI));


                }catch(Exception e){
                    Log.e("Test", "Erreur");
                    Toast.makeText(getApplicationContext(), "0 valeur entree", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.soustraction_button:
                // Premier calcul
                if (!text.getText().equals("") && getOperation() == '\u0000'){
                    setAffichage(getAffichage() + '-');
                    setA(getTemp());
                    setTemp("");
                    setOperation('-');
                    setNbPoint((short)0);

                }
                // Après un calcul
                if (!text2.getText().equals("")) {
                    setAffichage(getAffichageRes() + '-');
                    setA(getAffichageRes());
                    setTemp("");
                    setOperation('-');
                    setNbPoint((short)0);
                    setDone(false);
                }
                disableOperation();
                break;

            case R.id.multiplication_button:
                // Premier calcul
                if (!text.getText().equals("") && getOperation() == '\u0000'){
                    setAffichage(getAffichage() + '*');
                    setA(getTemp());
                    setTemp("");
                    setOperation('*');
                    setNbPoint((short)0);

                }
                // Après un calcul
                if (!text2.getText().equals("")) {
                    setAffichage(getAffichageRes() + '*');
                    setA(getAffichageRes());
                    setTemp("");
                    setOperation('*');
                    setNbPoint((short)0);
                    setDone(false);
                }
                disableOperation();
                break;

            case R.id.division_button:
                // Premier calcul
                if (!text.getText().equals("") && getOperation() == '\u0000'){
                    setAffichage(getAffichage() + '/');
                    setA(getTemp());
                    setTemp("");
                    setOperation('/');
                    setNbPoint((short)0);

                }
                // Après un calcul
                if (!text2.getText().equals("")) {
                    setAffichage(getAffichageRes() + '/');
                    setA(getAffichageRes());
                    setTemp("");
                    setOperation('/');
                    setNbPoint((short)0);
                    setDone(false);
                }
                disableOperation();
                break;

            case R.id.egal_button:

                if (getA() != "" && getTemp() != ""){
                    Log.d("Erreur", getTemp());
                    try {
                        if (Double.valueOf(getTemp()) == 0 && getOperation() == '/'){
                            Toast.makeText(getApplicationContext(), "Division par zero impossible", Toast.LENGTH_SHORT).show();
                            reset();
                            disableOperation();
                            disableEffacer();
                        }else{
                            if (text2.getText().equals("")){
                                setResultat(calcul(getA(), getTemp(), getOperation()));
                                setAffichageRes(String.valueOf(getResultat()));
                                setDone(true);
                                // Stocke dans A le dernier resultat pour calcul a repetition
                                //setTemp(String.valueOf(resultat));
                            }else{
                                setAffichage(getAffichageRes() + getOperation() + getTemp());
                                setResultat(calcul(getAffichageRes(), getTemp(), getOperation()));
                                setAffichageRes(String.valueOf(getResultat()));
                            }
                        }
                        //operation = '\u0000';
                    }catch (Exception e){
                        Log.d("Erreur", e.getMessage());
                    }
                }
                enableOperation();
                break;
        }

        text.setText(getAffichage());
        text2.setText(getAffichageRes());

        if (!text.getText().equals("") && getOperation() == '\u0000') {
            enableOperation();
            enableEffacer();
        }
    }

    /*
    * Getters & Setters
    */
    public String getAffichage() {
        return affichage;
    }

    public void setAffichage(String affichage) {
        this.affichage = affichage;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getAffichageRes() {
        return affichageRes;
    }

    public void setAffichageRes(String affichageRes) {
        this.affichageRes = affichageRes;
    }

    public BigDecimal getResultat() {
        return resultat;
    }

    public void setResultat(BigDecimal resultat) {
        this.resultat = resultat;
    }

    public short getNbPoint() {
        return nbPoint;
    }

    public void setNbPoint(short nbPoint) {
        this.nbPoint = nbPoint;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
