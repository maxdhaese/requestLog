package be.maxdhaese;


import java.io.IOException;

public class LogApp {
    public static void main(String[] args) throws IOException {

        LogService logService = new LogService();

        logService.mappingLogs("D:\\weblogs.txt");
        logService.searchLogbyPath("/test/");

    }
}
