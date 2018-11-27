import java.util.Random;

public class Main{
    //method that generates the histogram array
    public static void generateHisto(int[] arrayIn){
        //initialise the array
        String[] histoArray = new String[10];

        //set the string starts of each index for the ranges in the histogram
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

        //intiialise a new element
        int newElement;

        //loop throughthe input array
        for (int i = 0; i < arrayIn.length; i++){
            //set new element to the current index in arrayIn and divide by 10 to find index for histoArray
            newElement = arrayIn[i] / 10;

            //add a "*" to the corresponding index in histoArray
            histoArray[newElement] = histoArray[newElement]+"*";
        }
    }

    //method that produces a random number array of a given length
    public static int[] randomArray(int leng){
        //intialise array of given length leng
        int[] arrayOut = new int[leng];

        //intialise random number generator
        Random randNum = new Random();

        //loop through array and set current index to random number range 1 to 100
        for(int i = 0; i < arrayOut.length; i++){
            arrayOut[i] = randNum.nextInt(99) + 1;
        }
        //return random array
        return arrayOut;
    }

    //print array method used for testing
    public static void printArray(int[] arrayIn){
        for(int i = 0; i < arrayIn.length; i++){
            System.out.println(arrayIn[i]);
        }
    }

    //method used to time the generateHisto function given a number of tests and iterations of each test
    public static void timeHisto(int start, int iterSize, int numTests, int numIterations){
        //loop the number of tests
        for(int i = 0; i < numTests; i++) {

            //create an average
            long average = 0;

            //loop the number of iterations for this test
            for(int j = 0; j < numIterations; j++){
                //generate a random array
                int[] testArray = randomArray(start + (iterSize * i));

                //time the generateHisto function using nanoTime
                long startTime = System.nanoTime();
                generateHisto(testArray);
                long endTime = System.nanoTime();

                //add the time taken to the average
                average += (endTime - startTime)/numIterations;
            }
            //print out the average
            System.out.println(average);
        }
    }

    //test harness
    public static void main(String[] args){
        timeHisto(5000, 5000, 10, 100);
    }
}