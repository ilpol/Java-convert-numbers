import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int a,b;
        String x;

        //Проверка числа a в исходной системе
        do {
            System.out.println("Введите число а - основание исходной системы от 2 до 36: ");
            while (!reader.hasNextInt()) {
                System.out.println("Неправильное число, попробуйте еще раз");
                reader.next();
            }
            a = reader.nextInt();
        } while (a <2 || a>36);

        //Проверка числа b в целевой системе
        do {
            System.out.println("Введите число b - основание целевой системы от 2 до 36: ");
            while (!reader.hasNextInt()) {
                System.out.println("Неправильное число, попробуйте еще раз");
                reader.next();
            }
            b = reader.nextInt();
        } while (b <2 || b>36);

        //Проверяем, соответствует ли число x a-ичной кодировке
        Pattern p;
        if (a <10) {
            int number = a - 1;
            p = Pattern.compile("[^0-"+number+"]");
        }
        else
        {
            int number_of_character = 86 + a;
            char my_char = (char)number_of_character;
            p = Pattern.compile("[^a-"+my_char+"0-9]");
        }
        Matcher m;
        boolean check = true;
        do {
            System.out.println("Введите число x, записанное в a-ичной системе ");
            x=reader.next();
            m= p.matcher(x);
            check = m.find();
            if (check) {
                System.out.println("Неправильно число, не соответствует aичной кодировке");
            }
        } while (check);
        reader.close();
        //Перевод в другую кодировку
        String res = Integer.toString(Integer.parseInt(x, a), b);
        System.out.println("x в b-ичной системе = " + res);

    }
}
