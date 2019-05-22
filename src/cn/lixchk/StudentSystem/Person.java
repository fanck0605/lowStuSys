package cn.lixchk.StudentSystem;

public class Person {
    private String name;
    private byte gender;
    private int age;
    private static int numberOfPerson = 0;

    public static final int NO_AGE = -1;

    public static final byte NO_GENDER = 0;
    public static final byte MALE = 1;
    public static final byte FEMALE = 2;
    public static final byte SPECIAL_SEX = 3;


    public Person(String name, String gender, int age) {
        setName(name);
        setGender(gender);
        setAge(age);
        numberOfPerson++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        switch (gender) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            case 3:
                return "Special";
            default:
                return "None";
        }
    }

    public void setGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                this.gender = MALE;
                break;
            case "female":
                this.gender = FEMALE;
                break;
            case "special":
                this.gender = SPECIAL_SEX;
                break;
            case "none":
                this.gender = NO_GENDER;
                break;
            default:
                if (this.gender == MALE ||
                        this.gender == FEMALE ||
                        this.gender == SPECIAL_SEX ||
                        this.gender == NO_GENDER)
                    System.out.println("Invalid gender! Don't change!");
                else {
                    this.gender = NO_GENDER;
                    System.out.println("Invalid gender! Set to no gender.");
                }
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else if (this.age >= 0 && this.age <= 120) {
            System.out.println("Invalid age! Don't change!");
        } else {
            this.age = NO_AGE;
            System.out.println("Invalid age! Set to NO_AGE.");
        }
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }
}
