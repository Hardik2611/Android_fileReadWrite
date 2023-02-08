package com.example.hardikgoyal_filemb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText e;
    Button r,w;
    TextView t,t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e= findViewById(R.id.editTextTextPersonName);
        r= findViewById(R.id.button3);
        w= findViewById(R.id.button);
        t= findViewById(R.id.textView);
        t1.findViewById(R.id.textView2);

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = new String(e.getText().toString());
                writeTofile("testMb.txt",content);
                e.setText("");
                Toast.makeText(MainActivity.this, "Writing Done", Toast.LENGTH_LONG).show();
            }
        });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = new String();
                content = readFromFile("testMb.txt");
                t.setText(content);
            }
        });


    }

    private String readFromFile(String fileName) {
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path,fileName);
        byte b[] = new byte[(int) readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(b);
            return new String(b);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
    }

    private void writeTofile(String fileName, String content) {
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(content.getBytes());
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}