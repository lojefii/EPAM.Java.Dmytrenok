package nau.university.Game;

import java.util.Scanner;

public class Controller {
    private Model model;
    private Info info;
    Scanner sc = new Scanner(System.in);

    public Controller(Model model, Info info) {
        this.model = model;
        this.info = info;
        model.setRange(0, 100);
    }

    public void game() {
        info.task();
        while (true) {
            System.out.print("Your version: ");
            int number = sc.nextInt();
            if (number < model.getMin() || number > model.getMax()) {
                info.outOfRange();
            } else {
                model.addStat(number);
                if (number < model.getRandom()) {
                    info.bigger(model.getStat());
                    model.setRange(number, model.getMax());
                    info.info(model.getMin(), model.getMax());

                } else if (number > model.getRandom()) {
                    info.smaller(model.getStat());
                    model.setRange(model.getMin(), number);
                    info.info(model.getMin(), model.getMax());

                } else {
                    info.win(number, model.getStat());
                    break;
                }
            }
        }
    }
}