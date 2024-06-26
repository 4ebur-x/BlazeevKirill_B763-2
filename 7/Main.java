/*
Блажеев Кирилл Б763-2
Вариант А
2. Определить, являются ли слова анаграммами, т.е. можно ли из одного слова составить другое перестановкой букв.
*/

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
    Anagram anagram = new Anagram();
    anagram.setWord("нос", "сон");
    if (anagram.anagram()){
        System.out.println("Слова являются анаграммой");
    }
    else {
        System.out.println("Слова не являются анаграммой");
    }

    }

}

class Anagram{
    private String word1;
    private String word2;

    public void setWord(String word1,String word2) {
        this.word1 = word1.toLowerCase();
        this.word2 = word2.toLowerCase();
    }

    public boolean anagram(){
        if (word1.length() != word2.length()){
            return false;
        }
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return  Arrays.equals(arr1,arr2);

    }

}
