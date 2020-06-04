package ex1.synapsX;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Function
{
    public String solution(String str, String[] markers)
    {
        StringBuilder stringBuilder = new StringBuilder(); //we use StringBuilder because it is mutable
        String[] strArr = str.split("\n"); //split the text on lines
        boolean checker = false; //we use checker in order to see if the text on one line is different from the one already split and if so we return true
        List<String> list = new ArrayList<>(); //create a list where we store the text from every line, split or not

        for (String string : strArr) //we go through every line
        {
            int i = 0;
            while (i < markers.length)
            {
                String text = string.split(markers[i])[0]; //split the line where we find a marker
                if (!text.equals(string))
                {
                    list.add(text);
                    checker = true;
                }
                i++;
            }
            if (checker)
            {
                String shortest = list.stream().min(Comparator.comparing(String::length)).get(); //we use a stream in order to compare which element of the list we already obtained is shorter, and we get that one
                stringBuilder.append(shortest).append("\n");   //we use stringBuilder in order to get all the elements of the string together(stringBuilder is mutable)
            } else
                {
                stringBuilder.append(string).append("\n"); //here we get the hole line if it had no marker on it
                }
            checker = false;
        }
        return stringBuilder.toString().trim(); //we trim the string that we return
    }
}





