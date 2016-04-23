package com.himanshu.java8.examples;

import java.io.File;
import java.io.FilenameFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileNameFilterUsingLambda {
  private static Logger logger = LoggerFactory.getLogger(FileNameFilterUsingLambda.class);
  private static String directory = "C:\\entertainment\\";
  
  public static void main(String[] args) {
    File dir = new File(directory);
    FilenameFilter filter = (File f, String filename) -> {
      logger.info("Checking file: "+filename);
      if (filename.contains(".avi")) {
        return true;
      }
      return false;
    };
    String[] filename = dir.list(filter);
    for (String s : filename) {
      logger.info(s);
    }
  }
  
}
