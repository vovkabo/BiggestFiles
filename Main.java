import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class Main {

//    public static long folderSize = 0;

    public static void main(String[] args){


        String folderPath = "C:\\Users\\v79bo\\Documents\\Новая папка\\Sundisk";
        File file = new File(folderPath);
        Node root = new Node(file);

        long start = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(root.toString());


//        System.out.println("folder size "+ root.getHumanReadableSize(root.getSize()));
//        System.out.println("folder size "+ root.getMachineReadableSize(root.getHumanReadableSize(root.getSize())));

        long duration = (System.currentTimeMillis() - start);
        System.out.println("task done for " + duration + " ms");

    }

//    public static long getFolderSizes(File folder){
//        if(folder.isFile()){
//            return folder.length();
//        }
//
//        File[] files = folder.listFiles();
//        for (File file : files){
//            folderSize += getFolderSizes(file);
//        }
//        return folderSize;
//
//    }


}
