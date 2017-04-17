package messj.strengthenchemistry.chooserlistitem;

/**
 * Created by anupamchugh on 09/02/16.
 */
public class DataModel {

    String name;
    String updateTime;
    String key;


    public DataModel(String name, String updateTime, String key) {
        this.name = name;
        this.updateTime = updateTime;
        this.key = key;

    }

    public String getName() {
        return name;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getKey() {
        return key;
    }

}
