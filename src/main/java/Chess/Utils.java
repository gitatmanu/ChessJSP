package Chess;

public class Utils 
{
    public static int charToNum(char c) 
    {      
        int out = 0;
        switch (c) {
            case 'A':
                out = 0;
                break;
            case 'B':
                out = 1;               
                break;
            case 'C':
                out = 2;               
                break;
            case 'D':
                out = 3;
                break;
            case 'E':
                out = 4;
                break;
            case 'F':
                out = 5;
                break;
            case 'G':
                out = 6;
                break;
            case 'H':
                out = 7;
                break;  
        }
        return out;
    }
}
