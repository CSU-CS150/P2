import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *  <h1>Practical 2: Salary Data</h1>
 *
 *  This object helps read in salary data, for you to process in
 *  the rest of your assignment. While you can see the code to this object,
 *  it is better to treat it similar to how would look at other useful classes
 *  in java such as scanner or math.
 *
 *  The columns in the datafile are defined as follows
 *  <ul>
 *   <li>Major</li>
 *   <li>Male Salary Average</li>
 *   <li>Female Salary Average</li>
 *   <li>White Salary Average</li>
 *   <li>People of Color Average</li>
 *   <li>Overall Salary Average</li>
 *   <li>Percent Male</li>
 *   <li>Percent Female</li>
 *   <li>Percent White</li>
 *   <li>Percent PoC</li>
 *  </ul>
 *
 * @author Albert Lionelle <br>
 *         lionelle@colostate.edu <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 1.0
 */
public class SalaryData {

    /** Data structure for storing the salary data from the file **/
    private final List<String[]> salaries = new ArrayList<>();

    /// the following set of variables are all for easy access. This is often done when dealing with
    /// arrays from files, so you don't have to remember the exact number / column throughout your code.
    private final int MAJOR = 0;
    private final int MALE_SALARY = 1;
    private final int FEMALE_SALARY = 2;
    private final int WHITE_SALARY = 3;
    private final int POC_SALARY = 4;
    private final int AVERAGE_SALARY = 5;
    private final int PERCENT_MALE = 6;
    private final int PERCENT_FEMALE = 7;
    private final int PERCENT_WHITE = 8;
    private final int PERCENT_POC = 9;

    /**
     * Initializes the salary data using the default file name
     */
    public SalaryData(String file) {
        initialize(file);
    }

    /**
     * Returns the total number of majors with salary data.
     * @return total number of majors with salary data
     */
    public int size() {
        return salaries.size();
    }

    /**
     * Returns the name of the major based on the dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the major name or INVALID if the major is not in the arraylist
     */
    public String getMajor(int dataID) {
        if(dataID >= size() || dataID < 0) return "INVALID";
        return salaries.get(dataID)[MAJOR];
    }

    /**
     * The male salary based on the major dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the salary or 0.0 as a double
     */
    public double getMaleSalary(int dataID) {
        return getDoubleType(dataID, MALE_SALARY);
    }

    /**
     * The female salary based on the major dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the salary or 0.0 as a double
     */
    public double getFemaleSalary(int dataID) {
        return getDoubleType(dataID, FEMALE_SALARY);
    }

    /**
     * The white salary based on the major dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the salary or 0.0 as a double
     */
    public double getWhiteSalary(int dataID) {
        return getDoubleType(dataID, WHITE_SALARY);
    }

    /**
     * The PoC salary based on the major dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the salary or 0.0 as a double
     */
    public double getPocSalary(int dataID) {
        return getDoubleType(dataID, POC_SALARY);
    }

    /**
     * The  salary based on the major dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the salary or 0.0 as a double
     */
    public double getSalary(int dataID) {
        return getDoubleType(dataID, AVERAGE_SALARY);
    }

    /**
     * The percent males in the major and reporting a starting salary the major dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the percent or 0.0 as a double
     */
    public double getMalePercent(int dataID) {
        return getDoubleType(dataID, PERCENT_MALE);
    }

    /**
     * The percent females in the major and reporting a starting salary the major dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the percent or 0.0 as a double
     */
    public double getFemalePercent(int dataID) {
        return getDoubleType(dataID, PERCENT_FEMALE);
    }

    /**
     * The percent whites in the major and reporting a starting salary the major dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the percent or 0.0 as a double
     */
    public double getWhitePercent(int dataID) {
        return getDoubleType(dataID, PERCENT_WHITE);
    }

    /**
     * The percent PoC in the major and reporting a starting salary the major dataID
     * @param dataID the id of the major they want to access, based on a fixed order
     * @return the percent or 0.0 as a double
     */
    public double getPocPercent(int dataID) {
        return getDoubleType(dataID, PERCENT_POC);
    }

    /**
     * This is a helper method internal to the class.
     * It does the actual reading of the data location and converting it to a double.
     * It assumes the file is correct as is the request for the
     * information. If they request something outside the bounds, it will return 0
     * @param dataID the id of the major they want to access, based on a fixed order
     * @param type the value of which column that wants to be accessed.
     * @return the double value based on dataID x Column.
     */
    private double getDoubleType(int dataID, int type) {
        if(dataID >= size() || dataID < 0) return 0;
        return Double.parseDouble(salaries.get(dataID)[type]);
    }

    /**
     * Reads the provided file and loads it into the data structure. It assumes a simple CSV format (no quotes)
     * @param filename the name of the file to open.
     */
    private void initialize(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename)); // notice - same as reading from console, but we change where we are reading from.
            scanner.nextLine(); // skip headers
            while(scanner.hasNext()) {
                salaries.add(scanner.nextLine().split(",")); // assumes a simpel CSV format
            }
            scanner.close();
        }catch(FileNotFoundException fex) {
            System.err.printf("File %s not found. Exiting Program", filename);
            System.exit(1);
        }
    }



}
