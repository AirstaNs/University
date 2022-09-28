package ru.usatu.students.model;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String number;
    private String phone;

    public Student(){}

    public Student(int id, String surname, String name, String patronymic, String number, String phone){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.number = number;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {this.number = number; }

    public void setSurName(String surname) {this.surname = surname;}

    public void setPatronymic(String patronymic) {this.patronymic = patronymic; }

    public void setPhone(String phone) {this.phone = phone; }

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
