package TasksFromCodeabbey;

import java.util.Scanner;

public class Rounding {
    public static void main(String[] args) {
        boolean flag = true;
        do{
            try {
                rounding(strParsing(getInput()));
                flag=false;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
    }
/* Метод считывает количество пар чисел (выявляя не введен ли ноль или нечисловое значение),
записывает все числа в строку (проверяя разделены ли цифры пробелом и нет ли лишних пробелов).
**/
    static String getInput() {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        do {
            System.out.println("Введите количество пар сравниваемых чисел");
            String inputStr = scan.nextLine();
            if (inputStr.charAt(0) == ' ') {
                System.out.println("Вы ввели пустое значение. " +
                        "Необходимо ввести одно положительное число.");
            }
            try {
                count = Integer.parseInt(inputStr);
                if (count == 0) {
                    System.out.println("Вы ввели пустое значение. Необходимо ввести одно положительное число.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели недопустимые символы. Повторите ввод.");
            }
        } while (count <= 0);
        String numb = "";
        String inputStr = "";
        for (int i = 0; i < count; i++) {
            boolean err = true;
            do {
                System.out.printf("Введите пару чисел  №%d через пробел, " +
                        "каждая пара на новой строчке", i + 1);
                System.out.println();
                inputStr = scan.nextLine();
                if (inputStr.charAt(0) == ' ' || inputStr.endsWith(" ")) {
                    System.out.println("Введены лишние пробелы. Повторите ввод");
                } else if (!inputStr.contains(" ")) {
                    System.out.println("Необходимо числа разделить пробелом");
                } else {
                    err=false;
                    numb += inputStr + " ";
                }
            } while (inputStr.isEmpty() || !inputStr.contains(" ") || err);
        }
        return numb;
    }
    /* Метод преобразовывает строку в массив вещественных чисел.
    Если было введено нечисловое значение (за исключением '-') вместо числа пробрасывается в точку входа
    исключение.
    **/
    static float [] strParsing (String numb) {
        String[] strNumb = numb.split(" ");
        float[] massNumb = new float[strNumb.length];
        for (int i = 0; i <strNumb.length ; i++) {
            for (int j = 0; j <strNumb[i].length() ; j++) {
                if (!Character.isDigit(strNumb[i].charAt(j)) &&
                strNumb[i].charAt(j)!='-') {
                    throw new NumberFormatException("Значение "+strNumb[i]+" не является " +
                            "цифрой. Повторите ввод.");
                }
            }
            massNumb[i]=Float.parseFloat(strNumb[i]);
        }
        return massNumb;
    }

    /* Метод осуществляет округление, результат вносит в массив.
   **/
    static void rounding (float [] massNumb) {
        int [] roundOfDiv = new int[massNumb.length/2];
        for (int i = 0; i <roundOfDiv.length ; i++) {
            roundOfDiv[i]=Math.round(massNumb[i*2]/massNumb[i*2+1]);
            System.out.print(roundOfDiv[i]+ " ");
        }
    }
}
