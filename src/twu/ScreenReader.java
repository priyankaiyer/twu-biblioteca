package twu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ScreenReader {

    protected String getSelectionFromScreen(){
        BufferedReader reader = newReaderFromScreen();
        String rescuedNumber = "0";
        try{
            String inputLine = reader.readLine();
            while(inputLine.trim().equals("")){
                System.out.println("Input cannot be blank. Please re-enter.");
                inputLine = reader.readLine();
            }
            return inputLine;
        }catch (Exception e){
            return rescuedNumber;
        }
    }

    protected BufferedReader newReaderFromScreen() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
