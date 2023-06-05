
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class ReadCSV {

   // binary tree class to find out hit and run And Not hit and run data
    static class BinaryTreeNode {
    String month;
    int crashes; // no of crashes

    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String month, int crashes) {
    this.month = month;
    this.crashes = crashes;
    this.left = null;
    this.right = null;
    }
    }

    // problem NO.3
    // class for lowest and highest hit and run and Not hit and run crashes data

    // for rainy days crashes
    // public static class BinaryTreeNode {
    //     String key;  // for month
    //     int count;   // number of rainy days
    //     BinaryTreeNode left;
    //     BinaryTreeNode right;

    //     public BinaryTreeNode(String key, int count) {
    //         this.key = key;
    //         this.count = count;
    //         this.left = null;
    //         this.right = null;
    //     }
    // }

    public static void main(String[] args) {
        String csvFile = "file.csv";
        String line = "";
        String csvDelimiter = ",";

        int weekdayDarkCrashes = 0;
        int weekendDarkCrashes = 0;
        
        // this is object of queue Linkedlist
        Queue<DataObject> dataobject = new LinkedList<>();
        // sorted data year wise
        ArrayList<DataObject> carCrashes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // is me data para hwa ha
                String[] data = line.split(csvDelimiter);
                // is constructor me value aygi
                // queue obj me data aye ga
                DataObject obj = new DataObject(data[0], data[1], data[2], data[3], data[4], data[5], data[6],
                        data[7], data[8], data[9], data[10], data[11], data[12], data[12], data[13], data[14]);
                dataobject.add(obj);
                // System.out.println();

                //

            }
            br.close();

            // problem no1 part(b):
            Map<String, Integer> fridayCrashMap = new HashMap<>();

            for (DataObject carCrash : dataobject) {
                if (carCrash.getField4().equals("Friday")) {
                    String month = carCrash.getField1();
                    int currentCrashes = fridayCrashMap.getOrDefault(month, 0);
                    fridayCrashMap.put(month, currentCrashes + 1);
                }
            }
            String maxMonth = "";
            int maxCrashes = 0; // it is by defualt 0;

            for (Map.Entry<String, Integer> entry : fridayCrashMap.entrySet()) {
                if (entry.getValue() > maxCrashes) {
                    maxMonth = entry.getKey();
                    maxCrashes = entry.getValue();
                }
            }
            System.out.println("Month with the maximum number of crashes on a Friday: " +
                    maxMonth);
            System.out.println("Number of crashes on a Friday: " + maxCrashes);

            // postulate1:
            // Is it true that the weekends (Saturdays and Sundays) when the light
            // conditions were dark,
            // caused more crashes than Mondays and Tuesdays.

            // Initialize counters for crashes with dark light conditions on weekdays and
            // weekends separately

            for (DataObject carCrash : dataobject) {
                // Check if the light condition is dark and the day is a weekday
                if (carCrash.getField8().equals("Dark lighted") && carCrash.getField4().equals("Monday")
                        || carCrash.getField4().equals("Tuesday")) {
                    weekdayDarkCrashes++;
                }

                else if (carCrash.getField8().equals("Dark lighted") && carCrash.getField4().equals("Saturday")
                        || carCrash.getField4().equals("Sunday")) {
                    weekendDarkCrashes++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // sort data year wise
        Collections.sort(carCrashes, new Comparator<DataObject>() {

            @Override
            public int compare(DataObject o1, DataObject o2) {
                return Integer.compare(o1.getField(), o2.getField());
            }
        });

        // // print sorted data here
        // for (DataObject carCrash : dataobject) {
        // // System.out.println(carCrash);
        // }

        // System.out.println("Number of crashes with dark light conditions on
        // weekdays:" + weekdayDarkCrashes);
        // System.out.println("Number of crashes with dark light conditions on weekends:
        // " + weekendDarkCrashes);

        // if (weekendDarkCrashes > weekdayDarkCrashes) {
        // System.out.println("Weekends (Saturdays and Sundays) with dark light
        // conditions caused more crashes than Mondays and Tuesdays with dark light
        // conditions");
        // } else {
        // System.out.println("Mondays and Tuesdays with dark light conditions caused
        // more crashes than weekends (Saturdays and Sundays");
        // }

        // call our method here

        // here we created two binary tree
        BinaryTreeNode hitAndRunRoot = null;
        BinaryTreeNode nonHitAndRunRoot = null;

        while (!dataobject.isEmpty()) {
        DataObject crash = dataobject.poll();
        String month = crash.getField1();
        String crashType = crash.getField7();
        if (crashType.equals("Hit-and-run")) {
        hitAndRunRoot = insertIntoBinaryTree(hitAndRunRoot, month);
       
      

        } else {
        nonHitAndRunRoot = insertIntoBinaryTree(nonHitAndRunRoot, month);

        }

        }

        // System.out.println("hit and run by month");
        // printBinaryTree(hitAndRunRoot);

        // System.out.println("\nNon-Hit and Run Crashes by Month:");
        // printBinaryTree(nonHitAndRunRoot);
              
             // problem no.3
           BinaryTreeNode  minNode= findMinCrashesNode(nonHitAndRunRoot);
        //    System.out.println("");
        //    System.out.println("Month with min crashes: " + minNode.month + " (" + minNode.crashes + " crashes)");

        //    BinaryTreeNode maxNode= findMaximum(nonHitAndRunRoot);

        //    System.out.println("");

        //    System.out.println( "maximum element :"+ maxNode.month + "" + maxNode.crashes);
            // problem NO.3
          
         


        // problem no. 2
        // count number of rainy days crashes in every month
        // BinaryTreeNode rainyDayCrashesRoot = null;

        // while (!dataobject.isEmpty()) {
        // DataObject crash= dataobject.poll();
        // String month= crash.getField1();
        // String weatherCondition= crash.getField9();

        // if (weatherCondition.equals("Rain")) {
        // rainyDayCrashesRoot= insertIntoBinaryTree(rainyDayCrashesRoot, month);
        // }

        // }
        // // print binary tree
        // System.out.println("\nRainy Day Crashes by Month:");
        // printBinaryTree(rainyDayCrashesRoot);

        // make three sub queue for weathercondition
        Queue<DataObject> clearWeatherCrash = new LinkedList<>();
        Queue<DataObject> snowWeatherCrash = new LinkedList<>();
        Queue<DataObject> rainWeatherCrash = new LinkedList<>();

        for (DataObject crash : dataobject) {
            // weathercondition se comapre karen ge
            Object weatherCondition = crash.getField9();
            if (weatherCondition.equals("Clear")) {
                clearWeatherCrash.offer(crash);
            }
            if (weatherCondition.equals("Snow")) {
                snowWeatherCrash.offer(crash);
                // while (!snowWeatherCrash.isEmpty()) {
                // System.out.println(snowWeatherCrash);
                // }
            }
            if (weatherCondition.equals("Rain")) {
                rainWeatherCrash.offer(crash);
                // while (!rainWeatherCrash.isEmpty()) {
                // System.out.println(rainWeatherCrash);
                // }
            }

        }

        // to print weathercondition object

        // while (!clearWeatherCrash.isEmpty()) {
        // System.out.println(clearWeatherCrash);
        // }

        // while (!rainWeatherCrash.isEmpty()) {
        // System.out.println(rainWeatherCrash);
        // }

        // while (!snowWeatherCrash.isEmpty()) {
        // System.out.println(snowWeatherCrash);
        // }

        // make seven sub queues for each day of the week
        Queue<DataObject> mondayCrash = new LinkedList<>();
        Queue<DataObject> tuesdayCrash = new LinkedList<>();
        Queue<DataObject> wednesdayCrash = new LinkedList<>();
        Queue<DataObject> thursdayCrash = new LinkedList<>();
        Queue<DataObject> fridayCrash = new LinkedList<>();
        Queue<DataObject> saturdayCrash = new LinkedList<>();
        Queue<DataObject> sundayCrash = new LinkedList<>();

        // for loop to check condition
        for (DataObject dayCash : dataobject) {
            Object dayOfWeek = dayCash.getField4(); // here getfield4 is day of the week data object
            if (dayOfWeek.equals("Monday")) {
                mondayCrash.offer(dayCash);

            }
            if (dayOfWeek.equals("Tuesday")) {
                tuesdayCrash.offer(dayCash);
            }
            if (dayOfWeek.equals("Wednesday")) {
                wednesdayCrash.offer(dayCash);
            }
            if (dayOfWeek.equals("Thursday")) {
                thursdayCrash.offer(dayCash);
            }

            if (dayOfWeek.equals("Friday")) {
                fridayCrash.offer(dayCash);
            }
            if (dayOfWeek.equals("Saturday")) {
                saturdayCrash.offer(dayCash);
            }

            if (dayOfWeek.equals("Sunday")) {
                sundayCrash.offer(dayCash);
            }
        }

      

        // System.out.println("monday crashes "+mondayCrash.size());
        // System.out.println("tuesday crashes "+tuesdayCrash.size());
        // System.out.println("wednesday crashes "+wednesdayCrash.size());
        // System.out.println("thursday crashes "+thursdayCrash.size());
        // System.out.println("friday crashes "+ fridayCrash.size());
        // System.out.println("saturday crashes "+ saturdayCrash.size());
        // System.out.println("sunday crashes "+sundayCrash.size());

        // problem no.1
        int monday = mondayCrash.size();
        int tuesday = tuesdayCrash.size();
        int wednesday = wednesdayCrash.size();
        int thursday = thursdayCrash.size();
        int friday = fridayCrash.size();
        int saturday = saturdayCrash.size();
        int sunday = sundayCrash.size();
        int maxCrash = 0;
        String maxDay = "";
          
        if (monday > maxCrash) {
            maxCrash = monday;
            maxDay = "Monday";
        }
        if (tuesday > maxCrash) {
            maxCrash = tuesday;
            maxDay = "Tuesday";
        }

        if (wednesday > maxCrash) {
            maxCrash = wednesday;
            maxDay = "wed";
        }
        if (thursday > maxCrash) {
            maxCrash = thursday;
            maxDay = "thu";
        }

        if (friday > maxCrash) {
            maxCrash = friday;
            maxDay = "friday";
        }

        if (saturday > maxCrash) {
            maxCrash = saturday;
            maxDay = "sat";
        }
        if (sunday > maxCrash) {
            maxCrash = sunday;
            maxDay = "sun";
        } else
            System.out.println("");

            System.out.println("deadliest day :"+maxDay);
        }
    // count total no of friday from the day of the week

    // to print object of dayaCrashes

    // while (!mondayCrash.isEmpty()) {
    // System.out.println(mondayCrash);
    // System.out.println("");
    // }

    // while (!tuesdayCrash.isEmpty()) {
    // System.out.println(tuesdayCrash);
    // System.out.println("");

    // }

    // while (!wednesdayCrash.isEmpty()) {
    // System.out.println(wednesdayCrash);
    // }

    // while (!thursdayCrash.isEmpty()) {
    // System.out.println(thursdayCrash);
    // }

    // while (!fridayCrash.isEmpty()) {
    // System.out.println(fridayCrash);
    // }

    // while (!saturdayCrash.isEmpty()) {
    // System.out.println(saturdayCrash);
    // }

    // while (!sundayCrash.isEmpty()) {
    // System.out.println(sundayCrash);
    // }

    // while (!dataobject.isEmpty()) {
    // DataObject obj = dataobject.remove();
    // // do something with the DataObject, such as print its fields
    // System.out.println(obj.getField() + " | " + obj.getField1() + " | " +
    // obj.getField2()
    // + "| " + obj.getField3() + " |"+ obj.getField4() + "| "+ obj.getField5() + "
    // |"+ obj.getField6()
    // +" |"+ obj.getField7()+" |"+ obj.getField8()+" |"+ obj.getField9()+" |"+
    // obj.getField10()
    // +" |"+ obj.getField11()+" |"+ obj.getField12()+" |"+ obj.getField13()+" |"+
    // obj.getField14()

    // );
    // break;
    // }

    // main method end

    // // for month crashes hit and run && Not hit and run
    private static BinaryTreeNode insertIntoBinaryTree(BinaryTreeNode root,String month) {
    if (root == null) {
    return new BinaryTreeNode(month, 1);
    }

    if (month.compareTo(root.month) < 0) {
    root.left = insertIntoBinaryTree(root.left, month);
    } else if (month.compareTo(root.month) > 0) {
    root.right = insertIntoBinaryTree(root.right, month);
    } else {
    root.crashes++;
    }

    return root;
    }

    private static void printBinaryTree(BinaryTreeNode root) {
    if (root == null) {
    return;
    }

    printBinaryTree(root.left);
    System.out.println(root.month + ": " + root.crashes);
    printBinaryTree(root.right);
    }

    // find maximum node and minimum node from hit and run binary tree
 
    // public static BinaryTreeNode  findMaximum(BinaryTreeNode root){
    //      if (root== null) {
    //           return null;
    //      }
       
    //         BinaryTreeNode temp=  root;
    //         while (temp.right!=null) {
    //                temp=temp.right;

    //         }
    //         return temp;
    // }

    public static BinaryTreeNode findMinCrashesNode(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
    
        BinaryTreeNode minNode = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
    
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node.crashes < minNode.crashes) {
                minNode = node;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    
        return minNode;
    }
    
 


}
    // for rainy days crashes here
    // public static BinaryTreeNode insertIntoBinaryTree(BinaryTreeNode root, String key) {
    //     // If the tree is empty, create a new node as the root
    //     if (root == null) {
    //         return new BinaryTreeNode(key, 1);
    //     }

    //     // If the key already exists, increment its count
    //     if (root.key.equals(key)) {
    //         root.count++;
    //     } else if (key.compareTo(root.key) < 0) {
    //         // If the key is less than the root, insert it in the left subtree
    //         root.left = insertIntoBinaryTree(root.left, key);
    //     } else {
    //         // If the key is greater than the root, insert it in the right subtree
    //         root.right = insertIntoBinaryTree(root.right, key);
    //     }

    //     return root;
    // }

    // // to print the rainy days binary tree here

    // public static void printBinaryTree(BinaryTreeNode root) {
    //     if (root == null) {
    //         return;
    //     }

    //     // Traverse the left subtree
    //     printBinaryTree(root.left);

    //     // Print the current node's key and count
    //     System.out.println(root.key + ": " + root.count);

    //     // Traverse the right subtree
    //     printBinaryTree(root.right);
    // }


