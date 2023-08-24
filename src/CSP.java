import java.security.SecureRandom;

public class CSP {
    private String [][][] superVar;
    private String [] domain;
    private SecureRandom rc = new SecureRandom();
    private int totalSize =0;
    
    public CSP(String [] domain ,int totalSection){
        this.domain = domain.clone();
        superVar = new String[totalSection][5][6];
        this.totalSize = domain.length;


    }
    public void genrateTable(){
        changeFuntion(superVar, 0, domain, rc.nextInt(totalSize));
    }
    public void changeFuntion(String[][][] ar ,int index,String [] domain, int value){
        if(index == ar.length){
            return;
        }
        
        for(int i =0;i<ar[index].length;i++)
            for(int j =0;j<ar[index][i].length;j++){
                
                if(isValid(ar,index,i,j,domain,value)){
                    ar[index][i][j] = domain[value];
                    if(value>=domain.length)
                        value =0;
                   value++;
                }else
                    //ar[index][i][j] = ".";
                    j--;
                    value++;
                    if(value>=domain.length)
                        value =0;
            }
            index++;
        changeFuntion(ar, index, domain, value);
    }
    public static boolean isValid(String[][][] ar ,int index,int row,int col,String[] domain,int valueIndex){
        for(int a=0;a<index;a++){
            for(int b =0;b<ar[index].length;b++){
                for(int c=0;c<ar[index][b].length;c++){
                    if(ar[a][b][c].equals(ar[index][b][c])){
                        return false;
                    }
                }
            }
        }
        
        // for(int a =col;a>=0;a--){
        //     if(domain[valueIndex].equals(ar[index][row][a])){
        //         return false;
        //     }
        // }
        return true;
    }
    public void printAll(){
        int i =1;
        for(String[][]a:superVar){
            System.out.println("Slot "+ i++);
            for(String []b:a){
                for(String c:b){
                    System.out.printf("%-50s ",c);
                }
                System.out.println(" ");
            }
            System.out.println("*-----------*");
        }

    }
    public String [][] getSection(int index){
        return superVar[index];
    }
    public void printTable(int index){
        for(String[] i:superVar[index]){
            for(String j:i){
                System.out.printf("%10s",j);
            }
            System.out.println(" ");
        }
    }
    
}
