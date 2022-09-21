import java.util.Scanner;

/**
 * Программа предназначена для того, чтобы без всяких усилий заполнить дневник самоконтроля
 * Это можно сделать намного проще. Либо через рандом в Excel, либо просто выдумав числа
 * Но я мало того, что балабол, так еще и ленивый. То есть я лучше потрачу день на прогу
 * чем 10 минут на выдумывание.
 * Короче,
 * Как говориться "что по кайфу, то и делаем"
 * @author sanchez
 */

public class ListOfHelth {
    public static void main(String[] args) {
        // надо будет придумать как реализовать (адекватно) смену дат, длительность трени, ЧСС,сон , и самочуствие
        //начнем с даты
        int week = 0;
        Scanner num = new Scanner(System.in);
        System.out.print("Введите дату, которая будет являтся понедельником в недели: " );
        int date = num.nextInt();
        System.out.print("Введите месяц числом: ");
        int mounth = num.nextInt();
        System.out.print("Введите год: ");
        int year = num.nextInt();
        System.out.print("Введите интересуемое вас количество повторений: ");
        int i = num.nextInt();
        while (1 < i+1) { // изменить на for
            System.out.print(date + "." + mounth + "." + year + "\t");  // выводим дату на консоль
            week += 1;                              //нарасчиваем счетчик, который будет держать неделю в рамках
            if (mounth == 1 || mounth == 3 || mounth == 5 || mounth == 7 || mounth == 8 || mounth == 10 || mounth == 12){ //ограничения для тех месяцев, где 31 дней в месяце
                if (week > 2) {                        //когда неделя заканчивается надо прибавить 3, а не два как обычно
                    date += 3;
                    week = 0;
                } else {
                    date +=2;
                }
                if (date > 31) {                        // теперь, если число в месяце выходит за рамки 31, то нарасчиваем месяц, а дату обнуляем до первого числа + разница
                    int tmp = date - 31;
                    mounth += 1;
                    date = tmp;
                    if (mounth > 12){ // создаем переход через года
                        year += 1;
                        mounth = 1;
                    }
                }
            } else if (mounth == 4 || mounth == 6 || mounth == 9 || mounth == 11){ //ограничения для тех месяцев, где 30 дней в месяце
                if (week > 2) {                        //когда неделя заканчивается надо прибавить 3, а не два как обычно
                    date += 3;
                    week = 0;
                } else {
                    date +=2;
                }
                if (date > 30) {                        // теперь, если число в месяце выходит за рамки 30, то нарасчиваем месяц, а дату обнуляем до первого числа + разница
                    int tmp = date - 30;
                    mounth += 1;
                    date = tmp;
                } //специальные условия для февраля, чтоб его леший дрючил
            } else if (year % 4 == 0 && year % 100 != 0 && year % 400 == 0){ // если год високосный то он особенный
                if (week > 2) {                        //когда неделя заканчивается надо прибавить 3, а не два как обычно
                    date += 3;
                    week = 0;
                } else {
                    date +=2;
                }
                if (date > 29) {                        // теперь, если число в месяце выходит за рамки 30, то нарасчиваем месяц, а дату обнуляем до первого числа + разница
                    int tmp = date - 29;
                    mounth += 1;
                    date = tmp;
                }
            } else {
                if (week > 2) {                        //когда неделя заканчивается надо прибавить 3, а не два как обычно
                    date += 3;
                    week = 0;
                } else {
                    date +=2;
                }
                if (date > 28) {                        // теперь, если число в месяце выходит за рамки 30, то нарасчиваем месяц, а дату обнуляем до первого числа + разница
                    int tmp = date - 28;
                    mounth += 1;
                    date = tmp;
                }
            }
            i -= 1;
            // дата выводится почти идеально, но этого вполне достаточно, чтобы начать заполнять остальную таблицу
            int time = (int)(Math.random()*10+15); //заполняем время рандомными значениями
            System.out.print(time + "\t");
            //заполняем объективные показатели. Это ЧЧС и СОН
            int pulsStart = (int)(Math.random()*10+55); //пульс во время старта
            System.out.print(pulsStart + "\t");
            int pulsInTask = (int)(Math.random()*15+105); // пульс во время занятия
            System.out.print(pulsInTask + "\t");
            int pulsAfter = ((pulsStart + pulsInTask) / 2); // пульс спустя 5 минут после занятия
            System.out.print(pulsAfter + "\t");
            int sleep = (int)(Math.random()*5+1); // Выдаем оценку сна
            switch (sleep){
                case (1): System.out.print("Ужасно   " + "\t");
                    break;
                case (2): System.out.print("Терпимо   " + "\t");
                    break;
                case (3): System.out.print("Средне    " + "\t");
                    break;
                case (4): System.out.print("Прекрасно " + "\t");
                    break;
                case (5): System.out.print("Хорошо     " + "\t");
                    break;
                default: System.out.print("А вам какое дело?" + "\t");
                    break;
            }
            //Займемся субъективными показаниями
            byte feelPoints = (byte)(Math.random()*4+1); // присваиваем рандомные значения "самочуствию" по пяти бальной шкале
            System.out.print(feelPoints + "\t");
            // оценики "желанию заниматься" и "настроение" будем выставлять основываясь на самочуствии
            if (feelPoints<3) { // это если самочуствие плохое
                byte wantDo = (byte)(Math.random()*2+1); //рандом "желание заниматься
                System.out.print(wantDo + "\t");
                byte figZnaet = (byte)(Math.random()*2+1); // Даша сказала, что "Фиг Знает" это "Настроение" по английски XD
                System.out.print(figZnaet+"\t");

            } else { //это если самочуствие хорошее
                byte wantDo = (byte)(Math.random()*2+3);
                System.out.print(wantDo + "\t");
                byte figZnaet = (byte)(Math.random()*2+3); // Считай что это пасхалка))) <3
                System.out.print(figZnaet+"\t");
            }
            System.out.println(); //последняя запись, которая отделяет сейчас от потом
        }
    }
}