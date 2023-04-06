package Entities;

import java.util.ArrayList;
import java.util.List;

public class DeveloperObject {
    private static DeveloperObject instance = null;
    final private DeveloperFactory factory = new DeveloperFactory();
    private List<DeveloperData> developers = new ArrayList<DeveloperData>();

    public static DeveloperObject getInstance() {
        if (instance == null)
            instance = new DeveloperObject();
        return instance;
    }

    public List<DeveloperData> getDevelopers() {
        return developers;
    }
    public void setDevelopers(List<DeveloperData> customers) {
        this.developers = developers;
    }
}
