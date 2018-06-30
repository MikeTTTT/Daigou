package com.example.ttt.daigou;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String db_name = "DBTest";
    private int rowNo = 0;
    private final String CREATE_TABLE = "create table if not exists user(tableId INTEGER PRIMARY KEY AUTOINCREMENT, tableName varchar(10))";

    private EditText tableId, tableName, deleteId;
    private TextView mResult;
    private int dbVersion = 1;
    private DatabaseHelper helper;
    private SQLiteDatabase db;
    ListView lv;
    Myadapter myadapter;

    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Mainactivity","Daigou Start!");

        lv = (ListView) findViewById(R.id.lv_data);
        personList = new ArrayList<Person>();

        CreateDB();

//        Insert();
//
//        Select();

        myadapter = new Myadapter(getApplicationContext());
        lv.setAdapter(myadapter);

        Button btCreateDB = (Button) findViewById(R.id.bt_createdb);
        Button btSelectData = (Button) findViewById(R.id.bt_upgrade);
        Button btDeleteDB = (Button) findViewById(R.id.bt_delete);
        Button btinsertData = (Button) findViewById(R.id.bt_insertData);
        Button btDeleteTable = (Button) findViewById(R.id.bt_deletetable);

        tableId = (EditText) findViewById(R.id.tableid);
        tableName = (EditText) findViewById(R.id.tablename);

        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDB();
            }
        });

        btinsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insert();
            }
        });

        btDeleteTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete(v);
            }
        });

        btSelectData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Select();
                myadapter = new Myadapter(getApplicationContext());
                lv.setAdapter(myadapter);
            }
        });

        btDeleteDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteTable(v);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    class Myadapter extends BaseAdapter{
        private Context context;
        private LayoutInflater inflater;

        public Myadapter(Context context){
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return personList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Person p = personList.get(position);
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.list_item, null);
                viewHolder.tx_name = convertView.findViewById(R.id.tv_name);
                viewHolder.tx_no = convertView.findViewById(R.id.tv_no);
                viewHolder.tx_math = convertView.findViewById(R.id.tv_math);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tx_name.setText(p.getName());
            viewHolder.tx_no.setText(p.getNo());
            viewHolder.tx_math.setText(p.getMath());

            return convertView;
        }
    }

    class ViewHolder{
        private TextView tx_name;
        private  TextView tx_no;
        private  TextView tx_math;
    }

    public void CreateDB(){
        helper = new DatabaseHelper(this);
        db = helper.getWritableDatabase();
        Log.d("Mainactivity","create database in progress!");
        Toast.makeText(getApplicationContext(), "DB created!",Toast.LENGTH_LONG).show();
    }
    public void Insert() {

        //向学生表中添加10名学生
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"刘得意", 19, 1001, 60, 98, 75});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"王锐", 20, 1002, 63, 90, 96});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"何煜中", 19, 1003, 90, 73, 82});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"王磊", 21, 1004, 87, 86, 92});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"冯松", 19, 1005, 89, 98, 83});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"裴培", 20, 1006, 75, 82, 91});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"马骁", 19, 1007, 62, 67, 90});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"马婧", 20, 1008, 98, 84, 87});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"周俊升", 19, 1009, 57, 68, 96});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"贺祺", 21, 1010, 61, 96, 72});
    }

    public void DeleteTable(View view) {

        //删除姓名为"刘得意"的学生的信息
//        db.execSQL("drop table student");
    }

    public void Delete(View view) {

        //删除姓名为"刘得意"的学生的信息
        db.execSQL("delete from Student where name = ?", new Object[]{"刘得意"});
    }

    public void Update(View view) {

        //将数据库中所有人的学号减少1
        db.execSQL("update student set no = no -1");
    }

    public void Select() {

        //查询数据库中学生的姓名和以其对应的C++成绩,返回值为一个结果集
        Cursor cursor = db.rawQuery("select * from student", null);

        while (cursor.moveToNext()) {

            //cursor.getColumnIndex("name")获得姓名所在的列
            String _id = String.valueOf(cursor.getInt(cursor.getColumnIndex("_id")));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String cpp = String.valueOf(cursor.getFloat(cursor.getColumnIndex("cpp")));
            String no = String.valueOf(cursor.getInt(cursor.getColumnIndex("no")));
            String math = String.valueOf(cursor.getFloat(cursor.getColumnIndex("math")));
            String age = String.valueOf(cursor.getInt(cursor.getColumnIndex("age")));
            String english = String.valueOf(cursor.getFloat(cursor.getColumnIndex("english")));

            Person p = new Person(_id,name,no,age,cpp,math,english);
            personList.add(p);


            //输出学生的姓名和与姓名对应的C++成绩
            Log.d("MainActivity", '[' + name + ", " + cpp + ']');
        }Log.d("MainActivity","____________________________________");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void show(String t){
        Toast.makeText(getApplicationContext(), t, Toast.LENGTH_LONG).show();
    }
}
