public class Main {

    public static void main(String[] args)
    {

        Exercitiul1 m= new Exercitiul1(10);
        Exercitiul1 n= new Exercitiul1(50);
        Exercitiul1 k= new Exercitiul1(10);
        for(k.val=m.val;k.val<=n.val;k.val++)
            k.checkGoldbach();


        Exercitiul3 el=new Exercitiul3("Ana are mere");
        el.nrOfVocalsAndConsonants();

        Exercitiul5 x= new Exercitiul5();

        x.simulation();

    }
}
