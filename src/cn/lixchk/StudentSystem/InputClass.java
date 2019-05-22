package cn.lixchk.StudentSystem;

import java.util.Scanner;

class InputClass {

    private InputClass() {
    }

    public static int getInt() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Invalid Integer!");
            input.next();
        }
        return input.nextInt();
    }

    public static long getLong() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextLong()) {
            System.out.println("Invalid Long Integer!");
            input.next();
        }
        return input.nextLong();
    }

    public static String getString() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextLine()) {
            System.out.println("Invalid String!");
            input.next();
        }
        return input.nextLine();
    }

    public static double getDouble() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextDouble()) {
            System.out.println("Invalid Double!");
            input.next();
        }
        return input.nextDouble();
    }

    public static boolean getBoolean() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextBoolean()) {
            System.out.println("Invalid Boolean!");
            input.next();
        }
        return input.nextBoolean();
    }
}