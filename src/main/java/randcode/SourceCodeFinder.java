package randcode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 */
public class SourceCodeFinder {
    public static void main(String[] args) {
        System.out.println("本软件读取某文件夹下所有以java结尾的文件");
        System.out.println("使用方式 java SourceCodeFinder [dir] [out_file]");
        System.out.println("去掉注释和空行后");
        System.out.println("生成一个单一的文件");
        System.out.println("排序方法是文件和文件夹的字典序");

        System.out.println("行尾注释和段落注释的处理比较麻烦");


////
        ////
        System.out.println("\n以下是文件列表");
        String dir = "E:\\work\\南京所课题2项目\\policytool\\src\\main\\java";
        String ext = ".java";
        String outFile = "E:\\work\\软著申请\\code_text_policytool.txt";
        if (args.length > 1) {
            dir = args[0];
            outFile = args[1];
        }
        System.out.println("dir = " + dir);
        System.out.println("outFile = " + outFile);


        File file = new File(dir);
        File out = new File(outFile);
        try (FileWriter fileWriter = new FileWriter(out)) {
            Stream<Path> walk = Files.walk(file.toPath());
            walk.forEach(path -> {
                if (path.getFileName().toString().endsWith(ext)) {
                    System.out.println(path.toString());
                    List<String> lines = clean(path.toFile());
                    for (String line : lines) {
                        try {
                            fileWriter.write(line);
                            fileWriter.write('\n');
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String> clean(File javaFile) {
        try {
            List<String> strings = Files.readAllLines(javaFile.toPath());
            List<String> ans = new ArrayList<>();
            for (String line : strings) {
                if (!line.trim().startsWith("//")
                        && !line.trim().startsWith("import")
                        && line.trim().length() > 0) {
                    ans.add(line);
                }
            }
            return ans;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
