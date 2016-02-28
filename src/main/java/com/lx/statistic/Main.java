package com.lx.statistic;

import com.lx.statistic.dao.DBHelper;
import com.lx.statistic.dao.FileStatisticDao;
import com.lx.statistic.dao.RowStatisticDao;
import com.lx.statistic.data.FileStatistic;
import com.lx.statistic.data.RowStatistic;
import com.lx.statistic.logic.Agrigator;
import com.lx.statistic.logic.FileSystem;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Sergey_PC on 23.02.2016.
 */
public class Main {

    private Map<String, String> encodingMap;

    public Main() {
        encodingMap = new HashMap<>();
        encodingMap.put("1", "cp1251");
        encodingMap.put("2", "utf-8");
    }

    public void run(Scanner scanner) {
        String str = null;
        File file = null;
        String encoding = null;
        int menu = 1;
        boolean isRecursingScanDirectorys = false;
        while (menu >= 1 && menu <= 4) {
            if (scanner != null) {
                switch (menu) {
                    case 1:
                        System.out.print("Please input path to file or directory: ");
                        str = scanner.next();
                        if (isExitCommand(str)) {
                            menu = 0;
                            break;
                        }
                        file = new File(str);
                        if (file.exists()) menu++;
                        else System.out.println("Error. Not found file or directory!");
                        break;
                    case 2:
                        System.out.print("Please set encoding of file (1 - cp1251, 2 - utf-8): ");
                        str = scanner.next();
                        if (str == null || str.isEmpty()) break;
                        if (isExitCommand(str)) {
                            menu = 0;
                            break;
                        }
                        if (!encodingMap.containsKey(str.trim())) {
                            System.out.println("Error selected item!");
                            break;
                        }
                        encoding = encodingMap.get(str);
                        if (file.isDirectory()) menu++;
                        else menu += 2;
                        break;
                    case 3:
                        String s = "y";
                        System.out.print("Scanning input files and directories? (y/n): ");
                        str = scanner.next();
                        if (isExitCommand(str)) {
                            menu = 0;
                            break;
                        }
                        if (!"y".equalsIgnoreCase(str) && !"n".equalsIgnoreCase(str)) {
                            System.out.println("Error input letter!");
                            break;
                        } else {
                            isRecursingScanDirectorys = s.equalsIgnoreCase(str);
                        }
                        menu++;
                        break;
                    case 4:
                        startProcess(file, encoding, isRecursingScanDirectorys);
                        boolean isCorrectCommand = false;
                        System.out.print("Do you want continue? (y/n): ");
                        str = scanner.next();
                        while (!isCorrectCommand) {
                            if (!"y".equalsIgnoreCase(str) && !"n".equalsIgnoreCase(str)) {
                                System.out.println("Error input letter!");
                            } else isCorrectCommand = true;
                        }
                        if ("y".equalsIgnoreCase(str)) menu = 1;
                        else menu = 0;
                        break;
                }
            }
        }
    }

    public void saveStatistic(FileStatistic fileStatistic) {
        try {
            new FileStatisticDao().saveFileAndRowStatistics(fileStatistic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startProcess(File file, String encoding, boolean isRecursing) {
        System.out.println("Process started...");
        List<File> list = null;
        FileStatistic fileStatistic = null;
        List<RowStatistic> rowStatistics = null;
        Agrigator agrigator = null;
        FileSystem fileSystem = new FileSystem();
        try {
            if (file.isDirectory()) {
                list = isRecursing ? fileSystem.getFilesRecursing(file) : fileSystem.getFilesFirstDirectory(file);
            } else {
                list = new ArrayList<>();
                list.add(file);
            }
            if (list != null && list.size() > 0) {
                agrigator = new Agrigator();
                for (File fx : list) {
                    System.out.println("Calculate: " + fx);
                    rowStatistics = agrigator.getRowsStatisticsByFile(fx, encoding);
                    fileStatistic = agrigator.agregateFile(rowStatistics);
                    fileStatistic.setFileName(fx.getName());
                    saveStatistic(fileStatistic);
                }
            }
            System.out.println("Process finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isExitCommand(String str) {
        boolean isExit = false;
        if (str != null && !str.isEmpty()) {
            isExit = "exit".equalsIgnoreCase(str);
        }
        return isExit;
    }

    public static void main(String[] args) throws Exception {
        new DBHelper().initDataBase();
        Scanner scanner = new Scanner(System.in);
        new Main().run(scanner);
        System.out.println(new FileStatisticDao().getAllFileStatistic());
    }
}
