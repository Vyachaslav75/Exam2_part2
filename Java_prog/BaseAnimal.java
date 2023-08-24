//import java.util.Random;

public abstract class BaseAnimal implements AnimalsInterface {
    //protected int id;
    protected String name;
    protected String navik;
    protected String voice;

    public BaseAnimal(String name, String navik, String voice) {
        //this.id = id;
        this.name = name;
        this.navik = navik;
        this.voice = voice;

    }

    @Override
    public String voice() {
        System.out.println(this.voice);
        return this.voice;
    }

    @Override
    public void getCommands() {
        //Random r = new Random();
        System.out.println("Умеет:");
        System.out.println(this.navik);
        // for (int i = 0; i < navik.length; i++) {
        //     System.out.println(this.navik[i]);
        // }
        
    }

    public void getInfo(){
        System.out.println(String.format("Класс: %s, Имя: %s", this.getClass().getSimpleName(), this.name));

    }

    public String getInfoFile(){
        String temp = String.format("%s; %s; %s", this.getClass().getSimpleName(), this.name, this.navik);
        return temp;

    }
}
