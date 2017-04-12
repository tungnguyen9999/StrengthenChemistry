package messj.strengthenchemistry.chooserlistitem;

/**
 * Created by anupamchugh on 09/02/16.
 */
public class DataModel {

    String name;
    String updateTime;


    public DataModel(String name, String updateTime) {
        this.name = name;
        this.updateTime = updateTime;

    }

    public String getName() {
        return name;
    }

    public String getUpdateTime() {
        return updateTime;
    }

}
