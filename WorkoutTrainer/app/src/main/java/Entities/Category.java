package Entities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 12/14/2016.
 */

public class Category {
    int idCategory;
    String name;

    public static List<Category> getList(Context context){
        ArrayList<Category> ls = new ArrayList<Category>();
        SQLiteDatabase database = new DBContext(context).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Category", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            //Lấy dữ liệu
            int id = cursor.getInt(cursor.getColumnIndex("ID_Category"));
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            Category category = new Category(id, name);
            ls.add(category);
            cursor.moveToNext();
        }
        return ls;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(int idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }
}
