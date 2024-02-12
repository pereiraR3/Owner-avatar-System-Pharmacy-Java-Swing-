
package main.singlenton;
import java.util.ArrayList;

public class utilsSwing {

    private getConnection connect; 
    
    public utilsSwing(getConnection input){
        this.connect = input;
    }
    
    public getConnection getConnect() {
        return this.connect;
    }
    
    public boolean verifyTextField(ArrayList<String> textFields, String dataValidade, String dataFabricacao){
        for (String field : textFields) {
            if (field.trim().isEmpty()) {
                return false;
            }
        }      
        
        if(dataValidade != "null" && dataFabricacao != "null"){
            if (dataValidade.isEmpty() || dataFabricacao.isEmpty()){
                return false;
            }
        }
        
        return true;
    }

}
