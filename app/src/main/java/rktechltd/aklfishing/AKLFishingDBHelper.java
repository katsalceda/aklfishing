package rktechltd.aklfishing;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by romelyn on 13/05/2016.
 */
public class AKLFishingDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "aklfishingdatabase.db";
    public static final int DB_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT";
    private static final String REAL_TYPE = " REAL";
    private static final String NUMERIC_TYPE = " NUMERIC";
    private static final String BLOB_TYPE = " BLOB";
    private static final String COMMA_SEP = ",";

    private static final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + AKLFishingDBTables.Category.TABLE_NAME + " (" +
            AKLFishingDBTables.Category.COLUMN_CAT_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Category.COLUMN_CAT_NAME + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Category.COLUMN_CAT_DESC + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Category.PRIMARY_KEY +
            " )";

    private static final String CREATE_FISH_TABLE = "CREATE TABLE " + AKLFishingDBTables.Fish.TABLE_NAME + " (" +
            AKLFishingDBTables.Fish.COLUMN_FISH_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_FISH_NAME + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_FISH_CAT+ NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_FISH_DESC+ TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_FISH_IMAGE+ BLOB_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.PRIMARY_KEY +
            " )";

    private static final String CREATE_LOCATION_TABLE = "CREATE TABLE " + AKLFishingDBTables.Location.TABLE_NAME + " (" +
            AKLFishingDBTables.Location.COLUMN_LOCATION_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.COLUMN_LOCATION_NAME + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.COLUMN_lOCATION_LATITUDE+ REAL_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.COLUMN_LOCATION_LONGITUDE+ REAL_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.COLUMN_LOCATION_N0TE+ TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.PRIMARY_KEY +
            " )";

    private static final String CREATE_FISHEXPERIENCE_TABLE = "CREATE TABLE " + AKLFishingDBTables.FishingExperience.TABLE_NAME + " (" +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_LOCATION_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_DATE+ TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_TIME+ TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_REMARK+ TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.PRIMARY_KEY +
            " )";

    private static final String CREATE_FISHCATCH_TABLE = "CREATE TABLE " + AKLFishingDBTables.FishCatch.TABLE_NAME + " (" +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_EXPERIENCE + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_NAME + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_LENGTH + REAL_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_WEIGHT + REAL_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_REMARK + TEXT_TYPE + COMMA_SEP+
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_IMAGE + BLOB_TYPE + COMMA_SEP+
            AKLFishingDBTables.FishCatch.PRIMARY_KEY +
            " )";

    private static final String CREATE_CHECKLIST_TABLE = "CREATE TABLE " + AKLFishingDBTables.CheckList.TABLE_NAME + " (" +
            AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_IMAGE + BLOB_TYPE + COMMA_SEP +
            AKLFishingDBTables.CheckList.PRIMARY_KEY +
            " )";

    private static final String CREATE_NETRULES_TABLE = "CREATE TABLE " + AKLFishingDBTables.NetRules.TABLE_NAME + " (" +
            AKLFishingDBTables.NetRules.COLUMN_NETRULES_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.NetRules.COLUMN_NETRULES_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.NetRules.COLUMN_NETRULES_IMAGE + BLOB_TYPE + COMMA_SEP +
            AKLFishingDBTables.NetRules.PRIMARY_KEY +
            " )";

    private static final String CREATE_FAQ_TABLE = "CREATE TABLE " + AKLFishingDBTables.Faq.TABLE_NAME + " (" +
            AKLFishingDBTables.Faq.COLUMN_FAQ_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Faq.COLUMN_FAQ_QUESTION + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Faq.COLUMN_FAQ_ANSWER + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Faq.PRIMARY_KEY +
            " )";


    private static final String DELETE_CATEGORY_TABLE = "DROP TABLE IF EXISTS " + AKLFishingDBTables.Category.TABLE_NAME;
    private static final String DELETE_FISH_TABLE = "DROP TABLE IF EXISTS " + AKLFishingDBTables.Fish.TABLE_NAME;
    private static final String DELETE_lOCATION_TABLE = "DROP TABLE IF EXISTS " + AKLFishingDBTables.Location.TABLE_NAME;
    private static final String DELETE_FISHEXPERIENCE_TABLE = "DROP TABLE IF EXISTS " + AKLFishingDBTables.FishingExperience.TABLE_NAME;
    private static final String DELETE_FISHCATCH_TABLE= "DROP TABLE IF EXISTS " + AKLFishingDBTables.FishCatch.TABLE_NAME;
    private static final String DELETE_CHECKLIST_TABLE= "DROP TABLE IF EXISTS " + AKLFishingDBTables.CheckList.TABLE_NAME;
    private static final String DELETE_NETRULES_TABLE= "DROP TABLE IF EXISTS " + AKLFishingDBTables.NetRules.TABLE_NAME;
    private static final String DELETE_FAQ_TABLE= "DROP TABLE IF EXISTS " + AKLFishingDBTables.Faq.TABLE_NAME;



    public AKLFishingDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_FISH_TABLE);
        db.execSQL(CREATE_LOCATION_TABLE);
        db.execSQL(CREATE_FISHEXPERIENCE_TABLE);
        db.execSQL(CREATE_FISHCATCH_TABLE);
        db.execSQL(CREATE_CHECKLIST_TABLE);
        db.execSQL(CREATE_NETRULES_TABLE);
        db.execSQL(CREATE_FAQ_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_CATEGORY_TABLE);
        db.execSQL(DELETE_FISH_TABLE);
        db.execSQL(DELETE_lOCATION_TABLE);
        db.execSQL(DELETE_FISHEXPERIENCE_TABLE);
        db.execSQL(DELETE_FISHCATCH_TABLE);
        db.execSQL(DELETE_CHECKLIST_TABLE);
        db.execSQL(DELETE_NETRULES_TABLE);
        db.execSQL(DELETE_FAQ_TABLE);
        onCreate(db);
    }



   /* public boolean saveCategory(Category aCategory) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FIRST_NAME, aUser.getFirstName());
        cv.put(COLUMN_LAST_NAME, aUser.getLastName());
        cv.put(COLUMN_USER_ID, aUser.getUserId());
        cv.put(COLUMN_USER_PASSWORD, aUser.getUserPassword());

        db.insert(TABLE_USERS, null, cv);
        db.close();
        return true;
    }

    public List<User> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> userList;
        String query = "SELECT " + COLUMN_FIRST_NAME + ", "
                + COLUMN_LAST_NAME + ", "
                + COLUMN_USER_ID + ", "
                + COLUMN_USER_PASSWORD + " from " + TABLE_USERS;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            userList = new ArrayList<User>();
            cursor.moveToFirst();
            do {
                User aUser = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                userList.add(aUser);
            } while (cursor.moveToNext());
            db.close();
            return userList;
        }

        return null;
    }

    public User findUser(String userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_USER_ID, COLUMN_USER_PASSWORD},
                COLUMN_USER_ID + "=?", new String[]{userId}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            User aUser = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            db.close();
            return aUser;
        }

        return null;
    }*/

}