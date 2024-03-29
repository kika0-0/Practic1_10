/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practic1_10;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Practic1_10 {

    public static void main(String[] args) {
        System.out.println ("Коржавина Виктория Рибо-03-22 вариант 2");
       
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Укажите путь к файлу: ");
        String PathtoFile = scanner.nextLine();

        File file = new File(PathtoFile);
        if (!file.exists()) {
            System.out.println("Файл не найден");
            return;
        }

        StringBuilder newFile = new StringBuilder();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
        
                StringBuilder reversed = new StringBuilder();
                for (int i = line.length() - 1; i >= 0; i--) {
                    reversed.append(line.charAt(i));
                }
                newFile.append(reversed).append("\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка");
            return;
        }

        String PathtoNewFile = PathtoFile.substring(0, PathtoFile.lastIndexOf('.')) + "_updated.txt";

        try (FileWriter fileWriter = new FileWriter(PathtoNewFile)) {
            fileWriter.write(newFile.toString());
            System.out.println("Файл изменен!!");
            System.out.println("Расположение нового файла: " + PathtoNewFile);
        } catch (IOException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }
}
