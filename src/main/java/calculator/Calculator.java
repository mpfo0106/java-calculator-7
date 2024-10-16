package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void run(){
        try {
            String input = getInput();
        }
        catch (IllegalArgumentException e){

        }
    }
    private String getInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        return input;
    }

    private String[] splitInput(String input){
        if(input.startsWith("//")){
            int index =input.indexOf("\n");
            if(index != -1){
                String customDelimiter = input.substring(2,index);
                String numberString = input.substring(index+1);
                return numberString.split(customDelimiter);
            }
        }
        return input.split("[,:]");
    }
}
