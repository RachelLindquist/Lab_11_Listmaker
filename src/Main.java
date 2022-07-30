import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<>();
        //2.	Start by creating a menu driven loop:
        //a.	The Loop awaits user input until the Quit command is issued
        //b.	Options:
        //A – Add an item to the list
        //D – Delete an item from the list
        //P – Print (i.e. display) the list
        //Q – Quit the program  should do an are you sure?  type query before exiting.
        //c.	The program gets one of these commands from the user and executes that function
        //d.	Initially stub out the functions so you have a program that you can run almost immediately as you develop it as per the Agile Software Dev approach. You will develop each of the menu options as a separate java method.
        //        e.	You also will need some private static utility functions.

        //        f.	You should use your SafeInput library to bulletproof all input.
        //        For instance, use your getRegExString method to get the menu choice from the user.
        //        Here, a regEx pattern like this [AaDdPpQq] creates a set of where a match will be one of these characters which of course are the menu choice that they user will make..  Note that we have to include both the upper and lower case.

        //Use your getRangedInt method to get the item number to delete, etc.
        //        Use your getYNConfirm method for the quit prompt etc.
        do {
            String listOption = "";
            listOption = SafeInput.getRegExString(in,"Please pick an option", "[AaDdPpQq]");
            if (listOption.equalsIgnoreCase("a")){
                String addValue = SafeInput.getNonZeroLenString(in,"What would you like to add to the list?");
                inputList.add(addValue);
            } else if (listOption.equalsIgnoreCase("d")){
                int removeValue = SafeInput.getRangedInt(in, "Which value would you like to remove?", 0, inputList.size()-1);
                inputList.remove(removeValue);
            } else if (listOption.equalsIgnoreCase("p")){
                display(inputList);
            }else{ // equals Q
                if (SafeInput.getYNConfirm(in,"Are you sure you want to quit?")){
                    break;
                }
            }


        } while (true);

    }

    //i.	You will want to display the current list along with the menu of options
    // so the user can see what they are doing.
    //        ii.	You need to display a numbered version of the list
    //        to allow users to pick list elements for deletion.
    //        Here the user looks at the display and then indicates the item to delete by the number.
    /**
     * @param list - list to be displayed
     * Displays the command options and list
     */
    private static void display(ArrayList<String> list){
        System.out.println("A - Add an item to the list\n" +
                "D - Delete an item from the list\n" +
                "P - Print (i.e. display) the list\n" +
                "Q - Quit the program");
        System.out.println("List:");
        for (int i = 0; i < list.size(); i++){
            System.out.print(i + " " + list.get(i) + " \n");
        }
    }
}