package com.imagine.gid.thunk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.imagine.gid.thunk.abstracts.Thought;

public class MainActivity extends Activity implements OnClickListener
{
    private Button b_showThought;
    private TextView tv_Thoughts;
    private Thought thought;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setGui();

        thought = new Thought();
    }

    private void setGui()
    {
        b_showThought = (Button)findViewById(R.id.b_display_thought);
        b_showThought.setOnClickListener(this);
        tv_Thoughts = (TextView)findViewById(R.id.tv_display_thought);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == b_showThought.getId())
        {
            String integers = "";

            for(int i=0; i<10; i++)
            {
                Log.d("Value: ", "" + thought.get());
                integers += thought.get() + ", ";
            }

            tv_Thoughts.setText(integers);
        }
    }

}

