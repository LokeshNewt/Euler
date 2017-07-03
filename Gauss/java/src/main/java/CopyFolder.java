import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by neerbans on 11/7/2016.
 */
class Dog extends Anonymous{
    @Override
    public void show() {

    }

    @Override
    public void show2() {

    }
}

class Sub_class extends Super_Class {

    public Sub_class(int b) {
        System.out.println(" sub class constructor");
    }
    public void show_5() {
        System.out.println("sub_class" + a);
        super.show_5();
    }
}

class Super_Class {
    int a = 6;
    static int b = 5;

    public Super_Class(int a) {
        System.out.println("super class constructor");
    }

    Super_Class() {
        System.out.println("suepr class no arg construcotr");
    }

    public void show_5() {
//        show_6();
        System.out.println("super class " + b);
    }

    public static void show_6() {
        System.out.println("show_6" + b);
        new Super_Class().show_5();
    }
}

abstract class Anonymous {

    int a = 5;

    protected abstract void show();
    public abstract void show2();
}

interface inter_face {
    int a = 5;

    void show_interface();
}

class Animal {
    final private int a;

    Animal() {
        a = 100;
    }

    int show() {
        System.out.println("print this");
        return 0;
    }

}

public class CopyFolder {

    public static void main( String args[]) throws IOException {

        CopyFolder f = new CopyFolder();
        Sub_class sub_class = new Sub_class(5);
        if (sub_class instanceof Super_Class) {
            Super_Class s = sub_class;
            System.out.println(s.a);
        }
        f.copyFolder();
//        f.copyBuild("trunk_svn");
//        f.copyBuildDbApi();
//        f.copyBuildService();
//        f.copyBuildshared("trunk_svn");
//        f.copyBuildApi();
        //f.test();
        //f.testList();
        //f.copyTestData();
//        f.deleteFile();
//        f.copyWarFile();
//        System.out.println(null instanceof CopyFolder);
        //String s = "jdjdj";
//        s.index
//        return 0;
    }

    private void serialize() {

    }

    private void test() {

        Boolean b = null;
        boolean c = b;
        System.out.println(c);
        System.out.println(0/0);
        Map<String, String> set = new HashMap<>();
        set.put("65656", "jdjdjd");
        set.put("2dhdhdh", "jdjdjd");
        set.put("7d3hdh", "jdjdjd");
        set.put("3ww5wdh", "jdjdjd");
        set.put("4hdh6", "jdjdjd");
        for (String s : set.keySet()) {
            System.out.println(s);
        }
        //System.out.println("djdjdj" + "\' \'" + "djdjjd");
    }

    private void testList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.add(3);
        list.add(4);
        list2.add(5);
        list2.add(6);
        System.out.println(list);
        list.addAll(list2);
        System.out.println(list);
    }

    private void deleteFile() throws IOException {
        File srcData = new File("C:\\Neeraj\\PD\\eHIE\\ehie-portal\\trunk\\ehie-service\\target");
//        FileUtils.deleteDirectory(srcData);
        //srcData = new File("C:\\Neeraj\\PD\\eHIE\\ehie-portal\\trunk\\ehie-shared\\target\\ehie-shared-9.1.2-SNAPSHOT.jar");
        FileUtils.forceDelete(srcData);
    }

    private void copyTestData() throws IOException {
        File srcData = new File("C:\\Neeraj\\PD\\eHIE\\ehie-portal\\trunk\\ehie-service\\target\\xcdr\\sample");
        File destFile = new File("C:\\Neeraj");
        FileUtils.copyDirectory(srcData, destFile, true);
    }

    private void copyFolder() throws IOException {
        File srcFile = new File("C:\\Neeraj\\PD\\eHIE\\ehie-portal\\trunk_svn\\ehie-ui\\src\\main\\webapp\\app");
        File destFile = new File("C:\\Edifecs\\ServiceManager\\temp\\html\\pd\\app");
//        File destFile = new File("C:\\Neeraj\\PD\\build\\ServiceManager\\temp\\html\\pd\\app");
        FileUtils.copyDirectory(srcFile, destFile, true);
    }

    private void copyWarFile() throws IOException {
        File srcFile = new File("C:\\Neeraj\\Euler\\NB\\suduko\\target\\soduko.war");
        File destFile = new File("C:\\apache-tomcat-7.0.68\\webapps\\soduko.war");
        FileUtils.copyFile(srcFile, destFile, true);
    }

    private void copyBuild(String ws) throws IOException {
        File delFile = new File("C:\\Neeraj\\PD\\build\\ServiceManager\\apps\\pd-service-dist");
        FileUtils.deleteDirectory(delFile);
        File srcFile = new File("C:\\Neeraj\\PD\\eHIE\\ehie-portal\\"+ws+"\\ehie-sm-dist\\target\\pd-service-dist-9.1.3-SNAPSHOT\\ServiceManager\\apps");
        File destFile = new File("C:\\Neeraj\\PD\\build\\ServiceManager\\apps");
        FileUtils.copyDirectory(srcFile, destFile, true);
    }

    private void copyBuildService() throws IOException {
        File srcFile = new File("C:\\Neeraj\\PD\\eHIE\\ehie-portal\\trunk\\ehie-service\\target\\ehie-service-9.1.3-SNAPSHOT.jar");
        File destFile = new File("C:\\Neeraj\\PD\\build\\Edifecs\\ServiceManager\\apps\\pd-service-dist\\services\\pd-service\\lib\\ehie-service-9.1.3-SNAPSHOT.jar");
        FileUtils.copyFile(srcFile, destFile, true);
    }

    private void copyBuildshared(String name) throws IOException {
        File srcFile = new File("C:\\Neeraj\\PD\\eHIE\\ehie-portal\\" + name + "\\ehie-shared\\target\\ehie-shared-9.1.3-SNAPSHOT.jar");
        File destFile = new File("C:\\Neeraj\\PD\\build\\ServiceManager\\apps\\pd-service-dist\\services\\pd-service\\lib\\ehie-shared-9.1.3-SNAPSHOT.jar");
        FileUtils.copyFile(srcFile, destFile, true);
    }

    private void copyBuildApi() throws IOException {
        File srcFile = new File("C:\\Neeraj\\PD\\eHIE\\ehie-portal\\trunk\\ehie-api\\target\\ehie-api-9.1.2-SNAPSHOT.jar");
        File destFile = new File("C:\\Neeraj\\PD\\build\\Edifecs\\ServiceManager\\apps\\pd-service-dist\\services\\pd-service\\lib\\ehie-api-9.1.2-SNAPSHOT.jar");
        FileUtils.copyFile(srcFile, destFile, true);
    }

    private void copyBuildDbApi() throws IOException {
        File srcFile = new File("C:\\Neeraj\\PD\\eHIE\\ehie-portal\\trunk\\ehie-db-api\\target\\ehie-db-api-9.1.2-SNAPSHOT.jar");
        File destFile = new File("C:\\Neeraj\\PD\\build\\Edifecs\\ServiceManager\\apps\\pd-service-dist\\services\\pd-service\\lib\\ehie-db-api-9.1.2-SNAPSHOT.jar");
        FileUtils.copyFile(srcFile, destFile, true);
    }

    private void deleteFolder() throws IOException {
        File delFile = new File("C:\\Users\\neerbans\\Desktop\\delete");
        FileUtils.deleteDirectory(delFile);
    }
}
