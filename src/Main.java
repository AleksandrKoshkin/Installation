import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static StringBuilder create(File file, StringBuilder sb) {
        if (file.mkdir()) {
            sb.append("Директория " + file.getName() + " создана" + "\n");
        } else {
            sb.append("Директория " + file.getName() + " не создана" + "\n");
        }
        return sb;
    }

    public static StringBuilder createFile(File file, StringBuilder sb) {
        try {
            if (file.createNewFile())
                sb.append("Файл " + file.getName() + " создан" + "\n");
        } catch (IOException e) {
            sb.append("Файл " + file.getName() + " не создан" + "\n");
            throw new RuntimeException(e);
        }
        return sb;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        File newDir1 = new File("D:\\Java\\Games\\src");
        File newDir2 = new File("D:\\Java\\Games\\res");
        File newDir3 = new File("D:\\Java\\Games\\savegames");
        File newDir4 = new File("D:\\Java\\Games\\temp");
        sb = create(newDir1, sb);
        sb = create(newDir2, sb);
        sb = create(newDir3, sb);
        sb = create(newDir4, sb);
        File newDir5 = new File("D:\\Java\\Games\\src", "main");
        File newDir6 = new File("D:\\Java\\Games\\src", "test");
        sb = create(newDir5, sb);
        sb = create(newDir6, sb);
        File newFile1 = new File("D:\\Java\\Games\\src\\main", "Main.java");
        File newFile2 = new File("D:\\Java\\Games\\src\\main", "Utils.java");
        sb = createFile(newFile1, sb);
        sb = createFile(newFile2, sb);
        File newDir7 = new File("D:\\Java\\Games\\res", "drawables");
        File newDir8 = new File("D:\\Java\\Games\\res", "vectors");
        File newDir9 = new File("D:\\Java\\Games\\res", "icons");
        sb = create(newDir7, sb);
        sb = create(newDir8, sb);
        sb = create(newDir9, sb);
        File newFile3 = new File("D:\\Java\\Games\\temp", "temp.txt");
        sb = createFile(newFile3, sb);
        String text = sb.toString();
        try (FileOutputStream write = new FileOutputStream(newFile3)) {
            byte[] bytes = text.getBytes();
            write.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}