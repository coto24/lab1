package com.company;

import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        /*{
            int[] noten = {42, 37, 88, 91, 55, 43};
            University University1=new University(noten);
            int[] rez1 = University.nicht_ausreichende_Note();
            System.out.println("Aufgabe 1");
            University.print_list(rez1);
            System.out.println("");
            System.out.println(University.durchschnittswert());
            System.out.println("");
            University.print_list(University.abgerundete_noten_array());
            System.out.println("");
            System.out.println(University.max_abgerundete_note());
            System.out.println("");
        }*/

        /*{
            int[] aux={1,2,3,4,5};
            Array array1=new Array(aux);
            System.out.println("Aufgabe 2");
            System.out.println(Array.max());
            System.out.println("");
            System.out.println(Array.min());
            System.out.println("");
            System.out.println(Array.max_sum());
            System.out.println("");
            System.out.println(Array.min_sum());
            System.out.println("");
        }*/

        /*{
            int[] nr1 = {1,9,7,2}, nr2 ={9,3,4,5};
            grosse_Zahlen.print(grosse_Zahlen.summe(nr1, nr2));
            nr1 = new int[]{1, 9, 7, 2};
            nr2 = new int[]{9, 3, 4, 5};
            grosse_Zahlen.print(grosse_Zahlen.differenz(nr1, nr2));
            nr1 = new int[]{1, 9, 7, 2};
            nr2 = new int[]{9, 3, 4, 5};
            grosse_Zahlen.print(grosse_Zahlen.differenz(nr2, nr1));
            nr1 = new int[]{1, 9, 7, 2};
            grosse_Zahlen.print(grosse_Zahlen.multiplikation(nr1, 5));
            nr2 = new int[]{2,3,6,0,0,0};
            grosse_Zahlen.print(grosse_Zahlen.division(nr2, 2));
        }*/

        {
            int [] tastatur={40,35,70,15,45};
            System.out.println(Preis.min_preis(tastatur));
            tastatur=new int[]{15,20,10,35};
            int [] usb={20, 15, 40, 15};
            System.out.println(Preis.max_preis(tastatur,usb));
            int[] preise={15,45,20};
            System.out.println(Preis.teuerste_im_budget(preise,30));
            tastatur=new int[]{40,50,60};
            usb=new int[]{8,12};
            System.out.println(Preis.teuerste_im_budget(tastatur, usb,60));
            tastatur=new int[]{60};
            usb=new int[]{8,12};
            System.out.println(Preis.teuerste_im_budget(tastatur, usb,60));
            tastatur=new int[]{40,60};
            usb=new int[]{8,12};
            System.out.println(Preis.teuerste_im_budget(tastatur, usb,60));

        }
    }
}

class University{
    static int[] noten;
    public University(int @NotNull[] _noten) {noten=_noten;}

    public static int[] nicht_ausreichende_Note(){
        int[] list=new int[noten.length];
        int poz=0;
        for (int i : noten) {
            if(runden(i)<40){
                list[poz]=i;
                poz++;
            }
        }
        return list;
    }

    public static int runden(int x){
        return (int) Math.ceil(x);
    }

    public static void print_list(int @NotNull [] list){
        for(int i : list)
            if(i>0)
                System.out.println(i);
    }

    public static double durchschnittswert(){
        int sum=0;
        for(int i:noten){
            sum+=runden(i);
        }
        return sum/noten.length;
    }

    public static int [] abgerundete_noten_array(int @NotNull [] list){
        int[] aux=new int[list.length];
        for(int i=0;i<list.length;i++)
            aux[i]=runden(list[i]);
        return aux;
    }

    public static int [] abgerundete_noten_array(){
        return abgerundete_noten_array(noten);
    }

    public static int max_abgerundete_note(){
        int max=0;
        for(int i:abgerundete_noten_array(noten))
            if(i>max)
                max=i;
        return max;
    }
}

class Array{
    static int[] list;
    public Array(int @NotNull[] _list) {list=_list;}

    public static int max(int @NotNull [] liste) throws Exception {
        if(liste.length==0)
            throw new Exception("no elements");

        int maxx=liste[0];
        for(int i: liste){
            if(i>maxx)
                maxx=i;
        }
        return maxx;
    }

    public static int min(int @NotNull [] liste) throws Exception {
        if(liste.length==0)
            throw new Exception("no elements");

        int minn=liste[0];
        for(int i: liste){
            if(i<minn)
                minn=i;
        }
        return minn;
    }

    public static int min() throws Exception {
        return min(list);
    }

    public static int max() throws Exception {
        return max(list);
    }

    public static int max_sum() throws Exception {
        int sum=0;
        for(int i:list)
            sum+=i;
        return sum-min(list);
    }

    public static int min_sum() throws Exception {
        int sum=0;
        for(int i:list)
            sum+=i;
        return sum-max(list);
    }
}

class grosse_Zahlen{

    static public void print(int @NotNull [] nr){
        for(int i: nr) {
            System.out.print(i);
        }
        System.out.println("");
    }

    static public int[] da_mai_departe(int @NotNull [] nr){
        //1,12,11,7

        for(int i=nr.length-1;i>0;i--){
            if(nr[i]>=10){
                nr[i-1]+=nr[i]/10;
                nr[i]%=10;
            }
        }

        if(nr[0]>10){
            int[] rez=new int [nr.length+1];
            rez[0]=nr[0]%10;
            for(int i=0;i<nr.length;i++){
                rez[i+1]=nr[i];
            }
            rez[1]%=10;
            return rez;
        }
        return nr;
    }

    static public int[] summe(int @NotNull [] nr1, int @NotNull [] nr2){
        int[] rez=nr1;
        for(int i=nr1.length-1;i>=0;i--)
            rez[i] += nr2[i];
        return da_mai_departe(rez);
    }

    static public int[] differenz(int @NotNull [] nr1, int @NotNull [] nr2){
        //de verificat
        // 1 9 7 2
        //9 3 4 5
        int [] rez;
        int j=0;
        while(nr1[j]==nr2[j])
            j++;
        boolean ok= (nr1[j]>nr2[j]);
        //caz1: nr1 >=nr2
        //caz2: nr2 > nr1
        if(ok) {
            System.out.println("caz 1");
            rez=nr1;
            for (int i = nr1.length-1; i >0; i--)
                if(rez[i]>=nr2[i])
                    rez[i] -= nr2[i];
                else{
                    rez[i-1]--;
                    rez[i]+=10;
                    rez[i] -= nr2[i];
                }
            rez[0]-=nr2[0];
        }
        else{
            System.out.println("caz 2");
            rez=nr2;
            //9 3 4 5
            //1 9 7 2
            for (int i = nr1.length-1; i>0; i--)
                if(rez[i]>=nr1[i])
                    rez[i] -= nr1[i];
                else{
                    rez[i-1]--;
                    rez[i]+=10;
                    rez[i] -= nr1[i];
                }
                rez[0]-=nr1[0];
        }
        return rez;
    }

    static public int[] multiplikation(int @NotNull [] nr, int z){
        int[] rez=nr;
        for(int i=nr.length-1;i>=0;i--){
        rez[i] *= z;
        }
        return da_mai_departe(rez);
    }

    static public int[] division(int @NotNull [] nr, int z){
        int[] rez=nr;
        //236000 / 2
        //
        for(int i=0;i<nr.length-1;i++){
            int rest= rez[i]%z;
            rez[i] /= z;
            rez[i+1] += 10*rest;
        }
        rez[nr.length-1]/=z;
        return rez;
    }

}

class Preis{

    static public int min_preis(int @NotNull [] preisen){
        int minn=preisen[0];

        for(int i:preisen)
            if(i<minn)
                minn=i;

        return minn;
    }

    static public int max_preis(int @NotNull [] tastatur, int @NotNull [] usb){
        int maxx=-1;

        for(int i:tastatur)
            if(i>maxx)
                maxx=i;
        for(int i:usb)
            if(i>maxx)
                maxx=i;

        return maxx;
    }

    static public int teuerste_im_budget(int @NotNull [] preisen, int budget){
        int maxx=-1;

        for(int i:preisen)
            if(i<budget && maxx<i)
                maxx=i;

        return maxx;
    }


    static public int teuerste_im_budget(int @NotNull [] tastatur, int @NotNull [] usb, int budget){
        int maxx=-1;

        for(int i:tastatur)
            for(int j:usb)
                if(i+j<budget && i+j>maxx)
                    maxx=i+j;

        return maxx;
    }
}