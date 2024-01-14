// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem management=new EmployeeManagementSystem();
        management.hirePerson("Alex","Developer",1);
        management.hirePerson("Ion","Project Manager",2);
        management.hirePerson("Ana","Developer",3);
        management.hirePerson("Andrei","Project Manager",4);
        management.hirePerson("Ioan","Developer",5);
        management.hirePerson("Toni","Project Manager",6);
        management.hirePerson("Tudor","Project Manager",7);
        management.hirePerson("Bogdan","Developer",8);
        management.hirePerson("Jon","Project Manager",9);
        management.hirePerson("Ioana","Developer",10);
        management.hirePerson("Alex","Developer",11);
        management.hirePerson("Ion","Project Manager",12);
        management.hirePerson("Ana","Developer",13);
        management.hirePerson("Andrei","Project Manager",14);
        management.hirePerson("Ioan","Developer",15);
        management.hirePerson("Toni","Project Manager",16);
        management.hirePerson("Tudor","Project Manager",17);
        management.hirePerson("Bogdan","Developer",18);
        management.hirePerson("Jon","Project Manager",19);
        management.hirePerson("Ioana","Developer",20);

        String[] Req1={"Developer","Project Manager"};
        String[] Req2={"Project Manager"};
        management.createProject("Tema1",Req1,1);
        management.createProject("Tema2",Req1,2);
        management.createProject("Tema3",Req2,3);

    }E
}