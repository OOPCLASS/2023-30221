public class Exercitiul3 {

    String s;

    public Exercitiul3(String s)
    {
        this.s=s;
    }

    public void nrOfVocalsAndConsonants()
    {
        int consonants=0;
        int vocals=0;

        s = s.toLowerCase();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z')
            {
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
                {
                    vocals++;
                }
                else
                {
                    if(ch!=' ')
                         consonants++;
                }
            }
        }

        System.out.println("Numar de vocale: " + vocals);
        System.out.println("Numar de consoane: " + consonants);
    }


}

