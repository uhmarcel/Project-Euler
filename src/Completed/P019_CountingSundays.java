package Completed;

/* Problem No. 19 - Counting Sundays */

public class P019_CountingSundays {
    
    public static int countingSundays(int[] dateFrom, int[] dateTo) {
        // Date format int[] date = {2018, 10, 6}
        int fromSundays = getSundaysUpto(dateFrom);
        int toSundays = getSundaysUpto(dateTo);
        return toSundays - fromSundays;
    }
    
    public static boolean isLeapYear(int x) {
        final int NORMAL_YEAR_DAYS = 365;
        if ((x % 4 == 0) && (x % 100 != 0 || x % 400 == 0)) {
            return true;
        }
        return false;
    }
    
    public static int getSundaysUpto(int[] date) {
        final int YEAR = 0;
        final int MONTH = 1;
        final int DAY = 2;
        final int MONTH_DAYS[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final int DAYS_IN_A_YEAR = 365;
        final int FEBRUARY = 2;
        
        int base[] = {1900, 1, 1};
        int totalDays = 0;
        int totalSundays = 0;
        
        while (base[DAY] < date[DAY] || base[MONTH] < date[MONTH] || base[YEAR] < date[YEAR]) {
            int daysThisMonth = MONTH_DAYS[base[MONTH] - 1];
            if (base[MONTH] == FEBRUARY) 
                daysThisMonth++;
            
            totalDays++;
            base[DAY]++; 
            
            if (base[DAY] > daysThisMonth) {
                base[MONTH] += 1;
                base[DAY] = 1;
                if (totalDays % 7 == 0) {
                    totalSundays++;
                }
            }
            if (base[MONTH] > 12) {
                base[YEAR] += 1;
                base[MONTH] = 1;
            }   
        }
        return totalSundays;
    }
    
    
/* Main Testing */
    
    public static void main(String args[]) {
        int from[] = {1901, 1, 1};
        int to[] = {2000, 12, 30};
        
        System.out.println(countingSundays(from, to)); 
        
    }
    
}
