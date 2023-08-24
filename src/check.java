// package Final;

import java.util.Arrays;

public class check {

    static String[][][] superVar = new String[6][5][6];
    public static void main(String[] args) {
        String[] domain = {"oob", "prob", "CAD", "EDC", "Signal", "EPE"};
        int maxOccurrences = 2; // Set the maximum occurrences of a domain value in each 2D array
        generateTables(superVar, domain, maxOccurrences);
        
    }

    public static void generateTables(String[][][] ar, String[] domain, int maxOccurrences) {
        int tableCount = ar.length;
        int totalCells = ar[0].length * ar[0][0].length;
        int valuesPerTable = Math.min(domain.length, maxOccurrences * totalCells);

        for (int t = 0; t < tableCount; t++) {
            int valueIndex = 0;
            for (int i = 0; i < ar[t].length; i++) {
                for (int j = 0; j < ar[t][i].length; j++) {
                    ar[t][i][j] = domain[valueIndex];
                    valueIndex = (valueIndex + 1) % valuesPerTable;
                }
            }
            shuffleArray(ar[t]); // Shuffle the 2D array to randomize the domain values
        }
    }

    public static void shuffleArray(String[][] array) {
        for (String[] row : array) {
            for (int i = row.length - 1; i > 0; i--) {
                int index = (int) (Math.random() * (i + 1));
                String temp = row[index];
                row[index] = row[i];
                row[i] = temp;
            }
        }
    }

    public static void printArray() {
        int i = 1;
        for (String[][] a : superVar) {
            System.out.println("Slot " + i++);
            for (String[] b : a) {
                System.out.println(Arrays.toString(b));
            }
            System.out.println("*-----------*");
        }
    }
    public static String [][] getClass(int index){
        Section obj = new Section(superVar[index]);
        return obj.getData();
    }
    public static void printArray(String [][] ar){
        for(String [] i:ar){
            for(String j:i){
                System.out.printf("%s ",j);
            }
            System.out.println(" ");
        }
    }
}
