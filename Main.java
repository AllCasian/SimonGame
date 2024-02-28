public class Main {
    public static void main(String[] args) throws InterruptedException {

        BackEnd backEnd = new BackEnd();
        FrontEnd frontEnd = new FrontEnd(backEnd);

        //Asteapta o sec pana incepe jocul
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        TheBond theBond = new TheBond(frontEnd, backEnd);
    }

}