import java.util.Scanner;

public class Vigenère
{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        String ogMessage = input("Enter the message to decrypt: ");
        //  only a-z
        String message = ogMessage.toLowerCase().replaceAll("[^a-z]", "");
        String key = input("Enter the key: ");
        String result = "";

        for(int i = 0,j = 0; i < message.length(); i++, j++)
        {
            //  the character at position j in the original message
            int ogChar;
            //  inserting non-letter chars
            while(!isLetter(ogChar = ogMessage.charAt(j)))
            {
                result += (char)ogChar;
                ++j;
            }

            //  char at i of stripped message
            char messageChar = message.charAt(i);
            //  char at i of key
            char keyChar = key.charAt(i%key.length());
            if(isLetter(messageChar))
            {
                int dist = messageChar - keyChar;
                //  letterifies the distance (between 0-25, then adds 'a' (97) to make it ASCII)
                char letter = (char) (dist >= 0 ? dist+'a' : dist+26+'a');
                result += (char) ((isUpperCase(ogChar)) ? letter^0x20 : letter);
            }
        }
        System.out.println(result);
    }

    static boolean isUpperCase(int c)
    {
        return c >= 'A' && c <= 'Z';
    }

    static boolean isLowerCase(int c)
    {
        return c >= 'a' && c <='z';
    }

    static boolean isLetter(int c)
    {
        return isUpperCase(c) || isLowerCase(c);
    }

    static String input(String message)
    {
        System.out.print(message);
        return scanner.nextLine();
    }
}