package JavaJDBC;

public class Test {
    private int id;
    private  int age;
    private  String first;
    private String last;

    public  Test(int id,int age,String first,String last){
        super();
        this.id = id;
        this.age = age;
        this.first = first;
        this.last = last;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Test.java{" +
                "id=" + id +
                ", age=" + age +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

}

