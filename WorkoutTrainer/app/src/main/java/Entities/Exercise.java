package Entities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 12/8/2016.
 */

public class Exercise {
    private int idExercise;
    private String name;
    private String note;
    private int image;
    private int time;
    private int option;
    private int idCategory;

    public static Exercise getExercise(Context context, int idExercise){
        SQLiteDatabase database = new DBContext(context).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Exercise WHERE ID_Exercise="+idExercise+"", null);
        cursor.moveToFirst();
        Exercise exercise = null;
            //Lấy dữ liệu
            int id = cursor.getInt(cursor.getColumnIndex("ID_Exercise"));
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String note = cursor.getString(cursor.getColumnIndex("Note"));
            int image = cursor.getInt(cursor.getColumnIndex("Image"));
            int time = cursor.getInt(cursor.getColumnIndex("Time"));
            int option = cursor.getInt(cursor.getColumnIndex("Option"));
            int id_category = cursor.getInt(cursor.getColumnIndex("ID_Category"));
        exercise = new Exercise(id, name, note, image, time, option, id_category);
        return exercise;
    }

    public static List<Exercise> getList(Context context, int idCategory){
        ArrayList<Exercise> ls = new ArrayList<Exercise>();
        SQLiteDatabase database = new DBContext(context).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Exercise WHERE ID_Category="+idCategory+"", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            //Lấy dữ liệu
            int id = cursor.getInt(cursor.getColumnIndex("ID_Exercise"));
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String note = cursor.getString(cursor.getColumnIndex("Note"));
            int image = cursor.getInt(cursor.getColumnIndex("Image"));
            int time = cursor.getInt(cursor.getColumnIndex("Time"));
            int option = cursor.getInt(cursor.getColumnIndex("Option"));
            int id_category = cursor.getInt(cursor.getColumnIndex("ID_Category"));
            Exercise exercise = new Exercise(id, name, note, image, time, option, id_category);
            ls.add(exercise);
            cursor.moveToNext();
        }
        return ls;
    }

    public static List<Exercise> getListOfOption(Context context, int idOption){
        ArrayList<Exercise> ls = new ArrayList<Exercise>();
        SQLiteDatabase database = new DBContext(context).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Exercise WHERE Option="+idOption+"", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            //Lấy dữ liệu
            int id = cursor.getInt(cursor.getColumnIndex("ID_Exercise"));
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String note = cursor.getString(cursor.getColumnIndex("Note"));
            int image = cursor.getInt(cursor.getColumnIndex("Image"));
            int time = cursor.getInt(cursor.getColumnIndex("Time"));
            int option = cursor.getInt(cursor.getColumnIndex("Option"));
            int id_category = cursor.getInt(cursor.getColumnIndex("ID_Category"));
            Exercise exercise = new Exercise(id, name, note, image, time, option, id_category);
            ls.add(exercise);
            cursor.moveToNext();
        }
        return ls;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public Exercise(int idExercise, String name, String note, int image, int time, int option, int idCategory) {
        this.idExercise = idExercise;
        this.name = name;
        this.note = note;
        this.image = image;
        this.time = time;
        this.option = option;
        this.idCategory = idCategory;
    }
}
