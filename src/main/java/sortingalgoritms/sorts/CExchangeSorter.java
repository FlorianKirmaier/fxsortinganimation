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
 * Implementation of the Exchange sort algorithm.
 *
 * @author Eric Canull
 * @version 1.0
 */
public final class CExchangeSorter extends ASortOperator {

    public static final CExchangeSorter SINGLETON = new CExchangeSorter();

    /**
     * Implementation of the Exchange sort algorithm.
     */
    private CExchangeSorter() {
        // Private Constructor will prevent the instantiation of this class
        // directly
    }

    /**
     * Starts the Exchange Sort algorithm.
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
        IComparable temp;
        for (int i = 0; i < numbers.length - 1; i++) {
            count();
            for (int j = i + 1; j < numbers.length; j++) {
                count();
                if (numbers[i].compare(numbers[j]) == IComparable.GREATER) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    count();
                }
            }
        }
    }
}
