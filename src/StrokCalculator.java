import java.util.Scanner;

public class StrokCalculator {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String perv = scanner.nextLine();
        String[] massznak;
        String newsimvol;


        if (perv.contains(" + ")) {
            massznak = perv.split(" \\+ ");
            newsimvol = "+";

        } else if (perv.contains(" - ")) {
            massznak = perv.split(" - ");
            newsimvol = "-";

        } else if (perv.contains(" * ")) {
            massznak = perv.split(" \\* ");
            newsimvol = "*";

        } else if (perv.contains(" / ")) {
            massznak = perv.split(" / ");
            newsimvol = "/";

        } else {
            throw new Exception("Ошибка! Не верный символ");
        }


        if (massznak[0].length() > 10)
            throw new Exception("Введено больше 10 символов");
        if (massznak[1].length() > 10)
            throw new Exception("Введено больше 10 символов");

        if (newsimvol.equals("*") || newsimvol.equals("/")) {
            if (massznak[1].contains("\"")) throw new Exception("строчку можно делить и умножать только на число");
        }


        for (int i = 0; i < massznak.length; i++) {
            massznak[i] = massznak[i].replace("\"", "");
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
            } else {
                int line2 = massznak[0].length() / Integer.parseInt(massznak[1]);
                String result = massznak[0].substring(0, line2);

                printStrok(result);
            }


        }


    }


    static void printStrok(String text) {

        if (text.length() > 40) {
            String rez = text.substring(0, 40);
            System.out.println("\""+ rez + "...");
        } else {
            System.out.println("\"" + text + "\"");
        }


    }
}
