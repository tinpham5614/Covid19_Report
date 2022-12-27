import java.util.ArrayList;

public interface RegionManagerInterface {
    /**
     * @return number of region in the file
     */
    int getRegionCount();

    /**
     * @return region array list contains data
     */
    ArrayList<Region> getRegionArrayList();

    /**
     * @param index given index of region array list
     * @return specific region and its data
     */
    Region getRegionWithIndex(int index);

    /**
     * @param index given index of region array list
     * @return new array list without specific index region
     */
    ArrayList<Region> removeRegionWithIndex(int index);
}
