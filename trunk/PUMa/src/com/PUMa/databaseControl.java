package com.PUMa;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class databaseControl {
	Context context;
	private static SQLiteDatabase pum;
	private final String DB_NAME = "pum";
	private final int DB_VERSION = 1;

	private final static String TABLE_NAME_1 = "callloglist";
	private final static String TABLE_ROW_ID_1 = "_id";
	private final static String TABLE_PHONE_NUMBER_1 = "phnumber";
	private final static String TABLE_USERNAME_1 = "name";
	private final static String TABLE_LATITUDE_1 = "latitude";
	private final static String TABLE_LONGITUDE_1 = "longitude";

	private final String TABLE_NAME_2 = "bookmarks";
	private final String TABLE_ROW_ID_2 = "_id";
	private final String TABLE_PHONE_NUMBER_2 = "phnumber";
	private final String TABLE_USERNAME_2 = "name";
	private final String TABLE_LATITUDE_2 = "latitude";
	private final String TABLE_LONGITUDE_2 = "longitude";
	private final String TABLE_GROUPID = "groupid";

	public databaseControl(Context context) {
		this.context = context;

		CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
		this.pum = helper.getWritableDatabase();
	}

	// Adding row to Call Log List
	public static void addRowCLL(String row0, String row1, String row2, double latitude2,
			double longitude2) {
		//SQLiteDatabase pum = getWritableDatabase(); 
		ContentValues values = new ContentValues();
		values.put(databaseControl.TABLE_ROW_ID_1, row0);
		values.put(databaseControl.TABLE_PHONE_NUMBER_1, row1);
		values.put(databaseControl.TABLE_USERNAME_1, row2);
		values.put(databaseControl.TABLE_LATITUDE_1, latitude2);
		values.put(databaseControl.TABLE_LONGITUDE_1, longitude2);

		try {
			pum.insert(databaseControl.TABLE_NAME_1, null, values);
		} catch (Exception e) {
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}

	// Adding row to Bookmarks List
	public void addRowBookmarks(String row0, String row1, String row2, String row3,
			String row4, String row5) {
		ContentValues values = new ContentValues();
		values.put(TABLE_ROW_ID_2, row0);
		values.put(TABLE_PHONE_NUMBER_2, row1);
		values.put(TABLE_USERNAME_2, row2);
		values.put(TABLE_LATITUDE_2, row3);
		values.put(TABLE_LONGITUDE_2, row4);
		values.put(TABLE_GROUPID, row5);

		try {
			pum.insert(TABLE_NAME_2, null, values);
		} catch (Exception e) {
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}

	// Deleting a row in CLL
	public void deleteRowCLL(long rowID) {
		try {
			pum.delete(TABLE_NAME_1, TABLE_ROW_ID_1 + "=" + rowID, null);
		} catch (Exception e) {
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}

	// Retrieving data from CLL
	public static ArrayList<Object> getRowCLL(long rowID) {
		ArrayList<Object> rowArray = new ArrayList<Object>();
		Cursor cursor;

		try {
			cursor = pum.query(TABLE_NAME_1, new String[] { TABLE_ROW_ID_1,
					TABLE_PHONE_NUMBER_1, TABLE_USERNAME_1, TABLE_LATITUDE_1,
					TABLE_LONGITUDE_1 }, TABLE_ROW_ID_1 + "=" + rowID, null,
					null, null, null, null);

			cursor.moveToFirst();

			if (!cursor.isAfterLast()) {
				 {
					rowArray.add(cursor.getLong(0));
					rowArray.add(cursor.getString(1));
					rowArray.add(cursor.getString(2));
					rowArray.add(cursor.getInt(3));
					rowArray.add(cursor.getInt(4));
				} //while (cursor.moveToNext());
			}
			cursor.close();
		}

		catch (SQLException e) {
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}

		return rowArray;
	}

	// Retrieving data from Bookmarks
	public ArrayList<Object> getRowBookmarks(long rowID) {
		ArrayList<Object> rowArray = new ArrayList<Object>();
		Cursor cursor;

		try {
			cursor = pum.query(TABLE_NAME_2, new String[] { TABLE_ROW_ID_2,
					TABLE_PHONE_NUMBER_2, TABLE_USERNAME_2, TABLE_LATITUDE_2,
					TABLE_LONGITUDE_2, TABLE_GROUPID }, TABLE_ROW_ID_1 + "="
					+ rowID, null, null, null, null, null);

			cursor.moveToFirst();

			if (!cursor.isAfterLast()) {
				do {
					rowArray.add(cursor.getLong(0));
					rowArray.add(cursor.getString(1));
					rowArray.add(cursor.getString(2));
					rowArray.add(cursor.getLong(3));
					rowArray.add(cursor.getLong(4));
					rowArray.add(cursor.getLong(5));
				} while (cursor.moveToNext());
			}
			cursor.close();
		}

		catch (SQLException e) {
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}

		return rowArray;
	}
	
	public  static String[] GetPhoneNumbers() 
	{
	int i=0;
	Log.d("testinglog", "Will this come up");
	int numrows3 = getNumberOfRows();
	
	Cursor cur = null;
	String [] phone_array = new String[numrows3];	
	String sql_query  = "select " + TABLE_PHONE_NUMBER_1 + " from " + TABLE_NAME_1;
	try
	{
	cur = pum.rawQuery(sql_query, null);
	    
    	cur.moveToFirst();
    
    	if(!cur.isAfterLast())
    	{
    		do {
    			phone_array[i]= cur.getString(0);
    			i++;
   		 		}while(cur.moveToNext());
    	}	
    	cur.close();
	}
	
	catch (SQLException e){
		Log.e("DB ERROR", e.toString());
		e.printStackTrace();
	}
	return phone_array;
	} 

	
	
	public  static String GetCLLphonenumber(long row_id) 
	{
	int i=0;
	String phonenumber0 = null;
	
	Cursor cur = null;
	
	//Get Phone Number
	
	String sql_query  = "select " + TABLE_PHONE_NUMBER_1 + " from " + TABLE_NAME_1 + " where " + TABLE_ROW_ID_1 + " = " + row_id;
	try
	{
	cur = pum.rawQuery(sql_query, null);
	    
    	cur.moveToFirst();
    
    	if(!cur.isAfterLast())
    	{
    		{
    			phonenumber0= cur.getString(0);
    			i++;
   		 		}
    	}	
    	cur.close();
	}
	
	catch (SQLException e){
		Log.e("DB ERROR", e.toString());
		e.printStackTrace();
	}
	
	
	
	//Get Longitude
	
	return phonenumber0;
	} 

	
	public static int GetCLLlong(long row_id)
	{
		int i=0;
		String longitude0;
		double longitudecll1 = 0;
		int longitudecll = 0;
		
		Cursor cur2 = null;
		String sql_query2 = "select " + TABLE_LONGITUDE_1 + " from " + TABLE_NAME_1 + " where " + TABLE_ROW_ID_1 + " = " + row_id;
		try
		{
		cur2 = pum.rawQuery(sql_query2, null);
		    
	    	cur2.moveToFirst();
	    
	    	if(!cur2.isAfterLast())
	    	{
	    		{
	    			longitude0= cur2.getString(0);
	    			longitudecll1 = Double.parseDouble(longitude0);
	    			longitudecll1 = longitudecll1*(Math.pow(10, 6));
	    			longitudecll = (int) longitudecll1;
	    			i++;
	   		 		}
	    	}	
	    	cur2.close();
		}
		
		catch (SQLException e){
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
		return longitudecll;
	}
	
	
	
	public static int GetCLLlat(long row_id)
	{
		int i=0;
		String latitude0;
		double latitudecll1 = 0;
		int latitudecll = 0;
			
		//Get Lat
		Cursor cur1 = null;
		String sql_query1 = "select " + TABLE_LATITUDE_1 + " from " + TABLE_NAME_1 + " where " + TABLE_ROW_ID_1 + " = " + row_id;
		try
		{
		cur1 = pum.rawQuery(sql_query1, null);
		    
	    	cur1.moveToFirst();
	    
	    	if(!cur1.isAfterLast())
	    	{
	    		{
	    			latitude0= cur1.getString(0);
	    			latitudecll1 = Double.parseDouble(latitude0);
	    			latitudecll1 = latitudecll1*(Math.pow(10, 6));
	    			latitudecll = (int) latitudecll1;
	    			i++;
	   		 		}
	    	}	
	    	cur1.close();
		}
		
		catch (SQLException e){
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
		return latitudecll;
	}
	
	
	static int getNumberOfRows() {
		// TODO Auto-generated method stub
		Cursor norows = null;
		String numrows = "select count(*) from " + TABLE_NAME_1;
		norows = pum.rawQuery(numrows, null);
		norows.moveToFirst();
		String numrows1 = norows.getString(0);
		int numrows2 = Integer.parseInt(numrows1);
		return numrows2;
	}

	// Opening SQL
	private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
		public CustomSQLiteOpenHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase pum) {
			Log.d("testinglog", "Will this come up");
			String newTableQueryString1 = "create table " + TABLE_NAME_1 + " ("
					+ TABLE_ROW_ID_1
					+ " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
					+ TABLE_PHONE_NUMBER_1 + " TEXT, " + TABLE_USERNAME_1
					+ " TEXT, " + TABLE_LATITUDE_1 + " TEXT, " + TABLE_LONGITUDE_1
					+ " TEXT" + ");";

			String newTableQueryString2 = "create table " + TABLE_NAME_2 + " ("
					+ TABLE_ROW_ID_2
					+ " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
					+ TABLE_PHONE_NUMBER_2 
					+ " TEXT, " 
					+ TABLE_USERNAME_2
					+ " TEXT, " 
					+ TABLE_LATITUDE_2 
					+ " TEXT, " 
					+ TABLE_LONGITUDE_2
					+ " TEXT, " 
					+ TABLE_GROUPID 
					+ " TEXT" 
					+ ");";
            pum.execSQL(newTableQueryString1);
			pum.execSQL(newTableQueryString2);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase pum, int oldVersion, int newVersion) {
			// NULL
		}

	}

}
