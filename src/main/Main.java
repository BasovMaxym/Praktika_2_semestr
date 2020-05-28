package main;

import person.Person;

import java.io.FileWriter;

import java.io.IOException;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws IOException {

        Person[] people = {

                new Person("Кирова 32","Maksym","Basov",20,2000,3,2),

                new Person("Пархоменка 45","Misha","Gienko",19,2000,9,11),

                new Person("Пархоменка 45","Yura","Pahota",21,1999,3,15),

                new Person("Кирова 32","Andrey","Osokin",22,1998,5,25)

        };

        FileWriter file = new FileWriter("result.txt",true);

        Scanner enter = new Scanner(System.in);

        System.out.println("Введите фамилию для поиска в базе:");

        String findSurname = new String(enter.nextLine());

        for (Person person:people)
        {

            if(findSurname.equals(person.getSurname()) == true)
            {

                System.out.println(person.getName() + " " + person.getSurname());

                file.write(person.getName() + " " + person.getSurname() + "\n");

            }

        }

        System.out.println("Введите адрес по которому хотите найти человека:");

        String findAddress = new String(enter.nextLine());

        for (Person person:people)
        {

            if(findAddress.equals(person.getAddress()) == true)
            {

                System.out.println("На улице " + findAddress + " проживает " + person.getName() + " " + person.getSurname());

                file.write("На улице " + findAddress + " проживает " + person.getName() + " " + person.getSurname() + "\n");

            }

        }

        System.out.println("Введите дату начала и дату окончания для поиска людей:");

        int yearStart  = enter.nextInt();

        int yearFinish = enter.nextInt();

        for (Person person:people)
        {

            if(person.getYearBirthday()>= yearStart && person.getYearBirthday()<=yearFinish)
            {

                System.out.println(person.getName() + " " + person.getSurname() + " входит в етот диапазон!");

                file.write(person.getName() + " " + person.getSurname() + " входит в етот диапазон!" + "\n");

            }

        }

        int buffHigh = people[0].getYear();

        int buffIndexHigh = 0;

        int buffLow = people[0].getYear();

        int buffIndexLow = 0;

        for (int i = 1;i < people.length; i++)
        {

            if (buffHigh < people[i].getYear())
            {

                buffHigh = people[i].getYear();

                buffIndexHigh = i;

            }

            if (buffLow > people[i].getYear())
            {

                buffLow = people[i].getYear();

                buffIndexLow = i;

            }


        }

        System.out.println("Найстарший - " + people[buffIndexHigh].getName() + " " + people[buffIndexHigh].getSurname());

        file.write( "Найстарший - " + people[buffIndexHigh].getName() + " " + people[buffIndexHigh].getSurname() + "\n");

        System.out.println("Наймолодший - " + people[buffIndexLow].getName() + " " + people[buffIndexLow].getSurname());

        file.write( "Наймолодший - " + people[buffIndexLow].getName() + " " + people[buffIndexLow].getSurname() + "\n");

        for (int i = 0; i < people.length; i++)
        {

            System.out.println("C " + people[i].getName() + " на одной улице проживает:" );

            file.write( "C " + people[i].getName() + " на одной улице проживает:" + "\n");

            for(int j = 0; j < people.length;j++)
            {

                if(i != j && people[i].getAddress().equals(people[j].getAddress()) == true)
                {

                    System.out.println(people[j].getName());

                    file.write(people[j].getName()  + "\n");

                }

            }

        }

        file.flush();

    }

}
