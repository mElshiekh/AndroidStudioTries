import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Elshiekho on 5/6/2018.
 */

public class MySQLAdapt {
    private Context context;
    static MySQLHelper dbHelper;

    public MySQLAdapt(Context _context) {
        dbHelper = new MySQLHelper(_context);
        context = _context;
    }

    public long insertF(String str1, String str2) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLHelper.name, str1);
        contentValues.put(MySQLHelper.name2, str2);
        long i = db.insert(MySQLHelper.table_name, null, contentValues);
        return i;
    }

    public InputsC RetrieveF() {
        InputsC iC = new InputsC();
        Cursor c;
        //String qString = "select * from"+dbHelper.DATABASE_NAME;
        String[] columns = {dbHelper.name, dbHelper.name2};
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        c = db.query(dbHelper.table_name, columns, null, null, null, null, null);
        Log.i("ic", c.toString());
        while (c.moveToNext()) {
            iC.setName(c.getString(0));
            iC.setName2(c.getString(1));
        }
        return iC;
    }

    static class MySQLHelper extends SQLiteOpenHelper {
        public static final String table_name = "mytable";
        public static final String name = "name";
        public static final String name2 = "name2";
        private static final String DATABASE_NAME = "mydb.db";
        private static final int version = 1;

        public MySQLHelper(Context context) {
            super(context, DATABASE_NAME, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + table_name + " (_id integer primary key autoincrement," + name + " varchar(255)," + name2 + " varchar(255));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}