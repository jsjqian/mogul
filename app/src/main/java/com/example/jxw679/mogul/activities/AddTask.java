package com.example.jxw679.mogul.activities;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.jxw679.mogul.R;
import com.example.jxw679.mogul.model.Task;
import com.example.jxw679.mogul.model.requests.TaskRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTask extends AppCompatActivity {


    private EditText taskName;
    private EditText description;
    private EditText price;
    private EditText deadline;
    private ImageButton assign;
    private ImageButton backButton;
    private ImageButton createTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskName = (EditText) findViewById(R.id.task_name_edit);
        description = (EditText) findViewById(R.id.description_edit);
        price = (EditText) findViewById(R.id.price_edit);
        deadline = (EditText) findViewById(R.id.deadline_edit);
        assign = (ImageButton) findViewById(R.id.add_child_to_task);
        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ParentView.class);
                startActivity(intent);
            }
        });
        createTask = (ImageButton) findViewById(R.id.create_task_button);
        createTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequestForTask();
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        String[] names = new String[ParentView.parent.getChildren().size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = ParentView.parent.getChildren().get(i);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);
        // Specify the layout to use when the list of choices appears
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(dataAdapter);
    }

    private void sendRequestForTask() {
        TaskRequest req = new TaskRequest();
        req.setTaskname(taskName.getText().toString());
        req.setDeadline(deadline.getText().toString());
        req.setReward(Integer.parseInt(price.getText().toString()));
        req.setDescription(description.getText().toString());
        req.setOwner(ParentView.parent.getUid());
        req.setAssignto("GwTHM4mXnfYDgsP24cjnqh4YsRA2");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("/requests").push().setValue(req);
    }
}

