import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegionManager implements RegionManagerInterface {
    protected final ArrayList<Region> regionArrayList = new ArrayList<>();
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
    @Override
    public int getRegionCount(){
        return regionArrayList.size();
    }
    @Override
    public ArrayList<Region> getRegionArrayList() {
        return regionArrayList;
    }
    @Override
    public ArrayList<Region> getRegionWithIndex(int index){
        ArrayList<Region> newRegionList = new ArrayList<>();
        for (int i = 0; i < regionArrayList.size(); i++) {
            if (i == index){
                newRegionList.add(regionArrayList.get(i));
            }
        }
        return newRegionList;
    }
    @Override
    public ArrayList<Region> removeRegionWithIndex(int index){
        ArrayList<Region> newRegionList = new ArrayList<>();
        for (int i = 0; i < regionArrayList.size(); i++) {
            if (i != index){
                newRegionList.add(regionArrayList.get(i));
            }
        }
        return newRegionList;
    }
}
