import java.math.BigInteger;
/**
 * Create by Misha Kalashnikov
 */

public  class SumFactorial {
    // Метод вычисляет сумму всех чисел факториального числа
        public int getSumFactorial(int num) {

            int sum = 0;

            BigInteger fact = BigInteger.ONE;
// Вычисление факториала числа
             for (int i = 2; i <= num; i++) {
                 fact = fact.multiply(BigInteger.valueOf(i));
             }  String number = String.valueOf(fact);
  // Подсчет суммы всех чисел
         for(int i = 0; i < num ; i++) {
            sum += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
         return sum; }}