package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import com.google.gson.Gson;

public class SavedSkillManager {
    private static String savePath;
    static List<SavedSkill> savedSkills;
    
    public SavedSkillManager() {
        setPath();
        loadSkills(savePath);
    }
    
    /**
     * Sets up the path that skills will be saved to/loaded from.
     */
    private static void setPath() {
        savePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        savePath += "\\QuickHit\\skills.json";
    }

    /**
     * Saves the custom skills to a file.
     * @param path The path to the file
     */
    public static void saveSkills(String path) {
        
    }
    
    /**
     * Loads the custom skills from a file.
     * @param path The path to the file
     */
    private static void loadSkills(String path) {
        savedSkills = new ArrayList<SavedSkill>();
        try {
            Scanner s = new Scanner(new File(path), "utf-8");
            Gson gson = new Gson();
            while(s.hasNextLine()) {
                savedSkills.add(gson.fromJson(s.nextLine(), SavedSkill.class));
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("skills.json not found");
        }
    }
    
    class SavedSkill {
        
    }
}