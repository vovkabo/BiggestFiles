import java.util.HashMap;
import java.util.Map;

public class SizeCalculator {
    public static String getHumanReadableSize(long size){
        int x = 1024;
        if (size < x){
            return size + "byte";
        }
        else if(size < Math.pow(x, 2)){
            return Math.round(size / x) + "Kb";
        }
        else if(size < Math.pow(x, 3)){
            return Math.round(size / Math.pow(x, 2)) + "Mb";
        }
        else if(size < Math.pow(x, 4)){
            return Math.round(size / Math.pow(x, 3)) + "Gb";
        }
        else if(size < Math.pow(x, 5)){
            return Math.round(size / Math.pow(x, 4)) + "Tb";
        }
        return "unknown size";
    }

    public static long getMachineReadableSize(String size){
        Map<String, Long> map = new HashMap<>();
        map.put("byte", 1L);
        map.put("K", 1024L);
        map.put("Kb", 1024L);
        map.put("M", (long) (1024 * 1024));
        map.put("Mb", (long) (1024 * 1024));
        map.put("G", (long) (1024 * 1024 * 1024));
        map.put("Gb", (long) (1024 * 1024 * 1024));
        map.put("T", (long) (1024 * 1024 * 1024* 1024));
        map.put("Tb", (long) (1024 * 1024 * 1024* 1024));


        String stringVal = size.replaceAll("[0-9\\s+]+", "").trim();
        long digitalVal = Long.valueOf(size.replaceAll("[^0-9]", ""));

        Long calculatedVal = map.get(stringVal) * digitalVal;
        return calculatedVal;


    }
}
