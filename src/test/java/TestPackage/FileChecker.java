package TestPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileChecker {


    public static void main(String[] args) throws IOException {
        String path = "src\\main\\resources\\File";
        boolean fileExist = doesFileExist(path);
        if(fileExist == true) {
            BufferedReader oBuffer = new BufferedReader(new FileReader(path));
                String szLine;
                int nCount = 0;
                while ((szLine = oBuffer.readLine()) != null) {
                    nCount++;
                    //System.out.println(szLine);
                    String[] arrayName = szLine.split("[-]");
                    System.out.println(arrayName[0]);
                    //System.out.println(arrayName[1]);
                    if(nCount > 3) break;
                }

        }//end of if statement

    }

    //reusable method to check if a file exist
    public static boolean doesFileExist(String path){
        File temp;
        boolean exists = false;
        try
        {
            temp = new File(path);
            exists = temp.exists();
            System.out.println("Temp file exists : " + exists);
        } catch (Exception e)
        {
            System.out.println(e);
        }

        return exists;

    }





}
