package ru.khasang.honeymoney.localrepository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "honeymoney.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_USER_CREATE = "CREATE TABLE "
            + UserDataContractClass.User.TABLE_USER + " ("
            + UserDataContractClass.User._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserDataContractClass.User.PHONE + " TEXT, "
            + UserDataContractClass.User.NAME + " TEXT, "
            + UserDataContractClass.User.EMAIL + " TEXT, "
            + UserDataContractClass.User.PASSWORD + " TEXT, "
            + UserDataContractClass.User.CREATED + " NUMERIC NOT NULL DEFAULT CURRENT_TIMESTAMP"
            + ")";
    private static final String TABLE_ACCOUNT_HAS_USER_CREATE = "CREATE TABLE "
            + UserDataContractClass.AccountHasUser.TABLE_ACCOUNT_HAS_USER + " ("
            + UserDataContractClass.AccountHasUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserDataContractClass.AccountHasUser.ACCOUNT_ID + " INTEGER, "
            + UserDataContractClass.AccountHasUser.USER_ID + " INTEGER, "
            + UserDataContractClass.AccountHasUser.TYPE + " TEXT"
            + ")";
    private static final String TABLE_ACCOUNT_CREATE = "CREATE TABLE "
            + UserDataContractClass.Account.TABLE_ACCOUNT + " ("
            + UserDataContractClass.Account._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserDataContractClass.Account.NAME + " TEXT, "
            + UserDataContractClass.Account.CREATED + " NUMERIC NOT NULL DEFAULT CURRENT_TIMESTAMP, "
            + UserDataContractClass.Account.TYPE + " TEXT, "
            + UserDataContractClass.Account.ALERT + " NUMERIC NOT NULL DEFAULT CURRENT_TIMESTAMP"
            + ")";
    private static final String TABLE_CATEGORY_CREATE = "CREATE TABLE "
            + UserDataContractClass.Category.TABLE_CATEGORY + " ("
            + UserDataContractClass.Category._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserDataContractClass.Category.CATEGORY_ID + " INTEGER, "
            + UserDataContractClass.Category.NAME + " TEXT"
            + ")";
    private static final String TABLE_LOCATION_CREATE = "CREATE TABLE "
            + UserDataContractClass.Location.TABLE_LOCATION + " ("
            + UserDataContractClass.Location._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserDataContractClass.Location.LATITUDE + " TEXT, "
            + UserDataContractClass.Location.LONGITUDE + " TEXT, "
            + UserDataContractClass.Location.NAME + " TEXT"
            + ")";
    private static final String TABLE_CURRENCY_CREATE = "CREATE TABLE "
            + UserDataContractClass.Currency.TABLE_CURRENCY + " ("
            + UserDataContractClass.Currency._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserDataContractClass.Currency.CODE + " TEXT, "
            + UserDataContractClass.Currency.NAME + " TEXT"
            + ")";
    private static final String TABLE_OPERATION_CREATE = "CREATE TABLE "
            + UserDataContractClass.Operation.TABLE_OPERATION + " ("
            + UserDataContractClass.Operation._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserDataContractClass.Operation.CURRENCY_CODE + " TEXT, "
            + UserDataContractClass.Operation.ACCOUNT_ID + " INTEGER, "
            + UserDataContractClass.Operation.AMMOUNT + " REAL, "
            + UserDataContractClass.Operation.TYPE + " TEXT, "
            + UserDataContractClass.Operation.CREATED + " NUMERIC NOT NULL DEFAULT CURRENT_TIMESTAMP, "
            + UserDataContractClass.Operation.LOCATION_ID + " INTEGER, "
            + UserDataContractClass.Operation.CATEGORY_ID + " INTEGER, "
            + UserDataContractClass.Operation.COMMENT + " TEXT"
            + ")";

    public LocalDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER_CREATE);
        db.execSQL(TABLE_ACCOUNT_HAS_USER_CREATE);
        db.execSQL(TABLE_ACCOUNT_CREATE);
        db.execSQL(TABLE_CATEGORY_CREATE);
        db.execSQL(TABLE_LOCATION_CREATE);
        db.execSQL(TABLE_CURRENCY_CREATE);
        db.execSQL(TABLE_OPERATION_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + UserDataContractClass.User.TABLE_USER);
        db.execSQL("DROP TABLE IF EXIST " + UserDataContractClass.AccountHasUser.TABLE_ACCOUNT_HAS_USER);
        db.execSQL("DROP TABLE IF EXIST " + UserDataContractClass.Account.TABLE_ACCOUNT);
        db.execSQL("DROP TABLE IF EXIST " + UserDataContractClass.Category.TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXIST " + UserDataContractClass.Location.TABLE_LOCATION);
        db.execSQL("DROP TABLE IF EXIST " + UserDataContractClass.Currency.TABLE_CURRENCY);
        db.execSQL("DROP TABLE IF EXIST " + UserDataContractClass.Operation.TABLE_OPERATION);
        onCreate(db);
    }
}
