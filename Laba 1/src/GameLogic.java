import java.util.Random;

class GameLogic {
    private Random random = new Random();
    private int userNumber;
    private int border;
    private int computerNumber = -1;
    private int counter;

    GameLogic(int n) {
        border = n;
    }

    public void setRandomNumber() {
        computerNumber = random.nextInt(border)+1;
    }

    public void setUserNumber(String fieldString){
        userNumber=0;
        if (fieldString.isEmpty()) {
            userNumber=-2;
        }
        else userNumber = Integer.parseInt (fieldString);
    }

    public void setNegativeComputerNumber() {
        computerNumber = -1;
    }

    public CompareEnum.compareResult compareOfNumbers(){
        if (-1 == computerNumber) return CompareEnum.compareResult.NOT_STARTED;
        else if (-2 == userNumber) return CompareEnum.compareResult.NOT_ENTERED;
        else if (userNumber > computerNumber) return CompareEnum.compareResult.MORE;
        else if (userNumber < computerNumber) return CompareEnum.compareResult.LESS;
        else return CompareEnum.compareResult.WIN;

    }

    public void setCounterToZero() {
        counter = 0;
    }

    public void incCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public int getComputerNumber() {
        return computerNumber;
    }

    public int getUserNumber() {
        return userNumber;
    }
}