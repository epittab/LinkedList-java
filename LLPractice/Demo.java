package com.LinkedL.LLPractice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    private static String mySentence = "Now visiting ";
    public static void main(String[] args){
        //
        LinkedList<String> placesToVisit = new LinkedList<String>();


        //adding records

        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        
        printList(placesToVisit);
        addInOrder(placesToVisit, "Alice Springs");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        visit(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println(mySentence + i.next());
        }
        System.out.println("==========");
    }

    private static boolean addInOrder(LinkedList<String> linkedlist, String newCity){
        ListIterator<String> stringListIterator = linkedlist.listIterator();

        while(stringListIterator.hasNext()){
            //you must use .next() method to set up iterator
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                //records are equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // newCity should appear before current element
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move on to next City
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        boolean goingForward = true;

        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities to visit.");  
            return;  
        } else {
            System.out.println(mySentence + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    goingForward = forward(goingForward, listIterator);
                    break;
                case 2:
                    goingForward = backward(goingForward, listIterator);
                    break;
                case 3:
                    printMenu();
                    break;
                default:
                    break;
            }
        }

    }

    private static boolean forward(boolean goingForward, ListIterator listIterator){
        if (!goingForward) {
            if (listIterator.hasNext()) {
                listIterator.next();
            }
            goingForward = true;
        }
            if (listIterator.hasNext()) {
                System.out.println(mySentence + listIterator.next());
            } else {
                System.out.println("Reached the end of the list");
                goingForward = false;
            }
        return goingForward;
    }
    
    private static boolean backward(boolean goingForward, ListIterator listIterator){
        if (goingForward) {
            if (listIterator.hasPrevious()) {
                listIterator.previous();
            }
            goingForward = false;
        }
        if (listIterator.hasPrevious()) {
            System.out.println(mySentence + listIterator.previous());
        } else {
            System.out.println("Reached the beginning of the list");
            goingForward = true;
        }
        return goingForward;
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" + 
                    "1 - go to next city\n" +
                    "2 - go to previous city\n" + 
                    "3 - print menu options");
        
    }
}
