package algorithm.Math;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 *
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
    	return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
    
}
