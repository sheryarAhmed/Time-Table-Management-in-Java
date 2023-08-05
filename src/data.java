public class data {
    static String[] faculty = {
        "Dr. Alam Zaib", "Dr.Faisal Mehmood", "Dr.Imdad Khan", "Ayaz Ali Shah", "Zulfiqar Khattak"
    };
    static String section []={"BCE-4A","BCE-4B","BCE-4C","BCE-4D","BCE-4E"};
    static String col[] = {"Days","8:10 -9:30","9:40- 11:10","11:20 - 12:50","1:20-3:10","3:20-4:50","5:00 - 6:30"}; 
    static TimeTableGenerator table = TimeTableGenerator.genrate(data.faculty);
    public static void genrate(){
        table = TimeTableGenerator.genrate(data.faculty);;
    }
}
