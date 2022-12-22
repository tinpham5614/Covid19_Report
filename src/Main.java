import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        RegionManager regionManager = new RegionManager();
        System.out.println("regionManager.getRegionCount() = " + regionManager.getRegionCount());
        System.out.println("regionManager.getRegionArrayList() = " + regionManager.getRegionArrayList());
        System.out.println("regionManager.getRegionWithIndex(2) = " + regionManager.getRegionWithIndex(2));
        System.out.println("regionManager.removeRegionWithIndex(3) = " + regionManager.removeRegionWithIndex(3));
    }
}