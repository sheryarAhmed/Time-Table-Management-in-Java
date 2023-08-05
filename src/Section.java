public class Section {
    String[][] Section ;
    String[][] Slot;
    String[] days = {"Monday","Tuesday","Wednessday","Thursday","Friday","Saturday"};
    int length;
    public Section (String [][] values){
        this.length = values.length;
        Section = new String[length][length+1];
        Slot = values.clone();
        addData();
        check();
    }
    public void addData(){
        for(int i = 0;i<Section.length;i++){
            Section[i][0] = days[i];
            for(int j =0;j<Section[i].length;j++){
                if((i<length) && (j<Section[i].length-1)){
                    Section[i][j+1] = Slot[i][j];
                }
            }
        }

    }
    private void check(){
        for(int i=0;i<Section.length;i++){
            for(int j=0;j<Section[i].length;j++){
                if(Section[i][j]==null){
                    Section[i][j] = ".";
                }
            }
        }
    }
    
    public String[][] getData(){
        return Section;
    }

    
}
