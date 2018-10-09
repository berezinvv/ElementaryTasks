package numberToWords;

import java.math.BigDecimal;
import java.util.*;

public class NumberToWords {

    public static final Map<String, String> textDigital;
    public static final Map<String, String> textLevel;

    static {
        Map<String, String> tmpDigital =
                new HashMap<String, String>();
        tmpDigital.put("1", "один");
        tmpDigital.put("-1", "одна");
        tmpDigital.put("2", "два");
        tmpDigital.put("-2", "две");
        tmpDigital.put("3", "три");
        tmpDigital.put("4", "четыре");
        tmpDigital.put("5", "пять");
        tmpDigital.put("6", "шесть");
        tmpDigital.put("7", "семь");
        tmpDigital.put("8", "восемь");
        tmpDigital.put("9", "девять");
        tmpDigital.put("10", "десять");
        tmpDigital.put("11", "одиннадцать");
        tmpDigital.put("12", "двенадцать");
        tmpDigital.put("13", "тринадцать");
        tmpDigital.put("14", "четырнадцать");
        tmpDigital.put("15", "пятнадцать");
        tmpDigital.put("16", "шестнадцать");
        tmpDigital.put("17", "семнадцать");
        tmpDigital.put("18", "восемнадцать");
        tmpDigital.put("19", "девятнадцать");
        tmpDigital.put("20", "двадцать");
        tmpDigital.put("30", "тридцать");
        tmpDigital.put("40", "сорок");
        tmpDigital.put("50", "пятьдесят");
        tmpDigital.put("60", "шестьдесят");
        tmpDigital.put("70", "семьдесят");
        tmpDigital.put("80", "восемьдесят");
        tmpDigital.put("90", "девяносто");
        tmpDigital.put("100", "сто");
        tmpDigital.put("200", "двести");
        tmpDigital.put("300", "триста");
        tmpDigital.put("400", "четыреста");
        tmpDigital.put("500", "пятьсот");
        tmpDigital.put("600", "шестьсот");
        tmpDigital.put("700", "семьсот");
        tmpDigital.put("800", "восемьсот");
        tmpDigital.put("900", "девятьсот");

        Map<String, String> tmpLevel =
                new HashMap<String, String>();
        tmpLevel.put("11", "тысяча");
        tmpLevel.put("12", "тысячи");
        tmpLevel.put("15", "тысяч");
        tmpLevel.put("21", "миллион");
        tmpLevel.put("22", "миллиона");
        tmpLevel.put("25", "миллионов");
        tmpLevel.put("31", "миллиард");
        tmpLevel.put("32", "миллиарда");
        tmpLevel.put("35", "миллиардов");
        tmpLevel.put("41", "триллион");
        tmpLevel.put("42", "триллиона");
        tmpLevel.put("45", "триллионов");
        tmpLevel.put("51", "квадриллион");
        tmpLevel.put("52", "квадриллиона");
        tmpLevel.put("55", "квадриллионов");
        tmpLevel.put("61", "квинтиллион");
        tmpLevel.put("62", "квинтиллиона");
        tmpLevel.put("65", "квинтиллионов");
        tmpLevel.put("71", "секстиллион");
        tmpLevel.put("72", "секстиллиона");
        tmpLevel.put("75", "секстиллионов");
        tmpLevel.put("81", "септиллион");
        tmpLevel.put("82", "септиллиона");
        tmpLevel.put("85", "септиллионов");
        tmpLevel.put("91", "октиллион");
        tmpLevel.put("92", "октиллиона");
        tmpLevel.put("105", "октиллионов");
        tmpLevel.put("101", "нониллион");
        tmpLevel.put("102", "нониллиона");
        tmpLevel.put("105", "нониллионов");//I think enough

        textDigital = Collections.unmodifiableMap(tmpDigital);
        textLevel = Collections.unmodifiableMap(tmpLevel);
    }


    private static String converNumberToWords(BigDecimal number) {
        String res = "";

        List<String> list = new ArrayList();
        BigDecimal number999 = new BigDecimal("999");
        BigDecimal number1000 = new BigDecimal("1000");
        while (number.compareTo(number999) > 0) {
            BigDecimal temp = number.divide(number1000, BigDecimal.ROUND_DOWN);
            list.add(String.valueOf(number.subtract(temp.multiply(number1000))));
            number = temp;
        }
        list.add(String.valueOf(number));
        Collections.reverse(list);

        int level = list.size() - 1;
        for (String str : list) {

            if (str.length() == 1) str = "00" + str;
            if (str.length() == 2) str = "0" + str;
            int num100 = Integer.parseInt(str.substring(0, 1));
            int num10 = Integer.parseInt(str.substring(1, 2));
            int num10_19 = Integer.parseInt(str.substring(1, 3));
            int num1 = Integer.parseInt(str.substring(2, 3));

            if (num100 != 0) {
                res += textDigital.get(String.valueOf(num100) + "00") + " ";
            }

            if (num10_19 >= 10 && num10_19 <= 19) {
                res += textDigital.get(String.valueOf(num10_19)) + " ";
            } else {
                if (num10 != 0) {
                    res += textDigital.get(String.valueOf(num10) + "0") + " ";
                }
                if (num1 != 0) {
                    res += textDigital.get(String.valueOf(((num1 == 1 || num1 == 2) && level % 2 != 0) ? -num1 : num1)) + " ";
                }
            }


            if (level >= 1) {
                if (num1 == 0 || num1 >= 5) {
                    res += textLevel.get(String.valueOf(level) + "5") + " ";
                } else if (num1 >= 2 || num1 <= 4) {
                    res += textLevel.get(String.valueOf(level) + "2") + " ";
                } else {
                    res += textLevel.get(String.valueOf(level) + num1) + " ";
                }
            }

            level--;
        }

        return res;
    }

    public static String getNumberToWords(BigDecimal number) {
        String res = "";
        BigDecimal number0 = new BigDecimal("0");
        if (number.compareTo(number0) == 0) {
            res = "ноль ";
        }
        if (number.compareTo(number0) < 0) {
            res = "минус " + converNumberToWords(number.negate());
        } else  if (number.compareTo(number0) > 0){
            res = converNumberToWords(number);
        }
        return res;
    }
}
