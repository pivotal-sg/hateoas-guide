package sg.pivotal.domain;

public class Employee {
    private long id;
    private String name;
    private String username;
    private long salary;

    public Employee(long id, String username, String name, long salary) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public long getSalary() {
        return salary;
    }

}
