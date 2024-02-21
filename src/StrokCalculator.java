import java.util.Scanner;

public class StrokCalculator {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String perv = scanner.nextLine();
        String[] massznak;
        String newsimvol;
        String exp = exceptionTextPrint();


        if (perv.contains("\" + ")) {
            massznak = perv.split(" \\+ ");
            newsimvol = "+";
        } else if (perv.contains("\" - ")) {
            massznak = perv.split(" - ");
            newsimvol = "-";
        } else if (perv.contains("\" * ")) {
            massznak = perv.split(" \\* ");
            newsimvol = "*";
        } else if (perv.contains("\" / ")) {
            massznak = perv.split(" / ");
            newsimvol = "/";
        } else {
            throw new Exception("Ошибка! Математический знак можно использовать только после строчки с кавычками, например \"hello\" + \n Допустимые знаки: *, /, +, -");
        }


        char[] chars = massznak[0].toCharArray();
        if (chars[0] == '\"') {
            massznak[0] = String.copyValueOf(chars);
        } else {
            throw new Exception("Ошибка! Первое выражение должно быть в кавычках, например \"hello\" ");
        }
        if (newsimvol.equals("*") || newsimvol.equals("/")) {
            if (massznak[1].contains("\"")) throw new Exception("строчку можно делить и умножать только на число");
        }
        for (int i = 0; i < massznak.length; i++) {
            massznak[i] = massznak[i].replace("\"", "");
        }
        if (massznak[0].length() > 10 || massznak[1].length() > 10) {
            throw new Exception(exp);
        }


        if (newsimvol.equals("+")) {
            String result = massznak[0] + massznak[1];
            printStrok(result);

        } else if (newsimvol.equals("*")) {
            int superData2 = Integer.parseInt(massznak[1]);
            if (superData2 > 10) {
                throw new Exception("число должно быть не больше 10");
            }
            String result = "";
            for (int i = 0; i < superData2; i++) {
                result += massznak[0];
            }
            printStrok(result);

        } else if (newsimvol.equals("-")) {
            int index = massznak[0].indexOf(massznak[1]);
            if (index == -1) {
                System.out.println("\"" + massznak[0] + "\"");
            } else {
                String result = massznak[0].substring(0, index);
                result += massznak[0].substring(index + massznak[1].length());
                printStrok(result);
            }
        } else {
            int line1 = Integer.parseInt(massznak[1]);
            if (line1 > 10) {
                throw new Exception("число должно быть не больше 10");
            } else if (line1 > 0) {
                int line2 = massznak[0].length() / Integer.parseInt(massznak[1]);
                String result = massznak[0].substring(0, line2);
                printStrok(result);

            } else if (line1 == 0) {
                throw new Exception("Нельзя делить на ноль");
            }
        }
    }

    static void printStrok(String text) {

        if (text.length() > 40) {
            String rez = text.substring(0, 40);
            System.out.println("\"" + rez + "...");
        } else {
            System.out.println("\"" + text + "\"");
        }
    }

    static String exceptionTextPrint() {
       String exp1 = "Между \" может быть максимум 10 символов, например \"hellohello\"";
       return exp1;
    }
}