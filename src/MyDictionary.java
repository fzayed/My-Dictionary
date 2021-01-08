import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class MyDictionary {
    public static void main(String[] args) throws IOException {
        JLabel a1;
        JButton b,add,edit,delete;
        JTextField t,meaning,newWord,newMeaning;

        JFrame f=new JFrame("My Dictionary");
        Font font1=new Font("SansSerif",Font.BOLD,20);
        a1=new JLabel("Welcome To My Dictionary");
        a1.setBounds(50,70,500,30);
        a1.setFont(font1);
        f.add(a1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

        //create linked lists
        LinkedList<String> words = new LinkedList<String>();
        LinkedList<String> definitions = new LinkedList<String>();
        File file = new File("dictionary.txt");
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNextLine()){
            String word = inputFile.next();
            String definition = inputFile.nextLine();
            words.add(word);
            definitions.add(definition);
        }

        t = new JTextField("Type a word.");
        f.add(t);
        t.setBounds(50,150,200,30);
        meaning = new JTextField("Display the meaning.");
        meaning.setBounds(50,185,1000,100);
        f.add(meaning);
        b = new JButton("Search");
        b.setBounds(280,150,95,30);
        f.add(b);

        //search a word
        b.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String wordToSearch = t.getText();
                int index = words.indexOf(wordToSearch);
                if (index >= 0 && index <= 54555) {
                    meaning.setText(definitions.get(index));
                } else {
                    meaning.setText("Word you entered was not found, try again.");
                }
            }
        });

        //edit a definition
        edit=new JButton("Edit");
        edit.setBounds(100,300,95,30);
        f.add(edit);

        edit.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String wordToEdit = t.getText();
                int index1 = words.indexOf(wordToEdit);
                if (index1 >= 0 && index1 <= 54555) {
                    String newDefinition = meaning.getText();
                    definitions.set(index1, newDefinition);
                    meaning.setText("The definition was successfully modified to: " + definitions.get(index1));
                } else {
                    meaning.setText("Word you entered was not found, try again.");
                }
            }
        });

        //add a word + definition
        add=new JButton("Add");
        add.setBounds(150,510,95,30);
        f.add(add);
        newWord = new JTextField("Add new word.");
        newWord.setBounds(50,375,200,30);
        f.add(newWord);
        newMeaning = new JTextField("Add new meaning.");
        newMeaning.setBounds(50,410,1000,90);
        f.add(newMeaning);

        add.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String wordToAdd = newWord.getText();
                String definitionToAdd = newMeaning.getText();
                words.add(wordToAdd);
                definitions.add(definitionToAdd);
                newMeaning.setText("The word you wish to add is: " + words.getLast() +
                        " & the definition is: " + definitions.getLast());
            }
        });

        //delete a word + definition
        delete = new JButton("Delete");
        delete.setBounds(200,300,95,30);
        f.add(delete);

        delete.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String wordToDelete = t.getText();
                int index2 = words.indexOf(wordToDelete);
                if (index2 >= 0 && index2 <= 54555) {
                    meaning.setText("The word you removed is: " + words.remove(index2));
                    definitions.remove(index2);
                } else {
                    meaning.setText("Word you entered was not found, try again.");
                }
            }
        });
        f.setSize(1100,650);

    }
}







