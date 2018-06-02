package com.example.user.myapplication.Engineering;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.user.myapplication.DB.DBHelper;
import com.example.user.myapplication.R;

// 버튼 클릭 리스너 만들기

public class Engineering_1floor_WomenActivity extends AppCompatActivity{

    private Button btnCreateDatabase;
    private DBHelper dbHelper;
    private Button btnInsertDatabse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.engineering_1floor_women);

        btnCreateDatabase = (Button) findViewById(R.id.btnCreateButton);
        btnCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final EditText etDBName = new EditText(Engineering_1floor_WomenActivity.this);
                etDBName.setHint("DB명을 입력하세요.");

                // Dialog로 Database의 이름을 입력받는다.
                AlertDialog.Builder dialog = new AlertDialog.Builder(Engineering_1floor_WomenActivity.this);
                dialog.setTitle("Database 이름을 입력하세요.")
                        .setMessage("Database의 이름을 입력하세요.")
                        .setView(etDBName)
                        .setPositiveButton("생성", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if(etDBName.getText().toString().length() > 0) {
                                    dbHelper = new DBHelper(
                                            Engineering_1floor_WomenActivity.this,
                                            etDBName.getText().toString(),
                                            null, 1);
                                    dbHelper.testDB();

                                }

                            }
                        })
                        .setNeutralButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                        .show();
            }
        });

        btnInsertDatabse = (Button) findViewById(R.id.btnInsertButton);
        btnInsertDatabse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout layout = new LinearLayout(Engineering_1floor_WomenActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                final EditText etName = new EditText(Engineering_1floor_WomenActivity.this);
                etName.setHint("이름을 입력하세요.");

                final EditText etAge = new EditText(Engineering_1floor_WomenActivity.this);
                etAge.setHint("나이을 입력하세요.");

                final EditText etPhone = new EditText(Engineering_1floor_WomenActivity.this);
                etPhone.setHint("전화번호를 입력하세요.");

                layout.addView(etName);
                layout.addView(etAge);
                layout.addView(etPhone);

                AlertDialog.Builder dialog = new AlertDialog.Builder(Engineering_1floor_WomenActivity.this);
                dialog.setTitle("정보를 입력하세요")
                        .setView(layout)
                        .setPositiveButton("등록", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = et
                            }
                        })
            }
        });
    }
}
