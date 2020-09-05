package disc;

import java.util.ArrayList;

public class Week1 {
    static class People {
        public People(String n, int a) {
            this.name = n;
            this.age = a;
        }

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    /**
     * Calculates how many mutations from each people since their inception.
     * @param t - How many times that person will mutate each year.
     * @param p - The person, used to get their age
     * @return - Returns int, of total number of mutation after t years.
     */
    static int mutations(int t, People p) {
        return (int) Math.pow((double) p.getAge(), (double) t);
    }

    public static ArrayList<People> peopleDB = new ArrayList();

    public static void main(String[] args) {
        People mark = new People("Mark", 28);
        People yael = new People("Yael", 33);
        People kathy = new People("Kathy", 21);

        peopleDB.add(yael);
        peopleDB.add(mark);
        peopleDB.add(kathy);

        // Times each person will mutate.
        int mutations = 2;

        System.out.println("List of people in PeopleDB: \n");
        for (People p : peopleDB) {
            System.out.println("p.getName() = " + p.getName());
            System.out.println("p.getAge() = " + p.getAge());
            System.out.println("mutations = " + mutations(mutations, p));
            System.out.println("\n");
        }

    }

}

