package person;

import address.Address;

import java.util.Calendar;

import java.util.Date;

public class Person extends Address
{

    public Person(String address, String name,String surname,int year,int yearBirthday,int monthBirthday,int dayBirthday)
    {

        super(address);

        this.name = name;

        this.surname = surname;

        this.year = year;

        this.birthday = Calendar.getInstance();

        this.yearBirthday = yearBirthday;

        this.birthday.set(yearBirthday,monthBirthday,dayBirthday);

    }


    public String getName()
    {

        return this.name;

    }

    public String getSurname()
    {

        return this.surname;

    }

    public int getYear()
    {

        return this.year;

    }

    public Date getBirthday()
    {

        return this.birthday.getTime();

    }

    public int getYearBirthday()
    {

        return this.yearBirthday;

    }

    private String name;

    private String surname;

    private int year;

    private Calendar birthday;

    private int yearBirthday;

}
