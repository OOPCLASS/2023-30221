import java.util.Random;

public class Exercitiul5 {


    int selectedNumbers =6;
    int possibleNumbers=49;

    public int combinations(int n,int k)
    {
        int c=fact(n)/ (fact(k) * fact(n-k));
        return c;
    }

    public int fact(int n)
    {
        int f=1;
        for(int i=1;i<=n;i++)
            f=f*i;
        return f;
    }
    public void chancesToWin()
    {
        //calculam nr de cazuri posibile: combinari de 49 luate cate 6

        double possibleCases = combinations(possibleNumbers,selectedNumbers);

        double favorableCases=1;

        System.out.println("Sansele de castig la loto 6/49 sunt:" + favorableCases +"/" + possibleCases);


    }

    public void simulation()
    {
        Random rand= new Random();
        int[] numbers= new int[6];

        for(int i=0;i<6;i++)
        {
            int generatedNumber;
            do
            {
                generatedNumber = rand.nextInt(49) + 1;

            }while(isValid(numbers,generatedNumber));   // verificam sa nu se repete acelasi numar de doua ori

            numbers[i]=generatedNumber;
        }
        System.out.println("Numerele la extragerea 6 din 49 sunt: ");
        for(int i=0;i<6;i++)
            System.out.println(numbers[i]);
    }

    public boolean isValid(int[] numbers,int generatedNumber)
    {
        for(int element:numbers)
        {
            if(element==generatedNumber)
                return true;
        }
        return false;
    }


}
