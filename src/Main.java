import java.util.Random;

public class Main{
    public static void generateHisto(int[] arrayIn){
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

        for (int i = 0; i < arrayIn.length; i++){
            newElement = arrayIn[i] / 10;
            histoArray[newElement] = histoArray[newElement]+"*";
        }
    }

    public static int[] randomArray(int leng){
        int[] arrayOut = new int[leng];
        Random randNum = new Random();

        for(int i = 0; i < arrayOut.length; i++){
            arrayOut[i] = randNum.nextInt(99) + 1;
        }
        return arrayOut;
    }

    public static void printArray(int[] arrayIn){
        for(int i = 0; i < arrayIn.length; i++){
            System.out.println(arrayIn[i]);
        }
    }

    public static void timeHisto(int start, int iterSize, int numTests, int numIterations){
        for(int i = 0; i < numTests; i++) {
            long average = 0;
            for(int j = 0; j < numIterations; j++){
                int[] testArray = randomArray(start + (iterSize * i));

                long startTime = System.nanoTime();
                generateHisto(testArray);
                long endTime = System.nanoTime();

                average += (endTime - startTime)/numIterations;
            }
            System.out.println(average);
        }
    }

    public static void main(String[] args){
        timeHisto(5000, 5000, 10, 100);
    }
}