package messj.strengthenchemistry.listlessoncontent;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

import messj.strengthenchemistry.R;
import messj.strengthenchemistry.chooserlistitem.DataModel;

/**
 * Created by USER on 4/18/2017.
 */

public class ListLessonContentMaker {

    ArrayList<DataModel> dataModels;

    public ArrayList makeLessonDataModel(String itemKey, Context ctx) {
        String classKey = itemKey.substring(0, 3);
        String chapKey = itemKey.substring(3, itemKey.length());
        switch (classKey) {
            case "c10":
                makeClass10LessonDataModel(chapKey, ctx);
                break;
        }
        return dataModels;
    }

    public void makeClass10LessonDataModel(String chapterKey, Context ctx) {
        dataModels = new ArrayList<>();
        switch (chapterKey) {
            case "ch1":
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch1_lesson1_1), "September 23, 2008", "c10ch1.1"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch1_lesson1_2), "September 23, 2008", "c10ch1.2"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch1_lesson1_3), "September 23, 2008", "c10ch1.3"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch1_lesson1_4), "September 23, 2008", "c10ch1.4"));
                break;
            case "ch2":
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch2_lesson2_1), "September 23, 2008", "c10ch2.1"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch2_lesson2_2), "September 23, 2008", "c10ch2.2"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch2_lesson2_3), "September 23, 2008", "c10ch2.3"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch2_lesson2_4), "September 23, 2008", "c10ch2.4"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch2_lesson2_5), "September 23, 2008", "c10ch2.5"));
                break;
            case "ch3":
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch3_lesson3_1), "September 23, 2008", "c10ch3.1"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch3_lesson3_2), "September 23, 2008", "c10ch3.2"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch3_lesson3_3), "September 23, 2008", "c10ch3.3"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch3_lesson3_4), "September 23, 2008", "c10ch3.4"));
                break;
            case "ch4":
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch4_lesson4_1), "September 23, 2008", "c10ch4.1"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch4_lesson4_2), "September 23, 2008", "c10ch4.2"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch4_lesson4_3), "September 23, 2008", "c10ch4.3"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch4_lesson4_4), "September 23, 2008", "c10ch4.4"));
                dataModels.add(new DataModel(ctx.getApplicationContext().getString(R.string.class10_ch4_lesson4_5), "September 23, 2008", "c10ch4.5"));
                break;
        }
    }
}
