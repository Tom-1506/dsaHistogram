import java.util.Random;

public class Main
{
    public static String[] generateHisto(int[] arrayIn)
    {
        String[] histoArray = new String[10];

        histoArray[0] = "1 - 10    :  ";
        histoArray[1] = "11 - 20   :  ";
        histoArray[2] = "21 - 30   :  ";
        histoArray[3] = "31 - 40   :  ";
        histoArray[4] = "41 - 50   :  ";
        histoArray[5] = "51 - 60   :  ";
        histoArray[6] = "61 - 70   :  ";
        histoArray[7] = "71 - 80   :  ";
        histoArray[8] = "81 - 90   :  ";
        histoArray[9] = "91 - 100  :  ";

        int newElement;

        for (int i = 0; i < arrayIn.length; i++)
        {
            newElement = arrayIn[i] / 10;
            histoArray[newElement] = histoArray[newElement]+"*";
        }
        return histoArray;
    }

    public static int[] randomArray(int leng)
    {
        int[] arrayOut = new int[leng];
        Random randNum = new Random();

        for(int i = 0; i < arrayOut.length; i++)
        {
            arrayOut[i] = randNum.nextInt(100);
        }
        return arrayOut;
    }

    public static void printHisto(String[] histoArray)
    {
        for (int i = 0; i < histoArray.length; i++)
        {
            System.out.println(histoArray[i]);
        }
    }

    public static void main(String[] args)
    {
        printHisto(generateHisto(randomArray(100)));
    }
}