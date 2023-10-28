import java.util.Scanner;
public class CreditCardValidation
{
    String creditCardNumber="";
    public void set()/*checks whether the LENGTH of the CREDIT CARD NUMBER is between 12 to 19 digits,
     *if NOT, then it PRINTS "INVALID CREDIT CARD NUMBER"
     *Also, takes INPUT from the USER.
     */
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER YOUR CREDIT CARD NUMBER");
        creditCardNumber= sc.nextLine();
        if((creditCardNumber.length()<12) || (creditCardNumber.length()>19))
        {
            System.out.println("INVALID CREDIT CARD NUMBER");
            System.exit(0);
        }
    }

    public void mii()//CHECKS and PRINTS the MAJOR INDUSTRY IDENTIFIER (first digit of a CREDIT CARD NUMBER). For e.g., 3 for "TRAVEL", 4 and 5 for "BANKING and FINANCIAL",etc.
    {
        String majorIndustryIdentifier="";
        if (creditCardNumber.startsWith("1")|| creditCardNumber.startsWith("2"))
            majorIndustryIdentifier = "Airlines";
        else if (creditCardNumber.startsWith("3"))
            majorIndustryIdentifier = "Travel";
        else if ((creditCardNumber.startsWith("4")|| creditCardNumber.startsWith("5")))
            majorIndustryIdentifier = "Banking and Financial";
        else if (creditCardNumber.startsWith("6"))
            majorIndustryIdentifier = "Merchandising";
        else if(creditCardNumber.startsWith("7"))
            majorIndustryIdentifier = "Petroleum";
        else if(creditCardNumber.startsWith("8"))
            majorIndustryIdentifier = "Healthcare or Telecommmunications";
        else if(creditCardNumber.startsWith("9")|| creditCardNumber.startsWith("0"))
            majorIndustryIdentifier = "Unknown";
        System.out.println(("YOUR MAJOR INDUSTRY IDENTIFIER IS ") + majorIndustryIdentifier);
    }

    public void iin() /*checks and prints the ISSUER IDENTIFICATION NUMBER (first 6 digits of a CREDIT CARD NUMBER). For e.g. 4xxxxx fot VISA, etc.
    Also,calculates and prints the ACCOUNT NUMBER (7th and following digits but excluding the last digit)*/
    {
        String issuerIdentificationNumber = creditCardNumber.substring(0,6);
        int ch = Integer.parseInt(issuerIdentificationNumber);
        if(ch/100000 == 4)
            System.out.println("Your Issuer Identification Number is VISA");
        else if(ch /10000 == 34 || ch /10000 == 37)
            System.out.println("Your Issuer Identification Number is Amex");
        else if(ch /10000 >=51 && ch /10000 <=55)
            System.out.println("Your Issuer Identification Number is MasterCard");
        else if(ch /100 == 6011 || ch /1000 == 644 || ch/10000==65)
            System.out.println("Your Issuer Identification Number is Discover");
        else
            System.out.println("Your Issuer Identification Number is Unknown");
        System.out.println("Your Account Number is " + creditCardNumber.substring(7,creditCardNumber.length()-1));
    }

    public int checksum() // validates the CREDIT CARD NUMBER
    {
        int evenSum = 0, oddSum = 0, sum=0;
        int cardlength = creditCardNumber.length();
        for (int i = cardlength - 1; i >= 0; i--)
        {
            char d= creditCardNumber.charAt(i);
            int digit = Character.getNumericValue(creditCardNumber.charAt(i));
            if (i % 2 == 0)
            {
                int multiplyByTwo = digit * 2;
                if (multiplyByTwo > 9)
                {
                    //If the number after doubling has two digits, then add the digits to make it a single-digit number.
                    String mul = String.valueOf(multiplyByTwo);
                    multiplyByTwo = Character.getNumericValue(mul.charAt(0)) + Character.getNumericValue(mul.charAt(1));
                }
                evenSum += multiplyByTwo;
            }
            else
            {
                oddSum += digit;
            }
        }
        sum = evenSum + oddSum;
        if (sum % 10 == 0)//checks whether the sum is divisible by 10 or not, IF IT IS, then PRINTS "VALID CREDIT CARD NUMBER", else PRINTS "INVALID CREDIT CARD NUMBER"
        {
            System.out.println(creditCardNumber+" is a valid card");
        }
        else
        {
            System.out.println(creditCardNumber+" is an invalid card");
        }
        return sum;
    }

    public static void main() // every other method is called in the main method
    {
        CreditCardValidation object1 = new CreditCardValidation();
        object1.set();
        object1.mii();
        object1.iin();
        object1.checksum();
}
}