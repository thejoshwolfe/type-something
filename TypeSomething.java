import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

public class TypeSomething {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            printUsageAndExit();
        Robot robot = new Robot();
        for (String name : args) {
            if (name.startsWith("-"))
                printUsageAndExit();
            Field field = KeyEvent.class.getField("VK_" + name);
            int key = (Integer)field.get(null);
            robot.keyPress(key);
            robot.keyRelease(key);
        }
    }
    private static void printUsageAndExit() {
        System.err.println("usage: KEY_CODE...");
        System.err.println("  where KEY_CODE can be found as a field java.awt.KeyEvent.VK_[KEY_EVENT] such as \"NUM_LOCK\"");
        System.exit(1);
    }
}
