/*
 * Permissions of this free software license are conditioned on making available
 * complete source code of licensed works and modifications under the same 
 * license or the GNU GPLv3. Copyright and license notices must be preserved.
 * Contributors provide an express grant of patent rights. However, a larger 
 * work using the licensed work through interfaces provided by the licensed 
 * work may be distributed under different terms and without source code 
 * for the larger work.
 */
package sortingalgoritms.sorts;

import sortingalgoritms.util.IComparable;

/**
 * Implementation of Quick Sort Algorithm
 *
 * @author Eric Canull
 * @version 1.0
 */
public final class CQuickSorter extends ASortOperator {

    public static final CQuickSorter SINGLETON = new CQuickSorter();

    /**
     * Implementation of Quick Sort Algorithm
     */
    private CQuickSorter() {
        //Private Constructor will prevent the instantiation of this class
        //directly
    }

    /**
     * Starts the Quick Sort algorithm.
     *
     * @param numbers an array of numbers used for the sorting
     * @param lowIndex a integer representing the lowest index position in the
     * array
     * @param highIndex a integer representing the highest index position in the
     * array
     */
    @Override
    protected void startSort(IComparable[] numbers, int lowIndex, int highIndex) {
        resetCount();
        qsort(numbers, 0, numbers.length - 1);
    }

    /**
     * Recursive method to partition the array.
     *
     * @param numbers an array of numbers used for the sorting
     * @param lowIndex a integer representing the lowest index position in the
     * array
     * @param highIndex a integer representing the highest index position in the
     * array
     */
    private void qsort(IComparable[] numbers, int lowIndex, int highIndex) {
        if (highIndex <= lowIndex) {
            return;
        }
        count();
        int index = partition(numbers, lowIndex, highIndex);
        qsort(numbers, lowIndex, index - 1);
        qsort(numbers, index + 1, highIndex);
    }

    /**
     * Partitions the array.
     *
     * @param numbers an array of numbers used for the sorting
     * @param lowIndex a integer representing the lowest index position in the
     * array
     * @param highIndex a integer representing the highest index position in the
     * array
     */
    private int partition(IComparable[] numbers, int lowIndex, int highIndex) {
        IComparable tmp;
        int low = lowIndex - 1;
        int high = highIndex;
        IComparable pivot = numbers[highIndex]; // partition point
        while (true) {

            // scan up to find first item greater than partition
            // won't go past end because partition = last item in array
            while (numbers[++low].compare(pivot) == IComparable.LESS) {
                count();
            }

            // scan down down to find first item less in partion
            // or quit if none
            while (pivot.compare(numbers[--high]) == IComparable.LESS) {
                count();
                if (high == lowIndex) {
                    break;
                }
            }
            // if scan points cross, quit
            if (low >= high) {
                break;
            }
            count();
            // exchange the elements
            tmp = numbers[low];
            numbers[low] = numbers[high];
            numbers[high] = tmp;

        }

        // final swap
        numbers[highIndex] = numbers[low];
        numbers[low] = pivot;

        count();
        return low;
    }
}
