import java.util.ArrayList;

public interface RegionManagerInterface {
    int getRegionCount();

    ArrayList<Region> getRegionArrayList();

    ArrayList<Region> getRegionWithIndex(int index);

    ArrayList<Region> removeRegionWithIndex(int index);
}
