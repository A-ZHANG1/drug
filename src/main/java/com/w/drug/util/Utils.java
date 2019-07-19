package edu.sjtu.intelliband.sass.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by zhouxiaofan on 2019/1/9.
 */
public class Utils {

    public static String invokePython(String[] args, Logger logger) {
        String line;
        String result = "\n";
        String error = "\n";

        try {
            logger.log(Level.INFO, "--------start------");
            logger.log(Level.INFO, String.join(",", args));
            Process pr = Runtime.getRuntime().exec(args);
            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(pr.getErrorStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            logger.log(Level.ALL, "-----error------");
            while ((line = stdError.readLine()) != null) {
                error += line + "\n";
            }
            logger.log(Level.WARNING, error);
            in.close();
            pr.waitFor();
            logger.log(Level.INFO, "--------end------");
            logger.log(Level.INFO, result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}


