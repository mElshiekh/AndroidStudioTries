import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Elshiekho on 5/6/2018.
 */

public class ContentProviderTry extends ContentProvider {


    String url = "content://com.example.elshiekho.myapplication/try"; //l7ad el "/" da esmo elprovider w da ely beyt7at fel manifest
    // bas content_uri da ely bast5demo 3lshan ashtghl beeh fel methods
    Uri  content_uri = Uri.parse(url);


    @Override
    public boolean onCreate() {
        MySQLAdapt.MySQLHelper helper = new MySQLAdapt.MySQLHelper(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        MySQLAdapt.MySQLHelper dbHelper = new MySQLAdapt.MySQLHelper(getContext());
        Cursor c;
        //String qString = "select * from"+dbHelper.DATABASE_NAME;
        String[] columns = {dbHelper.name, dbHelper.name2};
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        c = db.query(dbHelper.table_name, columns, null, null, null, null, null);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return "vnd.android.cursor.dir/vnd.example.elshiekho";
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        MySQLAdapt.MySQLHelper helper = new MySQLAdapt.MySQLHelper(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        long i = db.insert(MySQLAdapt.MySQLHelper.table_name, null, values);
        Uri uriX = ContentUris.withAppendedId(content_uri,i);
        return uriX;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
