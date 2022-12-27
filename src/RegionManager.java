import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Region Manager Class implements from Region Manager Interface
 */
public class RegionManager implements RegionManagerInterface {
    /**
     * Region Array List contains data of all regions
     */
    protected final ArrayList<Region> regionArrayList = new ArrayList<>();

    /**
     * Region Manager Constructor
     * @throws FileNotFoundException if the file is not found
     */
    public RegionManager() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("COVID19_10-Region.csv"));
        //scan header
        scanner.nextLine();
        while (scanner.hasNext()) {
            String[] regionData = scanner.nextLine().split("~");
            Region region = new Region(
                    regionData[0],
                    Double.parseDouble(regionData[1]),
                    Integer.parseInt(regionData[2]),
                    Integer.parseInt(regionData[3]),
                    Integer.parseInt(regionData[4]),
                    Integer.parseInt(regionData[5]),
                    Integer.parseInt(regionData[6]),
                    Integer.parseInt(regionData[7]),
                    Double.parseDouble(regionData[8])
            );
            regionArrayList.add(region);
        }
        scanner.close();
    }

    /**
     * @return number of region in the file
     */
    @Override
    public int getRegionCount(){
        return regionArrayList.size();
    }

    /**
     * @return region array list contains data
     */
    @Override
    public ArrayList<Region> getRegionArrayList() {
        return regionArrayList;
    }

    /**
     * @param index given index of region array list
     * @return specific region and its data
     */
    @Override
    public Region getRegionWithIndex(int index){
        return regionArrayList.get(index);
    }

    /**
     * @param index given index of region array list
     * @return an array list without specific index region
     */
    @Override
    public ArrayList<Region> removeRegionWithIndex(int index){
        regionArrayList.remove(regionArrayList.get(index));
        return regionArrayList;
    }
}
