package data;

public class DataConf {
    // directory
    public static final String repConf = "conf";

    // windows file
    public static final String fichierConf = repConf
                    + System.getProperty("file.separator")
                    + "conf.properties";

    // parameters file
    public static final String fichierParam = repConf
                    + System.getProperty("file.separator")
                    + "param.properties";
}
