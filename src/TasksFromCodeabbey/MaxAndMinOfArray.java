package TasksFromCodeabbey;

import java.util.Scanner;

public class MaxAndMinOfArray {
    public static void main(String[] args) {
        boolean flag = true;
        do {
            try {
                printMaxAndMin(getNumb(getStr()));
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
    }

    static String[] getStr() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите входные данные");
        String inputStr = scan.nextLine();
        if (!inputStr.contains(" ")) {
            System.out.println("Вы не разделили данные пробелом. Необходимо ввести данные через пробел.");
        }
        String[] massStr = inputStr.split(" ");
        return massStr;
    }

    static int[] getNumb(String [] massStr) throws NumberFormatException {
        int[] massNumb = new int[massStr.length];
        for (int i = 0; i < massStr.length; i++) {
            for (int j = 0; j <massStr[i].length() ; j++) {
                if(!Character.isDigit(massStr[i].charAt(j)) && massStr[i].charAt(j)!='-'){
                    throw new NumberFormatException("Значение "+massStr[i]+" не является цифрой. Повторите ввод.");
                }
            }
            massNumb[i] = Integer.parseInt(massStr[i]);
        }
        return massNumb;
    }
    static void printMaxAndMin(int[] mass) {
        int currNumb = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length - 1; j++) {
                if (mass[j] > mass[j + 1]) {
                    currNumb = mass[j + 1];
                    mass[j + 1] = mass[j];
                    mass[j] = currNumb;
                }
            }
        }
        System.out.printf("Максимум = %d, Минимум = %d", mass[mass.length - 1], mass[0]);
        System.out.println();
    }
}
