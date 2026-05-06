public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int firstFriday = 5 ;
        System.out.println("Задание 1");
        for (int currentFriday = firstFriday; currentFriday <= 31; currentFriday= currentFriday+7) {
            System.out.println("Сегодня пятница, " + currentFriday + "-е число. Необходимо подготовить отчет.");
        }

        int totalDistance = 42195;
        int interval = 500;
        int currentDistance = 0;
        System.out.println();
        System.out.println("Задание 2");
        System.out.println("Версия с do-while");
        do {
            int distance = totalDistance - currentDistance;
            System.out.println("Держитесь! Осталось " + distance + " метров.");
            currentDistance= currentDistance+interval;
        } while (currentDistance <= totalDistance);

        System.out.println("\nВерсия с for");
        for (int dist = 0; dist <= 42195; dist = dist+500) {
            int remaining = 42195 - dist;
            System.out.println("Держитесь! Осталось " + remaining + " метров.");
        }


        int budget = 1300;
        int price = 100;
        int day = 0;
        System.out.println("\nЗадание 3");
        System.out.println("Версия с while");

        while (budget >= price) {
            day++;
            if (day % 5 == 0) {
                System.out.println("День " + day + " — бесплатно.");
                continue; //пропускаем каждый 5-й день
            }
            budget= budget-price;
            System.out.println("День " + day + ": осталось " + budget + " руб.");
        }
        System.out.println("Итого дней (while): " + day);

        int budget2 = 1300;
        int day2;
        int price2 = 100;
        System.out.println("\nВерсия с while");
        for (day2 = 1; budget2 >=100; day2++) {
            if (day2 % 5 == 0) {
                System.out.println("День " + day2 + " — бесплатно.");
                continue;
            }
            budget2= budget2-price2;
            System.out.println("День " + day2 + ": осталось " + budget2 + " руб.");
        }
        //вычитаем 1 из дня, т.к. инкремент сработал перед проверкой в for
        System.out.println("Итого дней (for): " + (day2 - 1));

        int month = 0;
        double total = 0;
        int monthlyPayment = 15000;
        int targetAmount = 12000000;
        System.out.println("\nЗадание 4");

        while (true) {
            month++;
            total = total+monthlyPayment; //ежемесячное пополнение

            //капитализация вклада
            if (month % 6 == 0) {
                total = total + (total * 0.07);
            }

            //вывод за каждый месяц
            //System.out.println("Месяц " + month + ", сумма накоплений: " + total + " руб");
            System.out.println("Месяц " + month + ", сумма накоплений: " + String.format("%.2f", total) + " руб");
            //String.format()-форматирование цифр E7, f — тип данных, %-начало команды, 2f-знак после запятой

            //выход из цикла
            if (total >= targetAmount) {
                System.out.println("\nЦель достигнута!");
                System.out.println("Понадобилось месяцев: " + month);
                //System.out.println("Итоговая сумма: " + total + " руб");
                System.out.println("Итоговая сумма: " + String.format("%.2f", total) + " руб");
                break;
            }
        }

        int charge = 20; //заряд
        int minute = 0; //счётчик времени
        int overheats = 0; //кол-во перегревов

        System.out.println("\nЗадание 5");
        while (charge < 100) {
            minute++;
            if (minute % 10 == 0) {
                overheats++;
                System.out.println("Минута " + minute + ": Перегрев! Зарядка прервана. (Перегрев №" + overheats + ")");

                //если перегревов стало больше 3 — выходим из цикла
                if (overheats > 3) {
                    break;
                }

                //иначе — пропускаем 2 минуты зарядки
                minute= minute+2;
                continue; //возвращаемся к началу цикла, заряд не прибавляем
            }

            //если перегрева нет, прибавляем 2% заряда
            charge= charge+2;

            //если в процессе заряд достиг 100%, прерываем цикл раньше
            if (charge >= 100) {
                charge = 100; //убираем максимум
                break;
            }
        }
        //проверяем причину завершения
        if (overheats > 3) {
            System.out.println("Зарядка прекращена из-за перегрева. Текущий заряд: " + charge + "%");
        } else {
            System.out.println("Зарядка завершена успешно. Текущий заряд: " + charge + "%");
        }
        System.out.println("Время зарядки составило " + minute + " минут.");

/*
1. Условие minute % 10 == 0: Ровно на 10-й, 20-й и т.д. минутах срабатывает блок перегрева.-ок
2. minute += 2 и continue: По условию, во время перегрева зарядка прерывается на 2 минуты.
   Мы добавляем это время к общему счетчику и с помощью continue переходим к следующему циклу, пропуская строку charge += 2. -ок
3. if (overheats > 3): Как только зафиксирован четвертый перегрев, срабатывает break, и зарядка останавливается досрочно. -ок
4. Финальный вывод: Программа честно считает всё потраченное время, включая минуты «простоя» при перегреве.-ок
*/

    }
}