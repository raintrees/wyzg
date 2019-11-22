package com.wyzg;


import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while(i<=0){
            try{
                double pro,pro1;
                System.out.println("输入 ");
                pro = scanner.nextDouble();
                System.out.println("输入 ");
                pro1 = scanner.nextDouble();
                System.out.println(pro + "+" + pro1 );
            }catch (Exception e){
                System.out.println("错误");
            }finally {

            }
        }

    }
}
