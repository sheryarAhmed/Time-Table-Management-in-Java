import java.security.SecureRandom;
import java.util.Arrays;

public class TimeTableGenerator{
    String departmentPlusYear;
    String[] faculty;
    String[][][] classes;
    int[][] recordIndexI, recordIndexJ;
    int totalClasses, lecturesPerWeek, totalLecturesPerTeacher, index;

    public TimeTableGenerator(String departmentPlusYear, String[] faculty, int totalClasses, int lecturesPerWeek){
        this.departmentPlusYear = departmentPlusYear;
        this.faculty = faculty;
        this.totalClasses = totalClasses;
        this.lecturesPerWeek = lecturesPerWeek;
        totalLecturesPerTeacher = totalClasses*lecturesPerWeek;
        recordInitialzer();
    }

    private void recordInitialzer(){
        classes = new String[totalClasses][6][6];
        recordIndexI = new int[faculty.length][totalLecturesPerTeacher];
        recordIndexJ = new int[faculty.length][totalLecturesPerTeacher];
        for(int i = 0; i < recordIndexI.length; i++){
            Arrays.fill(recordIndexI[i], -1);
            Arrays.fill(recordIndexJ[i], -1);
        }
    }

    public void assign(){
        for(int i = 0; i < faculty.length; i++){
            for(int j = 0; j < classes.length; j++){
                assignHelperMethod(faculty[i], i, classes[j]);
            }
        }
    }

    public String[][] get2Darray(int index){
        return classes[index];
    }
    public String[][][] get3Darray(){
        return classes;
    }

    private void assignHelperMethod(String teacher, int teacherIndex, String[][] table){
        int filled = 0, attempts = 0;
        SecureRandom r = new SecureRandom();
        if(index == totalLecturesPerTeacher){
            index = 0;
        }
        while(filled < lecturesPerWeek){
            int i = r.nextInt(5), j = r.nextInt(6);
            attempts++;
            boolean valid = validityVerifier(i, j, teacher, teacherIndex, table);
            if(table[i][j] == null && valid){
                table[i][j] = teacher;
                recordIndexI[teacherIndex][index] = i;
                recordIndexJ[teacherIndex][index] = j;
                index++;
                filled++;
            }
            if(attempts == 10000000){
                throw new IllegalArgumentException("Time Tables cannot be created as clash cannot be resolved.");
            }      
        }
    }

    private boolean validityVerifier(int row, int col, String teacher, int teacherIndex, String[][] table){
        // checking for an already existing i,j pair for a given teacher
        for(int i = 0; i < recordIndexI[0].length; i++){
            if(recordIndexI[teacherIndex][i] == row && recordIndexJ[teacherIndex][i] == col)
                return false;
        }
        // check the entire row of the table
        for(int i = 0; i < table[0].length; i++){
            if(teacher.equals(table[row][i])){
                return false;
            }
        }
        // check entire columnn of the table
        for (int i = 0; i < table.length; i++) {
            if (teacher.equals(table[i][col])) {
                return false;
            }
        }
        return true;
    }

    public void printTimeTables(){
        int inc = 0;
        for(String[][] table : classes){
            System.out.printf("%s:\n", departmentPlusYear + (char)('A'+inc));
            inc++;
            for(String[] i : table){
                for(String j : i)
                    System.out.printf("%-20s", (j != null)? j : "");
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------");
        }
    }

    /*private void createTables(){
        String[] days = {"Day", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] time = {"8:00 AM", "9:40 AM", "11:20 AM", "1:40 PM", "3:20 PM", "5:20 PM"};
        for(String[][] table : classes){
            for(int i = 0; i < days.length; i++){
                table[i][0] = days[i];
                table[0][i+1] = time[i];
            }
        }
    }*/

    public void printRecord(){
        System.out.println("Record of Indexes filled:");
        for(int i = 0; i < recordIndexI.length; i++){
            System.out.printf("%20s:\t", faculty[i]);
            for(int j = 0; j < recordIndexI[i].length; j++){
                System.out.printf("(%d,%d)\t", recordIndexI[i][j], recordIndexJ[i][j]);
            }
            System.out.println();
        }
    }
    public String[][][] getteacher3Darray(int teacherIndex){

        String array[][][] = new String[totalClasses][6][6];

        int i = 0;

        for(int section = 0; section < classes.length; section++){

            for(int j = 0; j < lecturesPerWeek; j++){

                array[section][recordIndexI[teacherIndex][i]][recordIndexJ[teacherIndex][i]] = faculty[teacherIndex];

                i++;

            }

        }

        return array;

    }
    public static TimeTableGenerator genrate(String[] faculty){
        TimeTableGenerator object = new TimeTableGenerator("BCE-4", faculty, 5, 3);
        int a = 10;
        for(int i = 1; i <= a; i++){
            try{
                object.assign();
                System.out.println("Time Tables created succesfully.");
                
                break;
            }
            catch(IllegalArgumentException s){
                System.out.println(s.getMessage());
                if(i < a)
                    System.out.printf("Trying again: %d/%d\n", i, a);
                else
                    System.out.println("Maybe reconsider the values.");
                object = new TimeTableGenerator("BCE-4", faculty, 5, 3);
            }

        }
        return object;
    }
    public String[][] getteacher2Darray(int teacherIndex){

        String array[][] = new String[6][6];

        int inc = 0, count = 0;

        for(int i = 0; i < recordIndexI[0].length; i++){

            array[recordIndexI[teacherIndex][i]][recordIndexJ[teacherIndex][i]] = departmentPlusYear + (char)('A'+inc);

            count++;

            if(count == lecturesPerWeek){

                inc++;

                count = 0;
            }
        }
        return array;

    }
}