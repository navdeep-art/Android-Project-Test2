package example.com.finaltest_android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewQuestions extends AppCompatActivity {

    // creating variables for our array list,
    // DBHandler, adapter and recycler view.
    private ArrayList<QuestionModal> questionModalArrayList;
    private DBHandler dbHandler;
    private QuestionRVAdapter questionRVAdapter;
    private RecyclerView coursesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_questions);

        // initializing our all variables.
        questionModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewQuestions.this);

        // getting our course array
        // list from db handler class.
        questionModalArrayList = dbHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        questionRVAdapter = new QuestionRVAdapter(questionModalArrayList, ViewQuestions.this);
        coursesRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewQuestions.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(questionRVAdapter);
    }
}