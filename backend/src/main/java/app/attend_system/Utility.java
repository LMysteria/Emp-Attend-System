package app.attend_system;

public class Utility {
    public static String log(String Action, long timeElapse){
        String msg = "Action: " + Action + "\tTime Elapsed: " + timeElapse + "ms";
        return msg;
    }
}
