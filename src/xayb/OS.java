package xayb;

public class OS {

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static void optimize(){
        if (OS.contains("win")){
            System.setProperty("sun.java2d.transaccel", "True");
            System.setProperty("sun.java2d.d3d", "True");
            System.setProperty("sun.java2d.ddforcevram", "True");
        }else{
            System.setProperty("sun.java2d.opengl", "True");
        }
    }
}
