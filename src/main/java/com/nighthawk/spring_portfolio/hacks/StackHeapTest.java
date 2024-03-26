package com.nighthawk.spring_portfolio.hacks;

public class StackHeapTest {
    public int n=5; //primitive data type on the heap
    public String a="string";//non-primitive data on the heap
    public double m = 3.5;//primitive data type on the heap
    public char c = 'a';//primitive data type on the heap

    public static void changeInt(int nValue, int nRefN, StackHeapTest nRef) {
        System.out.println("\nthe n value before: " + nValue + "\t The nRefn value before: " + nRefN + "\t The nRef.n value before: " + nRef.n);
        nValue+=10;
        nRefN+=10;
        nRef.n+=10;
        System.out.println("The n value after: " + nValue + "\t The nRefn value after: " + nRefN + "\t The nRef.n value after: " + nRef.n);
    }

    public static void changeString(String aValue, String nRefA, StackHeapTest nRef) {
        System.out.println("\nthe a value before: " + aValue + "\t The nRefA value before: " + nRefA + "\t The nRef.a value before: " + nRef.a);
        aValue+="s";
        nRefA+="s";
        nRef.a+="s";
        System.out.println("The a value after: " + aValue + "\t The nRefA value after: " + nRefA + "\t The nRef.a value after: " + nRef.a);
    }

    public static void changeDouble(double mValue, double nRefM, StackHeapTest nRef) {
        System.out.println("\nthe m value before: " + mValue + "\t The nRefM value before: " + nRefM + "\t The nRef.m value before: " + nRef.m);
        mValue+=1.2;
        nRefM+=1.2;
        nRef.m+=1.2;
        System.out.println("The m value after: " + mValue + "\t The nRefM value after: " + nRefM + "\t The nRef.m value after: " + nRef.m);
    }

    public static void changeChar(char cValue, char nRefC, StackHeapTest nRef) {
        System.out.println("\nthe c value before: " + cValue + "\t The nRefC value before: " + nRefC + "\t The nRef.c value before: " + nRef.c);
        cValue+='b';
        nRefC+='b';
        nRef.c+='b';
        System.out.println("The c value after: " + cValue + "\t The nRefC value after: " + nRefC + "\t The nRef.c value after: " + nRef.c);
    }

    public static void main(String[] args) {
        int n = 5; //primitive data type on the stack
        String a = "string";//non primitive data on stack
        double m = 3.5;//primitive data on stack
        char c = 'a';//primitive data on the stack
        StackHeapTest nRef = new StackHeapTest();
        System.out.println("\nn before: " + n + "\tHashCode of n before: " + System.identityHashCode(n));
        System.out.println("nRef.n before: " + nRef.n);
        System.out.println("HashCode of nRef.n before: " + System.identityHashCode(nRef.n) + "\tHashCode of nRef before: " + System.identityHashCode(nRef));
        changeInt(n, nRef.n, nRef);//stack by value, heap by value, heap by reference
        System.out.println("\nn after: " + n + "\tHashCode of n after: " + System.identityHashCode(n));
        System.out.println("nRef.n after: " + nRef.n);
        System.out.println("HashCode of nRef.n after: " + System.identityHashCode(nRef.n) + "\tHashCode of nRef after: " + System.identityHashCode(nRef));

        System.out.println("\na before: " + a + "\tHashCode of a before: " + System.identityHashCode(a));
        System.out.println("nRef.a before: " + nRef.a);
        System.out.println("HashCode of nRef.a before: " + System.identityHashCode(nRef.a) + "\tHashCode of nRef before: " + System.identityHashCode(nRef));
        changeString(a, nRef.a, nRef);//stack by value, heap by value, heap by reference
        System.out.println("\na after: " + a + "\tHashCode of a after: " + System.identityHashCode(a));
        System.out.println("nRef.a after: " + nRef.a);
        System.out.println("HashCode of nRef.a after: " + System.identityHashCode(nRef.a) + "\tHashCode of nRef after: " + System.identityHashCode(nRef));

        System.out.println("\nm before: " + m + "\tHashCode of m before: " + System.identityHashCode(m));
        System.out.println("nRef.m before: " + nRef.m);
        System.out.println("HashCode of nRef.m before: " + System.identityHashCode(nRef.m) + "\tHashCode of nRef before: " + System.identityHashCode(nRef));
        changeDouble(m, nRef.m, nRef);//stack by value, heap by value, heap by reference
        System.out.println("\nm after: " + m + "\tHashCode of m after: " + System.identityHashCode(m));
        System.out.println("nRef.m after: " + nRef.m);
        System.out.println("HashCode of nRef.m after: " + System.identityHashCode(nRef.m) + "\tHashCode of nRef after: " + System.identityHashCode(nRef));

        System.out.println("\nc before: " + c + "\tHashCode of c before: " + System.identityHashCode(c));
        System.out.println("nRef.c before: " + nRef.c);
        System.out.println("HashCode of nRef.c before: " + System.identityHashCode(nRef.c) + "\tHashCode of nRef before: " + System.identityHashCode(nRef));
        changeChar(c, nRef.c, nRef);//stack by value, heap by value, heap by reference
        System.out.println("\nc after: " + c + "\tHashCode of c after: " + System.identityHashCode(c));
        System.out.println("nRef.c after: " + nRef.c);
        System.out.println("HashCode of nRef.c after: " + System.identityHashCode(nRef.c) + "\tHashCode of nRef after: " + System.identityHashCode(nRef));
    }
}
