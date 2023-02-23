public class Student { // new class named 'Student'
    private String group; // class variable group
    private String name; // class variable name
    public Student () { // if we don't have an empty constructor we would not be able to create a new object without parameters, it's best practice to have one

    }
    public Student(String name, String group) { // name of the constructor must always match a name of the class
        this.name = name;
        this.group = group;
    }

    public Student(String name) { // we can have multiple constructors,
        this.name = name;
    }

    public void setName(String name) { // setter method for name
        this.name = name;
    }

    public String getName() { // getter method for name
        return this.name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return this.group;
    }
}
