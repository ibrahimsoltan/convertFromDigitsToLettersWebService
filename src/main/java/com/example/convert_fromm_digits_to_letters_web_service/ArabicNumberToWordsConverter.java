package com.example.convert_fromm_digits_to_letters_web_service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;

public class ArabicNumberToWordsConverter {

    private  final   HashMap<Integer, String> numberWordsMapUpToOne;
    private final HashMap<Long, String> numberWordsMapUpToTwenty;
    private final HashMap<Long, String> numberWordsMapUpToHundred;

    private final HashMap<Long, String> numberWordsMapUpToThousand;

    private final HashMap<Long, String> numberWordsMapUpToMillion;

    public ArabicNumberToWordsConverter() {
        numberWordsMapUpToTwenty = new HashMap<>();

        numberWordsMapUpToTwenty.put(1L, "واحد");
        numberWordsMapUpToTwenty.put(2L, "اثنان");
        numberWordsMapUpToTwenty.put(3L, "ثلاثة");
        numberWordsMapUpToTwenty.put(4L, "أربعة");
        numberWordsMapUpToTwenty.put(5L, "خمسة");
        numberWordsMapUpToTwenty.put(6L, "ستة");
        numberWordsMapUpToTwenty.put(7L, "سبعة");
        numberWordsMapUpToTwenty.put(8L, "ثمانية");
        numberWordsMapUpToTwenty.put(9L, "تسعة");
        numberWordsMapUpToTwenty.put(10L, "عشرة");
        numberWordsMapUpToTwenty.put(11L, "أحد عشر");
        numberWordsMapUpToTwenty.put(12L, "اثنا عشر");
        numberWordsMapUpToTwenty.put(13L, "ثلاثة عشر");
        numberWordsMapUpToTwenty.put(14L, "أربعة عشر");
        numberWordsMapUpToTwenty.put(15L, "خمسة عشر");
        numberWordsMapUpToTwenty.put(16L, "ستة عشر");
        numberWordsMapUpToTwenty.put(17L, "سبعة عشر");
        numberWordsMapUpToTwenty.put(18L, "ثمانية عشر");
        numberWordsMapUpToTwenty.put(19L, "تسعة عشر");
        numberWordsMapUpToTwenty.put(20L, "عشرون");

        numberWordsMapUpToHundred = new HashMap<>();

        numberWordsMapUpToHundred.put(30L, "ثلاثون");
        numberWordsMapUpToHundred.put(40L, "أربعون");
        numberWordsMapUpToHundred.put(50L, "خمسون");
        numberWordsMapUpToHundred.put(60L, "ستون");
        numberWordsMapUpToHundred.put(70L, "سبعون");
        numberWordsMapUpToHundred.put(80L, "ثمانون");
        numberWordsMapUpToHundred.put(90L, "تسعون");

        numberWordsMapUpToThousand = new HashMap<>();

        numberWordsMapUpToThousand.put(100L, "مائة");
        numberWordsMapUpToThousand.put(200L, "مائتان");
        numberWordsMapUpToThousand.put(300L, "ثلاثمائة");
        numberWordsMapUpToThousand.put(400L, "أربعمائة");
        numberWordsMapUpToThousand.put(500L, "خمسمائة");
        numberWordsMapUpToThousand.put(600L, "ستمائة");
        numberWordsMapUpToThousand.put(700L, "سبعمائة");
        numberWordsMapUpToThousand.put(800L, "ثمانمائة");
        numberWordsMapUpToThousand.put(900L, "تسعمائة");

        numberWordsMapUpToMillion = new HashMap<>();
        numberWordsMapUpToMillion.put(1000000L, "مليون");
        numberWordsMapUpToMillion.put(2000000L, "مليونان");
        numberWordsMapUpToMillion.put(3000000L, "ثلاثة ملايين");
        numberWordsMapUpToMillion.put(4000000L, "أربعة ملايين");
        numberWordsMapUpToMillion.put(5000000L, "خمسة ملايين");
        numberWordsMapUpToMillion.put(6000000L, "ستة ملايين");
        numberWordsMapUpToMillion.put(7000000L, "سبعة ملايين");
        numberWordsMapUpToMillion.put(8000000L, "ثمانية ملايين");
        numberWordsMapUpToMillion.put(9000000L, "تسعة ملايين");

        numberWordsMapUpToOne = new HashMap<>();
        numberWordsMapUpToOne.put(1, "قرشاً");
        numberWordsMapUpToOne.put(2, "قرشان");
        numberWordsMapUpToOne.put(3, "ثلاثة قروش");
        numberWordsMapUpToOne.put(4, "أربعة قروش");
        numberWordsMapUpToOne.put(5, "خمسة قروش");
        numberWordsMapUpToOne.put(6, "ستة قروش");
        numberWordsMapUpToOne.put(7, "سبعة قروش");
        numberWordsMapUpToOne.put(8, "ثمانية قروش");
        numberWordsMapUpToOne.put(9, "تسعة قروش");
        numberWordsMapUpToOne.put(10, "عشرة قروش");
        numberWordsMapUpToOne.put(11, "أحد عشر قرشاً");
        numberWordsMapUpToOne.put(12, "اثنا عشر قرشاً");
        numberWordsMapUpToOne.put(13, "ثلاثة عشر قرشاً");
        numberWordsMapUpToOne.put(14, "أربعة عشر قرشاً");
        numberWordsMapUpToOne.put(15, "خمسة عشر قرشاً");
        numberWordsMapUpToOne.put(16, "ستة عشر قرشاً");
        numberWordsMapUpToOne.put(17, "سبعة عشر قرشاً");
        numberWordsMapUpToOne.put(18, "ثمانية عشر قرشاً");
        numberWordsMapUpToOne.put(19, "تسعة عشر قرشاً");


    }

    public String convert(BigDecimal  number) {
        BigDecimal[] divideAndRemainder = number.divideAndRemainder(BigDecimal.ONE);
        BigDecimal integerPart = divideAndRemainder[0];
        BigDecimal decimalPart = divideAndRemainder[1].multiply(new BigDecimal("100")).setScale(0, RoundingMode.HALF_UP);
        long integerPartLong = integerPart.longValue();
        int decimalPartInt = decimalPart.intValue();

        String integerPartStr = "";

        if (integerPartLong >= 1 && integerPartLong <= 20) {
            integerPartStr = convertOneToTwenty(integerPartLong);

        } else if (integerPartLong > 20 && integerPartLong <= 99) {
            integerPartStr = convertTens(integerPartLong);
        } else if (integerPartLong >= 100 && integerPartLong <= 999) {
            integerPartStr = convertHundreds(integerPartLong);
        } else if (integerPartLong >= 1000 && integerPartLong <= 999999) {
            integerPartStr = convertThousandsAndAbove(integerPartLong);
        }
        else if (integerPartLong >= 1000000 && integerPartLong <= 999999999) {
            integerPartStr = convertMillionsAndAbove(integerPartLong);
        }
        else if (integerPartLong >= 1000000000 && integerPartLong <= 999999999999L) {
            integerPartStr = convertBillionsAndAbove(integerPartLong);
        }
        else if (integerPartLong >= 1000000000000L && integerPartLong <= 999999999999999L) {
            integerPartStr = convertTrillionsAndAbove(integerPartLong);
        }

        String decimalPartStr = "";
        if (decimalPartInt > 0) {
            decimalPartStr = convertDecimalToWords(decimalPartInt);
        }
        else {
            decimalPartStr = "جنيهاً";
        }


        return integerPartStr + (decimalPartInt > 0 ? " و " + decimalPartStr : "");

    }

    private String convertOneToTwenty(long number) {
        if (number == 2) {
            return "جنيهان ";
        }
        else if (number == 1) {
            return "جنيه ";
        }
        else if (number > 2 && number < 11) {
            return numberWordsMapUpToTwenty.get(number) + " جنيهات ";
        }
        else {
            return numberWordsMapUpToTwenty.get(number) + " جنيهاً ";
        }
    }

    private String convertTens(long number) {
        long tens = number / 10;
        long ones = number % 10;
        String result = tens == 2 ? "عشرون" : numberWordsMapUpToHundred.get(tens * 10);
        if (ones > 0) {
            result = numberWordsMapUpToTwenty.get(ones) + " و " + result + " جنيهاً";
        }

        return result;
    }

    private String convertTensForDecimal(long number) {
        long tens = number / 10;
        long ones = number % 10;
        String result = tens == 2 ? "عشرون" : numberWordsMapUpToHundred.get(tens * 10);

        if (ones > 0) {
            result = numberWordsMapUpToTwenty.get(ones) + " و " + result ;
        }

        return result;
    }

    private String convertDecimalToWords(int decimalPart) {
        String result = "";
        if (decimalPart >= 1 && decimalPart <= 19) {
            result = numberWordsMapUpToOne.get(decimalPart);
        } else if (decimalPart > 19 && decimalPart <= 99) {
            result = convertTensForDecimal(decimalPart) + " قرشاً لا غير";
        }
        return result;
    }

    private String convertHundreds(long number) {
        long hundreds = number / 100;
        long remainder = number % 100;
        String result = numberWordsMapUpToThousand.get(hundreds * 100);
        if (remainder > 0) {
            result = result + " و " + convert(BigDecimal.valueOf(remainder));
        }
        else {
            result += " جنيهاً";

        }
        return result;
    }

    private String convertThousandsAndAbove(long number) {
        long thousands = number / 1000;
        long remainder = number % 1000;
        String result = "";
        if(thousands == 2){
            return "ألفان";
        }
        if(thousands > 2 && thousands < 11){
            result = numberWordsMapUpToTwenty.get(thousands) + " آلاف";
        }
        if(thousands > 10 && thousands < 100){
            result = convertTens(thousands);
            if (result.contains("جنيهاً"))
            {
                result = result.replace("جنيهاً", "ألفاً");
            }
            else {
                result += " ألفاً";
            }
        }
        if(thousands > 100 && thousands < 1000){
            result = convertHundreds(thousands);
            if (result.contains("جنيهاً"))
            {
                result = result.replace("جنيهاً", "ألفاً");
            }
            else {
                result += " ألفاً";
            }
        }
        if(thousands == 1)
        {
            result = "ألف";
        }
        if (remainder > 0) {
            result = result + " و " + convert(BigDecimal.valueOf(remainder));
        }
        else {
            result += " جنيهاً";

        }

        return result;
    }
    private String convertMillionsAndAbove(long number) {
        long millions = number / 1000000;
        long remainder = number % 1000000;
        String result = "";
        if (millions == 1) {
            result = "مليون";
        } else if (millions == 2) {
            result = "مليونان";
        } else if (millions > 2 && millions < 11) {
            result = numberWordsMapUpToTwenty.get(millions) + " ملايين";
        } else if (millions >= 11 && millions < 100) {
            result = convertTens(millions) ;
            if (result.contains("جنيهاً"))
            {
                result = result.replace("جنيهاً", "مليوناً");
            }
            else {
                result += " مليوناً";
            }
        } else if (millions >= 100 && millions < 1000) {
            result = convertHundreds(millions) ;
            if (result.contains("جنيهاً"))
            {
                result = result.replace("جنيهاً", "مليوناً");
            }
            else {
                result += " مليوناً";
            }
        } else {
            result = convert(BigDecimal.valueOf(millions)) + " مليوناً"; // For millions >= 1000
        }

        if (remainder > 0) {
            result = result + " و " + convert(BigDecimal.valueOf(remainder));
        }
        else {
            result += " جنيهاً";

        }
        return result;
    }
    private String convertBillionsAndAbove(long number) {
        long billions = number / 1000000000;
        long remainder = number % 1000000000;
        String result = "";
        if (billions == 1) {
            result = "مليار";
        } else if (billions == 2) {
            result = "ملياران";
        } else if (billions > 2 && billions < 11) {
            result = numberWordsMapUpToTwenty.get(billions) + " مليارات";
        } else if (billions >= 11 && billions < 100) {
            result = convertTens(billions);
            if (result.contains("جنيهاً"))
            {
                result = result.replace("جنيهاً", "ملياراً");
            }
            else {
                result += " ملياراً";
            }

        } else if (billions >= 100 && billions < 1000) {
            result = convertHundreds(billions);
            if (result.contains("جنيهاً"))
            {
                result = result.replace("جنيهاً", "ملياراً");
            }
            else {
                result += " ملياراً";
            }
        } else {
            result = convert(BigDecimal.valueOf(billions)) + " ملياراً"; // For billions >= 1000
        }

        if (remainder > 0) {
            result = result + " و " + convert(BigDecimal.valueOf(remainder));
        }
        else {
            result += " جنيهاً";

        }
        return result;
    }

    private String convertTrillionsAndAbove(long number) {
        long trillions = number / 1000000000000L;
        long remainder = number % 1000000000000L;
        String result = "";

        if (trillions == 1) {
            result = "تريليون";
        } else if (trillions == 2) {
            result = "تريليونان";
        } else if (trillions > 2 && trillions < 11) {
            result = numberWordsMapUpToTwenty.get(trillions) + " تريليونات";
        } else if (trillions >= 11 && trillions < 100) {
            result = convertTens(trillions);
            if (result.contains("جنيهاً")) {
                result = result.replace("جنيهاً", "تريليوناً");
            } else {
                result += " تريليوناً";
            }
        } else if (trillions >= 100 && trillions < 1000) {
            result = convertHundreds(trillions);
            if (result.contains("جنيهاً")) {
                result = result.replace("جنيهاً", "تريليوناً");
            } else {
                result += " تريليوناً";
            }
        } else {
            result = convert(BigDecimal.valueOf(trillions)) + " تريليوناً"; // For trillions >= 1000
        }

        if (remainder > 0) {
            result = result + " و " + convert(BigDecimal.valueOf(remainder));
        }
        else {
            result += " جنيهاً";
        }
        return result;
    }



    public static void main(String[] args) {
        ArabicNumberToWordsConverter converter = new ArabicNumberToWordsConverter();
        BigDecimal number = new BigDecimal("524567898765432.23");
        String result = converter.convert(number);
        System.out.println("Result: " + result);

    }


}
