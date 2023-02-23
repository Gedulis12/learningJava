public class Student { // new class named 'Student'
    private int id;
    private String name; // class variable name
    private String surname;
    private String group; // class variable group
    public Student () {
        /*
         if we don't have an empty constructor we would not be able to create a new object without parameters,
         therefore it's best practice to have one.
         */
    }
    public Student(int id, String name, String surname, String group) { // name of the constructor must always match a name of the class
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
    }

    public Student(int id) { // we can have multiple constructors with different parameters.
        this.id = id;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) { // setter method for id
        this.id = id;
    }

    public int getId() { // getter method for id
        return this.id;
    }
    public void setName(String name) { // setter method for name
        this.name = name;
    }

    public String getName() { // getter method for name
        return this.name;
    }

    public void setSurname(String surname) { // setter method for surname
        this.surname = surname;
    }

    public String getSurname() { // getter method for surname
        return this.surname;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return this.group;
    }
}
