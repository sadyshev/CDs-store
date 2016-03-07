import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final String FILENAME= "src/main/resources/file.txt";
    public static ArrayList<String> list = new ArrayList<String>();


    public static void main(String[] args) throws IOException {

        // Запуск меню
        menu();

        int flag = 0;
        int v = 0;   // switch menu
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Music.Genre genreMusic=null;
        Games.Genre genreGames=null;
        Films.Genre genreFilms=null;
        String str=null;
        String executor=null;
        int gen=0;
        String search=null;

        do {
                v = Integer.parseInt(reader.readLine());
                switch (v) {
            /*Заполнить справочник*/
                    case 1: {
                        //Выбрать тип диска
                        System.out.println("Выберити тип диска: 1-Музыка, 2-Игры, 3-Фильмы");
                        int tip = Integer.parseInt(reader.readLine());

                        //Музыка
                        if (tip == 1) {
                            System.out.println("Исполнитель:");
                            executor = reader.readLine();

                            System.out.println("Выберите жанр: 1-Blues, 2-Jazz, 3-Pop, 4-Rock");
                            gen = Integer.parseInt(reader.readLine());
                            switch (gen) {
                                case 1: {
                                    genreMusic = Music.Genre.blues;
                                }
                                break;
                                case 2: {
                                    genreMusic = Music.Genre.jazz;
                                }
                                break;
                                case 3: {
                                    genreMusic = Music.Genre.pop;
                                }
                                break;
                                case 4: {
                                    genreMusic = Music.Genre.rock;
                                }
                                break;
                            }

                            System.out.println("Название альбома:");
                            String name = reader.readLine();

                            System.out.println("Год выпуска альбома");
                            String release = reader.readLine();

                            System.out.println("Стоимость");
                            int value = Integer.parseInt(reader.readLine());

                            str = executor + "\t" + genreMusic + "\t" + name + "\t" + release + "\t" + value;

                            add(str);

                        } else {
                        }
                        //Игры
                        if (tip == 2) {

                            System.out.println("Издатель:");
                            executor = reader.readLine();

                            System.out.println("Выберите жанр: 1-Action, 2-Arcade, 3-Simulator, 4-Strategy");
                            gen = Integer.parseInt(reader.readLine());
                            switch (gen) {
                                case 1: {
                                    genreGames = Games.Genre.action;
                                }
                                break;
                                case 2: {
                                    genreGames = Games.Genre.arcade;
                                }
                                break;
                                case 3: {
                                    genreGames = Games.Genre.simulator;
                                }
                                break;
                                case 4: {
                                    genreGames = Games.Genre.strategy;
                                }
                                break;
                            }

                            System.out.println("Название игры:");
                            String name = reader.readLine();

                            System.out.println("Год выпуска");
                            String release = reader.readLine();

                            System.out.println("Стоимость");
                            int value = Integer.parseInt(reader.readLine());

                            str = executor + "\t" + genreGames + "\t" + name + "\t" + release + "\t" + value;

                            add(str);

                        } else
                            // Фильмы
                            if (tip == 3) {
                                System.out.println("Кинокомпания:");
                                executor = reader.readLine();

                                System.out.println("Выберите жанр: 1-Western, 2-Detective, 3-Comedy, 4-Thriller");
                                gen = Integer.parseInt(reader.readLine());
                                switch (gen) {
                                    case 1: {
                                        genreFilms = Films.Genre.western;
                                    }
                                    break;
                                    case 2: {
                                        genreFilms = Films.Genre.detective;
                                    }
                                    break;
                                    case 3: {
                                        genreFilms = Films.Genre.comedy;
                                    }
                                    break;
                                    case 4: {
                                        genreFilms = Films.Genre.thriller;
                                    }
                                    break;
                                }

                                System.out.println("Название фильма:");
                                String name = reader.readLine();

                                System.out.println("Год выпуска");
                                String release = reader.readLine();

                                System.out.println("Стоимость");
                                int value = Integer.parseInt(reader.readLine());

                                str = executor + "\t" + genreFilms + "\t" + name + "\t" + release + "\t" + value;

                                add(str);


                            } else
                                System.out.println("Такого типа пока нет");
                        menu();


                    }
                    break;
                    // Вывести каталог дисков
                    case 2: {
                        read();

                        printDisk(list);

                        menu();
                    }
                    break;
                    // Поиск
                    case 3: {
                        read();

                        System.out.println("Что ищем?");
                        search = reader.readLine().toLowerCase();

                        search(list, search);

                        menu();
                    }
                    break;
                    // Выход
                    case 4: {
                        flag = 1;
                    }
                    break;

                }
            }while (flag == 0);
    }

    public static ArrayList<String> add(String str){
        ArrayList<String> disk = new ArrayList<String>();

        disk.add(str);

        Writer writer = null;
        try {
            writer = new FileWriter(FILENAME, true);
            for (String line : disk) {
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                }
            }
        }

        return disk;
    }

    public static void menu() {
        System.out.println("************************************");
        System.out.println("1 - Внести информацию о диске");
        System.out.println("2 - Вывести каталог дисков");
        System.out.println("3 - Поиск");
        System.out.println("4 - Выход");
        System.out.println("************************************");
        System.out.println("");
        System.out.println("Выберите пункт меню:");
    }

    public static ArrayList<String> read() throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(FILENAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        list.clear();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            list.add(line);
        }

        reader.close();
        return list;
    }

    public static void printDisk(ArrayList<String> list) {

        System.out.println("Каталог дисков:");
        for (String line : list) {
            System.out.println(line);
        }
        System.out.println("");
    }

    public static void search(ArrayList<String> list, String search){

        for (String line : list) {
            if (line.toLowerCase().contains(search)){
                System.out.println(line); }

        }
    }
}
