package org.example;

//import org.example.DAO.UserDaoImpl;
//import org.example.Services.BookService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {



    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
//            Scanner scanner = new Scanner(System.in);
//            int res = 0;
//            do {
//                System.out.println("Which menu would you like to access? \n1. Book Menu \n2. Author Menu \n3. User Menu \n4. Library Menu \n5. Exit");
//                res = scanner.nextInt();
//            }while (res < 1 || res > 5);
//            switch (res) {
//                case 1 -> System.out.println("Book Menu");
//                case 2 -> System.out.println("Author Menu");
//                case 3 -> userMenu.userMenu();
//                case 4 -> libraryMenu.libraryMenu();
//                case 5 -> System.out.println("Exiting...");
//            }
        };
    }
}