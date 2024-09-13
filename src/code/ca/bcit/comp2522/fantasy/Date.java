package code.ca.bcit.comp2522.fantasy;

/**
 * Represents a specific date
 *
 * @author Manases
 * @version 1.0
 */
public class Date {
    private final int YEAR;
    private final int MONTH;
    private final int DAY;

    private final int MONTH_IN_YEAR = 12;
    private final int THIRTY_DAYS = 30;
    private final int THIRTY_ONE_DAYS = 31;
    private final int TWENTY_NINE_DAYS = 29;
    private final int TWENTY_EIGHT_DAYS = 28;
    private final int EIGHTEEN_HUNDRED = 1800;
    private final int NINETEEN_HUNDRED = 1900;
    private final int TWO_THOUSAND = 2000;

    // Months
    private final int JANUARY = 1;
    private final int FEBRUARY = 2;
    private final int MARCH = 3;
    private final int APRIL = 4;
    private final int MAY = 5;
    private final int JUNE = 6;
    private final int JULY = 7;
    private final int AUGUST = 8;
    private final int SEPTEMBER = 9;
    private final int OCTOBER = 10;
    private final int NOVEMBER = 11;
    private final int DECEMBER = 12;

    //Static constants
    private static final int FOUR_HUNDRED = 400;
    private static final int HUNDRED = 100;
    private static final int NOTHING = 0;
    private static final int BEGINNING = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int DAYS_IN_WEEK = 7;
    private static final int CURRENT_YEAR = 2024;

    /**
     * Constructor of the class date
     * @param year represents the year as integer
     * @param month represents the month as integer
     * @param day represents the day as integer
     */
    public Date(final int year, final int month, final int day){

        // Verify if the year is greater than 1800 and equal or lower to the current year
        if(year < EIGHTEEN_HUNDRED || year > CURRENT_YEAR){
            // illegal argument if it does violate the rule above
            throw new IllegalArgumentException("Invalid! Year must be between 1 and " + CURRENT_YEAR);
        }

        // verify if the month is between 1 and 12
        if(month < BEGINNING || month > MONTH_IN_YEAR){
            throw new IllegalArgumentException("Invalid! Month must be between 1 and 12");
        }

        // Verify if the day is between one and the last day of the month (Depends on the month)
        if(day < BEGINNING || day > daysInMonth(month, year)){
            throw new IllegalArgumentException("Invalid! day must be between 1 and " + daysInMonth(month, year));
        }

        this.YEAR = year;
        this.MONTH = month;
        this.DAY = day;
    }

    /**
     * Gets the day
     * @return day as an int
     */
    public int getDay(){
        return DAY;
    }

    /**
     * Gets the month
     * @return month as an integer
     */
    public int getMonth(){
        return MONTH;
    }

    /**
     * Gets the year.
     * @return year as an integer
     */
    public int getYear(){
        return YEAR;
    }

    /**
     * It will return the month as string and not as an integer
     * @return month as a string
     */
    public String monthToString(){
        switch (MONTH){
            case JANUARY:
                return "January";
            case FEBRUARY:
                return "February";
            case MARCH:
                return "March";
            case APRIL:
                return "April";
            case MAY:
                return "May";
            case JUNE:
                return "June";
            case JULY:
                return "July";
            case AUGUST:
                return "August";
            case SEPTEMBER:
                return "September";
            case OCTOBER:
                return "October";
            case NOVEMBER:
                return "November";
            case DECEMBER:
                return "December";
            default:
                throw new IllegalArgumentException("Invalid month");
        }

    }

    /**
     * The amount of days that a month has
     * @return amount as an integer
     */
    private int daysInMonth(final int month, final int year){
        switch(month){
            // Month that contains 31 days
            case JANUARY, MAY, MARCH, JULY, AUGUST, OCTOBER, DECEMBER:
                return THIRTY_ONE_DAYS;

            case FEBRUARY:
                // when the year is leap year then February has 29 days
                if (isLeapYear(year)){
                    return TWENTY_NINE_DAYS;
                }
                return TWENTY_EIGHT_DAYS;

            // Month that have 30 days
            case APRIL, JUNE, SEPTEMBER, NOVEMBER:
                return THIRTY_DAYS;
            default:
                return NOTHING;
        }
    }

    /**
     * Input validation if is a leap year.
     * @param year as an int
     * @return result as a boolean
     */
    public static boolean isLeapYear(int year) {
        boolean result;

        // First, get the remainder of the year divided by 400
        // e.g. 2024 % 400
        int c1 = year % FOUR_HUNDRED;

        // Second, get the remainder of the year divided by 4
        // e.g. 2024 % 4
        int c2 = year % FOUR;

        // Third, get the remainder of the year divided by 100
        // e.g. 2024 % 100
        int c3 = year % HUNDRED;

        // if the remainder of the first  or the second step is zero
        // and the remainder of the third step is zero then is leap year
        result = c1 == NOTHING|| c2 == NOTHING && !(c3 == NOTHING);

        return result;
    }

    /**
     * It will return the date.
     * @return date as a string.
     */
    public String getYyyyMmDd(){
        // to print the date in format e.g. 2024-9-15
        return YEAR + "-" + MONTH + "-" + DAY;
    }

    /**
     * Gets the day of the week.
     * @return date a string.
     */
    public String getDayOfWeek(){

        // Variable declaration
        final int yearLastTwoDigits;
        int twelves;
        int remainderTwelve;
        int fours;
        int total = NOTHING;
        int remainderSeven;




        // get the last two numbers of the year e.g. 1977 it would get 77
        yearLastTwoDigits= (YEAR % HUNDRED);

        // Special cases
        // When the year is 2000 or greater add 6
        if(YEAR >= TWO_THOUSAND){
            total += SIX;

            // When the year is one of 1800s add 2
        } else if ( YEAR < NINETEEN_HUNDRED) {
            total += TWO;
        }

        // If the month is January or February
        // and is a leap year add 6
        if(MONTH == BEGINNING || MONTH == TWO){
            if(isLeapYear(YEAR)){
                total += SIX;
            }
        }

        // Step 1
        // It will get how many times 12 can fit in the last two digits of the year
        // e.g. year = 1977, lastTwoDigits = 77, is doing the following operation 77 /12
        twelves = yearLastTwoDigits / MONTH_IN_YEAR;

        // Step 2
        // Calculate the remainder from step 1: 77 - (12*6) = 77 - 72 = 5
        remainderTwelve = yearLastTwoDigits % MONTH_IN_YEAR;

        // Step 3
        // Calculate how many 4s can fit in the result from step 2 5/4 = 1
        fours = remainderTwelve / FOUR;

        // Step 4
        // Add everything
        total += DAY + twelves + remainderTwelve + fours;
        total += monthCode(MONTH); // Step 5: Add the month code, which uses a supporting method to provide the code


        // Step 6
        // Get the remainder if you divide the result from step 5 divided by 7
        remainderSeven = total % DAYS_IN_WEEK;

        // Step 7
        // The result from step 6 is the day only that the week goes from starts on Saturday and ends Friday
        switch (remainderSeven){
            case NOTHING:
                return "Saturday";
            case BEGINNING:
                return "Sunday";
            case TWO:
                return "Monday";
            case THREE:
                return "Tuesday";
            case FOUR:
                return "Wednesday";
            case FIVE:
                return "Thursday";
            case SIX:
                return "Friday";
            default:
                throw new IllegalArgumentException("Something went wrong the value passed was " + remainderSeven);
        }
    }

    /**
     * supporting function for the get day of the week
     * @param month to represent the month as an integer
     */
    private int monthCode(int month){
        // Returns the code of the month use in the method getDayOfWeek
        switch(month){
            case JANUARY, OCTOBER:
                return BEGINNING;
            case FEBRUARY, MARCH, NOVEMBER:
                return FOUR;
            case APRIL, JULY:
                return NOTHING;
            case MAY:
                return TWO;
            case JUNE:
                return FIVE;
            case AUGUST:
                return THREE;
            case SEPTEMBER, DECEMBER:
                return SIX;
            default:
                return NOTHING;
        }
    }

    /**
     * gives the date in a string format
     * @return date as string
     */
    public String dateToString(){
        return getDayOfWeek() + " " + monthToString() + ", " + getYear();
    }
}

