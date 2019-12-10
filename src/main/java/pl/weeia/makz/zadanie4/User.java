package pl.weeia.makz.zadanie4;

import java.util.Objects;

public class User {
    private String fullName;
    private String firstName;
    private String lastName;
    private String userTitle;

    public User(String fullName){
        this.fullName = fullName;
        String[] splitStr = fullName.split("\\s+");
        this.firstName = splitStr[0];
        this.lastName = splitStr[1];
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userTitle='" + userTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fullName, user.fullName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userTitle, user.userTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, firstName, lastName, userTitle);
    }
}
