package com.lx.statistic.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey_PC on 23.02.2016.
 */
public class FileSystem {


    public List<File> getFilesRecursing(File directory) throws Exception {
        List<File> list = new ArrayList<>();
        FileSystem.getFiles(directory, list);
        return list;
    }

    public static void getFiles (File f, List<File> files) throws Exception {
        if (!f.isDirectory()) {
            files.add(f);
        }
        if (f.isDirectory()) {
            try {
                File[] child = f.listFiles();
                for (int i = 0; i < child.length; i++) {
                    getFiles(child[i], files);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<File> getFilesFirstDirectory (File f) throws Exception {
        List<File> files = new ArrayList<>();
        if (f.isDirectory()) {
            try {
                File[] child = f.listFiles();
                for (File ft : child) {
                    if(ft!= null && ft.isFile()){
                        files.add(ft);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return files;
    }
}
