package com.testbatch3.appxone.tadawulproject;

public class AppSettings {

	public static int SPLASH_DELAY_TIME = 3500;

	// public static final String DB_Path = Environment
	// .getExternalStorageDirectory().getPath() + "/databases/";
   // public static  final Context context1= this;
    public static final String DATABASE_NAME = "stocks";
//	public static final String DB_Path = Environment.getDataDirectory()
  //          .getAbsolutePath() + "/databases/";
    public static final String DB_Path =  "/data/data/com.appinhand.tadawulstockexchange/databases/";
//    public static final String DATABASE_NAME = "test_db";
	public static final String DATABASE_TABLE = "stocks_kse";
	public static final int DATABASE_VERSION = 1;

	public static String KEY_ID = "id";
	public static String KEY_NAME = "symbol";
	public static String KEY_CHANGES = "changes";
	public static String KEY_RATIO = "ratio";

	public static String KEY_ICON = "icon";

	public static String KEY_PERCANTAGE = "percentage";

	public static String KEY_HIGH = "high";

	public static String KEY_LOW = "low";

	public static String KEY_VOLUME = "volume";

	public static String KEY_PREVIOUS = "previous";

	public static String KEY_bookmark = "bookmark";
	public static String KEY_POSITION = "position";
}