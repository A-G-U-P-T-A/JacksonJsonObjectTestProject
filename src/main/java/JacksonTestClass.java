import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTestClass {
    public static void main(String args[]){
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "{\"name\":\"AGUPTA\", \"age\":22, \"footballclub\":\"FC Barcelona\"}";

        try{
            TestInformationClass TestInformationObject = mapper.readValue(jsonString, TestInformationClass.class);
            System.out.println(TestInformationObject+"\n");
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(TestInformationObject);
            System.out.println(jsonString);
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
}

class TestInformationClass {
    private String name;
    private int age;
    private String footballclub;

    public TestInformationClass(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getFootballclub() {
        return footballclub;
    }
    public void setFootballclub(String footballclub) {
        this.footballclub = footballclub;
    }

    public String toString(){
        return "TestInformationClass [ name: "+name+", age: "+ age+", fan of football club: "+footballclub+ " ]";
    }

}
