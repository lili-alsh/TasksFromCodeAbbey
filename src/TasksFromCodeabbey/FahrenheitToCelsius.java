package TasksFromCodeabbey;

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        boolean flag = true;
        do {
            try {
                float[] mass = convertMass(getInput());
                while (!checkData(mass)) {
                    mass = convertMass(getInput());
                }
                convertFarToCel(mass);
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
    }
    /* Метод возвращает строку и считывает исходные данные: количество измерений, показатели измерений.
    Метод проверяет:
    1) разделены ли вводимые числа пробелами;
    2) нет ли лишних пробелов в начале и в конце строки.
    **/
    static String getInput() {
        Scanner scan = new Scanner(System.in);
        boolean err = true;
        String input = "";
        do {
            System.out.println("Введите вначале количество показателей температуры." +
                    "Затем сами значения");
            input = scan.nextLine();
            if (!input.contains(" ")) {
                System.out.println("Вы не ввели пробелы. Необходимо повторить ввод");
            } else if (input.charAt(0) == ' ' || input.endsWith(" ")) {
                System.out.println("Введены лишние пробелы. Повторите ввод");
            } else err = false;
        } while (input.isEmpty() || !input.contains(" ") || err);
        return input;
    }

    /* Метод преобразовывает введенную строку вначале в массив строк, затем в массив вещественных чисел.
    Если вместо чисел введены символы (за исключением минуса) или буквы,
     исключение пробрасывается в точку входа, где оно обрабатывается.
    **/
    static float[] convertMass(String input) {
        String[] massInput = input.split(" ");
        float[] massTemp = new float[massInput.length];
        for (int i = 0; i < massInput.length; i++) {
            for (int j = 0; j < massInput[i].length(); j++) {
                if (!Character.isDigit(massInput[i].charAt(j)) && massInput[i].charAt(j) != '-') {
                    throw new NumberFormatException("Значение " + massInput[i] + " не является цифрой." +
                            "Повторите ввод");
                }
            }
            massTemp[i] = Float.parseFloat(massInput[i]);
        }
        return massTemp;
    }

    /* Метод преобразовывает массив вещественных чисел - показателей температуры в Фаренгейтах в
    показатели температуры в Цельсиях и выводит на экран округленные соответствующие показатели в Цельсиях.
    **/
    static void convertFarToCel(float[] mass) {
        int[] massCel = new int[mass.length - 1];
        for (int i = 0; i < massCel.length; i++) {
            massCel[i] = Math.round((mass[i + 1] - 32) * 5 / 9);
            System.out.print(massCel[i] + " ");
        }
    }

    /* Метод проверяет, правильно ли введены данные с учетом того, что первое число - показатедь количества
    измерений, равное количеству всех остальных данных.
    **/
    static boolean checkData(float[] massTemp) {
        int countOfTemp = Math.round(massTemp[0]);
        if (countOfTemp == massTemp.length - 1) return true;
        else {
            System.out.println("Первое значение количества показателей " +
                    "не соответствует значениям показателей.");
            return false;
        }
    }
}
