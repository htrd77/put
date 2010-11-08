package com.PUMa;

import java.sql.SQLException;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class databaseControl {
	
	private Context context;
	private SQLiteDatabase db;

	public void initializeDatabase(Context context) throws SQLException {

		this.context = context;
		OpenHelper openHelper = new OpenHelper(this.context);
		this.db = openHelper.getWritableDatabase();
	}
	
	public boolean insertLog(String number, double longitude, double latitude, String name) throws SQLException {
		
		Cursor countInLog = this.db.rawQuery("SELECT count(*) FROM call_log",null);
		if(countInLog.getInt(1) == 20) {
			Cursor countSet = this.db.rawQuery("SELECT MIN(log_id) FROM call_log", null);
			String value[] = null;
			value[0] = countSet.getString(1);
			this.db.rawQuery("DELETE FROM call_log where log_id=?", value);
		}
		
		String[] insertString = null;
		insertString[0] = number;
		insertString[1] = name;
		insertString[2] = Double.toString(longitude);
		insertString[3] = Double.toString(latitude);
		
		Cursor insertQuery = this.db.rawQuery("INSERT INTO call_log (number, name, longitude, latitude) VALUES (?,?,?,?)",insertString);
		
 		if(insertQuery.getCount() > 0) return true;
		else return false;

	}
	
	public boolean insertBookmark(int toSave, int group) throws SQLException {
		
		String insertVars[] = null;
		insertVars[0] = Integer.toString(toSave);
		insertVars[1] = Integer.toString(group);

		Cursor queryLog = this.db.rawQuery("INSERT INTO bookmarks (number, name, longitude, latitude, group_id) SELECT number, name, longitude, latitude, ? FROM call_log WHERE log_id=?",insertVars);
		
		if(queryLog.getCount() > 0) return true;
		else return false;
	}
	
	public boolean deleteBookmark(int toDelete) throws SQLException {
		
		String deleteVar[] = null;
		deleteVar[0] = Integer.toString(toDelete);
		
		Cursor queryLog = this.db.rawQuery("DELETE FROM bookmarks WHERE bookmark_id = ?", deleteVar);
		
		if(queryLog.getCount() > 0)	return true;
		else return false;
	}
	
	public boolean changeGroup(int toChange, int newGroup) throws SQLException {
		
		String updateVar[] = null;
		updateVar[0] = Integer.toString(newGroup);
		updateVar[1] = Integer.toString(toChange);
		
		Cursor queryLog = this.db.rawQuery("UPDATE bookmarks SET group_id=? WHERE bookmark_id=?", updateVar);
		
		if(queryLog.getCount() > 0) return true;
		return false;
	}
	
	public Cursor getList(int table) throws SQLException {
		String table_name[] = null;
		
		if( table == 1) table_name[0] = "call_log";
		if( table == 2) table_name[0] = "bookmarks";
		
		Cursor getData = this.db.rawQuery("SELECT * FROM ?", table_name);

		return getData;
	}
	
  private static class OpenHelper extends SQLiteOpenHelper {

	  OpenHelper(Context context) {
		  super(context, "puma_db", null, 6);
	  }
	  
	  @Override
      public void onCreate(SQLiteDatabase db) {
		  db.execSQL("CREATE TABLE IF NOT EXISTS call_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT, number string NOT NULL, name string, longitude double NOT NULL, latitude double NOT NULL)");
		  db.execSQL("CREATE TABLE IF NOT EXISTS bookmarks (bookmark_id INTEGER PRIMARY KEY AUTOINCREMENT, number string NOT NULL, name string, longitude double NOT NULL, latitude double NOT NULL, group_id int NOT NULL)");
	  }

	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		  Log.w("Example", "Upgrading database, this will drop tables and recreate.");
		  db.execSQL("DROP TABLE IF EXISTS call_log, bookmarks");
		  onCreate(db);
	  }
  }
}