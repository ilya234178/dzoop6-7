package org.example.Note.model;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationImpl implements FileOperation {

    private String id;

    public FileOperationImpl (String id){
        this.id = id;
        try (FileWriter writer = new FileWriter(id,true)){
            writer.flush();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public  List<String> readAllLines(){
        List<String> lines = new ArrayList<>();
        try{
            File file = new File(id);
            // создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if(line != null){
                lines.add(line);
            }
            while (line != null){
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null){
                    lines.add(line);
                }
            }
            fr.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return  lines;
    }

    public void saveAllLines(List<String> lines) {
        try (FileWriter writer = new FileWriter(id, false)) {
            for (String line : lines) {
                // запись всей строки
                writer.write(line);
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
