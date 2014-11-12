package me.sheharyar.sparkrelay;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.Map;

public class CoreDB extends SQLiteOpenHelper {
    private static final int    DATABASE_VERSION = 1;
    private static final String DATABASE_NAME    = "CoreDB";

    private static final String TABLE_CORE       = "cores";
    private static final String TABLE_RELAY      = "relays";

    private static final HashMap<String, String> FIELDS_RELAY = new HashMap<String, String>() {{
        put("name",       "TEXT");
    }};

    private static final HashMap<String, String> FIELDS_CORE  = new HashMap<String, String>() {{
        put("name",       "TEXT");
        put("token",      "TEXT");
        put("identifier", "TEXT");

        put("relay1",     "INTEGER");
        put("relay2",     "INTEGER");
        put("relay3",     "INTEGER");
        put("relay4",     "INTEGER");
    }};


    // -----

    public CoreDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db, TABLE_CORE,  FIELDS_CORE);
        createTable(db, TABLE_RELAY, FIELDS_RELAY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CORE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RELAY);

        // create fresh books table
        this.onCreate(db);
    }

    static public void createTable(SQLiteDatabase db, String tableName, HashMap<String, String> fields) {
        String command = "CREATE TABLE " + tableName + " ( id INTEGER PRIMARY KEY AUTOINCREMENT";

        for (Map.Entry<String, String> entry : fields.entrySet())
            command = command + ", " + entry.getKey() + " " + entry.getValue();

        command = command + " )";
        db.execSQL(command);
    }
}
