public class 오토박싱연산과동일타입연산 {

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

        /*Long에서 long으로  오토 박싱 연산 시 동일 타입 연산에 비해 속도가 느리고
        * 100만 건 기준에서 는 약 5까지 차이가 난다
        * */
        System.out.println("오토 박싱 연산 : " + (System.currentTimeMillis() - t) + " ms");
        System.out.println("동일 타입 연산 : " + (System.currentTimeMillis() - t)  + " ms");
    }
}
