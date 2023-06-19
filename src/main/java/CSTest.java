public class CSTest {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        Long sum = 0L;

        long k = System.currentTimeMillis();
        long mou = 0L;

        for(long i = 0; i<100000000; i++) {
            sum+=1;
        }

        for (long s = 0; s < 100000; s++) {
            mou+=1;
        }


        System.out.println("오토 박싱 연상 : " + (System.currentTimeMillis() - t) + " ms");
        System.out.println("동일 타입 연산 : " + (System.currentTimeMillis() - t)  + " ms");
    }
}
