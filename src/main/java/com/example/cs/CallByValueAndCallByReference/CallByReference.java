package com.example.cs.CallByValueAndCallByReference;

public class CallByReference {
    int value;

    public CallByReference(int value) {
        this.value = value;
    }

    private static void swap(CallByReference n) {
        n.value = 20;
    }

    public void call_by_reference_main() {
       CallByReference n = new CallByReference(10);

        System.out.println(n.value);
        swap(n);
        System.out.println(n.value);
    }
}
