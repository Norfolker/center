public class Main {

    public static void main(String[] args) {

        Call call = new Call();

        new Atc("ATC", call).start();

        new Spec("Виктория", call).start();

        new Spec("Андрей", call).start();

        new Spec("Надежда", call).start();

        new Spec("Алексей", call).start();

        new Spec("Оксана", call).start();

    }
}
