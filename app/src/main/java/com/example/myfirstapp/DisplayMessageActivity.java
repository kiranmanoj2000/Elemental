package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

public class DisplayMessageActivity extends AppCompatActivity {
private long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title bar
        // hide status bar
        //Remove title bar


//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_display_message);

        // if dark mode is enabled
          if(MainActivity.darkMode){
            // set dark background
            getWindow().getDecorView().setBackgroundColor(Color.rgb(49,50,51));
            // identify text view to set white font
            TextView textView = (TextView) findViewById(R.id.textView);
            // set white text
            textView.setTextColor(Color.WHITE);

            //run everything
            // Get the Intent that started this activity and extract the string
            Intent intent = getIntent();
            String Element =intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

            int i =0;





            // found where element is in array
            while((!MainActivity.elementName[i].equalsIgnoreCase(Element))&&i<108){
                i++;
            }

            boolean here = false;

            // search entire array for element
            for (String element:MainActivity.elementName){
                if(element.equalsIgnoreCase(Element)){
                    here = true;
                }

            }

            // if the element is not in the list
            if(!here){
                // issue error
                textView.setText("Please enter a valid element");

                // initialize toggle button for molar mass
                ToggleButton toggleMolar = (ToggleButton)findViewById(R.id.toggleButton);
                // Lock the toggle button for molar mass
                toggleMolar.setText("Molar Mass");
                toggleMolar.setTextOff("Molar Mass");
                toggleMolar.setTextOn("Molar Mass");

                // initialize toggle button ffor atomic number
                ToggleButton toggleAtomic = (ToggleButton)findViewById(R.id.toggleButton2);
                // Lock the toggle button for atomic number
                toggleAtomic.setText("Atomic Number");
                toggleAtomic.setTextOff("Atomic Number");
                toggleAtomic.setTextOn("Atomic Number");

                // initiialzie toggle button for density
                ToggleButton toggleDensity = (ToggleButton)findViewById(R.id.toggleButton4);
                // Lock the toggle button for density
                toggleDensity.setText("Density");
                toggleDensity.setTextOff("Density");
                toggleDensity.setTextOn("Density");

                // initialize toggle button for state at SATP
                ToggleButton toggleState = (ToggleButton)findViewById(R.id.toggleButton3);
                // lock the toggle button for state
                toggleState.setText("State at SATP");
                toggleState.setTextOff("State at SATP");
                toggleState.setTextOn("State at SATP");

                // initialize toggle button for melting point
                ToggleButton toggleMP = (ToggleButton)findViewById(R.id.toggleButton5);
                // lock the toggle button for melting point
                toggleMP.setText("Melting Point");
                toggleMP.setTextOn("Melting Point");
                toggleMP.setTextOff("Melting Point");

                // intitialize toggle button for boiling point
                ToggleButton toggleBP = (ToggleButton)findViewById(R.id.toggleButton6);
                // lock the toggle button for boiling point
                toggleBP.setText("Boiling Point");
                toggleBP.setTextOn("Boiling Point");
                toggleBP.setTextOff("Boiling Point");

                // initialize toggle button for electronegativity
                ToggleButton toggleElectro = (ToggleButton)findViewById(R.id.toggleButton7);
                // lock electronegativity
                toggleElectro.setText("Electronegativity");
                toggleElectro.setTextOn("Electronegativity");
                toggleElectro.setTextOff("Electronegativity");

            }
            // valid element is listed
            else{

                // display the element and its chemical symbol
                textView.setText(MainActivity.elementName[i]+" ("+MainActivity.chemSymb[i]+")");
                // initialize toggle button for atomic number
                ToggleButton toggleAtomic = (ToggleButton)findViewById(R.id.toggleButton2);
                // intiialize toggle button for molar mass
                ToggleButton toggleMolar = (ToggleButton)findViewById(R.id.toggleButton);
                // initiialzie toggle button for density
                ToggleButton toggleDensity = (ToggleButton)findViewById(R.id.toggleButton4);
                // set intial text of atomic toggle
                toggleAtomic.setText("Atomic Number");
                // set text when atomic is off
                toggleAtomic.setTextOff("Atomic Number");
                // display the atomic number ascertained from the array position of the element
                toggleAtomic.setTextOn(""+ (i+1));

                // molar mass button
                toggleMolar.setText("Molar Mass");
                toggleMolar.setTextOff("Molar Mass");
                toggleMolar.setTextOn(""+MainActivity.molarMass[i]+" g/mol");

                // for density
                toggleDensity.setText("Density");
                toggleDensity.setTextOff("Density");
                // if there is a valid density known
                if(MainActivity.density[i]!=0.00){
                    toggleDensity.setTextOn(""+MainActivity.density[i]+" g/cm\u00b3");
                }
                // density is unknown
                else{
                    toggleDensity.setTextOn("\u00BFUnknown\u00BF");
                }


                // initialize toggle button for state at SATP
                ToggleButton toggleState = (ToggleButton)findViewById(R.id.toggleButton3);
                toggleState.setText("State at SATP");
                // is the state gas?
                if(MainActivity.elementName[i].equalsIgnoreCase("hydrogen")||MainActivity.elementName[i].equalsIgnoreCase("oxygen")||MainActivity.elementName[i].equalsIgnoreCase("helium")||MainActivity.elementName[i].equalsIgnoreCase("nitrogen")||MainActivity.elementName[i].equalsIgnoreCase("fluorine")||MainActivity.elementName[i].equalsIgnoreCase("neon")||MainActivity.elementName[i].equalsIgnoreCase("chlorine")||MainActivity.elementName[i].equalsIgnoreCase("argon")||MainActivity.elementName[i].equalsIgnoreCase("krypton")||MainActivity.elementName[i].equalsIgnoreCase("xenon")||MainActivity.elementName[i].equalsIgnoreCase("radon")){
                    toggleState.setTextOn("Gas");
                    toggleState.setTextOff("State at SATP");

                }
                // is it a liquid
                else if(MainActivity.elementName[i].equalsIgnoreCase("bromine")||MainActivity.elementName[i].equalsIgnoreCase("mercury")){
                    toggleState.setTextOn("Liquid");
                    toggleState.setTextOff("State at SATP");
                }// must be a solid
                else{
                    toggleState.setTextOn("Solid");
                    toggleState.setTextOff("State at SATP");
                }

                //MELTING POINT
                // initialize toggle button for melting point
                ToggleButton toggleMP = (ToggleButton)findViewById(R.id.toggleButton5);
                toggleMP.setText("Melting Point");
                toggleMP.setTextOff("Melting Point");
                // if there is melting point
                if(MainActivity.meltingPoint[i]!=0){
                    // display melting point
                    toggleMP.setTextOn(""+ MainActivity.meltingPoint[i]+" \u00b0"+"C");
                }
                // there isnt one
                else{
                    toggleMP.setTextOn("\u00BFUnknown\u00BF");
                }



                //BOILING POINT
                // intitialize toggle button for boiling point
                ToggleButton toggleBP = (ToggleButton)findViewById(R.id.toggleButton6);
                toggleBP.setText("Boiling Point");
                toggleBP.setTextOff("Boiling Point");
                // there is a boiling pint
                if(MainActivity.boilingPoint[i]!=0){
                    // display boiling point
                    toggleBP.setTextOn(""+ MainActivity.boilingPoint[i]+" \u00b0"+"C");
                }
                // is unknown
                else{
                    toggleBP.setTextOn("\u00BFUnknown\u00BF");
                }



                //ELECTRONEGATIVITY
                // intiialize toggle button for electronegativity
                ToggleButton toggleElectro = (ToggleButton)findViewById(R.id.toggleButton7);
                toggleElectro.setText("Electronegativity");
                toggleElectro.setTextOff("Electronegativity");
                // is there an elctronegstivy
                if(MainActivity.electronegativity[i]==0.00){
                    // say its unkown
                    toggleElectro.setTextOn("\u00BFUnknown\u00BF");
                }
                // it is known
                else{
                    toggleElectro.setTextOn(""+MainActivity.electronegativity[i]);
                }


            }

        }
        // light mode
        else{
            // Get the Intent that started this activity and extract the string
            Intent intent = getIntent();
            String Element =intent.getStringExtra(MainActivity.EXTRA_MESSAGE);





            TextView textView = (TextView)findViewById(R.id.textView);
            int i =0;





            // found where element is in array
            while((!MainActivity.elementName[i].equalsIgnoreCase(Element))&&i<108){
                i++;
            }

            boolean here = false;

            // search entire array for element
            for (String element:MainActivity.elementName){
                if(element.equalsIgnoreCase(Element)){
                    here = true;
                }

            }

            // if the element is not in the list
            if(!here){
                // issue error
                textView.setText("Please enter a valid element");
                // initialize toggle button for molar mass
                ToggleButton toggleMolar = (ToggleButton)findViewById(R.id.toggleButton);
                // Lock the toggle button for molar mass
                toggleMolar.setText("Molar Mass");
                toggleMolar.setTextOff("Molar Mass");
                toggleMolar.setTextOn("Molar Mass");
                // initialize toggle button ffor atomic number
                ToggleButton toggleAtomic = (ToggleButton)findViewById(R.id.toggleButton2);
                // Lock the toggle button for atomic number
                toggleAtomic.setText("Atomic Number");
                toggleAtomic.setTextOff("Atomic Number");
                toggleAtomic.setTextOn("Atomic Number");
                // initiialzie toggle button for density
                ToggleButton toggleDensity = (ToggleButton)findViewById(R.id.toggleButton4);
                // Lock the toggle button for density
                toggleDensity.setText("Density");
                toggleDensity.setTextOff("Density");
                toggleDensity.setTextOn("Density");
                // initialize toggle button for state at SATP
                ToggleButton toggleState = (ToggleButton)findViewById(R.id.toggleButton3);
                // lock the toggle button for state
                toggleState.setText("State at SATP");
                toggleState.setTextOff("State at SATP");
                toggleState.setTextOn("State at SATP");

                // initialize toggle button for melting point
                ToggleButton toggleMP = (ToggleButton)findViewById(R.id.toggleButton5);
                // lock the toggle button for melting point
                toggleMP.setText("Melting Point");
                toggleMP.setTextOn("Melting Point");
                toggleMP.setTextOff("Melting Point");

                // intitialize toggle button for boiling point
                ToggleButton toggleBP = (ToggleButton)findViewById(R.id.toggleButton6);
                // lock the toggle button for boiling point
                toggleBP.setText("Boiling Point");
                toggleBP.setTextOn("Boiling Point");
                toggleBP.setTextOff("Boiling Point");

                // intiialize toggle button for electronegativity
                ToggleButton toggleElectro = (ToggleButton)findViewById(R.id.toggleButton7);
                // lock electronegativity
                toggleElectro.setText("Electronegativity");
                toggleElectro.setText("Electronegativity");
                toggleElectro.setText("Electronegativity");

            }
            // valid element is listed
            else{

                // display the element and its chemical symbol
                textView.setText(MainActivity.elementName[i]+" ("+MainActivity.chemSymb[i]+")");
                // initialize toggle button for atomic number
                ToggleButton toggleAtomic = (ToggleButton)findViewById(R.id.toggleButton2);
                // intiialize toggle button for molar mass
                ToggleButton toggleMolar = (ToggleButton)findViewById(R.id.toggleButton);
                // initiialzie toggle button for density
                ToggleButton toggleDensity = (ToggleButton)findViewById(R.id.toggleButton4);
                // set intial text of atomic toggle
                toggleAtomic.setText("Atomic Number");
                // set text when atomic is off
                toggleAtomic.setTextOff("Atomic Number");
                // display the atomic number ascertained from the array position of the element
                toggleAtomic.setTextOn(""+ (i+1));

                // molar mass button
                toggleMolar.setText("Molar Mass");
                toggleMolar.setTextOff("Molar Mass");
                toggleMolar.setTextOn(""+MainActivity.molarMass[i]+" g/mol");

                // for density
                toggleDensity.setText("Density");
                toggleDensity.setTextOff("Density");
                // if there is a valid density known
                if(MainActivity.density[i]!=0.00){
                    toggleDensity.setTextOn(""+MainActivity.density[i]+" g/cm\u00b3");
                }
                // density is unknown
                else{
                    toggleDensity.setTextOn("\u00BFUnknown\u00BF");
                }
                // initialize toggle button for state at SATP
                ToggleButton toggleState = (ToggleButton)findViewById(R.id.toggleButton3);
                toggleState.setText("State at SATP");
                // is the state gas?
                if(MainActivity.elementName[i].equalsIgnoreCase("hydrogen")||MainActivity.elementName[i].equalsIgnoreCase("oxygen")||MainActivity.elementName[i].equalsIgnoreCase("helium")||MainActivity.elementName[i].equalsIgnoreCase("nitrogen")||MainActivity.elementName[i].equalsIgnoreCase("fluorine")||MainActivity.elementName[i].equalsIgnoreCase("neon")||MainActivity.elementName[i].equalsIgnoreCase("chlorine")||MainActivity.elementName[i].equalsIgnoreCase("argon")||MainActivity.elementName[i].equalsIgnoreCase("krypton")||MainActivity.elementName[i].equalsIgnoreCase("xenon")||MainActivity.elementName[i].equalsIgnoreCase("radon")){
                    toggleState.setTextOn("Gas");
                    toggleState.setTextOff("State at SATP");

                }
                // is it a liquid
                else if(MainActivity.elementName[i].equalsIgnoreCase("bromine")||MainActivity.elementName[i].equalsIgnoreCase("mercury")){
                    toggleState.setTextOn("Liquid");
                    toggleState.setTextOff("State at SATP");
                }// must be a solid
                else{
                    toggleState.setTextOn("Solid");
                    toggleState.setTextOff("State at SATP");
                }

                //MELTING POINT
                // initialize toggle button for melting point
                ToggleButton toggleMP = (ToggleButton)findViewById(R.id.toggleButton5);
                toggleMP.setText("Melting Point");
                toggleMP.setTextOff("Melting Point");
                // if there is melting point
                if(MainActivity.meltingPoint[i]!=0){
                    // display melting point
                    toggleMP.setTextOn(""+ MainActivity.meltingPoint[i]+" \u00b0"+"C");
                }
                // there isnt one
                else{
                    toggleMP.setTextOn("\u00BFUnknown\u00BF");
                }



                //BOILING POINT
                // intitialize toggle button for boiling point
                ToggleButton toggleBP = (ToggleButton)findViewById(R.id.toggleButton6);
                toggleBP.setText("Boiling Point");
                toggleBP.setTextOff("Boiling Point");
                // there is a boiling pint
                if(MainActivity.boilingPoint[i]!=0){
                    // display boiling point
                    toggleBP.setTextOn(""+ MainActivity.boilingPoint[i]+" \u00b0"+"C");
                }
                // is unknown
                else{
                    toggleBP.setTextOn("\u00BFUnknown\u00BF");
                }



                //ELECTRONEGATIVITY
                // intiialize toggle button for electronegativity
                ToggleButton toggleElectro = (ToggleButton)findViewById(R.id.toggleButton7);
                toggleElectro.setText("Electronegativity");
                toggleElectro.setTextOff("Electronegativity");
                // is there an elctronegstivy
                if(MainActivity.electronegativity[i]==0.00){
                    // say its unkown
                    toggleElectro.setTextOn("\u00BFUnknown\u00BF");
                }
                // it is known
                else{
                    toggleElectro.setTextOn(""+MainActivity.electronegativity[i]);
                }

            }
        }











    }


}
