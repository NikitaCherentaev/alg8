public class Main {
    public static void main(String[] args) {
        // Переменная для хранения последнего сообщения
        final String[] lastMessage = new String[1];

        Thread chickenThread = new Thread(() -> {
            lastMessage[0] = "Курица";
            System.out.println(lastMessage[0]);
        });

        Thread eggThread = new Thread(() -> {
            lastMessage[0] = "Яйцо";
            System.out.println(lastMessage[0]);
        });

        // Стартуем!
        chickenThread.start();
        eggThread.start();

        try {
            // Ждем, пока оба потока завершат свою работу
            chickenThread.join();
            eggThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим результаты в зависимости от того, что было последним
        System.out.println("Последнее слово: " + lastMessage[0]);
        if (lastMessage[0].equals("Курица")) {
            System.out.println("Яйцо победило!");
        } else {
            System.out.println("Курица победила!");
        }
    }
}