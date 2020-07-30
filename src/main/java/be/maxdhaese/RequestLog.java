package be.maxdhaese;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class RequestLog {

    static String getLog(String line) {
        return line.split("\n")[0];
    }



    public static void main(String[] args) throws IOException {
        //create file and logMap
        Map<String, Long> logMap = new HashMap<String, Long>();
        RandomAccessFile file = new RandomAccessFile("D:\\weblog.txt", "r");

        //read the file once and save in logMap
        String s;

        do {
            long startByte = file.getFilePointer();
            s = file.readLine();
            if (s != null) {
                String log = getLog(s);
                logMap.put(log, startByte);
            }

        }while (s!=null);

        for (String log: logMap.keySet()) {
            if (log.contains("/api/account")){
                System.out.println(logMap.get(log));




//                file.seek(logMap.get(log));
//                System.out.println(file.readLine());
            }

        }

    }

}
