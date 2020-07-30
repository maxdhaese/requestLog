package be.maxdhaese;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static be.maxdhaese.RequestLog.getLog;

public class LogService {
    private Map<String, Long> logMap = new HashMap<String, Long>();


    public LogService() throws FileNotFoundException {
    }

    //read the file once and save all the logs with index(byte) in a Map
    public void mappingLogs(String filenPath) throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:\\weblog.txt", "r");

        String s;

        do {
            long startByte = file.getFilePointer();
            s = file.readLine();
            if (s != null) {
                String log = getLog(s);
                logMap.put(log, startByte);
            }

        } while (s != null);
        System.out.println("Logs have been mapped");
    }

    //print a list of all the bytes found per log
    public List<Long> getBytesPerLog(String qry) {
        List<Long> bytesPerLog = new ArrayList<Long>();
        for (String log : logMap.keySet()) {
            if (log.contains(qry)) {
                bytesPerLog.add(logMap.get(log));
            }
        }
        return bytesPerLog;
    }

    public void searchLogbyPath(String qry) throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:\\weblog.txt", "r");

        for (String log:logMap.keySet()) {
            if (log.contains(qry)){
                file.seek(logMap.get(log));
                System.out.println(file.readLine());
            }

        }
    }
}
