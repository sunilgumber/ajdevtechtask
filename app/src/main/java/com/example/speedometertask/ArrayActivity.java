package com.example.speedometertask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayActivity extends AppCompatActivity {
Button buttoninput;
EditText etinput;
TextView etoutput;
TextView etarray;
TextView etdiff;
int[] array=new int[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
        etinput=(EditText) findViewById(R.id.etinput);
        buttoninput=(Button )findViewById(R.id.buttoninput);
        etoutput=(TextView ) findViewById(R.id.etoutput);
        etarray=(TextView ) findViewById(R.id.etarray);
        etdiff=(TextView ) findViewById(R.id.etdiff);
        buttoninput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkvalidation(Integer.valueOf(etinput.getText().toString()));
            }
        });
    }

    private void checkvalidation(int inputno){
        if(difference(inputno)>1.25) array=new int[]{};
        if(array.length==10) rearrangearray(inputno);
        calculateavg(inputno);
    }

    private double difference(int inputno){
        if(array.length==0)
            return 0;
        else{
            Set<Integer> set = new HashSet<Integer>();
            set.add(inputno);
            set.add(array[array.length-1]);
            double minSet = Collections.min(set);
            double maxSet = Collections.max(set);
            double diff=maxSet/minSet;
            etdiff.setText(String.valueOf(diff));
            return diff;
        }
    }


    private  int[] append(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    private void rearrangearray(int inputno) {
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array=Arrays.copyOf(array, array.length-1);
        //calculateavg(inputno);
    }

    private void calculateavg(int inputno) {
        array=append(array,inputno);
        etinput.setText("");
        double avg = Arrays.stream(array).average().getAsDouble();
        etoutput.setText(String.valueOf(avg));
        printarray(array);
    }


    public void printarray(int[] a){
        String s = "[";
        for(int i = 0; i < array.length; i++){
             s+= " "+array[i]+" " ;
        }
        s+="]";
        etarray.setText(s);
    }

}
