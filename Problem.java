import java.util.Arrays;

/* 
Asumptions:
1. Infinite number of coins
2. Target number can be obtain with given coins values

Case 1:
Inputs: 
    coin values: [1,2,5,8]
    target: 21
Output:
    num of coins needed: 3
*/
public class Problem {
    public void bubbleSort(int arr[]) {
        boolean didChanged;
        for (int i = 0; i < arr.length - 1; i++) {
            didChanged = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    didChanged = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (didChanged == false) {
                return;
            }
        }
    }

    public int[] addValueToArray(int arr[], int numAdded) {
        int newArray[] = Arrays.copyOf(arr, arr.length + 1);
        newArray[arr.length] = numAdded;
        return newArray;
    }

    public int[] coinProblem(int coinValues[], int target) {
        int results[] = {}; // init result array
        int remainder = target; // init remainder with target num
        bubbleSort(coinValues); // sort coin values array stating with the highest number

        while (remainder > 0) {
            for (int i = 0; i < coinValues.length; i++) {
                if (coinValues[i] <= remainder) { // iterate and look for next best coin
                    results = addValueToArray(results, coinValues[i]); // add coin value to result array
                    remainder -= coinValues[i]; // calculate new remainder
                    break;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Problem prob = new Problem();
        int myCoins[] = { 8, 5, 2, 1 };
        int target = 21;
        int usedCoins[] = prob.coinProblem(myCoins, target);
        System.out.println(usedCoins.length);
    }

}
