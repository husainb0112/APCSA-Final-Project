import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Setup setup = new Setup(scanner);
        Session session = new Session(scanner);

        Unit[] units = new Unit[] {
            new Unit1(), new Unit2(), new Unit3(),
            new Unit4(), new Unit5(), new Unit6(),
            new Unit7(), new Unit8(), new Unit9()
        };

        while (true) {
            Unit selectedUnit = setup.promptUnit(units);
            if (selectedUnit == null) break;  // exit requested

            Integer time = setup.promptTime();
            if (time == null) break;  // exit requested

            StudyMethod[] methods = StudyMethod.selectMethods(time, selectedUnit);
            for (StudyMethod method : methods) {
                session.runSession(selectedUnit, method);
            }
        }

        System.out.println("Good Luck!");
        scanner.close();
    }
}
