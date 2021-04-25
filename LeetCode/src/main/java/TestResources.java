import java.io.File;

import java.io.FileReader;
import java.io.IOException;

public class TestResources {
    public static void main(String[] args) throws IOException {
//        File file1 = new File("testPath");
//        file1.mkdir();
        String filePath = "/Users/rainjaneJerry/Documents/Code/LeetCode/LeetCode_Java/IdealLeetCode/LeetCode/src/main/resources/textForTrie.txt";
        File file = new File(filePath);
        FileReader reader = new FileReader(file);
        char[] buffer = new char[1024];
        reader.read(buffer);
        String s = null;
        if (buffer!=null){
             s = buffer.toString();
        }
        System.out.println(s);
        reader.close();
    }
}
