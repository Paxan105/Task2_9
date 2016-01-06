package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {


    /*

    Все задания реализованы в виде функций

    */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите n(количество чисел): ");

        int n = Integer.parseInt(scanner.next());

        if(n>0) {

            System.out.println("Задание 9:");
            int a[][] = fun_9(n);


            ///9.1


            System.out.println("Задание 9.1:");
            fun_9_1(a);


            ////9.2


            System.out.println("Задание 9.2:");

            System.out.print("Введите число сдвига k :");
            int k = Integer.parseInt(scanner.next());

            scanner.close();

            if(k>0) {

                //// Сдвигаем в право
                System.out.println("9.2: сдвиг вправо");
                shift_right(fun_9(n), k);


                /////Сдвигаем влево

                System.out.println();
                System.out.println("9.2: сдвиг влево");
                shift_left(fun_9(n), k);


                System.out.println();
                System.out.println("9.2: сдвиг вверх");
                shift_up(fun_9(n), k);


                System.out.println();
                System.out.println("9.2: сдвиг вниз");
                shift_down(fun_9(n), k);

            }else System.out.println("k не может быть меньше 1");

            System.out.println();


            System.out.println("Задание 9.3:");
            System.out.println();

            fun_9_3(fun_9(n));


            ///// 9.4


            System.out.println("Задание 9.4:");

            fun_9_4(fun_9(n));


            System.out.println("Задание 9.5:");

            a = fun_9(n);

            System.out.println();
            System.out.println("Поворот на 90 грудусов:");
            a = turn_90(a);                 //// Поворот на 90 грудусов
            System.out.println("Поворот на 180 грудусов:");
            a = turn_90(a);                 //// Поворот на 180 грудусов
            System.out.println("Поворот на 270 грудусов:");
            a = turn_90(a);                 //// Поворот на 270 грудусов


            System.out.println();
            System.out.println("Задание 9.6:");
            System.out.println();

            fun_9_6(fun_9(n));


            System.out.println("Задание 9.7:");
            System.out.println();

            fun_9_7(fun_9(n));


            System.out.println();
            System.out.println("Задание 9.8:");
            System.out.println();

            fun_9_8(fun_9(n));

        } else System.out.println("n не может быть меньше 1");
    }



    static int[][] fun_9(int n){
        System.out.println();

        Random random = new Random();

        int a[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = random.nextInt(n*2)-n;
            }
        }


        System.out.println("Наша матрица:");
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                System.out.print(a[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println();
        return a;
    }   ////++++++

    static void fun_9_1(int a1[][]){
        //// Берем матрицу из 9 задания


        //// Упорядочим по строкам
        for(int i=0; i<a1.length; i++) {
            for(int j=0; j<a1.length;j++)
                for(int k=0; k<a1.length;k++)
                    if (a1[i][j] < a1[i][k]) {
                        int tmp = a1[i][j];
                        a1[i][j] = a1[i][k];
                        a1[i][k] = tmp;
                    }

        }

        System.out.println("Упорядочили матрицу в порядке возростания по строкам:");
        for(int i=0; i<a1.length;i++){
            for(int j=0; j<a1.length;j++){
                System.out.print(a1[i][j]+"    ");
            }
            System.out.println();
        }

        System.out.println();

        //// Упорядочим по столбцам

        for(int i=0; i<a1.length; i++) {
            for(int j=0; j<a1.length;j++)
                for(int k=0; k<a1.length;k++)
                    if (a1[j][i] < a1[k][i]) {
                        int tmp = a1[j][i];
                        a1[j][i] = a1[k][i];
                        a1[k][i] = tmp;
                    }

        }

        System.out.println("Упорядочили матрицу в порядке возростания по столбцам:");
        for(int i=0; i<a1.length;i++){
            for(int j=0; j<a1.length;j++){
                System.out.print(a1[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println();
    } ////++++


    public static void shift_right(int a[][], int k){

        for(int i=0; i<k; i++)
            for(int j=0;j<a.length; j++) {
                for (int l = a.length - 1; l > 0; l--) {
                    a[j][l] = a[j][l - 1];
                }
            }

        for(int i=0; i<k;i++){
            for(int j =0; j<a.length; j++){
                a[j][i]=0;
            }
        }

        System.out.println("Сдвигаем вправо на " + k +" :");
        for(int i=0; i<a.length;i++){
            for(int j=0; j<a.length;j++){
                System.out.print(a[i][j]+"    ");
            }
            System.out.println();
        }

    }  ///++++


    public static void shift_left(int a[][], int k){

        for(int i=0; i<k; i++)
            for(int j=0;j<a.length; j++) {
                for (int l = 0; l < a.length-1; l++) {
                    a[j][l] = a[j][l+1];
                }
            }

        for(int i=a.length-1; i>a.length-1-k;i--){
            for(int j =a.length-1; j>-1; j--){
                a[j][i]=0;
            }
        }

        System.out.println("Сдвигаем влево на " + k +" :");
        for(int i=0; i<a.length;i++){
            for(int j=0; j<a.length;j++){
                System.out.print(a[i][j]+"    ");
            }
            System.out.println();
        }
    }  ///++++


    static void shift_up(int a[][],int k){

        for(int i=0; i<k; i++)
            for(int j=0;j<a.length; j++) {
                for (int l = 0; l < a.length-1; l++) {
                    a[l][j] = a[l+1][j];
                }
            }

        for(int i=a.length-1; i>a.length-1-k;i--){
            for(int j =a.length-1; j>-1; j--){
                a[i][j]=0;
            }
        }

        System.out.println("Сдвигаем вверх на " + k +" :");
        for(int i=0; i<a.length;i++){
            for(int j=0; j<a.length;j++){
                System.out.print(a[i][j]+"    ");
            }
            System.out.println();
        }
    }  ///++++


    static void shift_down(int a[][],int k){

        for(int i=0; i<k; i++)
            for(int j=0;j<a.length; j++) {
                for (int l = a.length-2; l > -1; l--) {
                    a[l+1][j] = a[l][j];
                }
            }

        for(int i=0; i<k;i++){
            for(int j =0; j<a.length; j++){
                a[i][j]=0;
            }
        }

        System.out.println("Сдвигаем вниз на " + k +" :");
        for(int i=0; i<a.length;i++){
            for(int j=0; j<a.length;j++){
                System.out.print(a[i][j]+"    ");
            }
            System.out.println();
        }


    }  ///++++

    static void fun_9_3(int a[][]){
        int voz=0,voz1=0,voz_i=0,voz_j=0,ub=0,ub1=0,ub_i=0,ub_j=0;

        for(int i=0; i<a.length; i++){              ///// Ищем возростающую последовательность
            if(i>0 && a[i-1][a.length-1]<a[i][0]){
                voz1++;
            }else {
                if (voz < voz1) {
                    voz = voz1;
                    voz_i=i-1;
                    voz_j=a.length-(voz-1);
                }
                voz1=0;
            }
            for(int j=0; j<a.length-1; j++)
            {
                if(a[i][j]<a[i][j+1]){
                    voz1++;
                }else {
                    if (voz < voz1) {           ///// сохраняем количество убывающих элементов
                        voz = voz1;             //// и координаты начала последовательности
                        if(j>=(voz-1)) {
                            voz_i = i;
                            voz_j = j - (voz - 1);
                        } else{
                            voz_i = i-1;
                            voz_j = (j+a.length) - (voz - 1);
                        }
                    }
                    voz1=0;
                }


            }
        }
        System.out.println("Наибольшее число возрастающих элементов матрицы, идущих подряд: "+voz);
        System.out.println("Начало последовательности с элемента  а["+voz_i+"]["+voz_j+"]");

        for(int i=0; i<a.length; i++){              ///// Ищем убывающую последовательность
            if(i>0 && a[i-1][a.length-1]>a[i][0]){
                ub1++;
            } else{
                if (ub < ub1) {
                    ub = ub1;
                    ub_i=i-ub;
                    ub_j=a.length-(ub-1);

                }
                ub1=0;;
            }
            for(int j=0; j<a.length-1; j++)
            {
                if(a[i][j]>a[i][j+1]){
                    ub1++;
                }else {
                    if (ub < ub1) {                 ///// сохраняем количество убывающих элементов
                        ub = ub1;                   ///// и координаты начала последовательности
                        if(j>=(ub-1)) {
                            ub_i = i;
                            ub_j = j - (ub - 1);
                        } else{
                            ub_i = i-1;
                            ub_j = (j+a.length) - (ub - 1);
                        }


                    }
                    ub1=0;
                }


            }
        }
        System.out.println("Наибольшее число убывающих элементов матрицы, идущих подряд: "+ub);
        System.out.println("Начало последовательности с элемента  а["+ub_i+"]["+ub_j+"]");


        System.out.println();
    }       /////+++

    static void fun_9_4(int a[][]){
        int p1=-1,p2=-1,summa;
        boolean fl_1,fl_2;


        for(int i=0; i<a.length; i++){
            summa=0;
            fl_1=fl_2=false;
            for (int j=0; j<a.length; j++){
                if((a[i][j]>-1) && !fl_2 && fl_1){
                    fl_2=true;
                    p2=j;                           /// Записываем индекс второго полож. числа
                }

                if(((a[i][j])>-1) && !fl_1){
                    fl_1=true;
                    p1=j;                           /// Записываем индекс первого полож. числа
                }
                if(fl_1 && fl_2){
                    break;
                }
            }

            for(int j=p1+1; j<p2; j++){
                summa+=a[i][j];
            }

            System.out.println(p1==-1 || p2==-1 ? "В строке "+i+" нет двух положительных чисел." : "Сумма строки "+ i + " между элементами "+ a[i][p1] +" и "+ a[i][p2] +" : "+ summa );

        }

        System.out.println();

    }  /////+++


    static int[][] turn_90(int a[][]){
        int n=a.length,b;
        for (int i=0;i<n/2;i++)
            for (int j=i;j<n-1-i;j++) {
                b=a[i][j];
                /*
                a[i][j]=a[n-j-1][i];
                a[n-j-1][i]=a[n-i-1][n-j-1];
                a[n-i-1][n-j-1]=a[j][n-i-1];
                a[j][n-i-1]=b;
                */
                a[i][j]=a[j][n-1-i];
                a[j][n-1-i]=a[n-1-i][n-1-j];
                a[n-1-i][n-1-j]=a[n-1-j][i];
                a[n-1-j][i]=b;
            }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(a[i][j]+"    ");
            }
            System.out.println();
        }

        return a;
    }



    static void fun_9_6(int a[][]){
        int sred=0;
        Random random = new Random();

        /*
        Для n=10!!!
            Так как матрица у нас заполняется рандомом (-n до n) то среднее число выходит не большое( обычно между -100 до 100)
            и при дилении этого числа на количество элементов матрицы(у нас 100) мы получаем 0, так как матрица int-ова.
            По условию(я так понял) нужно работать с матрицой из 9 задания.
            Есть 2 решения 1(мое решение): Переписать все элементы  (у меня рандом от 0 до 10)
            2: перенести значения из масива в новый масив float

        */

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){          //// заполняем рандомом от 0 до 10
                a[i][j] = random.nextInt(10);
            }
        }

        System.out.println("Наша матрица:");
        for (int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){          ////// выводим новый масив на консоль
                sred+=a[i][j];
                System.out.print(a[i][j] + "    ");
            }
            System.out.println();
        }


        sred=sred/(a.length*a.length);
        System.out.println();
        System.out.println("Среднее арифметическое:" + sred);
        System.out.println();

        for (int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){          /////// выводим обработаный масив
                a[i][j]-=sred;
                System.out.print(a[i][j] + "    ");
            }
            System.out.println();
        }

        System.out.println();
    }   ///// +++++


    static void fun_9_7(int a[][])  {
        boolean fl=true;
        int kol_strok=a.length, kol_stolb=a.length;  /// Сохраняем кол столбцов и строк


            /*
            Так как масив заполняется рандомом я запишу нули в одну строку( 3 ) и столбец( 0 ) для проверки функции
     */

        for(int i=0; i<kol_strok;i++)
        {
            a[3][i] = 0;
            a[i][0] = 0;
        }



        System.out.println("Наша матрица c нулями:");
        for (int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){          ////// выводим новый масив на консоль
                System.out.print(a[i][j] + "    ");
            }
            System.out.println();
        }


        for(int i=0; i<kol_strok; i++){     ///// Проверяем строки
            fl=true;

            for(int j=0; j<kol_stolb; j++){
                if(a[i][j]!=0){
                    fl=false;
                    break;
                }
            }

            if(fl){
                for(int j=i; j<kol_strok-1; j++){
                    for(int k=0; k<kol_stolb; k++)
                        a[j][k] = a[j+1][k];
                }
                kol_strok--;
            }
        }


        for(int i=0; i<kol_stolb; i++){     ///// Проверяем солбцы
            fl=true;

            for(int j=0; j<kol_strok; j++){
                if(a[j][i]!=0){
                    fl=false;
                    break;
                }
            }

            if(fl){
                for(int j=i; j<kol_stolb-1; j++){
                    for(int k=0; k<kol_strok; k++)
                        a[k][j] = a[k][j+1];
                }
                kol_stolb--;
            }
        }

        System.out.println();
        for(int i=0; i<kol_strok; i++){
            for(int j=0; j<kol_stolb; j++){
                System.out.print(a[i][j]+"    ");
            }
            System.out.println();
        }

    }    ////++++


    static void fun_9_8(int a[][]){

        for (int i=0; i<a.length; i++){
            for (int j=0; j<a.length; j++){
                if(a[i][j] ==0){
                    for(int k=j; k<a.length-1; k++) {
                        int number = a[i][k+1];
                        a[i][k + 1] = a[i][k];
                        a[i][k] = number;
                    }
                }
            }
        }

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                System.out.print(a[i][j]+"    ");
            }
            System.out.println();
        }


    }      //////++++
}
