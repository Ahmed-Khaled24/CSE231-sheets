package Multi_threading_Sheet;

import Multi_threading_Sheet.Problem6.pb6;
import Multi_threading_Sheet.Problems1_2_3.pb1;
import Multi_threading_Sheet.Problems1_2_3.pb2;
import Multi_threading_Sheet.Problems1_2_3.pb3;
import Multi_threading_Sheet.Problems4_5.pb4;
import Multi_threading_Sheet.Problems4_5.pb5;

;

public class Main{
        public static void main(String[] args) {
                // testProblem1();
                // testProblem2();
                // testProblem3();
                // testProblem4();
                // testProblem5();
                testProblem6();

        }

        private static void testProblem1(){
                pb1.problem1Run();
        }
        private static void testProblem2(){
                pb2.problem2Run();
        }
        private static void testProblem3(){
                pb3.problem3Run();
        }
        private static void testProblem4(){
                pb4.problem4Run();
        }
        private static void testProblem5(){
                pb5.problem5Run();
        }
        private static void testProblem6(){
                pb6.problem6Run();
        }
}
