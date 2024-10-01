package utilityClassPackage;

public class UtilityClassTestExample {
    public static void main(String[] args) {
        String str1 = "Stroka";
        String str2 = "A_A";
        String str3 = "  !  ";
        String str4 = "12345";
        String str5 = "It's a Random String";

        System.out.println("Total string length = " + StringLengthUtils.totalLength(str1, str2, str3, str4, str5));
        System.out.println("Average string length = " + StringLengthUtils.avgLength(str1, str2, str3, str4, str5));
        System.out.println("Min string length = " + StringLengthUtils.minLength(str1, str2, str3, str4, str5));
        System.out.println("Max string length = " + StringLengthUtils.maxLength(str1, str2, str3, str4, str5));
    }
}
