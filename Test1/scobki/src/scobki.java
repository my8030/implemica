/**
 * Create by Misha Kalashnikov
 */
public class scobki {
    //Возвращает количество правильных последовательностей
    public int getscobki(int number){
        final int MINNumber = 0;
        final int FirstSCOBKI = 1 ;
        int sum = 0;
        // возвращает первое значение если введенное равно 0
        if(number == MINNumber){
            return FirstSCOBKI;
        }
        // вычисление числа из ряда
        for (int i = 0; i < number; i++){
            sum += getscobki(i)* getscobki((number-1)-i);
        }
        return sum;
    }
}
