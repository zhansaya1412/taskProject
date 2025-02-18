package kz.bitlab.techorda2025.thirdProject.beans;

public class ExampleBean {

    private String text;

    public ExampleBean(){
        this.text = "Madiyar did the homework! Well done!";
    }

    public ExampleBean(String someText){
        this.text = someText;
    }

    public String getSomeText(){
        return text;
    }
}


