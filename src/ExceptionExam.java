public class ExceptionExam {
    public static void main(String[] args){

        int num = 10;
        long num2 = 20L;
        char c = 'A';

        if(true) {    // 컴파일 오류
            System.out.println("hihi");
        }

        // 자바는 컴파일 타임에는 L-value만 계산이 가능하고 R-value는 실행해봐야 알 수 있다.
        int[] arr = new int[3];

        // arr[4] = 10;    // 실행해보기 전에는 모르는 오류 => 런 타임 오류

        // 프로그램 실행 전 코드 보고 변수 크기 계산 => 컴파일 타임
        // 프로그램 실행 중 => 런 타임

        // 예외가 발생하면 프로그램이 종료 된다. => 예외를 잘 처리해서 프로그램이 중단되지 않도록
        try {
            arr[1] = 10;
            String str = "1a";
            int rst = Integer.parseInt(str);
            System.out.println(rst + 3);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("배열 관련 예외 발생");
        } catch (NumberFormatException e){
            System.out.println("숫자 관련 예외 발생");
        } catch (Exception e){
            System.out.println("예외 발생");
        }

        System.out.println("hehe");
    }
}
