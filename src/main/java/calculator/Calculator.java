package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void run(){
        try {
            String input = getInput();
            int[] numbers = parseNumbers(input);
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

    private int[] parseNumbers(String input) {
        String[] parts = splitInput(input);
        int[] numbers = new int[parts.length];

        for (int i = 0; i < numbers.length; i++) {
            try {
                int value = Integer.parseInt(parts[i].trim());
                if (value < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + numbers[i]);
                }
                numbers[i] = value;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + parts[i]);
            }
        }
        return numbers;
    }

}
