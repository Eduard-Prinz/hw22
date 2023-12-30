package mapDd.HW112.model;

import java.util.Objects;

public record Employee(String firstName, String lastName, int salary, int departmentId) {

    @Override
    public String toString() {
        return lastName + firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}