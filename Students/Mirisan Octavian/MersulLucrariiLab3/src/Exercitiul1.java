public class Exercitiul1 {

    int val;

    public Exercitiul1(int val){

        this.val=val;
    }

    public boolean checkPrime(int n)
    {
        for(int d=2;d<=n/2;d++)
            if(n%d==0)
                return false;
        return true;
    }

    public void checkGoldbach()
    {
        boolean ok;
        if(val%2==0 && val>2)
        {
            ok=false;
            for(int i=2;i<val;i++)
            {
                for(int j=2;j<val;j++)
                {
                    if(checkPrime(i) && checkPrime(j) && i+j==val)
                        ok=true;

                }
            }
            if(ok)
            {
                System.out.println("The "+ val + " verifies the Goldbach theorem");
            }

        }
        else
        {
            System.out.println("The " + val +" number is odd");
        }
    }


}
