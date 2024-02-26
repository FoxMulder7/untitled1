import java.util.Scanner;

public class StrokCalculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        System.out.println(parse(scan));
    }

    public static String parse(String scan) throws Exception {
        String operation;
        String[] words;

        if (scan.contains(" + ")) {
            words = scan.split(" \\+ ");
            operation = "+";
        } else if (scan.contains(" * ")) {
            words = scan.split(" \\* ");
            operation = "*";
        } else if (scan.contains(" - ")) {
            words = scan.split(" - ");
            operation = "-";
        } else if (scan.contains(" / ")) {
            words = scan.split(" / ");
            operation = "/";
        } else {
            throw new Exception("Ошибка! Неизвестный математический знак");
        }


        int x1 = words[0].length();
        char simvol1 = scan.charAt(0);
        char simvol2 = scan.charAt(x1 - 1);
        if (simvol1 != '"' || simvol2 != '"') {
            throw new Exception("первое  слово должно быть в кавычках");
        }


        if (operation.equals("*") || operation.equals("/")) {
            if (words[1].contains("\"")) throw new Exception("строчку можно делить и умножать только на число без кавычек");
        }


        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replace("\"", "");
        }


        if (words[0].length() > 10 || words[1].length() > 10) {
            throw new Exception("Слова должны содержать не больше 10 символов");
        }

        String text = calcultorStrok(words[0], words[1], operation);

        return printFinalText(text);
    }


    static String calcultorStrok(String word1, String word2, String simvol) throws Exception {
        if (simvol.equals("+")) {
            return word1 + word2;
        } else if (simvol.equals("*")) {
            int num1 = Integer.parseInt(word2);
            if (num1 > 10) {
                throw new Exception ("Число не должно быть больше 10");
            }
            String result = "";
            for (int i = 0; i < num1; i++) {
                result += word1;
            }
            return result;
        } else if (simvol.equals("-")) {
            int index = word1.indexOf(word2);
            if (index == -1) {
                return word1;
            } else {
                String result = word1.substring(0, index);
                result += word1.substring(index + word2.length());
                return result;
            }

        } else {
            int line1 = Integer.parseInt(word2);
            if (line1 > 10) {
                throw new Exception("Число не должно быть больше 10");
            }
            else if (line1 != 0) {
                int line2 = word1.length() / Integer.parseInt(word2);
                return word1.substring(0, line2);
            } else {
                throw new Exception("Ошибка");
            }
        }

    }

    static String printFinalText(String textfinal) {
        if (textfinal.length() > 40) {
            String over = textfinal.substring(0, 40);
            return "\"" + over + "...";
        } else return "\"" + textfinal + "\"";
    }

}