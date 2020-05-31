package TasksFromCodeabbey;

import java.util.Scanner;

public class VowelCount {
    public static void main(String[] args) {
        countOfVowel(getString(getQuantity()));
    }

    /* Метод возвращает и считывает количество вводимых строк (выявляя не введен ли ноль или нечисловое значение).
     **/
    static int getQuantity() {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        do {
            System.out.println("Введите количество строк");
            String input = scan.nextLine();
            try {
                count = Integer.parseInt(input);
                if (count == 0) System.out.println("Вы ввели пустое значение. Повторите ввод");
            } catch (NumberFormatException e) {
                System.out.println("Недопустимый ввод. Повторите.");
            }
        } while (count <= 0);
        return count;
    }

    /* Метод считывает введенные строки и возвращает их в массиве **/
    static String [] getString(int qnt) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        String [] massInput=new String[qnt];
        System.out.println("Введите строки");
        for (int i = 0; i <massInput.length ; i++) {
            do {
                String line = scan.nextLine();
                input = line.trim();
                if (input.isEmpty()) System.out.println("Вы ввели пустое значение. Повторите ввод.");
            } while (input.isEmpty());
            massInput[i]=input;
        }
        return massInput;
    }

    /* Метод принимает массив строк и производит подсчет гласных */
    static void countOfVowel (String[] massInput) {
        int count=0;
        for (String str:massInput) {
            for (char ch:str.toCharArray()) {
                switch (ch) {
                    case 'a':
                    case 'o':
                    case 'u':
                    case 'i':
                    case 'e':
                    case 'y':
                    case 'A':
                    case 'O':
                    case 'U':
                    case 'I':
                    case 'E':
                    case 'Y': count++;
                    default:
                }
            }
//            System.out.printf("Количество гласных в строке %s = %d", str, count);
            System.out.print(count+ " ");
            count=0;
        }
    }
}


