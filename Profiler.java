//import java.util.HashMap;
///import java.util.ArrayList;
//import java.util.Iterator;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// start time, stop time, start message, stop message
//MIGHT NEED TO CREATE OWN TIMER CLASS

public class Profiler{

  private static Profiler instance = null;
  HashMap map;
  boolean enabled;

  private Profiler(){
    map = new HashMap();
    setEnabled(true);
  }

  public static Profiler getInstance(){
    if(instance == null){
      instance = new Profiler();
    }
    return instance;
  }

  public void start(String timer_name){
    if(enabled){
    if(map.get(timer_name) == null){
      ArrayList timers = new ArrayList<Timer>();
      timers.add(new Timer());
      map.put(timer_name, timers);
    }
    else{
      ArrayList timers = (ArrayList)map.get(timer_name);
      timers.add(new Timer());
    }
  }
  }

  public void start(String timer_name, String optional){
    if(enabled){
    if(map.get(timer_name) == null){
      ArrayList timers = new ArrayList<Timer>();
      timers.add(new Timer(optional));
      map.put(timer_name, timers);
    }
    else{
      ArrayList timers = (ArrayList)map.get(timer_name);
      timers.add(new Timer(optional));
    }
  }
  }

  public void stop(String timer_name){
    if(enabled){
    if(map.get(timer_name) != null){
      ArrayList timers = (ArrayList)map.get(timer_name);
      for(int i = timers.size() - 1; i >= 0; i--){
        Timer t = (Timer)timers.get(i);
        if(t.getRunning() == true){
          t.setStop();
          break;
        }
      }
    }
  }
  }

  public void stop(String timer_name, String optional){
    if(enabled){
    if( map.get(timer_name) != null ){
      ArrayList timers = (ArrayList) map.get(timer_name);
      for( int i = timers.size() - 1; i >= 0; i-- ){
        Timer t = (Timer)timers.get(i);
        if( t.getRunning() == true ){
          t.setStop(optional);
          break;
        }
      }
    }
  }
  }

  public void setEnabled(boolean value){
    enabled = value;
  }
  public boolean enabled(){
    return enabled;
  }
  public int count(String name){
    ArrayList timers = (ArrayList)map.get(name);
    return timers.size();
  }

  public void generateReport(){
    //average, longest, shortest times, count info


    try{
    File f = new File("timer-report.html");
    FileWriter fw = new  FileWriter(f);
    fw.write("<!DOCTYPE html>");
    fw.write("<head><title>Timer Report</title></head>");
    fw.write("<body>");
    fw.write("<h1>Timer: </h1>");
    fw.write("<ul>");
    Iterator it = map.entrySet().iterator();
    long longest = 0;
    long shortest = 0;
    long average = 0;

    while(it.hasNext()){
      Map.Entry pairs = (Map.Entry)it.next();
      String timer_name = (String)pairs.getKey();
      ArrayList timers = (ArrayList)pairs.getValue();
      fw.write("<li>" + timer_name + "</li>");
      fw.write("<ul>");
      ArrayList timer_values = new ArrayList<Long>();

      for(int i = 0; i < timers.size(); i++){
        Timer t = (Timer)timers.get(i);
        fw.write("<li>" + t.toString() + "</li>");
        timer_values.add(t.getStop()-t.getStart());
      }

      if(timer_values.get(0) != null){
        longest = (Long)timer_values.get(0);
        shortest = (Long)timer_values.get(0);
      }

      for(int i = 0; i < timer_values.size(); i++){
        average += (Long)timer_values.get(i);
        average = average / 2;
        if((Long)timer_values.get(i) > longest)
          longest = (Long)timer_values.get(i);
        if((Long)timer_values.get(i) < shortest)
          shortest = (Long)timer_values.get(i);
      }

      fw.write("<li>Longest time: " + String.valueOf(longest) + "</li>");
      fw.write("<li>Shortest time: " + String.valueOf(shortest) + "</li>");
      fw.write("<li>Average time: " + String.valueOf(average) + "</li>");
      fw.write("<li>Counter: " + String.valueOf(timers.size()) + "</li>");
      fw.write("</ul>");

    }
    fw.write("</ul>");
    fw.write("</body></html>");
    fw.close();
  } catch (IOException e){}
  }
}
