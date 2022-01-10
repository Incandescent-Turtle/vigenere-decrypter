import java.util.Scanner;

public class Vigenère
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the message to decrypt: ");
        String msg = scanner.nextLine();

        System.out.print("Enter the key: ");
        String key = scanner.nextLine().toLowerCase();

        String result = "";

        for(int letterIndex = 0,msgIndex = 0; msgIndex < msg.length(); msgIndex++)
        {
            char msgChar = msg.charAt(msgIndex);
            if(isLetter(msgChar))
            {
                char lowerCaseChar = msg.toLowerCase().charAt(msgIndex);
                char keyChar = key.charAt(letterIndex%key.length());
                int dist = lowerCaseChar - keyChar;
                //  letterifies the distance (between 0-25, then adds 'a' (97) to make it ASCII)
                char letter = (char) (dist >= 0 ? dist+'a' : dist+26+'a');
                result += (char) ((isUpperCase(msgChar)) ? letter^0x20 : letter);
                letterIndex++;
            } else {
                result += msgChar;
            }
        }
        System.out.println(result);
    }

    static boolean isUpperCase(int c)
    {
        return c >= 'A' && c <= 'Z';
    }

    static boolean isLetter(int c)
    {
        return isUpperCase(c) || c >= 'a' && c <= 'z';
    }
}