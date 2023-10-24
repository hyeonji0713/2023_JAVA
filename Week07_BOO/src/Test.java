import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try (BufferedReader in = new BufferedReader(new FileReader(inputFile));
             BufferedWriter out = new BufferedWriter(new FileWriter(outputFile))) {

            int ch;
            while ((ch = in.read()) != -1) {
                if (Character.isLowerCase(ch)) {
                    ch = Character.toUpperCase(ch);
                }
                out.write(ch);
            }
            System.out.println("파일 변환이 완료되었습니다.");

        } catch (IOException e) {
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }
}
