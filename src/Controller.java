import java.util.Scanner;

public class Controller {
    public static void run(){
        Task t1 = new Task("Заплатить ипотеку", "Павел", 3, "27.03.2023");
        Task t2 = new Task("Записать брата к врачу", "Маша", 2, "21.03.2023");
        Task t3 = new Task("Купить дочери подарок на ДР", "Павел", 3, "31.07.2023");
        Task t4 = new Task("Оформить командировку в Сочи", "Павел", 2, "29.03.2023");
        Task t5 = new Task("Сдать домашнюю работу № 4 по ООП Java", "Павел", 3, "20.03.2023");
        Task t6 = new Task("Подготовить вещи к весне и лету", "Павел", 1, "30.04.2023");
        Planner myP = new Planner();
        myP.add(t1);
        myP.add(t2);
        myP.add(t3);
        myP.add(t4);
        myP.add(t5);
        myP.add(t6);
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Add add = new Add(scanner);
        UserInterface userInterface = new UserInterface(scanner, menu, myP, add);
        userInterface.start();
    }
}